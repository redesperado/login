package com.test.login.service;

import com.test.login.bean.WordBean;

import java.util.List;

public interface WordService {

    List<WordBean> getWords() throws Exception;

    WordBean getCnByEn(String word) throws Exception;

    int addWord(WordBean wordBean) throws Exception;

}
