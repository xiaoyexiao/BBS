package com.library.mapper;

import com.library.pojo.Ebook;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EbookMapper {
    List<Ebook> getAllEbook();
    Ebook listAllChapters(@Param("eid") int eid);

}
