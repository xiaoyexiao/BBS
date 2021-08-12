package com.library.service;

import com.alibaba.fastjson.JSONObject;
import com.library.pojo.Manager;

import java.util.List;

public interface ManagerService {
    Manager getManagerByID(String number);
    List<JSONObject> getAllStudentInfo();

}
