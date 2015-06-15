package com.bhanucodes.exceltesting.excelDAOImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bhanucodes.exceltesting.excelDAO.ExcelWriteDAO;
import com.bhanucodes.exceltesting.modals.Item;

public class ExcelWriteDAOImpl implements ExcelWriteDAO {

	@Override
	public String writeItemListToExcel(List<Item> items, String filePath) {
		try {

			Workbook workbook = new XSSFWorkbook();

			Sheet itemSheet = workbook.createSheet("Items");

			Row row = itemSheet.createRow(0);
			row.createCell(0).setCellValue("S.No");
			row.createCell(1).setCellValue("Item_Id");
			row.createCell(2).setCellValue("Item_Name");
			row.createCell(3).setCellValue("Item_Brand");
			row.createCell(4).setCellValue("Item_Category");
			row.createCell(5).setCellValue("Item_Price");

			int rowIndex = 1;
			for (Item item : items) {

				row = itemSheet.createRow(rowIndex);
				row.createCell(0).setCellValue(rowIndex++);

				int cellIndex = 1;

				row.createCell(cellIndex++).setCellValue(item.getItemId());
				row.createCell(cellIndex++).setCellValue(item.getName());
				row.createCell(cellIndex++).setCellValue(item.getBrand());
				row.createCell(cellIndex++).setCellValue(item.getCategory());
				row.createCell(cellIndex++).setCellValue(item.getPrice());
			}

			FileOutputStream fs = new FileOutputStream(filePath);

			workbook.write(fs);
			fs.close();
			workbook.close();
			return ("Success");
		} catch (IOException ex) {
			return ("Failure");
		}
	}

	@Override
	public String appendItemListToExcel(List<Item> items, String filePath) {
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			Workbook workbook = new XSSFWorkbook(fis);

			Sheet itemSheet = workbook.getSheet("Items");
			Row row;

			int rowIndex = (itemSheet.getLastRowNum()) + 1;

			for (Item item : items) {

				row = itemSheet.createRow(rowIndex);
				row.createCell(0).setCellValue(rowIndex++);

				int cellIndex = 1;

				row.createCell(cellIndex++).setCellValue(item.getItemId());
				row.createCell(cellIndex++).setCellValue(item.getName());
				row.createCell(cellIndex++).setCellValue(item.getBrand());
				row.createCell(cellIndex++).setCellValue(item.getCategory());
				row.createCell(cellIndex++).setCellValue(item.getPrice());
			}

			FileOutputStream fos = new FileOutputStream(filePath);
			
			workbook.write(fos);
			fos.close();
			workbook.close();
			return ("Success");
		} catch (IOException ex) {
			return ("Failure");
		}
	}

	
}
