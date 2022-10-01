package org.example.web.controllers;

import lombok.extern.log4j.Log4j2;
import org.example.app.service.LoginService;
import org.example.web.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String login(Model model) {
        log.info("GET /login return login_page.html");
        model.addAttribute("loginForm", new LoginForm());
        return "login_page";
    }

    @PostMapping("/auth")
    public String authenticate(LoginForm loginForm) {
        if (loginService.authenticate(loginForm)) {
            log.info("login OK redirect to book shelf");
            return "redirect:/books/shelf";
        } else {
            log.info("login FAIL redirect to book shelf, back to login");
            return "redirect:/login";
        }
    }
}
