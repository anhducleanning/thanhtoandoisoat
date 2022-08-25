package com.example.doisoat.demo;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws IOException, ParseException {
        Map<String, String> mapA = new HashMap<String, String>();
        mapA.put("1", "2");
        mapA.put("2", "2");
        mapA.put("3", "2");
        mapA.put("4", "2");
        mapA.put("5", "2");
        mapA.put("7", "2");
        mapA.put("8", "2");

        Map<String, String> mapB = new HashMap<String, String>();
        mapB.put("2", "3");
        mapB.put("3", "3");
        mapB.put("4", "3");
        mapB.put("5", "3");
        mapB.put("6", "3");
        mapB.put("7", "3");
        mapB.put("8", "3");


        Set<String> set = mapA.keySet();
//        for (String key : set) {
//            System.out.println(key + " " + mapA.get(key));
//        }

        System.out.println("---------MAP A---------");
        Set<String> set1 = mapA.keySet();
        for (String key : set1) {
            System.out.println(key + " " + mapA.get(key));
        }
        System.out.println("---------MAP B---------");
        Set<String> set2 = mapB.keySet();
        for (String key : set2) {
            System.out.println(key + " " + mapB.get(key));
        }

        Map<String, String> mapCloneA = new HashMap<>();
        mapCloneA.putAll(mapA);

        System.out.println("---------Diffe---------");

//        System.out.println("before" + set1 + mapA.get(set1));
        for (String key1 : set1) {
                for (String key2 : set2) {
                    if (key1.equals(key2)) {
                        mapCloneA.remove(key1);
                    }
                }
        }

//
//        mapCloneA.remove("2");
        for (String key :  mapCloneA.keySet()) {
            System.out.println(key + "-" + mapA.get(key));
        }
//
//
//        System.out.println("AfterRemove");
//        for (String key : mapA.keySet()) {
//            System.out.println(key + " " + mapA.get(key));
//        }

    }
}

