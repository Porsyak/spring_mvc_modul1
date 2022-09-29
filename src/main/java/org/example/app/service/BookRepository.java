package org.example.app.service;

import lombok.extern.log4j.Log4j2;
import org.example.web.dto.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Log4j2
public class BookRepository implements ProjectRepository<Book> {

    private final List<Book> repo = new ArrayList<>();

    @Override
    public List<Book> retrieveAll() {

        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        book.setId(book.hashCode());
        log.info("store new book" + book);
        repo.add(book);
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
        for (Book book : repo) {
            if (book.getId().equals(bookIdToRemove)){
            log.info("remove book completed " + book);
            return repo.remove(book);
             }
        }
        return false;
    }
}
