package com.pilecki1.Zwierzaki;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AnimalManagerTest {

	AnimalManagerTest dbanimal = new AnimalManagerTest();
	
	
	@Before
	public void setUp() throws Exception {
	
		dbanimal.addAnimal(new Animals("Zebra", 10, KiOfAnim.Mammals ));
		
		
	}
	
	

	



	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAnimalManager() {
		
	}

	@Test
	public void testAddAnimal() {
		 dbanimal.addAnimal(new Animals("Zebra", 10, KiOfAnim.Mammals ));
	}

	@Test
	public void testDeleteAllAnimals() {
		
	}

	@Test
	public void testSearchAnimalByName() {
		
	}

	@Test
	public void testSearchAnimalByKind() {
		
	}

	@Test
	public void testDeleteAnimal() {
		
	}

}
