package cn.com.devilmole.util;

import cn.com.devilmole.model.base.BaseEntity;
import cn.com.devilmole.model.message.PictMessage;
import cn.com.devilmole.model.message.TextMessage;
import cn.com.devilmole.model.message.VoiceMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by devilmole on 16/5/28.
 */
public class ParseMPMessage {

    private static final Logger logger = LoggerFactory.getLogger(ParseMPMessage.class);

    public static <T extends BaseEntity> T parseMessage(String xml,Class<T> target){
        String msgType=XmlHelper.dealMsgType(xml);
        logger.info("msgType--------->"+msgType);
        if(msgType==null||msgType.isEmpty()){
            return null;
        }

        if(msgType.equals("text")){

            T result=XmlHelper.parseToPojo(xml, target);

            return result;
        }

        return null;
    }
}
