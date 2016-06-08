package test.devilmole.mp.data;

import cn.com.devilmole.mpTool.MpUtil;
import org.junit.Before;
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
public class TestMpUtil {

    @Autowired
    private MpUtil tool;

    @Before
    public void setUp() throws Exception {
        

    }

    @Test
    public void testAccessToken() throws Exception {
//        tool.createMenu();
        System.out.println("test");
    }


}
