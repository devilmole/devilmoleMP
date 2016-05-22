package cn.com.devilmole.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import cn.com.devilmole.service.WxAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/rest/devilmole")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private WxAuthService authService;

    @RequestMapping(method = {RequestMethod.GET})
    public @ResponseBody
    String authGet(@RequestParam("signature") String signature,
                   @RequestParam("timestamp") String timestamp,
                   @RequestParam("nonce") String nonce,
                   @RequestParam("echostr") String echostr) {
        if (authService.validateAuth(signature, timestamp, nonce, echostr)) {
            logger.info("received authentication message from Weixin Server.");
            return echostr;
        }
        return null;
    }


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    String post(@RequestBody String requestBody){
        final String source=requestBody;
        try {
            String deal1=new String(source.getBytes(),"UTF-8");
            logger.info("deal1---->"+deal1);
            String deal2=new String(source.getBytes("ISO8859-1"),"UTF-8");
            logger.info("deal2---->"+deal2);
            String deal3=new String(source.getBytes("GBK"),"UTF-8");
            logger.info("deal3---->"+deal3);
            String deal4=new String(source.getBytes("UTF-8"),"UTF-8");
            logger.info("deal4---->"+deal4);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("requestBody--->"+requestBody);
        logger.info("requestBody--->"+requestBody);
        return null;
    }

}