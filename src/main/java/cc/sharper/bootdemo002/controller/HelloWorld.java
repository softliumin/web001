package cc.sharper.bootdemo002.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * first controller
 */
@Controller
public class HelloWorld {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String index() {
        return "dashboard/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("name", "haha");
        for (int x=0;x<1000;x++){
            logger.error("test log----");
        }
        return "index";
    }

}
