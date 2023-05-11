package br.com.nycdev.personallibrary.controllers;

import br.com.nycdev.personallibrary.forms.LoginForm;
import br.com.nycdev.personallibrary.services.TokenService;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("authenticate")
public class AuthController {

    TokenService tokenService;

    public AuthController(){
        tokenService = new TokenService();
    }

    @PostMapping
    public void authenticationUser(@RequestBody LoginForm form) {

    }

    @GetMapping
    public String hello() {
        return "hello";
    }
}
