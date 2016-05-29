package cn.com.devilmole.data.service;

import cn.com.devilmole.data.dao.TextMessageMapper;
import cn.com.devilmole.model.message.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by devilmole on 16/5/29.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private TextMessageMapper textMessageMapper;

    public int DealMessage(TextMessage textMessage){

        System.out.println("in dao");
        int a=textMessageMapper.newTextMessage(textMessage);
        System.out.println(a);
        return a;

    }

}
