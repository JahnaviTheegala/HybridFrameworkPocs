package com.cmro.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	
	//public static PageLoadTimeout=20;
	//public static  ImplicitWait=10;
	public static String testdatapath = "C:\\Selenium Practice session\\HybridFW_Practice\\src\\main\\java\\com\\cmro\\"
			+ "qa\\Testdata\\FreeCRMTestdata.xlsx";
	
	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTestdata(String sheetname){
		FileInputStream file = null;
		
			try {
				file= new FileInputStream(testdatapath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				try {
					book = WorkbookFactory.create(file);
				} catch (EncryptedDocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			
			sheet= book.getSheet(sheetname);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0; i<sheet.getLastRowNum(); i++) {
				for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
					 data[i][k]= sheet.getRow(i+1).getCell(k).toString();
				}
				
			}
			return data;
		
		
		
		
	}
}

