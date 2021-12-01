package com.rtb.authentication.couponservice.controllers;

import com.rtb.authentication.couponservice.model.User;
import com.rtb.authentication.couponservice.repository.UserRepository;
import com.rtb.authentication.couponservice.security.SecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/showReg")
    public String showRegistrationPage() {

        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String registerUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return "login";
    }

    @GetMapping("/")
    public String showLoginPage() {

        return "login";
    }

    @RequestMapping(name = "/login", method = RequestMethod.POST)
    public String login(String email, String password) {

        boolean loginResponse = securityService.login(email, password);

        log.info("login Response : " + loginResponse);

        if (loginResponse) {

            return "index";
        } else {
            return "login";
        }
    }

}
