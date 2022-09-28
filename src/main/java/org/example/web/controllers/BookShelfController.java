package org.example.web.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("books")
@Log4j2
public class BookShelfController {

    @GetMapping("/shelf")
    public String books(){
        log.info("got book shelf");
        return "book_shelf";
    }


}
