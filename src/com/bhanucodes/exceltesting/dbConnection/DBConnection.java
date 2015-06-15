package com.bhanucodes.exceltesting.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private Connection connection;
	private PreparedStatement preparedStatement;
	

	public DBConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
        //this.connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/indreni","root","");
	}
	
	public DBConnection(Connection connection) throws ClassNotFoundException{
		this();
		this.connection = connection;		
	}
	
	public PreparedStatement initStatement(String sql) throws SQLException
    {
        preparedStatement = connection.prepareStatement(sql);
        return preparedStatement;
    }
  
    
    public int execute() throws SQLException
    {
        return    preparedStatement.executeUpdate();        
    }
    
    public int execute(String sql) throws SQLException
    {
        Statement stmt = connection.createStatement();
        int result = stmt.executeUpdate(sql);
        stmt.close();
        return result;
    }
    
    public ResultSet fetch(String sql) throws SQLException
    {
        ResultSet resultSet = null;
        
        Statement stmt = connection.createStatement();
        resultSet = stmt.executeQuery(sql);
        
        return resultSet;
    }
    
    public ResultSet fetch() throws SQLException
    {
        ResultSet resultSet = null;
        
        resultSet = preparedStatement.executeQuery();
        
        return resultSet;
    }
    
    public void close() throws SQLException
    {
        if(!connection.isClosed())
        {
            connection.close();
            connection = null;
        }
    }
	
	
}
