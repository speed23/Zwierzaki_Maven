package com.pilecki1.Zwierzaki;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;

import com.pilecki1.jdbc.AnimalManager;



public class Main {

	
//private static Logger logger= Logger.getLogger(Main.class);
	
public static void main(String[] args) {

	
PropertyConfigurator.configure("log4j.properties");
	
Zoo z= new Zoo("Zoo in Gdansk");

z.AddAnimal(new Animals(KindOfAnimals.Mammals,"Zebra", 10));
z.AddAnimal(new Animals(KindOfAnimals.Mammals,"Giraffe", -2));
z.AddAnimal(new Animals(KindOfAnimals.Insects,"Spider", 4));
z.AddAnimal(new Animals(KindOfAnimals.Reptile,"Crocodile", 5 ));

Animals zw=new Animals(KindOfAnimals.Fish,"GoldFish", 10);

z.printAnimals();

AnimalManager db  = new AnimalManager();
db.addAnimal(zw);



try {
zw.SetAge(-1.0);
} catch (AgeException e) {


}

System.out.println(z);
}

}

