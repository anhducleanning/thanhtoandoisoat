package com.example.doisoat.controller;

import com.example.doisoat.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
public class CompareController {

    @Autowired
    CompareDataSerivce compareDataSerivce;

    @GetMapping("/compare")
    public void compare() throws IOException {
        compareDataSerivce.compare();
   }

}
