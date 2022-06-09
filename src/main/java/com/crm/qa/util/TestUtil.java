package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//contains reusable objects
public class TestUtil 
{
	public static long implicitTimeWait = 10;
	public static long Page_Load_TimeOut = 20;
	static Workbook book;
	static Sheet sheet;
	
	
	
	public static Object[][] getTestData(String sheetname) throws FileNotFoundException
	{
		FileInputStream fin = new FileInputStream("D:\\Selenium_Workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx");
		try {
			book = WorkbookFactory.create(fin);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0; i < sheet.getLastRowNum(); i++)
		{
			for(int j = 0; j<sheet.getRow(0).getLastCellNum(); j++)
			{
				data[i+1][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		
		return data;
	}
}

