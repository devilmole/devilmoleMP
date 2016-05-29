package cn.com.devilmole.mpTool;

import cn.com.devilmole.config.WxConfig;
import cn.com.devilmole.http.HttpClientUtil;
import cn.com.devilmole.model.menu.Menu;
import cn.com.devilmole.model.token.AccessTokenResp;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
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

    HttpClientUtil util=new HttpClientUtil();

    public String getAccessToken() throws IOException {
        if(access!=null&&access.getExpireTime()!=null&&access.getExpireTime().after(new Date())){
            logger.info("getAccessToken------>"+access.getAccess_token());
            return access.getAccess_token();
        }
        Map params=new HashMap();
        params.put("grant_type","client_credential");
        params.put("appid",config.getAppid());
        params.put("secret",config.getAppsecret());
        String url=config.getAccessTokenCreateUrl();
        String result=util.getHttpWithParam(url,params);
        AccessTokenResp newAccess= JSON.parseObject(result,AccessTokenResp.class);
        access=newAccess;
        logger.info("getAccessToken------>"+access.getAccess_token());
        return access.getAccess_token();
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
        Menu root1=new Menu();
        root1.setType("click");
        root1.setName("今日歌曲");
        root1.setKey("root_key_123");

        Menu root2=new Menu();
        root2.setName("菜单");


        Menu node21=new Menu();
        node21.setType("view");
        node21.setName("外链");
        node21.setUrl("http://www.baidu.com");
        Menu node22=new Menu();
        node22.setType("view");
        node22.setName("内链");
        node22.setUrl("http://115.159.206.167/test/page/formPage");
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
