package com.example.demoshopmarcin;

import com.example.demoshopmarcin.users.UserRegistrationDTO;
import com.example.demoshopmarcin.users.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    private UserRegistrationService userRegistrationService;

    @Autowired
    public MainController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @GetMapping(value = "/")
    public String home(Model model){
        model.addAttribute("userData", new UserRegistrationDTO());
        return"index";
    }

    @PostMapping(value = "/")
    public String registerUser(@ModelAttribute(name = "userData") @Valid UserRegistrationDTO userRegistrationDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){return "register";}
        return "registerDone";
    }

    @GetMapping(value = "/register")
    public String registerForm(Model model){
        model.addAttribute("userData", new UserRegistrationDTO());

        return "register";
    }

   // @PostMapping(value = "/register")
   // public String registerUser(@ModelAttribute(name = "userData") @Valid UserRegistrationDTO userRegistrationDTO, BindingResult bindingResult){
   //     if (bindingResult.hasErrors()){return "register";}
    //    return "registerDone";
    }

