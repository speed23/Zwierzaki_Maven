package com.pilecki1.Zwierzaki;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pilecki1.jdbc.ZooManager;

public class ZooManagerTest {

	
	ZooManager zooManager = new ZooManager();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		zooManager.addZoo(new Zoo("ZooInPoland", "Rzeszow"));
	}

	@After
	public void tearDown() throws Exception {
		zooManager.deleteAllZoo();
	}

	@Test
	public void testGetConnection() {
		assertNotNull(zooManager.getConnection());
	}

	@Test
	public void testAddZoo() {
		zooManager.addZoo(new Zoo("Zoolandia", "Bytom"));
		assertTrue(zooManager.getAllZoo().size() == 2);
		assertEquals(2, zooManager.getAllZoo().size());
	}

	@Test
	public void testDeleteAllZoo() {
		zooManager.addZoo(new Zoo("Zoolandia2", "Gdansk"));
		zooManager.addZoo(new Zoo("Zoolandia3", "Poznan"));
		zooManager.deleteAllZoo();
		assertEquals(0, zooManager.getAllZoo().size());
	}

	@Test
	public void testSearchZooByName() {
		zooManager.addZoo(new Zoo("Zoolandia2", "Gdansk"));
		zooManager.addZoo(new Zoo("Zoolandia3", "Poznan"));
		assertEquals(1, zooManager.searchZooByName("Zoolandia2").size());
		assertTrue(zooManager.searchZooByName("Zoolandia2").size() == 1);
	}

	@Test
	public void testFindAnimalByAdress() {
		zooManager.addZoo(new Zoo("Zoolandia2", "Gdansk"));
		zooManager.addZoo(new Zoo("Zoolandia3", "Poznan"));
		assertEquals(1, zooManager.findAnimalByAdress("Gdansk").size());
		assertTrue(zooManager.findAnimalByAdress("Gdansk").size() == 1);
	}

	@Test
	public void testGetAllZoo() {
		zooManager.addZoo(new Zoo("Zoolandia2", "Gdansk"));
		zooManager.addZoo(new Zoo("Zoolandia3", "Poznan"));
		assertEquals(3, zooManager.getAllZoo().size());
	}

	@Test
	public void testDeleteZoo() {
		zooManager.addZoo(new Zoo("Zoolandia2", "Gdansk"));
		zooManager.addZoo(new Zoo("Zoolandia3", "Poznan"));
		assertTrue(zooManager.getAllZoo().size() == 2);
		zooManager.deleteZoo(zooManager.findAnimalByAdress("Poznan"));
		assertTrue(zooManager.getAllZoo().size() == 3);
	}

}
