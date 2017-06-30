package io.github.kilmajster.controller;

import io.github.kilmajster.model.HelloMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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

    @Bean
    private WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("https://kilmajster.herokuapp.com/");
            }
        };
    }
}
