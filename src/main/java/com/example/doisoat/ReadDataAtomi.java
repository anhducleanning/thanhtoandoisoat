package com.example.doisoat;

import com.example.doisoat.model.AtomiEntity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadDataAtomi {
    public static void main(String[] args) throws FileNotFoundException {
        ReadFileAtomi();
    }
    public static void ReadFileAtomi() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("D:\\Project\\ThanhToanDoiSoat\\FileDoiSoat\\atomi.tsv"));

        AtomiEntity atomiEntity[] = new AtomiEntity[1];

        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split("\t");
            atomiEntity[0] = new AtomiEntity(split[0], split[1], split[2], split[3], split[4], split[5],
                    split[6], split[7], split[8], split[9], split[10], split[11], split[12]);

            System.out.println(atomiEntity[0].getTID() + "-" + atomiEntity[0].getSERVICE_CODE());
            System.out.println();
        }

    }
}
