package test.devilmole.mp.data;

import org.junit.Test;

import java.util.Date;

/**
 * Created by devilmole on 16/5/29.
 */
public class TestDefault {

    Date date=new Date();
    @Test
    public void testDate() throws Exception {
        long time=1464513401000l;
        System.out.println(time);
        Date date=new Date(time);
        System.out.println(date);
    }
}
