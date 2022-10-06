package org.example.app.service;

import lombok.extern.log4j.Log4j2;
import org.example.web.dto.Book;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
@Log4j2
public class BookRepository implements ProjectRepository<Book>, ApplicationContextAware {

    //private final List<Book> repo = new ArrayList<>();
    private ApplicationContext context;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> retrieveAll() {
        List<Book> books = jdbcTemplate.query("Select * from books", (ResultSet rs, int colum) ->{
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            //book.setSize(rs.getInt("size"));
            return book;
        } );

        return new ArrayList<>(books);
    }

    @Override
    public void store(Book book) {
        // book.setId(context.getBean(IdProvider.class).providerId(book));
        log.info("store new book" + book);
        //repo.add(book);
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
        for (Book book : retrieveAll()) {
            if (book.getId().equals(bookIdToRemove)) {
                log.info("remove book completed: " + book);
                return true;//repo.remove(book);
            }
        }
        return false;
    }

    @Override
    public boolean removeByRegex(String queryRegex) {
//        for (Book book : repo) {
//            if (book.getAuthor().contains(queryRegex) ||
//                    book.getTitle().contains(queryRegex)) {
//                return repo.remove(book);
//
//            }
//        }
        throw new RuntimeException("Method don`t work");
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
