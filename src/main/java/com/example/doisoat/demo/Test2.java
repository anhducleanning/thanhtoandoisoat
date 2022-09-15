package com.example.doisoat.demo;

import java.util.*;

public class Test2 {

    public static Long a = 0l;
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
       Long b =  getLong(list, a);
        System.out.println(list.size());
        System.out.println(b);
    }
        public static List<Long> listLong(Long a){
            List<Long> list= new ArrayList<>();
                list.add(3L);
                a = 3L;
                return list;
        }
    public static Long getLong( List<Long> list,Long a){
        list.add(3L);
       return a+1;
    }

}

