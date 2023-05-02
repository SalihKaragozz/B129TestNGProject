package techproed.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    Workbook workbook;
    Sheet sheet;
    String path;
    //Constuctor: Excel path'ine ve Excel'deki sayfaya ulaşmak için 2 parametreli cons. oluşturduk
    public ExcelUtils(String path,String sheetName){
        this.path = path;
        try {
            FileInputStream fis = new FileInputStream(path);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Satir ve sütun sayilari girildiğinde, o hücredeki veriyi return eder
    public String getCellData(int rowNum,int colNum){
        Cell cell = sheet.getRow(rowNum).getCell(colNum);
        return cell.toString();
    }

    //Exceldeki satir sayisini return eder
    public int rowCount(){
        return  sheet.getLastRowNum();
    }
    //Exceldeki sütun sayisini return eder
    public int columnCount(){
        return sheet.getRow(0).getLastCellNum();
    }

}
