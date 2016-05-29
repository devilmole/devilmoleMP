package test.mp.devilmole;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by devilmole on 16/5/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml","classpath:servlet-context.xml","classpath:mybatis-config.xml"})
public class TestMessage {

    @Test
    public void testName() throws Exception {


    }
}
