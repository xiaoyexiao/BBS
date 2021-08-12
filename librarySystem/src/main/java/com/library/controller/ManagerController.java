package com.library.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.library.pojo.Borrow;
import com.library.pojo.Manager;
import com.library.pojo.ResultInfo;
import com.library.pojo.Student;
import com.library.service.ManagerService;
import com.library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ：Vizzk
 * @description：管理员控制器
 * @date ：2021/3/29 20:08
 */
@Controller
public class ManagerController {
    @Autowired
    @Qualifier("managerServiceImpl")
    private ManagerService managerService;

    @ResponseBody
    @RequestMapping("/managerLogin")
    public String ManagerLogin(HttpServletRequest request){
        //event: 0 不存在账号  1成功  2密码错误
        String account = (String)request.getAttribute("account");
        String password = (String) request.getAttribute("password");
        Manager manager = managerService.getManagerByID(account);
        ResultInfo response;
        JSONObject jsonObject = new JSONObject();
        Boolean ispass = false;
        if(manager == null){
            response = new ResultInfo("fail",0);
        }
        else {
            if(manager.getPassword().equals(password)){
                ispass = true;
                response = new ResultInfo("success",1);
                jsonObject.put("account",manager.getNumber());
                jsonObject.put("name",manager.getName());
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
    @RequestMapping("/getAllStudent")
    public String getAllStudent(){
        //event: 0 不存在账号  1成功  2密码错误
        ResultInfo response = new ResultInfo("success",0);

        List<JSONObject> studentInfo = managerService.getAllStudentInfo();
        response.setData(studentInfo);

        return JSON.toJSONString(response);
    }
}
