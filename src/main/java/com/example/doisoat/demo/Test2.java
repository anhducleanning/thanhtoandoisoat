package com.example.doisoat.demo;
import com.example.doisoat.model.TransEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {

        String  line = "                   '213213213";
        System.out.println(line);

        System.out.println(line.trim());
        if (line.trim().startsWith("'")) {
            String[] part = line.split("'");
            String part1 = part[1];
            System.out.println(part1);
        }
    }
}

