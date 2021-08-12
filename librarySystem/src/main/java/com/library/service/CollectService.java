package com.library.service;

import com.library.pojo.Collect;

import java.util.List;

public interface CollectService {
    List<Collect> getCollectionsByStudentID(String account);
    int saveCollect(String account, int bookID);
    int deleteCollect(String account, int bookID);
    Integer getCollectByBookAndID(String account, int bookID);
}
