package com.example.doisoat.controller;

import com.example.doisoat.ReadDataAtomi;
import com.example.doisoat.ReadImediaTxt;
import com.example.doisoat.model.*;
import com.example.doisoat.service.*;
import com.example.doisoat.until.GlobalConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

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
