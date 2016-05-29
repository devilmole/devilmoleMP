package test.cn.com.devilmole.util;

import cn.com.devilmole.model.base.BaseEntity;
import cn.com.devilmole.model.message.TextMessage;
import cn.com.devilmole.util.ParseMPMessage;
import cn.com.devilmole.util.XmlHelper;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;

/**
 * Created by devilmole on 16/5/28.
 */
public class XmlHelperTest {

    XmlHelper helper=new XmlHelper();
    String source="<Simple><x>1</x><y>2</y></Simple>";
    String xmlSource="<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[this is a test]]></Content><MsgId>1234567890123456</MsgId></xml>";

    String source2="<xml><ToUserName><![CDATA[toUser大方]]></ToUserName></xml>";

    @org.junit.Before
    public void setUp() throws Exception {


    }

    @Test
    public void testXtream2() throws Exception {

        XStream xs = new XStream();
        BaseEntity entity=new BaseEntity();
        entity.setToUserName("阿迪舒服sd");
        xs.processAnnotations(BaseEntity.class);
        String result=xs.toXML(entity);
        System.out.println(result);
    }

    @Test
    public void testParseMPMessage() throws Exception {

        TextMessage entity=ParseMPMessage.parseMessage(xmlSource,TextMessage.class);
        System.out.println(entity.getContent());


    }

    @Test
    public void testName() throws Exception {
        TextMessage test=new TextMessage();
        test.setMsgType("123");
        BaseEntity base=test;
        System.out.println(base.getMsgType());
    }
}
