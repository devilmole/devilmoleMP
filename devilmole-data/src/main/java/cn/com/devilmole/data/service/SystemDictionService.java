package cn.com.devilmole.data.service;

import java.util.Map;

/**
 * Created by devilmole on 16/9/25.
 */
public interface SystemDictionService {

    String getAreaDictionByLevel(int level,int selected);

    String getAreaDictionByParentId(int parentId,int selected);

    void getAreaReselect(int id,Map result);
}
