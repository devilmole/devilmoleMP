package cn.com.devilmole.controller;

import cn.com.devilmole.data.service.StudentService;
import cn.com.devilmole.model.banana.StudentBasic;
import cn.com.devilmole.model.banana.StudentTime;
import cn.com.devilmole.model.token.WebAccessTokenResp;
import cn.com.devilmole.mpTool.MpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by devilmole on 16/5/29.
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MpUtil mpUtil;

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);
    @RequestMapping("/formPage")
    public String gotoForm(@RequestParam( value = "code",required = false) String code,
                           @RequestParam(value = "state",required = false) String state,
                           Model model) throws IOException {
        logger.info("in PageController---------------->");
        logger.info("state---------->"+state);
        logger.info("code---------->"+code);
        WebAccessTokenResp webAccessToken=new WebAccessTokenResp();
        if(code!=null&&!code.isEmpty()){
            webAccessToken=mpUtil.getWebAccessToken(code);
        }
        model.addAttribute("openId",webAccessToken.getOpenid());
        return "form/test";

    }

    @RequestMapping("/newClass")
    @ResponseBody
    public Map saveForm(@ModelAttribute StudentTime studentTime,
                        @ModelAttribute StudentBasic studentBasic){
        Map result=new HashMap();
        logger.info("in saveForm-------->");
        int a=studentService.newClassForm(studentBasic,studentTime);
        System.out.println(studentTime.isMonday1());
        return result;
    }
}
