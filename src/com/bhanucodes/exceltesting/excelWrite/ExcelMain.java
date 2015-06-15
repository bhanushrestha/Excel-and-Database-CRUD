package com.bhanucodes.exceltesting.excelWrite;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.bhanucodes.exceltesting.excelDAO.DatabaseDAO;
import com.bhanucodes.exceltesting.excelDAO.ExcelReadDAO;
import com.bhanucodes.exceltesting.excelDAO.ExcelWriteDAO;
import com.bhanucodes.exceltesting.excelDAOImpl.DatabaseDAOImpl;
import com.bhanucodes.exceltesting.excelDAOImpl.ExcelReadDAOImpl;
import com.bhanucodes.exceltesting.excelDAOImpl.ExcelWriteDAOImpl;
import com.bhanucodes.exceltesting.modals.Item;


public class ExcelMain {
	private static final String FILE_PATH = "/home/bhanu/Documents/items.xlsx"; //For Windows try giving path from root
	
	public static void main(String[] args) {
		List<Item> items = new ArrayList<Item>();
		
		//items.add(new Item(1,"Skin Whitener For Men", "Garnier", "Beauty", 550.5));
		//items.add(new Item(2,"Anti Rash", "Benetic", "Medicine", 1350));
		
		//ExcelWriteDAO eWriteDAO = new ExcelWriteDAOImpl();
		
		//String result = eWriteDAO.writeItemListToExcel(items, FILE_PATH);
		//String result = eWriteDAO.appendItemListToExcel(items, FILE_PATH);
		//System.out.println("File Transaction was a : " + result);
		
		
		ExcelReadDAO eReadDAO = new ExcelReadDAOImpl();
		try{
		DatabaseDAO dbDAO = new DatabaseDAOImpl();
		items=dbDAO.getAll();
		//items = eReadDAO.getAll(FILE_PATH);
		/*items = eReadDAO.getByCategory(FILE_PATH,"Medicine");
		*/
		for(Item item: items){
			System.out.println(item.toString());
		}
		
		/*Set<String> brands = eReadDAO.getAllBrand(FILE_PATH);
			System.out.println("All available brands are");
			for(String brandName :  brands){
				System.out.println(brandName);
			}*/
		
		}catch(Exception ex){
			
		}
		
	}
}
