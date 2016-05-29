package test.cn.com.devilmole.util;

import cn.com.devilmole.model.menu.Menu;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devilmole on 16/5/29.
 */
public class MenuTest {

    List <Menu> menuList=new ArrayList<Menu>();
    @Before
    public void setUp() throws Exception {
        Menu root1=new Menu();
        root1.setType("click");
        root1.setName("今日歌曲");
        root1.setKey("root_key_123");
        Menu root2=new Menu();
        root2.setName("菜单");


        Menu node21=new Menu();
        node21.setType("view");
        node21.setName("外链");
        node21.setUrl("http://www.baidu.com");
        Menu node22=new Menu();
        node22.setType("view");
        node22.setName("内链");
        node22.setUrl("http://115.159.206.167/test/page/formPage");
        Menu node23=new Menu();
        node23.setType("click");
        node23.setName("点赞按钮");
        node23.setKey("key_click_00012");

        List subMenuList=new ArrayList();
        subMenuList.add(node21);
        subMenuList.add(node22);
        subMenuList.add(node23);
        root2.setSub_button(subMenuList);

        menuList.add(root1);
        menuList.add(root2);

    }

    @Test
    public void testMenu() throws Exception {

        JSONArray array= (JSONArray) JSON.toJSON(menuList);
        JSONObject target=new JSONObject();
        target.put("button",array);
        String result=target.toString();
        System.out.println(result);

    }
}
