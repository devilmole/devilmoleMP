package test.mp.devilmole;

import cn.com.devilmole.config.WxConfig;
import cn.com.devilmole.util.HttpClientUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by devilmole on 16/5/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml","classpath:servlet-context.xml"})
public class TestHttpClient {

    HttpClientUtil util=new HttpClientUtil();
    @Autowired
    WxConfig config;
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testHttpClient() throws Exception {

        String param="grant_type=client_credential&appid="+config.getAppid()+"&secret="+config.getAppsecret();
        String url=config.getAccessTokenCreateUrl();
        System.out.println(util.getAccessToken(url,param));
    }


    @Test
    public void testMenuCreate() throws Exception {
        String jsonMenu="{\\\"button\\\":[{\\\"name\\\":\\\"扫码\\\",\\\"sub_button\\\":[{\\\"type\\\":\\\"scancode_waitmsg\\\",\\\"name\\\":\\\"扫码带提示\\\",\\\"key\\\":\\\"rselfmenu_0_0\\\",\\\"sub_button\\\":[]},{\\\"type\\\":\\\"scancode_push\\\",\\\"name\\\":\\\"扫码推事件\\\",\\\"key\\\":\\\"rselfmenu_0_1\\\",\\\"sub_button\\\":[]}]},{\\\"name\\\":\\\"发图\\\",\\\"sub_button\\\":[{\\\"type\\\":\\\"pic_sysphoto\\\",\\\"name\\\":\\\"系统拍照发图\\\",\\\"key\\\":\\\"rselfmenu_1_0\\\",\\\"sub_button\\\":[]},{\\\"type\\\":\\\"pic_photo_or_album\\\",\\\"name\\\":\\\"拍照或者相册发图\\\",\\\"key\\\":\\\"rselfmenu_1_1\\\",\\\"sub_button\\\":[]},{\\\"type\\\":\\\"pic_weixin\\\",\\\"name\\\":\\\"微信相册发图\\\",\\\"key\\\":\\\"rselfmenu_1_2\\\",\\\"sub_button\\\":[]}]},{\\\"name\\\":\\\"发送位置\\\",\\\"type\\\":\\\"location_select\\\",\\\"key\\\":\\\"rselfmenu_2_0\\\"},{\\\"type\\\":\\\"media_id\\\",\\\"name\\\":\\\"图片\\\",\\\"media_id\\\":\\\"MEDIA_ID1\\\"},{\\\"type\\\":\\\"view_limited\\\",\\\"name\\\":\\\"图文消息\\\",\\\"media_id\\\":\\\"MEDIA_ID2\\\"}]}";
        System.out.println(util.postMenuCreat(config.getMenuCreateUrl()+"?access_token="+config.getAccessToken(), jsonMenu));
    }
}
