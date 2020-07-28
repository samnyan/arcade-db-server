package cn.samnya.arcadedbserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
