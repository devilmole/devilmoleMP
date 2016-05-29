package cn.com.devilmole.model.base;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.Date;

/**
 * Created by devilmole on 16/5/26.
 */
public class BaseEntity {

    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private Date createTimeDate;
    private String MsgType;
    private String MsgId;

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public Date getCreateTimeDate() {

        return new Date(Long.parseLong(CreateTime+"000"));
    }

    public void setCreateTimeDate(Date createTimeDate) {
        this.createTimeDate = createTimeDate;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }


    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
