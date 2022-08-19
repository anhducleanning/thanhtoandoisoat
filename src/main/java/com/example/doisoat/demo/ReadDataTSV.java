package com.example.doisoat.demo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadDataTSV {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Start");
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateReturn = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);
        cal.add(Calendar.DATE, 3);

        Scanner input = new Scanner(System.in);

        Scanner s = new Scanner(new File("C:\\Users\\Administrator\\Desktop\\fileExcel\\file.txt"));
        List<InventoryRow> videos = new ArrayList<InventoryRow>();



        while (s.hasNextLine()) {
            String[] split = s.nextLine().split("   ");

            // x.charAt(0) returns the first char of the string "x"
            videos.add(new InventoryRow(split[0], split[1], split[2].charAt(0), split[3]));


        }  System.out.println(videos.toString());

        s.close();


    }
}