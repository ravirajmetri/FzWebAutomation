package com.fieldez.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities
{
	
	 private static XSSFSheet ExcelWSheet;
	 
	 private static XSSFWorkbook ExcelWBook;
	 
	 private static XSSFCell Cell;
	 
	 private static XSSFRow Row;
	 
	 public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   
	 
	    String[][] tabArray = null;
	 
	    try {
	 
	    FileInputStream ExcelFile = new FileInputStream(FilePath);
	 
	    // Access the required test data sheet
	 
	    ExcelWBook = new XSSFWorkbook(ExcelFile);
	 
	    ExcelWSheet = ExcelWBook.getSheet(SheetName);
	 
	    int startRow = 1;
	 
	    int startCol = 0;
	 
	    int ci,cj;
	 
	    int totalRows = ExcelWSheet.getLastRowNum();
	    System.out.println("Rows Count="+totalRows);
	 
	    // you can write a function as well to get Column count
	   
	    //XSSFRow row = null;
	    
	    //Row = ExcelWSheet.getRow(0);
	      Row = ExcelWSheet.getRow(0);
	      int totalCols = Row.getLastCellNum();
          System.out.println("Column Count= " + totalCols);
	    
    
	   /* int totalCols = 2;
	    System.out.println("number of cols="+totalCols);*/
	 
	    tabArray=new String[totalRows][totalCols];
	 
	    ci=0;
	 
	    for (int i=startRow;i<=totalRows;i++, ci++) 
	    {              
	 
	   cj=0;
	 
	    for (int j=startCol;j<totalCols;j++, cj++)
	    {
	 
	    tabArray[ci][cj]=getCellData(i,j);
	 
	    System.out.println(tabArray[ci][cj]);  
	 
	 }
	 
	 }
	 
	 }
	 
	 catch (FileNotFoundException e)
	    {
	 
	 System.out.println("Could not read the Excel sheet");
	 
	 e.printStackTrace();
	 
	 }
	 
	 catch (IOException e)
	    {
	 
	 System.out.println("Could not read the Excel sheet");
	 
	 e.printStackTrace();
	 
	 }
	 
	 return(tabArray);
	 
	 }
	 
	 
	 
	 @SuppressWarnings("deprecation")
	public static String getCellData(int RowNum, int ColNum) throws Exception {
	 
	 try{
	 
	 Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	 
	 int dataType = Cell.getCellType();
	 
	 if  (dataType == 3) 
	 
	 {
	 
	 return "";
	 
	 }
	 
	 
	 else

	 {
	 
	 String CellData = Cell.getStringCellValue();
	 
	 return CellData;
	 
	 }
	 }
	 catch (Exception e)
	 
	 {
	 
	 System.out.println(e.getMessage());
	 
	 throw (e);
	 
	 }
	 
	
} }