package io.github.kilmajster.config;


import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("https://kilmajster.github.io/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }
}
