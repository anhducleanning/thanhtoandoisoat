package com.example.doisoat;

import java.util.Random;

public class Order_Id_Random {
    public String genOderId(){
        String alphabet = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");

        String result = new String();
        Random r = new Random();

        for (int i=0; i<9; i++)
            result = result + alphabet.charAt(r.nextInt(9));
        return result;
    }
}
