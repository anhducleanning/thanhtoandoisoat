package com.example.doisoat.demo;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        HashSet<String> listA = new HashSet<String>();
        HashSet<String> listB = new HashSet<String>();


        for (int i = 0; i < 5; i++) {
            listA.add(String.valueOf(i));
            listB.add(String.valueOf(i+2));
        }

        System.out.println("--------After----------");
        System.out.println(listA);
        System.out.println(listB);


        List<String> temp = new ArrayList<>();

        for (String a:listA) {
            for (String b:listB) {
                if(!a.contains(b)){
                   temp.add(a);
                }
            }
        }

//        for (String a: listA) {
//            for (String b: listB) {
//                if(a.equals(b)){
//                    System.out.println();
//                    listB.remove(b);
//                    listA.remove(a);
//                    break;
//                }
//            }
//
//        }

        for (String in:temp) {
            listA.remove(in);
        }


        System.out.println("--------Before----------");
        System.out.println(listA);
        System.out.println(listB);
    }
}

