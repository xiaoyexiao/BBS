package com.library.controller;

import com.alibaba.fastjson.JSONObject;
import com.library.pojo.Ebook;
import com.library.pojo.ResultInfo;
import com.library.service.BorrowService;
import com.library.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/5/9 21:47
 */
@Controller
public class EbookController {

    @Autowired
    @Qualifier("ebookServiceImpl")
    private EbookService ebookService;

    @ResponseBody
    @RequestMapping(value = "/getAllEbook", method = RequestMethod.GET)
    public String getAllEbook(){
        ResultInfo response = new ResultInfo("success",0);
        List<Ebook> allEbook = ebookService.getAllEbook();
        response.setData(allEbook);
        return JSONObject.toJSONString(response);
    }

    @ResponseBody
    @RequestMapping(value = "/getAllChapters", method = RequestMethod.GET)
    public String getAllChapters(int eid){
        ResultInfo response = new ResultInfo("success",0);
        Ebook ebooks = ebookService.listAllChapters(eid);
        response.setData(ebooks);
        return JSONObject.toJSONString(response);
    }
}
