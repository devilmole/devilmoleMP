package cn.com.devilmole.data.dao;

import cn.com.devilmole.model.message.TextMessage;
import org.springframework.stereotype.Component;

/**
 * Created by devilmole on 16/5/29.
 */
@Component
public interface TextMessageMapper {

    int newTextMessage(TextMessage textMessage);

}
