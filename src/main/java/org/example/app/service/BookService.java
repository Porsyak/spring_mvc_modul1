package org.example.app.service;

import lombok.extern.log4j.Log4j2;
import org.example.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class BookService {
    private final ProjectRepository<Book> bookRepo;

    @Autowired
    public BookService(ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retrieveAll();

    }

    public void saveBook(Book book) {
        if (book.getTitle().trim().length() != 0 ||
                book.getAuthor().trim().length() != 0) {
            bookRepo.store(book);
        }
    }

    public boolean removeBookById(Integer bookIdToRemove) {
        return bookRepo.removeItemById(bookIdToRemove);
    }

    public boolean removeByRegex(String query) {
        return bookRepo.removeByRegex(query);
    }

    private void defaultInit() {
        log.info("default INIT in BookService");
    }

    private void defaultDestroy() {
        log.info("destroy INIT in BookService");
    }


}
