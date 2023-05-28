package com.code4fun.hackathon.controllers;

import com.code4fun.hackathon.domain.User;
import com.code4fun.hackathon.dto.UserLoginDto;
import com.code4fun.hackathon.repository.UserRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model) {
        UserLoginDto user = new UserLoginDto();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(
            @ModelAttribute("user") UserLoginDto userDto,
            BindingResult result,
            Model model) {
        val existingUser = this.userRepository.getUserDetails(userDto.getUserEmail());

        if (existingUser != null)
            result.rejectValue("email", null,
                    "User already registered !!!");

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/registration";
        }

        this.save(userDto);
        return "redirect:/registration?success";
    }

    private void save(UserLoginDto userLoginDto) {
        val user = new User();
        user.setUserName(userLoginDto.getUserName());
        user.setUserEmail(userLoginDto.getUserEmail());
        user.setUserPassword(userLoginDto.getUserPassword());
        userRepository.save(user);
    }
}
