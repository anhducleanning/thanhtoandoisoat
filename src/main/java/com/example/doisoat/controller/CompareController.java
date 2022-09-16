package com.example.doisoat.controller;

import com.example.doisoat.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

@RestController
@Slf4j
public class CompareController {

    @Autowired
    CompareDataSerivce compareDataSerivce;

    @GetMapping("/compare")
    public void compare() throws IOException {
        compareDataSerivce.compare();
   }

   @GetMapping("/map")
    public ResponseEntity<HashMap<Integer, String>> getHashMap(){
       HashMap<Integer, String> map = new HashMap<>();
       map.put(1,"Xin chào");
       map.put(2,"Xin chào");
       map.put(3,"Xin chào");
       map.put(4,"Xin chào");
       map.put(5,"Xin chào");
       map.put(6,"Xin chào");
       return new ResponseEntity<HashMap<Integer,String>>(map, HttpStatus.OK);
   }

}
