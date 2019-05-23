/*
 * This excel Utility will return object [][] 
 * Search with Testcase name (when the testcase name is the first column)
 * Call the method getData with a string
 * 
 */


package UtilityPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RowData {
	

	public ArrayList<String> getData(String testCaseName) throws IOException
	{
	//fileInputStream argument
	ArrayList<String> a=new ArrayList<String>();

	FileInputStream fis=new FileInputStream("C://Users//cc313272//Documents//demodata1.xlsx");
	@SuppressWarnings("resource")
	XSSFWorkbook workbook=new XSSFWorkbook(fis);

	int sheets=workbook.getNumberOfSheets();
	for(int i=0;i<sheets;i++)
	{
	if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
	{
	XSSFSheet sheet=workbook.getSheetAt(i);
	int coloumn = 0;

	Iterator<Row>  rows= sheet.iterator();
	Row firstrow= rows.next();

	
	Iterator<Cell> ce=firstrow.cellIterator();
	
	while(ce.hasNext())
	{
	Cell value=ce.next();
			while(rows.hasNext())
			{

				Row r=rows.next();

				if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testCaseName))
				{
		
					Iterator<Cell>  cv=r.cellIterator();
					while(cv.hasNext())
					{
						Cell c= cv.next();
						
						
						
						
						
						
						
								/*
								 * if(c.getCellTypeEnum()==CellType.STRING) { a.add(c.getStringCellValue()); }
								 * else{ a.add(NumberToTextConverter.toText(c.getNumericCellValue())); }
								 */
					}	
		
				}
			}
		}
	}
	}
	return a;
	}

	
}
