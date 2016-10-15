package cn.com.devilmole.mpTool;

import java.util.Random;

/**
 * Created by devilmole on 16/8/24.
 */
public class CharacterUtils {

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for(int i = 0 ; i < length; ++i){
            int number = random.nextInt(62);//[0,62)

            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
