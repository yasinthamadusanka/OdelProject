package com.odel.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.odel.base.BaseClass;

public class TestUtil extends BaseClass{
    public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + "/src/test/resources/testdata/TestData.xlsx";

    static Workbook book;
    static Sheet sheet;

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
            book = WorkbookFactory.create(file);
        } catch (FileNotFoundException e) {
            System.err.println("Test data file not found at: " + TESTDATA_SHEET_PATH);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading test data file.");
            e.printStackTrace();
        } finally {
            try {
                if (file != null) file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (book == null) {
            throw new RuntimeException("Workbook could not be initialized.");
        }

        sheet = book.getSheet(sheetName);
        if (sheet == null) {
            throw new RuntimeException("Sheet not found: " + sheetName);
        }

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                Cell cell = sheet.getRow(i + 1).getCell(k);
                data[i][k] = getCellValue(cell);
            }
        }
        return data;
    }

    private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case BLANK:
                return "";
            default:
                return cell.toString();
        }
    }

    public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String dir = System.getProperty("user.dir") 
                     + File.separator 
                     + "src" 
                     + File.separator 
                     + "test" 
                     + File.separator 
                     + "resources" 
                     + File.separator 
                     + "screenshots" 
                     + File.separator;

        File screenshotDir = new File(dir);
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        FileUtils.copyFile(file, new File(dir + "screenshot_" + System.currentTimeMillis() + ".png"));
    }
}
