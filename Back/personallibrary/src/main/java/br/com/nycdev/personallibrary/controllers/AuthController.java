package br.com.nycdev.personallibrary.controllers;

import br.com.nycdev.personallibrary.forms.LoginForm;
import br.com.nycdev.personallibrary.services.TokenService;
import org.springframework.web.bind.annotation.*;


// TODO: 29/04/2023 Adicionar a autenticação 
@RestController
@CrossOrigin
@RequestMapping("v1/token")
public class AuthController {

    TokenService tokenService;

    public AuthController(){
        tokenService = new TokenService();
    }

    @PostMapping
    public void authenticationUser(@RequestBody LoginForm form) {

    }
}
