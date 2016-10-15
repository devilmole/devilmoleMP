package test.devilmole.mp.data;

import cn.com.devilmole.config.WxConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by devilmole on 16/5/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml","classpath:servlet-context.xml","classpath:mybatis-config.xml"})
public class TestConfig {
    @Autowired
    WxConfig config;

    @Test
    public void testName() throws Exception {
        System.out.println("token---->"+config.getToken());
    }
}
