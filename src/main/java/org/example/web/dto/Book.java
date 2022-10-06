package org.example.web.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Digits;

@Log4j2
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Integer id;

    private String author;

    private String title;

    @Digits(integer = 4, fraction = 0)
    private Integer size;
}
