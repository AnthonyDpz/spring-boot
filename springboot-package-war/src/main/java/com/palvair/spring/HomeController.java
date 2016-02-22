package com.palvair.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by widdy on 07/02/2016.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("msg", "Welcome to springboot-package-war");
        return "index";
    }
}
