package com.bhanucodes.exceltesting.excelDAO;

import java.util.List;

import com.bhanucodes.exceltesting.modals.Item;

public interface ExcelWriteDAO {
	public String writeItemListToExcel(List<Item> items, String filePath);
	public String appendItemListToExcel(List<Item> items, String filePath);
}
