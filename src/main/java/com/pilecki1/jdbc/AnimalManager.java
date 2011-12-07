package com.pilecki1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pilecki1.Zwierzaki.Animals;

public class AnimalManager {
	
	private Connection connection;
	
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	
	private String createTableAnimal = "CREATE TABLE Animal(id bigint GENERATED BY DEFAULT AS IDENTITY, name varchar(20), kind varchar(20), age double)";

	private PreparedStatement addAnimalStmt;
	private PreparedStatement deleteAllAnimalStmt;
	private PreparedStatement getAllAnimalStmt;
	
	private Statement statement;
	
	public AnimalManager() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null,
					null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Animal".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(createTableAnimal);

			addAnimalStmt = connection
					.prepareStatement("INSERT INTO Animal (name, kind, age) VALUES (?, ?, ?)");
			deleteAllAnimalStmt = connection
					.prepareStatement("DELETE FROM Animal");
			getAllAnimalStmt = connection
					.prepareStatement("SELECT id, name, kind, age FROM Animal");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	Connection getConnection() {
		return connection;
	}
	
	public int addAnimal(Animals animal) {
		int count = 0;
		try {
			addAnimalStmt.setString(1, animal.getName());
			addAnimalStmt.setDouble(2, animal.age());

			count = addAnimalStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
}
