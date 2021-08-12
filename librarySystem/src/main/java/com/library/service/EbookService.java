package com.library.service;

import com.library.pojo.Ebook;

import java.util.List;

public interface EbookService {
    List<Ebook> getAllEbook();
    Ebook listAllChapters(int eid);
}
