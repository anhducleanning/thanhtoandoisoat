package com.example.doisoat;

import com.example.doisoat.model.ImediaBuyCardEntity;
import com.example.doisoat.model.ImediaTopUpEntity;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ReadImedia {


    public static final int STT = 0;
    public static final int THOI_GIAN = 1;
    public static final int NHA_CUNG_CAP = 2;
    public static final int MENH_GIA = 3;
    public static final int GIA_CHIET_KHAU = 4;
    public static final int MA_YEU_CAU = 5;
    public static final int MA_GIAO_DICH = 6;
    public static final int TRANG_THAI = 7;
    public static final int TAI_KHOAN_DICH = 8;


    public static void main(String[] args) throws IOException, ParseException {
        ReadImedia readImedia = new ReadImedia();


//        final String excelFilePath = "C:\\Users\\Administrator\\Desktop\\fileExcel\\ImediaTopUpClone.xls";
//        String TimeS = "23/08/2022 00:00:46";
//        String TimeE = "23/08/2022 23:59:59";
//        final List<ImediaTopUpEntity> books = readImedia.readInmediaTopup(excelFilePath,TimeS, TimeE);
//        for (ImediaTopUpEntity book : books) {
//            if(book.getThoiGian()!=null){
//                System.out.println(book);
//            }
//        }


        final String path = "C:\\Users\\Administrator\\Desktop\\fileExcel\\ImediaBuyCard.xls";
        String TimeSt = "23/08/2022 00:00:46";
        String TimeEn = "23/08/2022 23:59:59";
        final List<ImediaBuyCardEntity> listBuyCard = readImedia.readInmediaBuyCard(path,TimeSt, TimeEn);
        for (ImediaBuyCardEntity list: listBuyCard) {
            System.out.println(list);
        }


    }

    public List<ImediaTopUpEntity> readInmediaTopup(String excelFilePath, String TimeS, String TimeE) throws IOException, ParseException {
        List<ImediaTopUpEntity> listBooks = new ArrayList<>();

        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));

        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);

        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);

        int lastRow = sheet.getLastRowNum();

        int faild = 0;
        int total = 0;
        int sussess = 0;




        for (int i = 7; i <= lastRow; i++) {
            Row row = sheet.getRow(i);
            ImediaTopUpEntity model = new ImediaTopUpEntity();
            total ++;
            for (Cell cell : row) {
            Cell getCellTime = row.getCell(THOI_GIAN);
            if(CompareBetweenDateTime(TimeS,TimeE,String.valueOf(getCellValue(getCellTime)))==false){
                   break;
                }

//                Object cellValue = getCellValue(cell);

//                if (cellValue == null || cellValue.toString().isEmpty()) {
//
//                    continue;
//                }
//
             sussess ++;
             String a =   String.valueOf(getCellValue(cell));

                int columnIndex = cell.getColumnIndex();

                try {
                    switch (columnIndex) {
                        case STT:
                            model.setSTT(String.valueOf(getCellValue(cell)));
                            break;
                        case THOI_GIAN:
                            model.setThoiGian(String.valueOf(getCellValue(cell)));
                            break;
                        case NHA_CUNG_CAP:
                            model.setNhaCungCap(String.valueOf(getCellValue(cell)));
                            break;
                        case MENH_GIA:
                            model.setMenhGia(String.valueOf(getCellValue(cell)));
                            break;
                        case GIA_CHIET_KHAU:
                            model.setGiaChietKhau(String.valueOf(getCellValue(cell)));
                            break;
                        case MA_YEU_CAU:
                            model.setMaYeuCau(split(String.valueOf(getCellValue(cell))));
                            break;
                        case MA_GIAO_DICH:
                            model.setMaGiaoDich(split(String.valueOf(getCellValue(cell))));
                            break;
                        case TRANG_THAI:
                            model.setTrangThai(String.valueOf(getCellValue(cell)));
                            break;
                        case TAI_KHOAN_DICH:
                            model.setTaiKhoanDich(String.valueOf(getCellValue(cell)));
                            break;
                        default:
                            break;
                    }

                }catch (Exception e){

                }
                listBooks.add(model);
            }


        }
        System.out.println("Total:"+total);
        System.out.println("Faild:"+faild);
        System.out.println("Susses:"+sussess);
        workbook.close();
        inputStream.close();

        return listBooks;
    }
    public List<ImediaBuyCardEntity> readInmediaBuyCard(String excelFilePath, String TimeS, String TimeE) throws IOException, ParseException {
        List<ImediaBuyCardEntity> listBooks = new ArrayList<>();

        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));

        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);

        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);

        int test = sheet.getLastRowNum();

        int faild = 0;
        int total = 0;
        int sussess = 0;

        for (int i = 7; i <= test; i++) {
            Row row = sheet.getRow(i);
            ImediaBuyCardEntity model = new ImediaBuyCardEntity();
            total ++;
            for (Cell cell : row) {

                Cell getCellTime = row.getCell(THOI_GIAN);
                if(CompareBetweenDateTime(TimeS,TimeE,String.valueOf(getCellValue(getCellTime)))==false){
                    break;
                }

//                if (cellValue == null || cellValue.toString().isEmpty()) {
//
//                    continue;
//                }
                sussess ++;
                int columnIndex = cell.getColumnIndex();

                    switch (columnIndex) {
                        case STT:
                            model.setSTT(String.valueOf(getCellValue(cell)));
                            break;
                        case THOI_GIAN:
                        model.setThoiGian(String.valueOf(getCellValue(cell)));
                            break;
                        case NHA_CUNG_CAP:
                            model.setNhaCungCap(String.valueOf(getCellValue(cell)));
                            break;
                        case MENH_GIA:
                            model.setMenhGia(String.valueOf(getCellValue(cell)));
                            break;
                        case GIA_CHIET_KHAU:
                            model.setGiaChietKhau(String.valueOf(getCellValue(cell)));
                            break;
                        case MA_YEU_CAU:
                            model.setMaYeuCau(split(String.valueOf(getCellValue(cell))));
                            break;
                        case MA_GIAO_DICH:
                            model.setMaGiaoDich(split(String.valueOf(getCellValue(cell))));
                            break;
                        case TRANG_THAI:
                            model.setSeriThe(split(String.valueOf(getCellValue(cell))));
                            break;
                        case TAI_KHOAN_DICH:
                            model.setChietKhau(String.valueOf(getCellValue(cell)));
                            break;
                        default:
                            break;
                    }



            }

                if(model.getThoiGian()!=null)
                listBooks.add(model);



        }
        System.out.println("Total:"+total);
        System.out.println("Faild:"+faild);
        System.out.println("Susses:"+sussess);
        workbook.close();
        inputStream.close();

        return listBooks;
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

    public String split(String text) {
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
    }
}

