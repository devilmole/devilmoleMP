package cn.com.devilmole.data.service;

import cn.com.devilmole.data.dao.AccessTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by devilmole on 16/5/28.
 */
@Service
public class AccessTokenServiceImpl implements  AccessTokenService {

    @Autowired
    private AccessTokenMapper accessTokenMapper;

    public void newAccessToken(){

    }
}
