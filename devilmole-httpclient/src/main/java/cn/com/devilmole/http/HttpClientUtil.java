package cn.com.devilmole.http;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by devilmole on 16/5/22.
 */
public class HttpClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public String getHttpWithParam(String url, Map<String,String> params) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        if(params!=null&&params.size()>0){
            StringBuffer sb=new StringBuffer();
            for (Map.Entry<String, String>  param:params.entrySet()) {
                sb.append(param.getKey()+"="+param.getValue()+"&");
            }
            url=url+"?"+sb.toString();

        }
        HttpGet httpget = new HttpGet(url);
        HttpResponse response = httpclient.execute(httpget);

        HttpEntity entity = response.getEntity();
        String html = EntityUtils.toString(entity);
        httpclient.close();
        logger.info("getHttpWithParam-------result--------->"+html);
        return html;
    }

    public String postHttpWithParam(String url, Map<String,String> params) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost=new HttpPost(url);
        if(params!=null&&params.size()>0){
            List<BasicNameValuePair> paramList=new ArrayList<BasicNameValuePair>();
            for (Map.Entry<String, String>  param:params.entrySet()) {
                paramList.add(new BasicNameValuePair(param.getKey(),param.getValue()));
            }
            httppost.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
        }
        HttpResponse httpresponse = httpclient.execute(httppost);
        HttpEntity entity = httpresponse.getEntity();
        String html = EntityUtils.toString(entity);
        httpclient.close();
        logger.info("postHttpWithParam------result---------->"+html);

        return html;
    }





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
        StringEntity entity=new StringEntity(body,HTTP.UTF_8);
        entity.setContentType("application/json; encoding=utf-8");
        httppost.setEntity(entity);

        HttpResponse httpresponse = httpclient.execute(httppost);

        HttpEntity entity1 = httpresponse.getEntity();
        String html = EntityUtils.toString(entity1);
        httpclient.close();
        logger.info("html2222---------------->"+html);
        return null;
    }
}
