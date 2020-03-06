package com.syntax.practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriteDemo {
	@Test
	public void writeExcel() throws Exception {
		String xlPath = "src/test/resources/testdata/OrangeHrmData.xlsx";

		FileInputStream fis = new FileInputStream(xlPath);
		// open workbook & sheet
		XSSFWorkbook wbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = wbook.getSheet("EmployeeDetails");
		// write some values
		sheet.getRow(0).createCell(4).setCellValue("Result");
		sheet.getRow(1).createCell(4).setCellValue("Pass");
		sheet.getRow(1).getCell(4).setCellValue("Fail");
		sheet.createRow(11).createCell(0).setCellValue("Mehmet");
		// write to Excel
		FileOutputStream fos = new FileOutputStream(xlPath);
		wbook.write(fos);
		// close file and opened streams
		fos.close();
		wbook.close();
		fis.close();
		//break till 1:35
	}
}


