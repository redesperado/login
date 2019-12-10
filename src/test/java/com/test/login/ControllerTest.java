package com.test.login;


import com.test.login.bean.WordBean;
import com.test.login.controller.LoginController;
import com.test.login.controller.WordController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {

    MockMvc mockMvc = null;
    MockMvc mockMvc1 = null;


    @Autowired
    LoginController loginController;
    @Autowired
    WordController wordController;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
        mockMvc1 = MockMvcBuilders.standaloneSetup(wordController).build();

    }


    @Test
    @Transactional
    public void login() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/loginIn")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("name","admin")
                .param("password","admin"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }

    @Test
    public void showWord() throws Exception {
        mockMvc1.perform(MockMvcRequestBuilders.post("/showWords")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }

    @Test
    public void selectWord() throws Exception {
        mockMvc1.perform(MockMvcRequestBuilders.post("/selectWord")
                .contentType(MediaType.APPLICATION_JSON_UTF8).param("en","cue"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }

    @Test
    @Transactional
    public void addWord() throws Exception {
        WordBean wordBean = new WordBean();
        wordBean.setEn("surgery");
        wordBean.setProperties("n.");
        wordBean.setCn("外科，外科手术，外科室");
        mockMvc1.perform(MockMvcRequestBuilders.get("/addWord")
                .contentType(MediaType.APPLICATION_JSON_UTF8).param("WordBean",wordBean.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
    }

}
