package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutilities {
	
	public String readDataFromExcel(String sheetname,int rownum,int cellnum) throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream(Constants.excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row row=sh.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		String value=cell.toString();
		wb.close();
		return value;
		
	}
	
	public void writeDataToExcel(String filepath,String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row row=sh.getRow(rownum);
		Cell cell=row.createCell(cellnum);
		cell.setCellValue(data);
        FileOutputStream fos = new FileOutputStream(filepath);
        wb.write(fos);
        wb.close();
	}
	
	public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(Constants.excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum();
		wb.close();
		return rowcount;	 	
	}
	public int getCellCount(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(Constants.excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
           int cellcount=sh.getRow(0).getLastCellNum();
		wb.close();
		return cellcount;
		 
		
	}
	
	

}
