package cn.com.devilmole.controller;

import cn.com.devilmole.config.WxConfig;
import cn.com.devilmole.http.HttpClientUtil;
import cn.com.devilmole.mpTool.MpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by devilmole on 16/5/29.
 */
@Controller
@RequestMapping("/function")
public class FunctionController {

    @Autowired
    private MpUtil mpUtil;

    @RequestMapping("/createMenu")
    @ResponseBody
    public Map createMenu() throws Exception {
        Map result=new HashMap();
        result.put("detail","新建菜单gogogo");
        mpUtil.createMenu();

        return result;
    }


}
