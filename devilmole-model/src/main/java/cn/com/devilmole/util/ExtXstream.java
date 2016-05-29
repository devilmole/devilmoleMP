package cn.com.devilmole.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.MapperWrapper;

/**
 * Created by devilmole on 16/5/28.
 */
public class ExtXstream extends XStream {

    @Override
    protected MapperWrapper wrapMapper(MapperWrapper next) {
        return new MapperWrapper(next) {
            /*
             * (non-Javadoc)
             *
             * @see
             * com.thoughtworks.xstream.mapper.MapperWrapper#shouldSerializeMember
             */
            @Override
            public boolean shouldSerializeMember(@SuppressWarnings("rawtypes") Class definedIn, String fieldName) {
                // 不能识别的节点，掠过。
                if (definedIn == Object.class) {
                    return false;
                }
                // 节点名称为fileName的掠过
                if (fieldName.equals("fileName")) {
                    return false;
                }
                return super.shouldSerializeMember(definedIn, fieldName);
            }
        };
    }
}
