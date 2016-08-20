package com.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 泽宏 on 2016/8/19.
 */

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error",required = false)String error,
                        @RequestParam(value = "logout",required = false)String logout,
                        Model model){
        if(error != null){
            model.addAttribute("error","Invalid username and password");
        }

        if(logout != null){
            model.addAttribute("logout","You have been logged out successfully.");
        }

        return "login";

    }

}
