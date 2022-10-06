package org.example.web.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
public class BookIdToRemove {

    @NonNull
    private Integer id;

}
