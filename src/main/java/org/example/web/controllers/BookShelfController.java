package org.example.web.controllers;

import lombok.extern.log4j.Log4j2;
import org.example.app.exception.BookShelfLoginException;
import org.example.app.service.BookService;
import org.example.web.dto.Book;
import org.example.web.dto.BookIdToRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/books")
@Log4j2
@Scope("singleton")
public class BookShelfController {

    private final BookService bookService;

    private final String REDIRECT_BOOKS_SHELF = "redirect:/books/shelf";
    private final String BOOK_SHELF = "book_shelf";

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/shelf")
    public String books(Model model) {
        log.info(this.toString());
        model.addAttribute("book", new Book());
        model.addAttribute("bookIdToRemove", new BookIdToRemove());
        model.addAttribute("bookList", bookService.getAllBooks());
        return BOOK_SHELF;
    }

    @PostMapping("/save")
    public String saveBook(Book book) {
        bookService.saveBook(book);
        log.info("current repository size " + bookService.getAllBooks().size());
        return REDIRECT_BOOKS_SHELF;
    }

    @PostMapping("/remove")
    public String removeBook(BookIdToRemove bookIdToRemove) {
        if (bookService.removeBookById(bookIdToRemove.getId())) {
            return REDIRECT_BOOKS_SHELF;
        } else {
            return BOOK_SHELF;
        }
    }

    @PostMapping("/removeByRegex")
    public String removeByRegex(String queryRegex) {
        if (bookService.removeByRegex(queryRegex)) {
            return REDIRECT_BOOKS_SHELF;
        }
        return BOOK_SHELF;
    }




}
