package com.pilecki1.Zwierzaki;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

import com.pilecki1.jdbc.AnimalManager;
import com.pilecki1.jdbc.DBManager;
import com.pilecki1.jdbc.ZooManager;



public class Main {

	public static void main(String[] args){
		
		
		
		List<Animals> animals = new ArrayList<Animals>();
		
		Zoo zoo = new Zoo("AnimalsWorld", "Gdansk", animals);
		
		try{
		
		zoo.addAnimal(new Animals("Mouse", 3, KiOfAnim.Mammals));
		zoo.addAnimal(new Animals("Tiger", 10, KiOfAnim.Mammals));
		zoo.addAnimal(new Animals("Lizard", 2, KiOfAnim.Reptile));
		zoo.addAnimal(new Animals("GoldFish", 5, KiOfAnim.Fish));
		zoo.addAnimal(new Animals("Monkey", 4, KiOfAnim.Mammals));
		
		
		
		}
		catch(AgeLessThanZeroException e){
			
		}
		
		zoo.printZoo();
		zoo.printAnimals();
		System.out.println("There are: " + animals.size() + " games on the list");
		zoo.findAnimalByName("Tiger").printAnimals();
		
		
		
		AnimalManager AnimalBase = new AnimalManager();
		AnimalBase.addAnimal(new Animals("Zebra", 10, KiOfAnim.Mammals));
		AnimalBase.addAnimal(new Animals("Eagle", 2,  KiOfAnim.Bird));
		AnimalBase.addAnimal(new Animals("Tiger", 2,  KiOfAnim.Mammals));
		AnimalBase.addAnimal(new Animals("Lizard", 2,  KiOfAnim.Reptile));
		AnimalBase.addAnimal(new Animals("Mouse", 2,  KiOfAnim.Mammals));
		AnimalBase.addAnimal(new Animals("Scoropin", 2,  KiOfAnim.Insects));
		
		AnimalBase.searchAnimalByName("Scorpion");
		
		
		ZooManager ZooBase = new ZooManager();
		ZooBase.addZoo(new Zoo("ZooLand", "Gdynia"));
		ZooBase.addZoo(new Zoo("FunnyAn", "Wejherowo"));
		
		
		
		DBManager  dbcos = new DBManager();
		
		dbcos.addAnimalToZoo(ZooBase.findAnimalByAdress("Gdynia"), AnimalBase.searchAnimalByName("Zebra"));
		for (Integer id : ZooBase.findAnimalByAdress("Gdynia"))
		{
			System.out.println(id);
		}
		
			
		}
}
	
	
