package com.project.everytime.domain.auth.client.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    @GetMapping("/login")
    public String login() {
        return "pages/login/login";
    }

    @GetMapping("/onboarding")
    public String onboarding() {
        return "pages/onboarding/onboarding";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
}