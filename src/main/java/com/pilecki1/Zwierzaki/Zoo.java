package com.pilecki1.Zwierzaki;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import org.apache.log4j.Logger;

public class Zoo {

	public List<Animals> animals = new ArrayList<Animals>();
	
	
	public Zoo(String name, String adress) {
		this.name = name;
		this.adress = adress;
		this.animals = new ArrayList<Animals>();
	}
	
	
	public Zoo(String name, String adress, List<Animals> animals) {
		this.name = name;
		this.adress = adress;
		this.animals = animals;
	}
	
	
	public void printAnimals() {
		for(Animals a : this.animals) {
			a.printAnimals();
		}
   }

	
	
	public String printZoo() {
		String PrintZoo = "Name: " + name + " Adress: " + adress;
		System.out.println(PrintZoo);
		return PrintZoo;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
	public List<Animals> returnAnimalsList() {
		return animals;
	}
	
	
	public void removeAnimals(Animals animal) {	
		animals.remove(animal);
		System.out.println("Animals: " + animal.getName() + " removed");
	}
	

	public List<Animals> findAllAnimalsByKind(KiOfAnim kind) {
		List<Animals> results = new ArrayList<Animals>();
		for (Animals a : animals) {
			if (a.getKinOfAnim().equals(kind)) {
				results.add(a);
			}
		}
		return results;
	}
	
	
	public Animals findAnimalByName(String name) {
		for (Animals a : animals) {
			if (a.getName().equals(name)) {
				return a;
			}
		}
		return null;
	}	

	
	
	public void removeAllAnimals() {
		animals.clear();
		System.out.println("All animals have been removed");
		
	}
	
	public void addAnimal(Animals animal) throws AgeLessThanZeroException {
		if (animal.getAge()>0)
			animals.add(animal);
	}	
	
	
	public String name;
	public String adress;
}
