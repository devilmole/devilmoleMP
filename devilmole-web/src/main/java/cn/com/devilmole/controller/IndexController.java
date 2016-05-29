package cn.com.devilmole.controller;

import cn.com.devilmole.data.service.MessageService;
import cn.com.devilmole.model.message.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by devilmole on 16/5/22.
 */
@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/index")
    public String index(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "index";
    }

    @RequestMapping(value = "/")
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "home";
    }

    @RequestMapping("/testInput")
    @ResponseBody
    public Map testInput(Model model, @RequestParam(value = "lalala") String source){
        logger.info("source---"+source);
        Map result=new HashMap();
        result.put("detail","中文内容");
        TextMessage entity=new TextMessage();
        entity.setMsgId("6289946169080149103");
        entity.setContent("ad阿迪沙发舒服");
        entity.setFromUserName("ofAqCwnhFIOuQ6SgIko0bZg_ngHo");
        entity.setToUserName("gh_f454e36456b5");
        entity.setCreateTime("1464492215");
        messageService.DealMessage(entity);
        return result;
    }

}
