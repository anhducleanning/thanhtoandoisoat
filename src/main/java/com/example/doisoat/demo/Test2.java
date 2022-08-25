package com.example.doisoat.demo;
import com.example.doisoat.model.TransEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {

        String fileName = "C:\\Users\\saotr\\Desktop\\fileDoiSoat\\testAtomi.tsv";
        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            list = br.lines().skip(1).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String a:list) {
            System.out.println(a);
        }
    }
}

