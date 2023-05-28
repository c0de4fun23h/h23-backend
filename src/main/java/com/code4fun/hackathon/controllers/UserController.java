package com.code4fun.hackathon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
    @GetMapping("/user")
    public String registrationForm() {
        return "index";
    }
}
