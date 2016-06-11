package test.devilmole.mp.data;

import cn.com.devilmole.data.dao.StudentInfoMapper;
import cn.com.devilmole.model.banana.StudentTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by devilmole on 16/6/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml","classpath:servlet-context.xml","classpath:mybatis-config.xml"})
public class TestStudentData {

    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Before
    public void setUp() throws Exception {
        

    }

    @Test
    public void testStudentData() throws Exception {
        StudentTime student=new StudentTime();
        student.setMonday1(true);
        student.setMonday2(false);
        student.setMpCode("mpCode");
//        int a=studentInfoMapper.newStudentTimeInfo(student);
//        System.out.println("------>"+a);
        StudentTime result=studentInfoMapper.getStudentTimeByMpCode("mpCode");
        System.out.println(result);
        System.out.println(result.isMonday1());
        System.out.println(result.getUpdateTime());
    }
}
