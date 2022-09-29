package org.example.web.controllers;

import lombok.extern.log4j.Log4j2;
import org.example.app.service.BookService;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/books")
@Log4j2
public class BookShelfController {

    private final BookService bookService;

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/shelf")
    public String books(Model model){
        log.info("got book shelf");
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());
        return "book_shelf";
    }

    @PostMapping("/save")
    public String saveBook(Book book){
        bookService.saveBook(book);
        log.info("current repository size " + bookService.getAllBooks().size());
        return "redirect:/books/shelf";
    }

    @PostMapping("/remove")
    public String removeBook(Integer bookIdToRemove){
        if (bookService.removeBookById(bookIdToRemove)){
            return "redirect:/books/shelf";
        }
        else {
            return "book_shelf";
        }
    }


}
