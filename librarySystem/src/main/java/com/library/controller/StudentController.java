package com.library.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.library.pojo.*;
import com.library.service.BookService;
import com.library.service.BorrowService;
import com.library.service.CollectService;
import com.library.service.StudentService;
import com.library.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ：Vizzk
 * @description：学生控制器
 * @date ：2021/3/28 20:18
 */
@Controller
public class StudentController {
    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;
    @Autowired
    @Qualifier("collectServiceImpl")
    private CollectService collectService;
    @Autowired
    @Qualifier("borrowServiceImpl")
    private BorrowService borrowService;

    @RequestMapping("/studentLogin")
    @ResponseBody
    public String studentLogin(HttpServletRequest request){
        //event: 0 不存在账号  1成功  2密码错误
        String account = (String)request.getAttribute("account");
        String password = (String)request.getAttribute("password");
        Student student = studentService.getStudentByID(account);
        ResultInfo response;
        JSONObject jsonObject = new JSONObject();
        Boolean ispass = false;
        if(student == null){
            response = new ResultInfo("fail",0);
        }
        else {
            if(student.getPassword().equals(password)){
                ispass = true;
                response = new ResultInfo("success",1);
                jsonObject.put("account",student.getNumber());
                jsonObject.put("name",student.getName());
            }
            else{
                response =new ResultInfo("fail",2);
            }
        }
        jsonObject.put("isPass",ispass);
        response.setData(jsonObject);
        return JSON.toJSONString(response);
    }

    @ResponseBody
    @RequestMapping("/getStudent")
    public String studentInfo(@RequestBody JSONObject json){
        //1查无此人  0查询成功
        String account = (String) json.get("account");
        Student student = studentService.getStudentByID(account);
        ResultInfo response = new ResultInfo("success",0);
        if(student == null){
            response.setEvent(1);
        }
        response.setData(student);
        return JSON.toJSONString(response);
    }

    @ResponseBody
    @RequestMapping(value = "/studentRegister", method = RequestMethod.POST)
    public String insertStudent(@RequestBody JSONObject request){
        ResultInfo response = new ResultInfo("success", 0);

        Student student = JSONObject.toJavaObject(request, Student.class);
        int i = studentService.insertStudent(student);
        if(i != 1){
            response.setMsg("fail");
            response.setEvent(1);
        }

        return JSONObject.toJSONString(response);
    }
    @ResponseBody
    @RequestMapping(value = "/getCollections", method = RequestMethod.GET)
    public String getCollectionsByStudentID(String account){
        ResultInfo response = new ResultInfo("success", 0);

        List<Collect> collections = collectService.getCollectionsByStudentID(account);
        final List<JSONObject> list = new ArrayList();
        collections.stream().forEach(collect -> {
            Borrow record = borrowService.getBorrowRecordByBook(collect.getBook().getNo());
            JSONObject data = new JSONObject();
            data.put("collection",collect);
            if(record != null){
                try {
                    String deadline = Util.getDeadline(record.getBorrowDate(), record.getResting());
                    data.put("status", false);
                    data.put("deadline", deadline);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            else{
                data.put("status", true);
            }
            list.add(data);
        });
        response.setData(list);

        return JSONObject.toJSONString(response);
    }

    @ResponseBody
    @RequestMapping(value = "/saveCollect", method = RequestMethod.GET)
    public String saveCollect(String account, int bookID){
        ResultInfo response = new ResultInfo("success", 0);
        int i = collectService.saveCollect(account, bookID);
        if(i != 1){
            response.setMsg("fail");
            response.setEvent(1);
        }
        return JSONObject.toJSONString(response);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteCollect", method = RequestMethod.GET)
    public String deleteCollect(String account, int bookID){
        ResultInfo response = new ResultInfo("success", 0);
        int i = collectService.deleteCollect(account, bookID);
        if(i == 0){
            response.setMsg("fail");
            response.setEvent(1);
        }
        return JSONObject.toJSONString(response);
    }

    @ResponseBody
    @RequestMapping(value = "/testCollect", method = RequestMethod.GET)
    public String testCollect(String account, int bookID){
        //检测是否已经收藏过
        ResultInfo response = new ResultInfo("success", 0);
        response.setData(false);
        Integer collect = collectService.getCollectByBookAndID(account, bookID);
        if(collect == null){
            response.setData(true);
        }

        return JSONObject.toJSONString(response);
    }
}
