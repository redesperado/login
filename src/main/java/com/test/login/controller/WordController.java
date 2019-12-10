package com.test.login.controller;


import com.test.login.bean.WordBean;
import com.test.login.service.WordService;
import org.apache.ibatis.mapping.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


//@Controller
public class WordController {

    @Autowired
    WordService wordService;

    @RequestMapping("/showWords")
    public String showWords(ModelMap modelMap) throws Exception{
        modelMap.addAttribute("getWords",wordService.getWords());
        return "word/showWords";
    }

    @RequestMapping(value = "/showSelectWord",method = RequestMethod.GET)
    public String showSelectWord() throws Exception{
        return "word/selectWord";
    }

    @RequestMapping(value = "/selectWord",method = RequestMethod.POST)
    public String selectWord(String en,ModelMap modelMap) throws Exception{
        WordBean wordBean = wordService.getCnByEn(en);
        modelMap.addAttribute("properties",wordBean.getProperties());
        modelMap.addAttribute("cn",wordBean.getCn());
        return "word/selectWord";
    }

    @ResponseBody
    @RequestMapping(value = "/selectWord2",method = RequestMethod.POST)
    public WordBean selectWord2(String en) throws Exception{
        WordBean wordBean = wordService.getCnByEn(en);
        return wordBean;
    }

    @RequestMapping("/showAddword")
    public String showAddWord(){
        return "word/addWord";
    }

    @RequestMapping(value = "/addWord",method = RequestMethod.POST)
    public String addWord(WordBean wordBean) throws Exception{
        int a = 0;
        a = wordService.addWord(wordBean);
        if(a != 0){
            return "success";
        }else {
            return "error";
        }
    }
}
