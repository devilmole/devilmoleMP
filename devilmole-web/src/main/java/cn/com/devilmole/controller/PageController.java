package cn.com.devilmole.controller;

import cn.com.devilmole.data.service.StudentService;
import cn.com.devilmole.data.service.SystemDictionService;
import cn.com.devilmole.model.banana.StudentBasic;
import cn.com.devilmole.model.banana.StudentTime;
import cn.com.devilmole.model.token.WebAccessTokenResp;
import cn.com.devilmole.mpTool.MpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by devilmole on 16/5/29.
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private SystemDictionService systemDictionService;

    @Autowired
    private MpUtil mpUtil;

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);
    @RequestMapping("/formPage")
    public String gotoForm(@RequestParam( value = "code",required = false) String code,
                           @RequestParam(value = "state",required = false) String state,
                           Model model) throws IOException {
        logger.info("in PageController---------------->");
        logger.info("state---------->"+state);
        logger.info("code---------->"+code);
        WebAccessTokenResp webAccessToken=new WebAccessTokenResp();
        if(code!=null&&!code.isEmpty()){
            webAccessToken=mpUtil.getWebAccessToken(code);
        }
        //webAccessToken.setOpenid("mpCode");
        model.addAttribute("openId",webAccessToken.getOpenid());

        StudentBasic studentBasic=studentService.getStudentInfoByMPCode(webAccessToken.getOpenid());
        model.addAttribute("studentBasic",studentBasic);
        if(studentBasic==null||studentBasic.getLocationId()==0){
            String location0=systemDictionService.getAreaDictionByLevel(0,0);
            model.addAttribute("location0",location0);
        }
        StudentTime studentTime=studentService.getStudentTimeByMpCode(webAccessToken.getOpenid());
        model.addAttribute("studentTime",studentTime);
        return "form/test";

    }

    @RequestMapping("/newClass")
    @ResponseBody
    public Map saveForm(@ModelAttribute StudentTime studentTime,
                        @ModelAttribute StudentBasic studentBasic,
                        @RequestParam(value = "mpCode",required = false) String mpCode,
                        @RequestParam(value = "location0",required = false,defaultValue = "0") int location0,
                        @RequestParam(value = "location1",required = false,defaultValue = "0") int location1,
                        @RequestParam(value = "location2",required = false,defaultValue = "0") int location2){
        Map result=new HashMap();
        if(location0==0){
            studentBasic.setLocationId(0);
        }else if(location1==0){
            studentBasic.setLocationId(location0);
        }else if(location2==0){
            studentBasic.setLocationId(location1);
        }else{
            studentBasic.setLocationId(location2);
        }
        int a=studentService.newClassForm(studentBasic,studentTime,mpCode);
        System.out.println(studentTime.isMonday1());
        return result;
    }

    @RequestMapping("/getSelect")
    @ResponseBody
    public Map getSelect(@RequestParam(value = "parentId",required = true) int parentId,
                            @RequestParam(value = "selected",required = false,defaultValue = "0") int selected){
        Map result=new HashMap();
        String html=systemDictionService.getAreaDictionByParentId(parentId,selected);
        if(html==null||html.isEmpty()){
            result.put("result","error");
        }else{
            result.put("result","ok");
            result.put("detail",html);
        }
        return result;
    }

    @RequestMapping("/getSelectReselect")
    @ResponseBody
    public Map getSelectReselect(@RequestParam(value = "locationId",required = true,defaultValue = "0") int locationId){
        Map result=new HashMap();
        systemDictionService.getAreaReselect(locationId,result);
        return result;
    }

}
