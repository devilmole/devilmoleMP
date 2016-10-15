package test.devilmole.mp.data;

import cn.com.devilmole.mpTool.TimeUtils;
import org.junit.Test;

import java.util.Date;

/**
 * Created by devilmole on 16/8/24.
 */
public class TestUtils {

    @Test
    public void dummy() {
        Date date=new Date();
        System.out.println("data----->"+date);
        Date newDate=TimeUtils.dealTimeBySec(date,-10);
        System.out.println(newDate);
    }

}
