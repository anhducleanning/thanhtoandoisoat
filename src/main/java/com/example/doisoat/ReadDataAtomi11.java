//package com.example.doisoat;
//
//import com.example.doisoat.model.AtomiEntity;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class ReadDataAtomi11 {
//    public static void main(String[] args) throws FileNotFoundException {
//        String path = "C:\\Users\\Administrator\\Desktop\\fileExcel\\atomi.tsv";
//        ReadFileAtomi(path);
//    }
//    public static void ReadFileAtomi(String path) throws FileNotFoundException {
//
//        Scanner sc = new Scanner(new File(path));
//        int n =  ReadDataAtomi11.countLine(path);
//
//        AtomiEntity atomiEntity[] = new AtomiEntity[n];
//        List<AtomiEntity> list = new ArrayList<>();
//
////        while (sc.hasNextLine()) {
////            String[] split = sc.nextLine().split("\t");
////            atomiEntity[0] = new AtomiEntity(split[0], split[1], split[2], split[3], split[4], split[5],
////                    split[6], split[7], split[8], split[9], split[10], split[11], split[12]);
////
////            System.out.println(atomiEntity[0].getTID() + "-" + atomiEntity[0].getSERVICE_CODE());
////            System.out.println(atomiEntity[0].toString());
////        }
//
//        for (int i = 0; i < n; i++) {
//            String[] split = sc.nextLine().split("\t");
//            atomiEntity[i] = new AtomiEntity(split[0], split[1], split[2], split[3], split[4], split[5],
//                    split[6], split[7], split[8], split[9], split[10], split[11], split[12]);
//
////            System.out.println(atomiEntity[i].getTID() + "-" + atomiEntity[i].getSERVICE_CODE());
//            list.add(atomiEntity[i]);
//        }
//        for (AtomiEntity atomi: list) {
//            System.out.println(atomi.getTID());
//        }
//    }
//
//    public static int countLine(String path){
//        Path pathFile = Paths.get(path);
//
//        int lines = 0;
//        try {
//
//            // much slower, this task better with sequence access
//            //lines = Files.lines(path).parallel().count();
//
//            lines = (int) Files.lines(pathFile).count();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return lines;
//    }
//}
