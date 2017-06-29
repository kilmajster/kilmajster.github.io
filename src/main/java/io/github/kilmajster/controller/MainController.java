package io.github.kilmajster.controller;

import io.github.kilmajster.model.HelloMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/")
public class MainController {

    private AtomicInteger counter = new AtomicInteger(0);

    @GetMapping("/")
    public @ResponseBody HelloMessage index(HttpServletRequest request) {
        
        return HelloMessage.builder()
                .id(Long.valueOf(counter.incrementAndGet()))
                .message("Hello " + request.getRemoteAddr())
                .currentTime(new Date())
                .build();
    }
}
