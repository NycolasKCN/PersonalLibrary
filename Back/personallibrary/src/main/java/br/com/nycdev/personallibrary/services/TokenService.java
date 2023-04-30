package br.com.nycdev.personallibrary.services;

import org.springframework.stereotype.Service;

// TODO: 29/04/2023 Adicionar a autenticação

@Service
public class TokenService {

    @Value()
    private String expiration;
}
