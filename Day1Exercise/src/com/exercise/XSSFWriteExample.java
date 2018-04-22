package com.exercise;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSFWriteExample {
	
	public static void setHeader(XSSFRow row,List<String> headers) {
		Integer cIdx=0;
		for(String header:headers ) {
			XSSFCell cell = row.createCell(cIdx++);
			cell.setCellValue(header);
		}
	}
	
	public static void setRowValue(XSSFRow row,Object value,Integer index) {
			XSSFCell cell = row.createCell(index);
			cell.setCellValue((String)value);
	}
	
	
	public static XSSFWorkbook writeXLSXFile() throws IOException {
		List<String> headers=new ArrayList<>();
		headers.add("Col_1");
		headers.add("Col_2");
		headers.add("Col_3");
		headers.add("Col_4");
		headers.add("Col_5");
		
		List<Object[]> values=new ArrayList<>();
		values.add(new Object[]{"A1","B1","C1","D1","E1"});
		values.add(new Object[]{"A2","B2","C2","D2","E2"});
		values.add(new Object[]{"A3","B3","C3","D3","E3"});
		values.add(new Object[]{"A4","B4","C4","D4","E4"});
		values.add(new Object[]{"A5","B5","C5","D5","E5"});
		
		
		String excelFileName = "C:\\Users\\MohsinIqbal\\Downloads\\Test.xlsx";//name of excel file

		String sheetName = "Sheet1";//name of sheet

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName) ;
		Integer rowCnt=0;
		Integer colCnt=0;
		
		XSSFRow row = sheet.createRow(rowCnt++);
		setHeader(row, headers);
		
		for(Object[] value: values) {
			colCnt=0;
			row = sheet.createRow(rowCnt++);
			setRowValue(row, value[colCnt], colCnt++);
			setRowValue(row, value[colCnt], colCnt++);
			setRowValue(row, value[colCnt], colCnt++);
			setRowValue(row, value[colCnt], colCnt++);
			setRowValue(row, value[colCnt], colCnt++);
		}
		
		/*FileOutputStream fileOut = new FileOutputStream(excelFileName);
		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();*/
		System.out.println("wb:"+wb);
		return wb;
	}

	private static void zip() throws IOException {
		XSSFWorkbook workbook = writeXLSXFile();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		workbook.write(bos);
		byte[] bytes=bos.toByteArray();
		
		System.out.println("bytes:"+bytes.length);
		String currentDate = "06-10-2017";
		String fileName = "C:\\Users\\MohsinIqbal\\Downloads\\Admin audit reports_Bill_Id_" + currentDate + ".zip";
		final File xlsFile = new File(fileName);
		OutputStream outputStream = new FileOutputStream(xlsFile);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(outputStream);
		
		for (int i=0;i<8;i++) {
			workbook = writeXLSXFile();
			bos = new ByteArrayOutputStream();
			workbook.write(bos);
			bytes=bos.toByteArray();
			
			zos.putNextEntry(new ZipEntry("AnExcelFile_"+i+".xlsx"));
			zos.write(bytes);
			zos.closeEntry();
			// Add other entries as needed
		}
		zos.close();

		System.out.println("zos:"+zos.toString());
		
	}
	/*private File zipAdminAuditReport() throws Exception {/*
		String currentDate = "06-10-2017";
		String fileName = "Admin audit reports_Bill_Id_" + currentDate + ".zip";
		final File xlsFile = new File(fileName);
		OutputStream outputStream = new FileOutputStream(xlsFile);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream out = new ZipOutputStream(baos);
		XSSFWorkbook excelSheet = null;
		//create excel
		excelSheet=writeXLSXFile();
		//byte[] bytesArray = new byte[(int) excelSheet.length()];
		//FileInputStream fis = new FileInputStream(excelSheet);
		//fis.read(bytesArray);
		fis.close();
		ZipEntry zipEntry = new ZipEntry(serviceType + currentDate + ".xlsx");
		out.putNextEntry(zipEntry);
		out.write(bytesArray, 0, bytesArray.length);
		out.closeEntry();
		baos.writeTo(outputStream);
		out.close();
		outputStream.close();
		return xlsFile;
	}*/
	public static void main(String[] args) throws IOException {
		
		//writeXLSFile();
		//readXLSFile();
		
		//writeXLSXFile();
		//readXLSXFile();
		zip();

	}
}

