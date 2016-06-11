package test.devilmole.mp.data;

import cn.com.devilmole.data.dao.AccessTokenMapper;
import cn.com.devilmole.data.dao.TextMessageMapper;
import cn.com.devilmole.data.service.MessageService;
import cn.com.devilmole.model.message.TextMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by devilmole on 16/5/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml","classpath:servlet-context.xml","classpath:mybatis-config.xml"})
public class testDataLink {

    @Autowired
    private AccessTokenMapper mapper;

    @Autowired
    private TextMessageMapper textMessageMapper;
    @Autowired
    private MessageService messageService;

    @Test
    public void testData(){

        Date date=new Date();
        TextMessage message=new TextMessage();
        message.setContent("内容短发的");
        message.setFromUserName("from");
        message.setCreateTime(String.valueOf(date.getTime()));
        message.setCreateTimeDate(date);
        System.out.println("------>"+messageService.toString());
        System.out.println("------>"+messageService.toString());
        System.out.println("------------>" + mapper.toString());
//        int a=messageService.DealMessage(message);

    }
}
