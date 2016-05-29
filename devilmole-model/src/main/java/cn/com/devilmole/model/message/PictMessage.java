package cn.com.devilmole.model.message;

import cn.com.devilmole.model.base.BaseEntity;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by devilmole on 16/5/26.
 */
@XStreamAlias("xml")
public class PictMessage extends BaseEntity {

    private String PicUrl;
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
