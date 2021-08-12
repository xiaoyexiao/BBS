package com.library.service;

import com.library.mapper.CollectMapper;
import com.library.pojo.Collect;

import java.util.List;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/5/8 11:02
 */
public class CollectServiceImpl implements CollectService {
    private CollectMapper mapper;

    public void setMapper(CollectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Collect> getCollectionsByStudentID(String account) {
        return mapper.getCollectionsByStudentID(account);
    }

    @Override
    public int saveCollect(String account, int bookID) {
        return mapper.saveCollect(account, bookID);
    }

    @Override
    public int deleteCollect(String account, int bookID) {
        return mapper.deleteCollect(account,bookID);
    }

    @Override
    public Integer getCollectByBookAndID(String account, int bookID) {
        return mapper.getCollectByBookAndID(account,bookID);
    }
}
