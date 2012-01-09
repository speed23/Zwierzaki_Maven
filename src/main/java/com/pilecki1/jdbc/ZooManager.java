package com.pilecki1.jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.pilecki1.Zwierzaki.Zoo;


public class ZooManager {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement addZooStmt;
	private PreparedStatement getCustomerStmt;
	private PreparedStatement deleteAllZooStmt;
	private PreparedStatement deleteZooStmt;
	private PreparedStatement findZooByAdressStmt;


	public ZooManager() {


		Properties properties = new Properties();
		try {

			try {		
				properties.load(ClassLoader.getSystemResourceAsStream("com/pilecki1/resources/jdbc.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}

			conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
			conn = DriverManager.getConnection(properties.getProperty("url"));
			stmt = conn.createStatement();
			boolean ZooTableExists = false;

			ResultSet rs = conn.getMetaData().getTables(null, null, null, null);

			while(rs.next()) {
				if("Zoo".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					ZooTableExists = true;
					break;
				}
			}


			if(!ZooTableExists) {
				stmt.executeUpdate("" +
						"CREATE TABLE Zoo(" +
						"id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY," +
						"name varchar(20)," +
						"adress varchar(20)," +
						")");
			}

			addZooStmt = conn.prepareStatement("" +
					"INSERT INTO Zoo (name, adress) VALUES (?, ?)" +
					"");

			deleteAllZooStmt = conn.prepareStatement("" +
					"DELETE FROM Zoo" +
					"");
			
			deleteZooStmt = conn.prepareStatement("" +
					"DELETE FROM Zoo WHERE id = ?" +
					"");

			findZooByAdressStmt = conn.prepareStatement("" +
					"SELECT id FROM Zoo WHERE adress = ?" +
					"");

		


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;
		}

	public void addZoo(Zoo zoo) {
		try {
			addZooStmt.setString(1, zoo.getName());
			addZooStmt.setString(2, zoo.getAdress());
			addZooStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

	public void deleteAllZoo() {
		try {
			deleteAllZooStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Integer> findAnimalByAdress(String adress) {
		try 
		{
			List<Integer> result = new ArrayList<Integer>();
			findZooByAdressStmt.setString(1, adress);
			ResultSet rs = findZooByAdressStmt.executeQuery();

			while (rs.next())
				result.add(rs.getInt("Id"));

			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;			
	}

	public void deleteZoo(List<Integer> list) {
		try {
			for (Integer id : list) {
				deleteZooStmt.setInt(1, id);
				deleteZooStmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	



}
