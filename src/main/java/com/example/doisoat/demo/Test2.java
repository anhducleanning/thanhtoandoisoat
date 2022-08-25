package com.example.doisoat.demo;
import com.example.doisoat.model.TransEntity;

import java.io.*;
import java.util.*;

public class Test2 {

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("1","1");
        map1.put("2","2");
        map1.put("3","3");

        Map<String, String> map2 = new HashMap<>();
        map2.put("4","4");
        map2.put("5","5");
        map2.put("6","6");

        Map<String, String> map3 = new HashMap<>();
        Map<String, String> temp = new HashMap<>();
        map3.putAll(map1);
        map3.putAll(map2);
        temp.putAll(map3);


        Map<String, String> map4 = new HashMap<>();
        map4.put("1","1");
        map4.put("2","2");
        map4.put("3","3");

        for (String keyAtomi :  map3.keySet()) {
            for (String keyImedia : map4.keySet()) {
                if (keyAtomi.equals(keyImedia)){
                    temp.remove(keyAtomi);
                }
            }
        }



        for (String key : temp.keySet()) {
            System.out.println("key Atomi: " + key);
        }


    }
}

