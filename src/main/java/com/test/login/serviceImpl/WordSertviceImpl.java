package com.test.login.serviceImpl;

import com.test.login.bean.WordBean;
import com.test.login.dao.WordDao;
import com.test.login.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordSertviceImpl implements WordService {

    @Autowired
    WordDao wordDao;

    @Override
    public List<WordBean> getWords() throws Exception {
        return wordDao.selectWords();
    }

    @Override
    public WordBean getCnByEn(String word) throws Exception {
        return wordDao.selectCnByEn(word);
    }

    @Override
    public int addWord(WordBean wordBean) throws Exception {
        return wordDao.insertWord(wordBean);
    }
}
