package com.example.doisoat.controller;

import com.example.doisoat.demo.dowloadupload.FileUploadResponse;
import com.example.doisoat.dto.LinkFilePartern;
import com.example.doisoat.model.TransEntity;
import com.example.doisoat.service.*;
import com.example.doisoat.service.impl.CompareDataSerivceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
public class CompareController {

    @Autowired
    CompareDataSerivce compareDataSerivce;

    @Autowired
    CompareDataSerivceImpl serivce;

    @PostMapping ("/compare")
    public ResponseEntity<List<TransEntity>> compare(
            @RequestParam("fileAtomi") MultipartFile fileAtomi,
            @RequestParam("fileImedia1") MultipartFile fileImedia1 ,
            @RequestParam("fileImedia2") MultipartFile fileImedia2) throws IOException {
//        compareDataSerivce.compare(fileAtomi,fileImedia1,fileImedia2);
        return new ResponseEntity<>( compareDataSerivce.compare(fileAtomi,fileImedia1,fileImedia2), HttpStatus.OK);
   }


//    @PostMapping("/upfile")
//    public  ResponseEntity<List<LinkFilePartern>> uploadFile(
//            @RequestParam("fileAtomi") MultipartFile fileAtomi,
//            @RequestParam("fileImedia1") MultipartFile fileImedia1 ,
//            @RequestParam("fileImedia2") MultipartFile fileImedia2
//            ) throws IOException {
//      List<LinkFilePartern> list =  serivce.linkFileUpload(fileAtomi,fileImedia1,fileImedia2);
//      return new ResponseEntity<>(list, HttpStatus.OK);
//    }

}
