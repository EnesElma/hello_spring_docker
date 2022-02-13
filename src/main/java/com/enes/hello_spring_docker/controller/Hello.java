package com.enes.hello_spring_docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("docker")
public class Hello {

    @GetMapping("hello")
    public String sayHello(){
        return "Hello from docker";
    }

    @GetMapping("{text}")
    public String sayText(@PathVariable String text){
        return "Your text is " + text;
    }
}
