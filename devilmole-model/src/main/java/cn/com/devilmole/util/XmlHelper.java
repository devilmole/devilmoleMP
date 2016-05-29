package cn.com.devilmole.util;

import cn.com.devilmole.model.base.BaseEntity;
import cn.com.devilmole.model.base.DefaultPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by devilmole on 16/5/28.
 */
public class XmlHelper {

    private static final Logger logger = LoggerFactory.getLogger(XmlHelper.class);

    public static String dealMsgType(String xml){
        logger.info("dealMsgType----source---->"+xml);
        ExtXstream xs = new ExtXstream();
        xs.processAnnotations(DefaultPojo.class);
        DefaultPojo entity= (DefaultPojo) xs.fromXML(xml);
        if(entity!=null&&entity.getMsgType()!=null){
            return entity.getMsgType();
        }else{
            return "";
        }
    }

    public static <T extends BaseEntity> T parseToPojo(String xml, Class<T> target ){

        logger.info("dealMsgType----parseToPojo---->"+xml);

        ExtXstream xs = new ExtXstream();
        xs.processAnnotations(target);
        T entity=(T) xs.fromXML(xml);
        return entity;
    }
}
