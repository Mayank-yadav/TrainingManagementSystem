package com.yash.training.tmp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static Connection connection;
	static String url="jdbc:mysql://localhost:3306/trainingmanagementsystem";
	static String user="root";
	static String password="root";
	static Connection connect;
	private static PreparedStatement preparedStatement;

	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				connection=DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	public static void close(){
		try{
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static ResultSet select(String query){
		System.out.println("select:"+query);
		ResultSet resultSet = null;
		try {
			Connection connection= getConnection();
			preparedStatement = connection.prepareStatement(query);
			 resultSet = preparedStatement.executeQuery();
			System.out.println(resultSet);
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return resultSet;

	
		
	}

	public static void update(String query){
		System.out.println("update:"+query);
		Connection connection=getConnection();
		
		try {
			preparedStatement=connection.prepareStatement(query);	
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
