package br.com.nycdev.personallibrary.exceptions;

public class UserLoginAlreadyExists extends Exception{
    public UserLoginAlreadyExists(String message) {
        super(message);
    }

    public UserLoginAlreadyExists() {
    }
}
