package cn.com.devilmole.model.message;

import cn.com.devilmole.model.base.BaseEntity;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by devilmole on 16/5/26.
 */
@XStreamAlias("xml")
public class LinkMessage extends BaseEntity {

    private String Title;
    private String Description;
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
