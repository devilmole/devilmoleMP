package cn.com.devilmole.service;

import cn.com.devilmole.config.WxConfig;
import cn.com.devilmole.model.WxAuthReq;
import cn.com.devilmole.mpTool.MpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by devilmole on 16/8/22.
 */
@Service
public class JSSignatureService {

    private static final Logger log = LoggerFactory.getLogger(JSSignatureService.class);
    @Autowired
    private MpUtil mpUtil;

    public String generateSignature(String url, String timestamp,
                                String noncestr) throws IOException {

        String ticket= mpUtil.getJSapiToken();
        return getStringToHash(url, timestamp, noncestr, ticket);
    }

    protected static String getStringToHash(String url, String timestamp,
                                            String noncestr,String ticket) {

       log.info("source url---->"+url);
        if(url.indexOf("#")>-1){
            url=url.substring(0,url.indexOf("#"));

        }

        StringBuffer sb=new StringBuffer();
        sb.append("jsapi_ticket="+ticket);
        sb.append("&noncestr="+noncestr);
        sb.append("&timestamp="+timestamp);
        sb.append("&url="+url);
        log.info("getStringToHash source="+sb.toString());
        String result=hash(sb.toString());
        log.info("getStringToHash result="+result);
        return result;
    }

    protected static String hash(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] b = md.digest(str.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < b.length; i++) {
                sb.append(Integer.toString((b[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // never happens
        }
        return null;
    }
}
