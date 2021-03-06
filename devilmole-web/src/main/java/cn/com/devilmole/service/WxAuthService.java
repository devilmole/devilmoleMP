package cn.com.devilmole.service;

import cn.com.devilmole.config.WxConfig;
import cn.com.devilmole.model.WxAuthReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by devilmole on 16/5/22.
 */
@Service
public class WxAuthService {

    private static final Logger log = LoggerFactory.getLogger(WxAuthService.class);

    @Autowired
    protected WxConfig wxConfig;

    public boolean validateAuth(String signature, String timestamp,
                                String nonce, String echostr){
        WxAuthReq authReq = new WxAuthReq();
        authReq.setCreatedDate(new Date());
        authReq.setSignature(signature);
        authReq.setTimestamp(timestamp);
        authReq.setNonce(nonce);
        authReq.setEchostr(echostr);

        String excepted = hash(getStringToHash(timestamp, nonce,
                wxConfig.getToken()));

        if (signature == null || !signature.equals(excepted)) {
            log.error("Authentication failed! excepted echostr ->" + excepted);
            log.error("                                 actual ->" + signature);
            return false;
        }

        return true;
    }

    protected static String getStringToHash(String timestamp, String nonce,
                                            String token) {
        List<String> list = new ArrayList<String>();
        list.add(timestamp);
        list.add(nonce);
        list.add(token);

        String result = "";
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            result += list.get(i);
        }
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
