package com.example.doisoat.demo;

import com.example.doisoat.common.until.Constant;
import com.example.doisoat.common.until.Util;

import java.util.*;

public class Test2 {


    public static void main(String[] args) {
        String TimeS = "25/08/2022 00:00:00";
        String timeAtomi = "2022-08-25 00:00:00";
        System.out.println(Util.convertTimeImedia(Constant.FomartDate.DATE_FORMAT_ATOMI,Constant.FomartDate.DATE_FORMAT_IMEDIA, timeAtomi));

    }

}

