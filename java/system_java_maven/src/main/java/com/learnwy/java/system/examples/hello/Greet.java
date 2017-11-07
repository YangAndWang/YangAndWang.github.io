package com.learnwy.java.system.examples.hello;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/api/greet"})
public class Greet {

    @GetMapping
    public String greeting() {
        return "greeting,everyone.";
    }
}
