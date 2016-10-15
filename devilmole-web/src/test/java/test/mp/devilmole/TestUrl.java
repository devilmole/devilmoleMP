package test.mp.devilmole;

import org.junit.Test;

/**
 * Created by devilmole on 16/8/28.
 */
public class TestUrl {
    @Test
    public void testUrl() throws Exception {
        String url="http://mp.whitehorseprince.com/test/page/formPage?code=0111nXsU0HbWlS14ZAsU0Wy2tU01nXsv&state=123";
        System.out.println(url.indexOf("#"));
        if(url.indexOf("#")>-1){
            url=url.substring(0,url.indexOf("#"));
        }else{

        }
        System.out.println(url);
    }

    public void testEncodeUrl(){
        String url="http://test.whitehorseprince.com/whitehorseprince/page/formPage";

    }
}
