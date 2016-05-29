package cn.com.devilmole.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by devilmole on 16/5/29.
 */
@Controller
@RequestMapping("/page")
public class PageController {

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);
    @RequestMapping("/formPage")
    public String gotoForm(){
        logger.info("in PageController---------------->");
        return "form/test";

    }
}
