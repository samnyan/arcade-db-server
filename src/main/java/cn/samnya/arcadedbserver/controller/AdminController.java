package cn.samnya.arcadedbserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sam_nya (samnya@outlook.com)
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String adminIndex() {
        return "admin/index";
    }
}
