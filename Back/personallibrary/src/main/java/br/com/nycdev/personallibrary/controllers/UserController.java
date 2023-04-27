package br.com.nycdev.personallibrary.controllers;

import br.com.nycdev.personallibrary.dtos.UserDto;
import br.com.nycdev.personallibrary.exceptions.UserLoginAlreadyExists;
import br.com.nycdev.personallibrary.forms.UserForm;

import br.com.nycdev.personallibrary.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("v1/users")
public class UserController {

    private final UserService userService = new UserService();

    @PostMapping
    public ResponseEntity<UserDto> registerUser(@RequestBody UserForm userForm) {
        try {
            return new ResponseEntity<>(userService.registerUser(userForm), HttpStatus.CREATED);
        } catch (UserLoginAlreadyExists e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
