package cn.com.devilmole.util;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by devilmole on 16/5/22.
 */
public class HttpClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public String getAccessToken(String url,String params) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        if(params==null||params.isEmpty()){

        }else{
            url=url+"?"+params;
        }
        HttpGet httpget = new HttpGet(url);

        HttpResponse response = httpclient.execute(httpget);

        HttpEntity entity = response.getEntity();
        String html = EntityUtils.toString(entity);
        httpclient.close();
        logger.info("html---------------->"+html);
        return null;
    }

    public String postMenuCreat(String url,String body)throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost=new HttpPost(url);
        System.out.println("url--->" + url);
        StringEntity entity=new StringEntity(body,"UTF-8");
        httppost.setEntity(entity);

        HttpResponse httpresponse = httpclient.execute(httppost);

        HttpEntity entity1 = httpresponse.getEntity();
        String html = EntityUtils.toString(entity1);
        httpclient.close();
        logger.info("html2222---------------->"+html);
        return null;
    }
}
