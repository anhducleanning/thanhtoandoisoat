package com.example.doisoat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class IndexController {

    @GetMapping("/index")
    public String index(){
        System.out.println("a");
        return "index";
    }
}

