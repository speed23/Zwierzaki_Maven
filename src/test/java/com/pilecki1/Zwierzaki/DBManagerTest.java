package com.pilecki1.Zwierzaki;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pilecki1.jdbc.AnimalManager;
import com.pilecki1.jdbc.ZooManager;
import com.pilecki1.jdbc.DBManager;

import com.pilecki1.Zwierzaki.Zoo;
import com.pilecki1.Zwierzaki.Animals;
import com.pilecki1.Zwierzaki.KiOfAnim;
import com.pilecki1.jdbc.ZooManager;
import com.pilecki1.jdbc.AnimalManager;
import com.pilecki1.jdbc.DBManager;

public class DBManagerTest {
	
	
	ZooManager zooManager = new ZooManager();
	AnimalManager animalManager = new AnimalManager();
	DBManager dbManager = new DBManager();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		zooManager.addZoo(new Zoo("Zoolandia", "Gdynia"));
		zooManager.addZoo(new Zoo("ZooInGdansk", "Gdansk"));
		animalManager.addAnimal(new Animals("Cat", 2, KiOfAnim.Mammals));
		animalManager.addAnimal(new Animals("Dog", 3, KiOfAnim.Mammals));
		dbManager.addAnimalToZoo(zooManager.searchZooByName("Test1"), animalManager.searchAnimalByName("Cat"));
	}

	@After
	public void tearDown() throws Exception {
		
		
		
	}

	@Test
	public void testDBManager() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetConnection() {
		assertNotNull(animalManager.getConnection());
	}

	@Test
	public void testAddAnimalToZoo() {
		animalManager.addAnimal(new Animals("Lion", 2, KiOfAnim.Mammals));
		zooManager.addZoo(new Zoo("Zoolandia", "Gdynia"));
		
	}

	@Test
	public void testDeleteAllAnimalsFromZoo() {
		
	}

}
