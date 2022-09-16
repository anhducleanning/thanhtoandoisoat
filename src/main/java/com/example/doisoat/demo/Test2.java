package com.example.doisoat.demo;

import java.util.*;

public class Test2 {

    public static Long a = 0l;
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }

        for (int i = 3; i < 10; i++) {
            list.add(i);
        }

        for (Integer index:list) {
            System.out.println(index);
        }
    }

}

