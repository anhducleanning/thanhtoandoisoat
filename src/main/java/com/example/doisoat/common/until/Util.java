package com.example.doisoat.common.until;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Util {
    public static String convertTimeImedia(String fomartDateImedia, String fomartDateAtomi,  String time){
        String timeFinal = null;
        try{
            if(time ==null || time.equals("")) {
                return null;
            }
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(fomartDateImedia);
                DateTimeFormatter dateFormatterNew = DateTimeFormatter.ofPattern(fomartDateAtomi);
                LocalDateTime ldateTime = LocalDateTime.parse(time, dateFormatter);
                 timeFinal = dateFormatterNew.format(ldateTime);
                

        }catch (Exception e){
            e.printStackTrace();
        }
        return timeFinal;
    }

    public static boolean CompareBetweenDateTime(String timeStart, String timeEnd, String timeRow, String fomartDate) throws ParseException {

        try {
            if(timeRow==null||timeStart.equals("")){
                return false;
            }
            SimpleDateFormat sdf = new SimpleDateFormat(fomartDate);
            Date timeS = sdf.parse(timeStart);
            Date timeE= sdf.parse(timeEnd);
            Date timeR = sdf.parse(timeRow);

            // compareTo
            int diffStart = timeS.compareTo(timeR);
            int diffEnd = timeE.compareTo(timeR);

            if(diffStart <0 &&diffEnd >0) {
                return true;
            } else if(diffStart == 0 || diffEnd ==0) {
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public static boolean compareBetweenDateTime(String timeStart, String timeEnd, String timeRow) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date timeS = sdf.parse(timeStart);
        Date timeE = sdf.parse(timeEnd);
        Date timeR = sdf.parse(timeRow);

        // compareTo
        int diffStart = timeS.compareTo(timeR);
        int diffEnd = timeE.compareTo(timeR);

        if (diffStart < 0 && diffEnd > 0) {
            return true;
        } else if (diffStart == 0 || diffEnd == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String split(String text) {
        if (text.trim().startsWith("'")) {
            String[] part = text.split("'");
            String part1 = part[1];
            return part1;
        }
        return text;
    }

    public static String splitComma(String str){
       return str.replaceAll(",", "");
    }
}
