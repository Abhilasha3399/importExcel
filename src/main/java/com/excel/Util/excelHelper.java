package com.excel.Util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.excel.entity.Product;

public class excelHelper {
	
	public static boolean checkexcelformate(MultipartFile file) {
		String contentType = file.getContentType();
		
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
		return true;
		}
		else {
			return false;
		}
	}
	
	public static List<Product> convertExcelToListofProduct(InputStream is){
		List<Product> list =new ArrayList<>();
		
		try {
			 XSSFWorkbook workkbook = new XSSFWorkbook(is);
			 XSSFSheet sheet = workkbook.getSheet("Sheet1");
			 
			 int rowNumber=0;
//			 Iterator<Row> iterator = sheet.iterator();
//			 while(iterator.hasNext()) {
//				 Row row = iterator.next();
//				 if(rowNumber==0) {
//					 rowNumber++;
//					 continue;
//				 }
//				 
//				 
//			 }
//			  int rowNumber = 0;
	            for (Row row : sheet) {
	                if (rowNumber == 0) {
	                    rowNumber++; // Skip header row
	                    continue;
	                }

	                Product product = new Product();

	               // product.setId((int) row.getCell(0).getNumericCellValue());
	                product.setName(row.getCell(1).getStringCellValue());
	                product.setCourse(row.getCell(2).getStringCellValue());
	                product.setAmount(row.getCell(3).getNumericCellValue());

	                list.add(product);
	            }

	          //  workbook.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Failed to parse Excel file: " + e.getMessage());
	        }

	        return list;
	    }
			
		
	}


