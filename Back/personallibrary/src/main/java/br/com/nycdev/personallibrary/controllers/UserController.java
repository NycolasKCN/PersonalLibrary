package br.com.nycdev.personallibrary.controllers;

import br.com.nycdev.personallibrary.dtos.UserDto;
import br.com.nycdev.personallibrary.exceptions.UserLoginAlreadyExistsException;
import br.com.nycdev.personallibrary.forms.UserForm;

import br.com.nycdev.personallibrary.repositorys.UserRepository;
import br.com.nycdev.personallibrary.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserRepository repository) {
        userService = new UserService(repository);
    }

    @PostMapping
    public ResponseEntity<UserDto> registerUser(@RequestBody UserForm userForm) {
        try {
            return new ResponseEntity<>(userService.registerUser(userForm), HttpStatus.CREATED);
        } catch (UserLoginAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping
    public List<UserDto> getALlUsers() {
        return userService.getAll();
    }
}
