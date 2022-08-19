package com.example.doisoat.demo;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Test {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("D:\\Project\\ThanhToanDoiSoat\\FileDoiSoat\\atomi.txt");
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("D:\\Project\\ThanhToanDoiSoat\\FileDoiSoat\\atomi.txt");
            System.out.println("FileContents :");
            //read characters from FileInputStream and write them
            byte[] bytes = new byte[5];
            // So byte doc duoc tu FileInputStream
            int bytesReaded = fin.read(bytes);
            while (bytesReaded != -1) {
                for (int i = 0; i < bytesReaded; i++) {
                    System.out.print((char) bytes[i]);
                }
                bytesReaded = fin.read(bytes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
