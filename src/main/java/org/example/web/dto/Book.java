package org.example.web.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Digits;

@Log4j2
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Integer id;

    private String author;

    private String title;

    @Digits(integer = 4, fraction = 0)
    private Integer size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
