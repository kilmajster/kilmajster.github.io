package io.github.kilmajster.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class HelloMessage {

    private Long id;
    private String message;
    private Date currentTime;
}
