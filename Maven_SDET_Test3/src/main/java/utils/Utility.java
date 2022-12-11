package utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {

	
	
	public static String getDataFromExcelSheet(String s,int r,int c) throws EncryptedDocumentException, IOException {
		
		File file= new File("src//test//resources//TestData//pragati.xlsx");
		
		Cell expectedCell= WorkbookFactory.create(file).getSheet(s).getRow(r).getCell(c);
		
		String cellValue="";
		
		try {
			cellValue=expectedCell.getStringCellValue();
		}
		catch(IllegalStateException ise) {
			double numCellValue=expectedCell.getNumericCellValue();
			cellValue= Double.toString(numCellValue);
		}
		catch (NullPointerException npe) {
			npe.printStackTrace();
			npe.getMessage();
		}
		return cellValue;
	}
	
	
	
	
}
