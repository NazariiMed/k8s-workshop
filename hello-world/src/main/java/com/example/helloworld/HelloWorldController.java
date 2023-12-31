package com.example.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloWorld")
public class HelloWorldController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping
    public String helloWorld(){
        logger.info("received hello world request");
        return "Hello world!";
    }
}
