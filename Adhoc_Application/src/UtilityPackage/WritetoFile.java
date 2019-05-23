package UtilityPackage;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritetoFile 
{
	
	
	
	public void writeDatatoExcel(List<String> input) throws IOException 
	{
		FileInputStream FiS = new FileInputStream("C:\\Users\\cc313272\\Desktop\\Ban\\Automation\\Book1.xlsx");
		XSSFWorkbook wb =  new XSSFWorkbook(FiS);
		XSSFSheet sheet = wb.getSheet("test");
		
				
	
	

	for(int a = 0; a < input.size(); a++)
		{
			String one = input.get(a).split(",")[0];
			String two = input.get(a).split(",")[1];
			String three = input.get(a).split(",")[2];
			/*		
			XSSFCell v1 = sheet.createRow(a+1).createCell(0);
			v1.setCellValue(one);*/
		/*	sheet.createRow(a+1).createCell(0).setCellValue(one);
			sheet.createRow(a+1).createCell(1).setCellValue(two); 
			sheet.createRow(a+1).createCell(2).setCellValue(three); 


			sheet.getRow(a+1).createCell(0).setCellValue(one);
			sheet.getRow(a+1).createCell(1).setCellValue(two); 
			sheet.getRow(a+1).createCell(2).setCellValue(three); 
			*/
			
			/*sheet.getRow(a+1).getCell(0).setCellValue(one);
			sheet.getRow(a+1).getCell(1).setCellValue(two);
			sheet.getRow(a+1).getCell(2).setCellValue(three);*/
			
			XSSFRow row = sheet.createRow(a+1);
			row.createCell(0).setCellValue(one);
			row.createCell(1).setCellValue(two);
			row.createCell(2).setCellValue(three);
			
			
		/*	XSSFCell v2 = sheet.createRow(a+1).createCell(1);
			v2.setCellValue(two);
			XSSFCell v3 = sheet.createRow(a+1).createCell(2);
			v3.setCellValue(three);
			*/
						
		
	
		}
	FileOutputStream FOS = new FileOutputStream("C:\\Users\\cc313272\\Desktop\\Ban\\Automation\\Book1.xlsx");
    wb.write(FOS);
		
	FOS.close();
	//wb.close();
		
}
}
