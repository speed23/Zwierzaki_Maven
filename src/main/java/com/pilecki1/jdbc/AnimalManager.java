package com.pilecki1.jdbc;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.pilecki1.Zwierzaki.Animals;
import com.pilecki1.Zwierzaki.Zoo;

public class AnimalManager {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement addAnimalStmt;
	private PreparedStatement deleteAnimalStmt;
	private PreparedStatement deleteAllAnimalsStmt;
	private PreparedStatement searchAnimalByNameStmt;
	private PreparedStatement getAnimalStmt;
	

	public AnimalManager() {

		Properties properties = new Properties();
		try {

			try {	
				properties.load(ClassLoader.getSystemResourceAsStream("com/pilecki1/resources/jdbc.properties"));
			} catch (IOException e) {
				e.printStackTrace();
			}	

		
			conn = DriverManager
					.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
			stmt = conn.createStatement();
			boolean animalTableExists = false;

			ResultSet rs = conn.getMetaData().getTables(null, null, null, null);

			while(rs.next()) {
				if("animal".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					animalTableExists = true;
					break;
				}
			}


			if(!animalTableExists) {
				stmt.executeUpdate("" +
						"CREATE TABLE animal(" +
						"id bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY," +
						"name varchar(36)," +
						"age int," +
						"kind varchar(36)" +
						")");
			}

			addAnimalStmt = conn.prepareStatement("" +
					"INSERT INTO animal (name, age, kind) VALUES ( ?, ?, ?)" +
					"");


			deleteAllAnimalsStmt = conn.prepareStatement("" +
					"DELETE FROM animal" +
					"");

			searchAnimalByNameStmt = conn.prepareStatement("" +
					"SELECT id FROM animal WHERE name = ?" +
					"");


			deleteAnimalStmt = conn.prepareStatement("" +
					"DELETE FROM animal WHERE id = ?" +
					"");
			} catch (SQLException e) {
				e.printStackTrace();
			}					
		
		}

	public Connection getConnection() {
		return conn;
	}		

	public void addAnimal(Animals animals) {
		try {
			addAnimalStmt.setString(1, animals.getName());
			addAnimalStmt.setInt(2, animals.getAge());
			addAnimalStmt.setString(3, animals.getKinOfAnim().toString());
			addAnimalStmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	
	public void deleteAllAnimals() {
		try {
			deleteAllAnimalsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Integer> searchAnimalByName (String name)
	{
		try {
			List<Integer> result = new ArrayList<Integer>();
			searchAnimalByNameStmt.setString(1, name);

			ResultSet rs = searchAnimalByNameStmt.executeQuery();
			while (rs.next())
				result.add(rs.getInt("ID"));
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

		

	public void deleteAnimal(List<Integer> list)
	{
		try {
			for (Integer id : list) {
				deleteAnimalStmt.setInt(1, id);
				deleteAnimalStmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	




}
	
	
	