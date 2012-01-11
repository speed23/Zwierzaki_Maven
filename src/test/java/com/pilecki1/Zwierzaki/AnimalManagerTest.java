package com.pilecki1.Zwierzaki;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;


import com.pilecki1.Zwierzaki.Animals;
import com.pilecki1.Zwierzaki.KiOfAnim;
import com.pilecki1.Zwierzaki.Zoo;
import com.pilecki1.jdbc.AnimalManager;



public class AnimalManagerTest {

	AnimalManager animalManagerTest = new AnimalManager();
	
	
	@Before
	public void setUp() throws Exception {
	
		animalManagerTest.addAnimal(new Animals("Zebra", 10, KiOfAnim.Mammals ));
		
		
	}
	
	

	@After
	public void tearDown() throws Exception {
	}
	
	
	@Test
	public void GetConnection() {
		assertNotNull(animalManagerTest.getConnection());
	}

	@Test
	public void testAnimalManager() {
		
	}

	@Test
	public void testAddAnimal() {
		 animalManagerTest.addAnimal(new Animals("Zebra", 10, KiOfAnim.Mammals ));
	}



	@Test
	public void testSearchAnimalByName() {
		
		animalManagerTest.addAnimal(new Animals("Lion", 2, KiOfAnim.Mammals));
		animalManagerTest.addAnimal(new Animals("Lizard", 2, KiOfAnim.Reptile));
		assertTrue(animalManagerTest.searchAnimalByName("Lion").size() == 1);
		
	}


	@Test
	public void testSearchAnimalByKind() {
		
		animalManagerTest.addAnimal(new Animals("Tiger", 2, KiOfAnim.Mammals));
		animalManagerTest.addAnimal(new Animals("Mouse", 2, KiOfAnim.Mammals));
		
	}

	@Test
	public void testDeleteAnimal() {
		
		animalManagerTest.addAnimal(new Animals("Lion", 2, KiOfAnim.Mammals));
		animalManagerTest.addAnimal(new Animals("Eagle", 5, KiOfAnim.Bird));
		animalManagerTest.deleteAnimal(animalManagerTest.searchAnimalByName("Lion"));
		
		
	}

}
