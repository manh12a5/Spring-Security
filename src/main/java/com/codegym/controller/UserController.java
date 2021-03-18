package com.codegym.controller;

import java.security.Principal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class UserController {

    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/user")
    public ModelAndView user(Principal principal) {
        // Get authenticated user name from Principal
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("user", principal.getName());
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        // Get authenticated user name from SecurityContext
        ModelAndView modelAndView = new ModelAndView("admin");
        SecurityContext context = SecurityContextHolder.getContext();
        modelAndView.addObject("admin", context.getAuthentication().getName());
        return modelAndView;
    }

}