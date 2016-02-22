package com.palvair.spring.form.validation.thymeleaf.controller;

import com.palvair.spring.form.validation.thymeleaf.form.UserForm;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by widdy on 07/02/2016.
 */
@Controller
@Log4j
public class HomeController extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(UserForm userForm) {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String validateUser(@Valid UserForm userForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            log.error("errors = " + bindingResult.getAllErrors());
            return "index";
        }
        redirectAttributes.addAttribute("name", userForm.getName());
        redirectAttributes.addAttribute("age", userForm.getAge());
        return "redirect:/results";
    }

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public ModelAndView results(@RequestParam("name") String name, @RequestParam("age") String age) {
        final Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        return new ModelAndView("results", map);
    }
}
