import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadAndInsertImedia {


    public static final int COLUMN_INDEX_TAIKHOAN = 0;
    public static final int COLUMN_INDEX_SYSTEMTRAYID = 1;
    public static final int COLUMN_INDEX_MENHGIA = 2;
    public static final int COLUMN_INDEX_TRANGTHAI = 3;
    public static final int COLUMN_INDEX_NGAYTHANG = 4;
    public static final int COLUMN_INDEX_REQUESTID = 5;
    public static final int COLUMN_INDEX_PHONE = 6;
    public static final int COLUMN_INDEX_CHIETKHAU = 7;
    public static final int COLUMN_INDEX_SOLUONG = 8;
    public static final int COLUMN_INDEX_NHAMANG = 9;


    public static void main(String[] args) throws IOException {
        final String excelFilePath = "C:\\Users\\Administrator\\Desktop\\fileExcel\\Book2.xlsx";
        final List<ImediaModel> books = readExcel(excelFilePath);
        for (ImediaModel book : books) {
            System.out.println(book);
        }
    }



    public static List<ImediaModel> readExcel(String excelFilePath) throws IOException {
        List<ImediaModel> listBooks = new ArrayList<>();

        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));

        // Get workbook
        Workbook workbook = getWorkbook(inputStream, excelFilePath);

        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);

        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                // Ignore header
                continue;
            }

            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            // Read cells and set value for book object
            ImediaModel model = new ImediaModel();
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
                // Set value for book object
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case COLUMN_INDEX_TAIKHOAN:
                        model.setTaiKhoan((String) getCellValue(cell));
                        System.out.println((String) getCellValue(cell));
                        break;
                    case COLUMN_INDEX_SYSTEMTRAYID:
                        model.setSystemTrayId(String.valueOf(getCellValue(cell)));
                        System.out.println(getCellValue(cell));
                        break;
                    case COLUMN_INDEX_MENHGIA:
                        model.setMenhGia(String.valueOf(getCellValue(cell)));
                        System.out.println(getCellValue(cell));
                        break;
                    case COLUMN_INDEX_TRANGTHAI:
                        model.setTrangThai(String.valueOf(getCellValue(cell)));
                        System.out.println(getCellValue(cell));
                        break;
                    case COLUMN_INDEX_NGAYTHANG:
//                        book.setNgayThang(String.valueOf(cell.getDateCellValue());
                        String pattern = "MM/dd/yyyy HH:mm:ss";
                        DateFormat df = new SimpleDateFormat(pattern);
                        String todayAsString = df.format(cell.getDateCellValue());
                        System.out.println(todayAsString);
                        break;
                    case COLUMN_INDEX_REQUESTID:
                        model.setRequestID(String.valueOf(getCellValue(cell)));
                        System.out.println(getCellValue(cell));
                        break;
                    case COLUMN_INDEX_PHONE:
                        model.setPhone(String.valueOf(getCellValue(cell)));
                        System.out.println(getCellValue(cell));
                        break;
                    case COLUMN_INDEX_CHIETKHAU:
                        model.setChietKhau(String.valueOf(getCellValue(cell)));
                        System.out.println(getCellValue(cell));
                        break;
                    case COLUMN_INDEX_SOLUONG:
                        model.setSoLuong(String.valueOf(getCellValue(cell)));
                        System.out.println(getCellValue(cell));
                        break;
                    case COLUMN_INDEX_NHAMANG:
                        model.setNhaMang(String.valueOf(getCellValue(cell)));
                        System.out.println(getCellValue(cell));
                        break;
                    default:
                        break;
                }

            }
            listBooks.add(model);
        }
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
}
