package com.ecommerce.testutils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    public static String TEST_DATA_PATH = "./src/main/java/com/ecommerce/testdata/TutorialsNinjaTestData.xlsx";
    public static Workbook book;
    public static Sheet sheet;

    public static Object[][]  getTestdata(String sheetName)
    {
        Object[][] data = null;
        try {
            FileInputStream file  = new FileInputStream(TEST_DATA_PATH);
            book= WorkbookFactory.create(file);
            sheet = book.getSheet(sheetName);

            data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            for(int i=0;i<sheet.getLastRowNum();i++){
                for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
                    data[i][j] = sheet.getRow(i+1).getCell(j).toString();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
          return data;
    }
}
