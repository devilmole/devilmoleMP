package test.mp.devilmole;

import cn.com.devilmole.data.dao.TextMessageMapper;
import cn.com.devilmole.model.message.TextMessage;
import cn.com.devilmole.service.JSSignatureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Date;

/**
 * Created by devilmole on 16/5/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml","classpath:servlet-context.xml","classpath:mybatis-config.xml"})
public class TestData {
    @Autowired
    private TextMessageMapper textMessageMapper;
    @Autowired
    private JSSignatureService jsSignatureService;

    @Test
    public void testData(){

        Date date=new Date();
        TextMessage message=new TextMessage();
        message.setContent("内容短发的");
        message.setFromUserName("from");
        message.setCreateTime(String.valueOf(date.getTime()));
        message.setCreateTimeDate(date);
//        int a=textMessageMapper.newTextMessage(message);
//        System.out.println(a);
    }

    public void testUrl() throws IOException {
        String timestamp="1414587457";
        String noncestr="Wm3WZYTPz0wzccnW";
        String jsapi_ticket="sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg";
        String url="http://mp.weixin.qq.com?params=value";

        jsSignatureService.generateSignature(url,timestamp,noncestr);

    }
}
