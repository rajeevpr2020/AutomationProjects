package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Readexcel {
	
	String numvalue="";
	public  String readExcel(int rowvalue,int cellvalue) throws IOException {
		
		
		FileInputStream excel1= new FileInputStream("E:\\softwear testing course materials\\test case for redmine\\new ERP application\\client testcase-02.xlsx");
		
		XSSFWorkbook workbook1= new XSSFWorkbook(excel1);
	
		Sheet sheet= workbook1.getSheet("Test case");
		
	//	Row Row=sheet.getRow(0);	            
	//	Cell cell=  Row.getCell(0);
		Cell	cell=sheet.getRow(rowvalue).getCell(cellvalue); 
		CellType r=   cell.getCellType();
		 
		switch(r) {
		case NUMERIC: 
			double numbr=cell.getNumericCellValue();
			numvalue=String.valueOf(numbr);
			break;
		case STRING :
			numvalue=cell.getStringCellValue();
			break;
		}
		return numvalue;
		}
		
		
	}

