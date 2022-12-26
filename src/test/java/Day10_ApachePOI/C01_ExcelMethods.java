package Day10_ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExcelMethods {
    public static void main(String[] args) throws IOException {
        String path ="src\\test\\java\\resources\\excelfile.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        Workbook wb = WorkbookFactory.create(fileInputStream);

        Sheet sheet =wb.getSheetAt(0);

        Row row1=sheet.getRow(0);

        Cell cell1 =row1.getCell(0);
        System.out.println("cell1 = " + cell1.toString().toLowerCase());


    }
}
