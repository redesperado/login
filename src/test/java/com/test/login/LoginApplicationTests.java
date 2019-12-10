package com.test.login;

import com.test.login.bean.UserBean;
import com.test.login.bean.WordBean;
import com.test.login.service.UserService;
import com.test.login.service.WordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginApplicationTests {



    @Autowired
    UserService userService;
    @Autowired
    WordService wordService;

    @Test
    public void contextLoads() {
        UserBean userBean = userService.loginIn("admin","admin");
        System.out.println("该用户ID为：");
        System.out.println(userBean.getId());
    }

    @Test
    public void showWords() throws Exception{
        List<WordBean> list = wordService.getWords();
        for (WordBean wordBean : list) {
            System.out.println(wordBean.getId()+"  "+wordBean.getCn()+"  "+wordBean.getProperties()+"  "+wordBean.getEn());
        }
    }

    @Test
    public void showCnByEn() throws Exception {
        WordBean wordBean = wordService.getCnByEn("cue");
        if (wordBean!= null){
            System.out.println(wordBean.getId()+"  "+wordBean.getCn()+"  "+wordBean.getProperties()+"  "+wordBean.getEn());
        }
    }

    @Test
    @Transactional
    public void addWord() throws Exception {
        WordBean wordBean = new WordBean();
        wordBean.setEn("surgery");
        wordBean.setProperties("n.");
        wordBean.setCn("外科，外科手术，外科室");
        wordService.addWord(wordBean);

    }

}
