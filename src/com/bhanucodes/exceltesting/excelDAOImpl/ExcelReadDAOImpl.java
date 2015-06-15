package com.bhanucodes.exceltesting.excelDAOImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bhanucodes.exceltesting.excelDAO.ExcelReadDAO;
import com.bhanucodes.exceltesting.modals.Item;

public class ExcelReadDAOImpl implements ExcelReadDAO{
	@Override
	public List<Item> getAll(String filePath) {
		List<Item> items = new ArrayList<Item>();
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			
			Workbook workbook = new XSSFWorkbook(fis);
			
				Sheet sheet = workbook.getSheet("Items");
				
				int numberOfRows = (sheet.getLastRowNum()+1);
				
					for(int j = 1 ; j < numberOfRows ; j++){
						Row row = sheet.getRow(j);
						
						
						int numberOfCells = row.getPhysicalNumberOfCells();
						int cellIndexNumber = 0;
						
						Item item = new Item();
						while(numberOfCells > 0){
							
							Cell cell = row.getCell(cellIndexNumber);
							
							if(cell.getColumnIndex() == 1){
								item.setItemId(Integer.valueOf((int) cell.getNumericCellValue()));
							}
							else if(cell.getColumnIndex() == 2){
								item.setName(cell.getStringCellValue());
							}
							else if(cell.getColumnIndex() == 3){
								item.setBrand(cell.getStringCellValue());
							}
							else if(cell.getColumnIndex() == 4){
								item.setCategory(cell.getStringCellValue());
							}
							else{
								item.setPrice(cell.getNumericCellValue());
							}
							
							cellIndexNumber ++;
							numberOfCells--;
							
					}
						items.add(item);	
						/* Apparently using switch creates some sort of error here do not know why
						 * Try using switch
						*/							
					}
			
			fis.close();
			workbook.close();
		} catch (IOException ex) {
			System.out.println("Error");
		} 
		return items;
	}

	@Override
	public List<Item> getByCategory(String filePath, String category) {
		List<Item> items = new ArrayList<Item>();
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));

			Workbook workbook = new XSSFWorkbook(fis);

			Sheet sheet = workbook.getSheet("Items");

			int numberOfRows = (sheet.getLastRowNum() + 1);

			for (int j = 1; j < numberOfRows; j++) {
				Row row = sheet.getRow(j);

				if (row.getCell(4).getStringCellValue()
						.equalsIgnoreCase(category)) {
					Item item = new Item();
					int numberOfCells = row.getPhysicalNumberOfCells();
					int cellIndexNumber = 0;

					while (numberOfCells > 0) {
						Cell cell = row.getCell(cellIndexNumber);
						if (cell.getColumnIndex() == 1) {
							item.setItemId(Integer.valueOf((int) cell
									.getNumericCellValue()));
						} else if (cell.getColumnIndex() == 2) {
							item.setName(cell.getStringCellValue());
						} else if (cell.getColumnIndex() == 3) {
							item.setBrand(cell.getStringCellValue());
						} else if (cell.getColumnIndex() == 4) {
							item.setCategory(cell.getStringCellValue());
						} else {
							item.setPrice(cell.getNumericCellValue());
						}
						cellIndexNumber++;
						numberOfCells--;
					}
					items.add(item);
				}
			}
			fis.close();
			workbook.close();
			
		} catch (IOException ex) {
			System.out.println("Error");
		}
		return items;
	}

	@Override
	public Set<String> getAllBrand(String filePath) {
		Set<String> brands = new HashSet<String>();
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));

			Workbook workbook = new XSSFWorkbook(fis);

			Sheet sheet = workbook.getSheet("Items");

			int numberOfRows = (sheet.getLastRowNum() + 1);

			for (int j = 1; j < numberOfRows; j++) {
				Row row = sheet.getRow(j);

				brands.add(row.getCell(3).getStringCellValue());
			}
			fis.close();
			workbook.close();
			
		} catch (IOException ex) {
			System.out.println("Error");
		}
		
		return brands;
	}

}
