package cn.com.devilmole.model.message;

import cn.com.devilmole.model.base.BaseEntity;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by devilmole on 16/5/26.
 */
@XStreamAlias("xml")
public class TextMessage extends BaseEntity {

    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
