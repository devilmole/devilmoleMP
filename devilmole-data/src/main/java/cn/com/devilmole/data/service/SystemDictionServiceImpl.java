package cn.com.devilmole.data.service;

import cn.com.devilmole.data.dao.SystemDictionMapper;
import cn.com.devilmole.model.system.AreaDiction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by devilmole on 16/9/25.
 */
@Service
public class SystemDictionServiceImpl implements  SystemDictionService {

    @Autowired
    private SystemDictionMapper systemDictionMapper;

    /**
     * 根据层级获取地域信息
     * @param level
     * @param selected
     * @return
     */
    public String getAreaDictionByLevel(int level,int selected){
        return dealOptions(systemDictionMapper.getAreaDictionByLevel(level),selected);
    }

    /**
     * 根据父id,获取父节点下所有地域信息
     * @param parentId
     * @param selected
     * @return
     */
    public String getAreaDictionByParentId(int parentId,int selected){
        return dealOptions(systemDictionMapper.getAreaDictionByParentId(parentId),selected);
    }

    /**
     * 根据地域id,获取所有历史节点及相关选项
     * @param id
     */
    public void getAreaReselect(int id,Map result){
        //获取当前地域选项,判断层级
        AreaDiction current=systemDictionMapper.getAreaDictionById(id);
        result.put("level"+current.getLevel(),getAreaDictionByParentId(current.getParentId(),id));
        if (current.getLevel()!=0){
            getAreaReselect(current.getParentId(),result);
        }

    }

    private String dealOptions(List<AreaDiction> list,int selected){
        if(list==null||list.size()==0){
            return "";
        }
        StringBuffer sb=new StringBuffer();
        sb.append("<option value=\"0\">请选择</option>");
        for (AreaDiction temp:list) {
            if(selected!=0 &&selected==temp.getId()){
                sb.append("<option value=\""+temp.getId()+"\" selected >");
            }else{
                sb.append("<option value=\""+temp.getId()+"\">");
            }
            sb.append(temp.getName());
            sb.append("</option>");
        }
        return sb.toString();
    }
}
