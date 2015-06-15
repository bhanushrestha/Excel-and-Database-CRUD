package com.bhanucodes.exceltesting.excelDAO;

import java.sql.SQLException;
import java.util.List;

import com.bhanucodes.exceltesting.modals.Item;

public interface DatabaseDAO {
	public int addItems(List<Item> items);
	public List<Item> getAll() throws SQLException , ClassNotFoundException;
	public Item getByName();
}
