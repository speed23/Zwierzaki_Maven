package com.pilecki1.Zwierzaki;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pilecki1.Zwierzaki.Zoo;
import com.pilecki1.Zwierzaki.Animals;
import com.pilecki1.Zwierzaki.KindOfAnimals;

public class ZooTest {

	
	private static final KindOfAnimals KindOfAnimals = null;
	private Zoo z;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		
		z = new Zoo("Zoo in Gdansk");
		z.AddAnimal(new Animals(KindOfAnimals.Reptile,"Lizard", 10));
		z.AddAnimal(new Animals(KindOfAnimals.Mammals,"Monkey", 4));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testZoo() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintAnimals() {
		z.printAnimals();
		assertTrue(ZooTest.printAnimals().equals("Lew"));
	}

	@Test
	public void testAddAnimal() {
		z.printAnimals();
		z.AddAnimal(new Animals(KindOfAnimals.Mammals,"Lew", 10));
		assertTrue(ZooTest.AddAnimals().size() == 1);
		assertNotNull(ZooTest.ReturnAnimals());
	}

	@Test
	public void testRemoveAnimal() {
		 Animals lion = z.FindByName(KindOfAnimals );
			z.removeAnimals(lion);
			assertTrue(ZooTest.animals().size() == 0);
	}

	@Test
	public void testAnimalsExist() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAllAnimals() {
		z.RemoveAllAnimals();
	}

	@Test
	public void testAddMoreAnimals() {
		fail("Not yet implemented");
	}

	@Test
	public void testReturnAnimals() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByKind() {
		assertSame(ZooTest.findByKind(kind), ZooTest.Animals().get(0));
	}

	@Test
	public void testSwitchAnimals() {
		fail("Not yet implemented");
	}

}
