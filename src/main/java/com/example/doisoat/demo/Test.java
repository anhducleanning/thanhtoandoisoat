package com.example.doisoat.demo;

public class Test {

    public static void main(String[] args){
        String str = "50000";
        String[] arr = str.replaceAll(",","").split("[ ,]");
        String s = str.replaceAll(",","");
        System.out.println(s);

    }
}

