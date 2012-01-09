package com.pilecki1.Zwierzaki;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class ZooTest {

	private static Zoo testZoo;
	private static Animals animal;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testZoo = new Zoo("AnimalsWorld", "Gdansk");
		animal = new Animals("Wykonano", 2, KiOfAnim.Mammals);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testZoo.addAnimal(animal); 
	}

	@After
	public void tearDown() throws Exception {
		testZoo.removeAllAnimals();
	}



	@Test
	public void printCustomerCorrect() {
		String expectedResult = "Name: John Adress: Doe";
		assertEquals(expectedResult, testZoo.printZoo());	
	}

	@Test
	public void getName() {
		assertTrue(testZoo.getName().equals("AnimalsWorld"));
	}	

	@Test
	public void setName() {
		testZoo.setName("AnimalsWorld");
		assertTrue(testZoo.getName().equals("AnimalsWorld"));
	}	

	@Test
	public void getAdress() {
		assertTrue(testZoo.getAdress().equals("Gdansk"));
	}	

	@Test
	public void setAdress() {
		testZoo.setAdress("Gdansk");
		assertTrue(testZoo.getAdress().equals("Gdansk"));
	}	

	

	@Test
	public void removeAnimals() throws AgeLessThanZeroException {
		testZoo.removeAnimals(testZoo.findAnimalByName("Test"));
		assertTrue(testZoo.returnAnimalsList().size() == 0); 
	}

	@Test
	public void removeAllAnimals() throws AgeLessThanZeroException {
		testZoo.removeAllAnimals();
		
	}

	@Test
	public void findAnimalByName() {
		assertSame(testZoo.findAnimalByName("testujemy"), testZoo.returnAnimalsList().get(0));
	}

	@Test(expected=AgeLessThanZeroException.class, timeout=10)
	public void AgeLessThanZeroException() throws AgeLessThanZeroException {
		animal.setAge(-1);
	}
}