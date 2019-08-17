package com.bbs.service;

import com.bbs.domain.Word;

import java.util.List;

public interface IWordService {
    List<Word> findByPage();

    boolean add(Word word);

    void changeStatus(Integer wid);
}
