package com.example.doisoat.demo;
import com.example.doisoat.model.TransEntity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {

        String text = "Ki tu duoc ghi vao file";

        try {

            BufferedWriter f_writer = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\file24\\doisoat.txt"));

            f_writer.write(text);

            f_writer.close();
        }

        // Catch block to handle if exceptions occurs
        catch (IOException e) {

            // Print the exception on console
            // using getMessage() method
            System.out.print(e.getMessage());
        }
    }
}

