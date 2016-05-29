package cn.com.devilmole.data.dao;

import cn.com.devilmole.model.token.AccessTokenResp;
import org.springframework.stereotype.Component;

/**
 * Created by devilmole on 16/5/25.
 */
@Component
public interface AccessTokenMapper {

    int newAccessToken(AccessTokenResp accessTokenResp);

    AccessTokenResp getAccessToken();

}
