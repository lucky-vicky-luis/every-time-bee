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
        return "pages/signup/signup";
    }
    @GetMapping("/main")
    public String main() {
        return "pages/main/main";
    }
    @GetMapping("/myarticle")
    public String myarticle() {
        return "pages/myarticle/myarticle";
    }
    @GetMapping("/allarticle")
    public String allarticle() {
        return "pages/allarticle/allarticle";
    }
    @GetMapping("/write")
    public String write() {
        return "pages/write/write";
    }
    @GetMapping("/detail")
    public String detail() {
        return "pages/detail/detail";
    }
    @GetMapping("/admin")
    public String admin() {
        return "pages/admin/admin";
    }
}