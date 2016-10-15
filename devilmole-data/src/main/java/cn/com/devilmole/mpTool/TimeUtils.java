package cn.com.devilmole.mpTool;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by devilmole on 16/8/24.
 */
public class TimeUtils {

    public static Date dealTimeBySec(Date date,int seconds){
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND,seconds);
        return calendar.getTime();
    }

}
