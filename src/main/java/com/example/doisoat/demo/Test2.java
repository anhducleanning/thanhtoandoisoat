package com.example.doisoat.demo;

import java.util.*;

public class Test2 {


    public static void main(String[] args) {
            List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (Integer key:list) {
            System.out.println(key);
        }
    }

}

