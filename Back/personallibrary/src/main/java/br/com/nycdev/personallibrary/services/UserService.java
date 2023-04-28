package br.com.nycdev.personallibrary.services;

import br.com.nycdev.personallibrary.dtos.UserDto;
import br.com.nycdev.personallibrary.exceptions.UserLoginAlreadyExists;
import br.com.nycdev.personallibrary.forms.UserForm;
import br.com.nycdev.personallibrary.models.User;
import br.com.nycdev.personallibrary.repositorys.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        userRepository = repository;
    }

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    public UserDto registerUser(UserForm userForm) throws UserLoginAlreadyExists {
        log.info("Passando pelo Service");
        Optional<User> userOptional = userRepository.findByLogin(userForm.login());
        if (userOptional.isPresent()) {
            throw new UserLoginAlreadyExists("User with login: " +userForm.login()+ " already exists.");
        }
        User user = new User(userForm);
        userRepository.save(user);
        return new UserDto(user);
    }

    public List<UserDto> getAll() {
        List<UserDto> all = new ArrayList<>();

        userRepository.findAll().forEach(user -> {
            all.add(new UserDto(user));
        });
        return all;
    }
}
