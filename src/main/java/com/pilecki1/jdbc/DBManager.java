package com.pilecki1.jdbc;


import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.pilecki1.Zwierzaki.*;


public class DBManager {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement addAnimalToZooStmt;
	private PreparedStatement deleteAllAnimalsFromZooStmt;
	

	public DBManager() {

		Properties properties = new Properties();

		try {

			try {	
				properties.load(ClassLoader.getSystemResourceAsStream("com/pilecki1/resources/jdbc.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}		


			conn = DriverManager
					.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
			conn = DriverManager.getConnection(properties.getProperty("url"));
			stmt = conn.createStatement();
			boolean Zoo_AnimalTableExists = false;

			ResultSet rs = conn.getMetaData().getTables(null, null, null, null);

			while(rs.next()) {
				if("Zoo_Animal".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					Zoo_AnimalTableExists = true;
					break;
				}
			}


			if(!Zoo_AnimalTableExists) {
				stmt.executeUpdate("" +
						"CREATE TABLE Zoo_Animal(Zoo_id int, Animal_id int, " +
						"CONSTRAINT Zoo_id_fk FOREIGN KEY (Zoo_id) REFERENCES Zoo (id), " +
						"CONSTRAINT Animal_id_fk FOREIGN KEY (Animal_id) REFERENCES Animal (id))" +
						"");
			}

			addAnimalToZooStmt = conn.prepareStatement("" +
					"INSERT INTO Zoo_Animal (Zoo_id, Animal_id) VALUES (?, ?)" +
					"");

			deleteAllAnimalsFromZooStmt = conn.prepareStatement("" +
					"DELETE FROM Zoo_Animal WHERE Zoo_id = ?" +
					"");

			


			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	    public Connection getConnection() {
		return conn;
	   }	

	   
	    public void addAnimalToZoo(List<Integer> listZooId, List<Integer> listAnimalId) {
		try {
			for (Integer ZooId : listZooId) {
				for (Integer AnimalId : listAnimalId) {
					addAnimalToZooStmt.setInt(1, ZooId);
					addAnimalToZooStmt.setInt(2, AnimalId);
					addAnimalToZooStmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteAllAnimalsFromZoo (List<Integer> listZooId) {
		try {
			for (Integer ZooID : listZooId) {
				deleteAllAnimalsFromZooStmt.setInt(1, ZooID);
				deleteAllAnimalsFromZooStmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	

	


}





