package cn.com.devilmole.controller;

import cn.com.devilmole.config.WxConfig;
import cn.com.devilmole.http.HttpClientUtil;
import cn.com.devilmole.mpTool.CharacterUtils;
import cn.com.devilmole.mpTool.MpUtil;
import cn.com.devilmole.service.JSSignatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/function")
public class FunctionController {

    private static final Logger logger = LoggerFactory.getLogger(FunctionController.class);

    @Autowired
    WxConfig config;
    @Autowired
    private MpUtil mpUtil;
    @Autowired
    private JSSignatureService jsSignatureService;

    @RequestMapping("/createMenu")
    @ResponseBody
    public Map createMenu() throws Exception {
        Map result=new HashMap();
        result.put("detail","新建菜单gogogo");
        mpUtil.createMenu();

        return result;
    }

    @RequestMapping("/getSignature")
    @ResponseBody
    public Map getSignature(@RequestBody String url) throws IOException {
        Map result=new HashMap();
        String appId=config.getAppid();
        String timestamp=String.valueOf(System.currentTimeMillis());
        String nonceStr=CharacterUtils.getRandomString(16);
        String signature=jsSignatureService.generateSignature(url,timestamp,nonceStr);
        logger.info("url---" + url);
        logger.info("appId---" + appId);
        logger.info("timestamp---" + timestamp);
        logger.info("nonceStr---" + nonceStr);
        logger.info("signature-----" + signature);
        result.put("appId",appId);
        result.put("timestamp",timestamp);
        result.put("nonceStr", nonceStr);
        result.put("signature",signature);
        return result;
    }


}
