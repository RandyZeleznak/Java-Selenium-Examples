import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	public ArrayList<String> getData(String testCaseName) throws IOException{
		
		ArrayList<String> al = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C://Users//Randy//Documents//demodata.xlsx");
		
		System.out.println("fis = " +fis.toString());
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int numSheets = workbook.getNumberOfSheets();
		System.out.println("Number of Sheets = " +numSheets);
		for(int i =0; i < numSheets; i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")){
				
			
			XSSFSheet sheet = workbook.getSheetAt(i);
			Iterator<Row> rows = sheet.iterator();
			Row firstRow = rows.next();
			Iterator<Cell> ce = firstRow.cellIterator();
			int k =0;
			int colNum = 0;
			if(ce.hasNext()) {
				Cell value = ce.next();
				
				 if(value.getStringCellValue().equalsIgnoreCase("Data1")) {
					 colNum = k;
				 }
				 k++;
			}
			
			
			while(rows.hasNext()) {
				Row r = rows.next();
				if(r.getCell(colNum).getStringCellValue().equalsIgnoreCase(testCaseName)) {
					Iterator<Cell> cv= r.cellIterator();
					while(cv.hasNext()) {
						Cell c = cv.next();
						if(c.getCellType() == CellType.STRING) {
						al.add(cv.next().getStringCellValue());
						} else {
							al.add(NumberToTextConverter.toText(cv.next().getNumericCellValue()));
							
						}
					}
				}
			}
			
			
		}

	}
			return al;
}

	
	
}
