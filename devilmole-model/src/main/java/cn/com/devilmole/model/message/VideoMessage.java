package cn.com.devilmole.model.message;

import cn.com.devilmole.model.base.BaseEntity;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by devilmole on 16/5/26.
 */
@XStreamAlias("xml")
public class VideoMessage extends BaseEntity {

    private String MediaId;
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
