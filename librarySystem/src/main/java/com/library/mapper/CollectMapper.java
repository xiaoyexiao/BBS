package com.library.mapper;

import com.library.pojo.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {
    List<Collect> getCollectionsByStudentID(String account);
    int saveCollect(@Param("account") String account, @Param("bookID") int bookID);
    int deleteCollect(@Param("account") String account, @Param("bookID") int bookID);
    Integer getCollectByBookAndID(@Param("account") String account, @Param("bookID") int bookID);
}
