package com.example.doisoat;

import com.example.doisoat.model.ImediaBuyCardEntity;
import com.example.doisoat.model.ImediaTopUpEntity;
import com.example.doisoat.model.TransEntity;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadImedia {



    public static final int STT = 0;
    public static final int THOI_GIAN = 1;
    public static final int MA_YEU_CAU = 5;


    public static void main(String[] args) throws IOException, ParseException {

        final String excelFilePath = "C:\\Users\\saotr\\Desktop\\fileDoiSoat\\buycard.xls";
        final String link = "C:\\Users\\Administrator\\Desktop\\fileDoiSoat\\topup.xls";
        String TimeS = "24/08/2022 00:00:46";
        String TimeE = "24/08/2022 23:59:59";


        Map<String,TransEntity> buyCard =  readInmedia(excelFilePath,TimeS,TimeE);


        for (String key : buyCard.keySet()) {
            TransEntity value = buyCard.get(key);
            System.out.println(key + " = " + value);
        }


    }

    public static Map<String,TransEntity> readInmedia(String excelFilePath, String TimeS, String TimeE) throws IOException, ParseException {
        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));

        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);

        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);

        Map<String, TransEntity> map = new LinkedHashMap<String, TransEntity>();

        int test = sheet.getLastRowNum();


        for (int i = 7; i <= test; i++) {
            Row row = sheet.getRow(i);
            TransEntity tran = new TransEntity();
            for (Cell cell : row) {

                Cell getCellTime = row.getCell(THOI_GIAN);
                if (CompareBetweenDateTime(TimeS, TimeE, String.valueOf(getCellValue(getCellTime))) == false) {
                    break;
                }

                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case STT:
                        tran.setID(String.valueOf(getCellValue(cell)));
                        break;
                    case THOI_GIAN:
                        tran.setDATETIME_LOG(String.valueOf(getCellValue(cell)));
                        break;
                    case MA_YEU_CAU:
                        tran.setTRANS_ID(split(String.valueOf(getCellValue(cell))));
                        break;
                    default:
                        tran.setCUSTOMER_CODE("Mua mã thẻ");
                        break;
                }


            }

            if (tran.getDATETIME_LOG() != null)
                map.put(tran.getTRANS_ID(),tran);


        }

        workbook.close();
        inputStream.close();

        return map;
    }

    // Get Workbook
    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
        return workbook;
    }

    // Get cell value
    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellTypeEnum();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = Math.round(cell.getNumericCellValue());
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            default:
                break;
        }

        return cellValue;
    }

    //Split number if exits "'"

    public static String split(String text) {
        if (text.startsWith("'")) {
            String[] part = text.split("'");
            String part1 = part[1];
            return part1;
        }
        return text;
    }

    //Comparty betweenDate
    public static boolean CompareBetweenDateTime(String timeStart, String timeEnd, String timeRow) throws ParseException {
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
}

