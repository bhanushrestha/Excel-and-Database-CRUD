package com.bhanucodes.exceltesting.excelDAOImpl;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bhanucodes.exceltesting.dbConnection.DBConnection;
import com.bhanucodes.exceltesting.excelDAO.DatabaseDAO;
import com.bhanucodes.exceltesting.modals.Item;

public class DatabaseDAOImpl implements DatabaseDAO{
	
	DBConnection connection ;
	
	public DatabaseDAOImpl() throws ClassNotFoundException, SQLException{
		connection = new DBConnection(DriverManager.getConnection("jdbc:mysql://localhost:3306/items","root","root"));
	}

	@Override
	public int addItems(List<Item> items) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Item> getAll()  throws SQLException, ClassNotFoundException {
		
		List<Item> items = new ArrayList<Item>();
		String sql = "Select * from item";
		PreparedStatement stmt = connection.initStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		Item item = new Item();
		while(rs.next()){
			System.out.println("I am in here");
			item.setItemId(rs.getInt("item_id"));
			item.setName(rs.getString("name"));
			item.setCategory(rs.getString("category"));
			item.setBrand(rs.getString("brand"));
			item.setPrice(rs.getDouble("price"));
			items.add(item);
		}
		
		
		return items;
	}

	@Override
	public Item getByName() {
		// TODO Auto-generated method stub
		return null;
	}

}
