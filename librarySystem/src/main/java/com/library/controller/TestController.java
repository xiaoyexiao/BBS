package com.library.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/4/15 16:13
 */
@Controller
public class TestController {
    @RequestMapping("/testJson")
    @ResponseBody
    public String testJson(@RequestBody JSONObject json){
        Object account = json.get("account");
        System.out.println(account.getClass().getTypeName());
        Object password = json.get("password");
        Object isManager = json.get("isManager");
        System.out.println(isManager.getClass().getTypeName());
        JSONObject res = new JSONObject();
        res.put("account",account.getClass().getTypeName());
        res.put("password",password.getClass().getTypeName());
        res.put("isManager",isManager.getClass().getTypeName());
        System.out.println(res.toJSONString());
        return res.toJSONString();
    }

    @RequestMapping("/forwardTest")
    public ModelAndView login(String account){
        ModelAndView model = new ModelAndView("forward:/studentLogin");
        model.addObject("account",account);
        model.addObject("password","123");
        return model;
    }
}
