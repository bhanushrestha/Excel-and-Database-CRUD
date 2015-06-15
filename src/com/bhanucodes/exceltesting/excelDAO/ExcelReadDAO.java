package com.bhanucodes.exceltesting.excelDAO;

import java.util.List;
import java.util.Set;

import com.bhanucodes.exceltesting.modals.Item;

public interface ExcelReadDAO {
	public List<Item> getAll(String filePath);
	public List<Item> getByCategory(String filePath,String category);
	public Set<String> getAllBrand(String filePath);
	
}
