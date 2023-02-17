package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelFiles {

    //region Variables
    static XSSFSheet newSheet = null;
    static XSSFCell newCell = null;
    //endregion

    public static XSSFSheet createFile(String filePath, String sheetName) throws IOException{
        try {
            File file = new File(filePath);
            FileInputStream inputStream = new FileInputStream(file);
            //Create book
            XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
            //Create page
            newSheet = newWorkBook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newSheet;
    }

    public static void readExcel(String filePath, String sheetName) throws IOException{

        createFile(filePath, sheetName);

        //region Iterator row and column
        int rowCount = newSheet.getLastRowNum();
        //Iteration above the rows
        for (int i = 0; i <= rowCount; i++){
            XSSFRow row = newSheet.getRow(i);
            //Iteration above the cells
            for (int j = 0; j < row.getLastCellNum(); j++){
                //Take and print values string of cells
                System.out.println("Row[" + i + "]," + "Column[" + j +"] = "
                        + row.getCell(j).getStringCellValue());
            }
        }
        //endregion

    }

    //Method for read a specific cell
    public static String getCellValue(String filePath, String sheetName, int rowNumber, int cellNumber) throws IOException{
        try {
            createFile(filePath, sheetName);
            //Obtain index of row
            XSSFRow row = newSheet.getRow(rowNumber);
            //Obtain index of Column/Cell
            newCell = row.getCell(cellNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newCell.getStringCellValue();
    }

}
