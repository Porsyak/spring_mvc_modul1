package org.example.app.service;

import lombok.extern.log4j.Log4j2;
import org.example.web.dto.LoginForm;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class LoginService {
    public boolean authenticate(LoginForm loginForm){
        log.info("try auth with user-form: " + loginForm);
        return loginForm.getUsername().equals("root") && loginForm.getPassword().equals("123");
    }
}
