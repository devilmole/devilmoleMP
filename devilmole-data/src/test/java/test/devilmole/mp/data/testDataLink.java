package test.devilmole.mp.data;

import cn.com.devilmole.data.dao.AccessTokenMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by devilmole on 16/5/25.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml","classpath:servlet-context.xml","classpath:mybatis-config.xml"})
public class testDataLink {

    @Autowired
    private AccessTokenMapper mapper;

    @Test
    public void testData(){
        System.out.println("-------->"+mapper.newLog());

    }
}
