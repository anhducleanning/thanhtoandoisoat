package com.example.doisoat;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Test {
    public static void main(String[] args) {
        Timestamp ts = Timestamp.valueOf(LocalDateTime.now(ZoneId.of("UTC")));

        System.out.println(ts);
    }
}
