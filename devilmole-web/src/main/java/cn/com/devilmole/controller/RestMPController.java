package cn.com.devilmole.controller;

import cn.com.devilmole.data.service.MessageService;
import cn.com.devilmole.model.message.TextMessage;
import cn.com.devilmole.service.WxAuthService;
import cn.com.devilmole.util.ParseMPMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/rest/devilmole")
public class RestMPController {

    private static final Logger logger = LoggerFactory.getLogger(RestMPController.class);

    @Autowired
    private WxAuthService authService;

    @Autowired
    private MessageService messageService;


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

        TextMessage entity= ParseMPMessage.parseMessage(source,TextMessage.class);
        if(entity==null){
            logger.info("entity---->null");
        }else{
            messageService.DealMessage(entity);
        }

        return null;
    }

}