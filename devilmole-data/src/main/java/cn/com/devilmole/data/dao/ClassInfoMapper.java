package cn.com.devilmole.data.dao;

import cn.com.devilmole.model.banana.ClassBasic;
import org.springframework.stereotype.Component;

/**
 * Created by devilmole on 16/6/8.
 */
@Component
public interface ClassInfoMapper {

    int newClassInfo(ClassBasic classBasic);

}
