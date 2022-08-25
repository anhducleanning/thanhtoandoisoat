//package com.example.doisoat;
//
//import com.example.doisoat.model.AtomiEntity;
//import com.example.doisoat.model.ImediaTopUpEntity;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//
//public class CompareBetween {
//
//
//    public static void main(String[] args) throws IOException, ParseException {
//
//
//        String excelFilePath = "C:\\Users\\Administrator\\Desktop\\fileExcel\\Imedia1.xls";
//        ReadImedia readImedia = new ReadImedia();
//         List<ImediaTopUpEntity> listImedia = readImedia.readInmediaTopup(excelFilePath);
//
//        ReadDataAtomi readDataAtomi = new ReadDataAtomi();
//        String path = "C:\\Users\\Administrator\\Desktop\\fileExcel\\atomi.tsv";
//        List<AtomiEntity> listAtomi =  readDataAtomi.ReadFileAtomi(path);
//
//        HashSet<String>  setAtomi = new   HashSet<String>();
//        HashSet<String>  setImedia = new  HashSet<String>();
//
//        //Add TID Atomi
//        for (AtomiEntity atomi: listAtomi) {
//            setAtomi.add(atomi.getATMD_TRANS_ID());
//        }
//
//        //Add MaGiaoDich Imedia
//        for (ImediaTopUpEntity imedia: listImedia) {
//            setImedia.add(imedia.getMaGiaoDich());
//        }
//
//        List<String> tempAtomi = new ArrayList<>();
//        List<String> tempImedia = new ArrayList<>();
//
//        for (String a:setAtomi) {
//            for (String b:setImedia) {
//                if(a.contains(b)){
//                    tempAtomi.add(a);
//                }
//            }
//        }
//
//        for (String a:setImedia) {
//            for (String b:setAtomi) {
//                if(a.contains(b)){
//                    tempImedia.add(a);
//                }
//            }
//        }
//
//        for (String in:tempAtomi) {
//            setAtomi.remove(in);
//        }
//
//        for (String in:tempImedia) {
//            setImedia.remove(in);
//        }
//
//        System.out.println(setAtomi);
//        System.out.println(setImedia);
//    }
//}
