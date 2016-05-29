package cn.com.devilmole.model.token;

import java.util.Date;

/**
 * Created by devilmole on 16/5/26.
 */
public class AccessTokenResp {

    private String access_token;
    private int expires_in;
    private Date expireTime;
    private String errcode;
    private String errmsg;

    public String getAccess_token() {
        return access_token;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
