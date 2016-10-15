package cn.com.devilmole.data.dao;

import cn.com.devilmole.model.system.AreaDiction;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by devilmole on 16/9/25.
 */
@Component
public interface SystemDictionMapper {

    List<AreaDiction> getAreaDictionByParentId(int parentId);

    List<AreaDiction> getAreaDictionByLevel(int level);

    AreaDiction getAreaDictionById(int id);
}
