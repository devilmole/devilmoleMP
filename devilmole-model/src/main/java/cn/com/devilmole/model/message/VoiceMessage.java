package cn.com.devilmole.model.message;

import cn.com.devilmole.model.base.BaseEntity;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by devilmole on 16/5/26.
 */
@XStreamAlias("xml")
public class VoiceMessage extends BaseEntity {

    private String MediaId;
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
