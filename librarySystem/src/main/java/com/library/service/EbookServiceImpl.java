package com.library.service;

import com.library.mapper.EbookMapper;
import com.library.pojo.Ebook;

import java.util.List;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/5/9 21:43
 */
public class EbookServiceImpl implements EbookService{
    private EbookMapper ebookMapper;

    public void setEbookMapper(EbookMapper ebookMapper) {
        this.ebookMapper = ebookMapper;
    }

    @Override
    public List<Ebook> getAllEbook() {
        return ebookMapper.getAllEbook();
    }

    @Override
    public Ebook listAllChapters(int eid) {
        return ebookMapper.listAllChapters(eid);
    }
}
