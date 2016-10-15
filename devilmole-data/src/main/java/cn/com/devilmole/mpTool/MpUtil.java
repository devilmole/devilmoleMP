package cn.com.devilmole.mpTool;

import cn.com.devilmole.config.WxConfig;
import cn.com.devilmole.http.HttpClientUtil;
import cn.com.devilmole.model.menu.Menu;
import cn.com.devilmole.model.token.AccessTokenResp;
import cn.com.devilmole.model.token.JSapiTicketResp;
import cn.com.devilmole.model.token.WebAccessTokenResp;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by devilmole on 16/5/29.
 */
@Component
public class MpUtil {
    @Autowired
    WxConfig config;

    private static final Logger logger = LoggerFactory.getLogger(MpUtil.class);

    private static AccessTokenResp access;

    private static JSapiTicketResp jsapiTicket;


    HttpClientUtil util=new HttpClientUtil();

    public String getAccessToken() throws IOException {
        if(access!=null&&access.getExpireTime()!=null&&access.getExpireTime().after(new Date())){
            logger.info("getAccessToken--exist---->"+access.getAccess_token());
            return access.getAccess_token();
        }
        Map params=new HashMap();
        params.put("grant_type","client_credential");
        params.put("appid",config.getAppid());
        params.put("secret",config.getAppsecret());
        String url=config.getAccessTokenCreateUrl();
        String result=util.getHttpWithParam(url,params);
        AccessTokenResp newAccess= JSON.parseObject(result,AccessTokenResp.class);
        newAccess.setExpireTime(TimeUtils.dealTimeBySec(new Date(),newAccess.getExpires_in()));
        access=newAccess;
        logger.info("getAccessToken------>"+access.getAccess_token());
        return access.getAccess_token();
    }

    public String getJSapiToken() throws IOException {
        if(jsapiTicket!=null&& jsapiTicket.getExpireTime()!=null&&jsapiTicket.getExpireTime().after(new Date())){
            logger.info("getJSapiToken--exist---->"+jsapiTicket.getTicket());
            return jsapiTicket.getTicket();
        }
        Map params=new HashMap();
        params.put("access_token",getAccessToken());
        params.put("type","jsapi");
        String url=config.getWebJSapiTicketUrl();
        String result=util.getHttpWithParam(url,params);
        JSapiTicketResp newTicket=JSON.parseObject(result,JSapiTicketResp.class);
        newTicket.setExpireTime(TimeUtils.dealTimeBySec(new Date(),newTicket.getExpires_in()));
        jsapiTicket=newTicket;
        logger.info("getJSapiToken------>"+jsapiTicket.getTicket());
        return jsapiTicket.getTicket();
    }

    public WebAccessTokenResp getWebAccessToken(String code) throws IOException {
        Map params=new HashMap();
        params.put("grant_type","authorization_code");
        params.put("appid",config.getAppid());
        params.put("secret",config.getAppsecret());
        params.put("code",code);
        String url=config.getWebAccessTokenUrl();
        String result=util.getHttpWithParam(url,params);
        WebAccessTokenResp res=JSON.parseObject(result,WebAccessTokenResp.class);
        return res;
    }

    public void createMenu() throws Exception {

        logger.info("createMenu------>");
        String url=config.getMenuCreateUrl();
        String acc=getAccessToken();
        url=url+"?access_token="+acc;
        Map params=new HashMap();
        params.put("access_token",getAccessToken());
        String result=util.postMenuCreat(url,getMenuString());
        logger.info("createMenu  result-------->"+result);
    }

    private String getMenuString(){

        List <Menu> menuList=new ArrayList<Menu>();
        Menu root=new Menu();
        root.setType("view");
        root.setName("我要拼班");
        root.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx4a268c507204e06d&redirect_uri=http%3A%2F%2Fmp.whitehorseprince.com%2Fwhitehorseprince%2Fpage%2FformPage&response_type=code&scope=snsapi_base&state=123#wechat_redirect");

        menuList.add(root);

        JSONObject target=new JSONObject();
        target.put("button",JSON.toJSON(menuList));
        return target.toString();
    }

    private String getMenuStringOrigin(){

        List <Menu> menuList=new ArrayList<Menu>();
        Menu root1=new Menu();
        root1.setType("click");
        root1.setName("今日歌曲");
        root1.setKey("root_key_123");

        Menu root2=new Menu();
        root2.setName("菜单");


        Menu node21=new Menu();
        node21.setType("view");
        node21.setName("直接跳");
        node21.setUrl("http://mp.whitehorseprince.com/test/page/formPage");
        Menu node22=new Menu();
        node22.setType("view");
        node22.setName("我要拼班");
        node22.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx60841f4ca3be8348&redirect_uri=http%3A%2F%2Fmp.whitehorseprince.com%2Ftest%2Fpage%2FformPage&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
        Menu node23=new Menu();
        node23.setType("click");
        node23.setName("点赞按钮");
        node23.setKey("key_click_00012");

        List subMenuList=new ArrayList();
        subMenuList.add(node21);
        subMenuList.add(node22);
        subMenuList.add(node23);
        root2.setSub_button(subMenuList);

        menuList.add(root1);
        menuList.add(root2);
        JSONObject target=new JSONObject();
        target.put("button",JSON.toJSON(menuList));
        return target.toString();
    }
}
