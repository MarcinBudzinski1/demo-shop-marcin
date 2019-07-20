package com.example.demoshopmarcin;

import com.example.demoshopmarcin.users.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private UserRegistrationService userRegistrationService;

    @Autowired
    public MainController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @GetMapping("/")
    public String home(){
        return"index";
    }

    @GetMapping(value = "/register")
    public String registerForm(Model model){
        return "registerForm";
    }

}
