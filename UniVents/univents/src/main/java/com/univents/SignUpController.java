package com.univents;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpController {

    @GetMapping("/signup")
    public String showSignUpPage() {
        return "signup"; // This will look for signup.html in "src/main/resources/templates/"
    }
}
