package br.com.nycdev.personallibrary.controllers;

import br.com.nycdev.personallibrary.dtos.BookDto;
import br.com.nycdev.personallibrary.exceptions.BookAlreadyExistsException;
import br.com.nycdev.personallibrary.forms.BookForm;
import br.com.nycdev.personallibrary.repositorys.BookRepository;
import br.com.nycdev.personallibrary.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
@RequestMapping("v1/books")
public class BookController {

    private final BookService service;

    public BookController(BookRepository repository) {
        service = new BookService(repository);
    }

    @GetMapping
    @RequestMapping("/add")
    public ResponseEntity<BookDto> addBook(@RequestBody BookForm bookForm) throws BookAlreadyExistsException {
        try {
            return new ResponseEntity<>(service.addBook(bookForm), HttpStatus.CREATED);
        } catch (BookAlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());

        }
    }
}
