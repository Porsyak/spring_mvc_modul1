package org.example.app.service;

import lombok.extern.log4j.Log4j2;
import org.example.web.dto.Book;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Log4j2
public class BookRepository implements ProjectRepository<Book>,
        ApplicationContextAware {

    private final List<Book> repo = new ArrayList<>();
    private ApplicationContext context;

    @Override
    public List<Book> retrieveAll() {

        return new ArrayList<>(repo);
    }

    @Override
    public void store(Book book) {
        book.setId(context.getBean(IdProvider.class).providerId(book));
        log.info("store new book" + book);
        repo.add(book);
    }

    @Override
    public boolean removeItemById(String bookIdToRemove) {
        for (Book book : repo) {
            log.info("remove book completed " + book);
            if (repo.remove(book)) return true;
        }
        return false;
    }

    @Override
    public boolean removeByRegex(String queryRegex) {
        for (Book book : repo) {
            if (book.getAuthor().contains(queryRegex) ||
                    book.getTitle().contains(queryRegex)) {
                repo.remove(book);
                return true;
            }
        }
        return false;
    }

//    @Override
//    public boolean removeByRegex(Integer queryRegex) {
//        for (Book book : repo) {
//            if (book.getSize().equals(queryRegex)) {
//                repo.remove(book);
//            }
//        }
//
//        return false;
//    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.context = applicationContext;
    }

    private void defaultInit() {
        log.info("default INIT in book repo bean");
    }

    private void defaultDestroy() {
        log.info("destroy DESTROY in book repo bean ");
    }


}
