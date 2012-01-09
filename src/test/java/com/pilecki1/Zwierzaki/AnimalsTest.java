package com.pilecki1.Zwierzaki;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class AnimalsTest {

	private static Zoo testZoo;
	private static Animals animals;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testZoo = new Zoo("AnimalsWorld", "Gdansk");
		animals = new Animals("Crocodile", 4, KiOfAnim.Reptile);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testZoo.addAnimal(animals); 
	}

	@After
	public void tearDown() throws Exception {
		testZoo.removeAllAnimals();
	}

	@Test
	public void getName() {
		assertTrue(testZoo.returnAnimalsList().get(0).getName().equals("Bla Bla BLa"));
	}

	@Test
	public void setName() {
		testZoo.returnAnimalsList().get(0).setName("bla bla bla");
		assertTrue(testZoo.returnAnimalsList().get(0).getName().equals("bla blas bla"));
	}

	@Test
	public void getKinOfAnim() {
		assertTrue(testZoo.returnAnimalsList().get(0).getKinOfAnim().equals(KiOfAnim.Bird));
	}

	@Test
	public void setKiOfAnimals() {
		testZoo.returnAnimalsList().get(0).setKiOfAnim(KiOfAnim.Reptile);
		assertTrue(testZoo.returnAnimalsList().get(0).getKinOfAnim().equals(KiOfAnim.Reptile));
	}	

	@Test
	public void getAge() {
		assertTrue(testZoo.returnAnimalsList().get(0).getAge() == 2);
	}

	@Test
	public void setPrice() throws AgeLessThanZeroException {
		testZoo.returnAnimalsList().get(0).setAge(2);
		assertTrue(testZoo.returnAnimalsList().get(0).getAge() == 2);
	}

}

