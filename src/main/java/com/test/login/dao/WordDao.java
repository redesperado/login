package com.test.login.dao;

import com.test.login.bean.WordBean;

import java.util.List;

public interface WordDao {

    List<WordBean> selectWords() throws Exception;

    WordBean selectCnByEn(String word) throws Exception;

    int insertWord(WordBean wordBean) throws Exception;
}
