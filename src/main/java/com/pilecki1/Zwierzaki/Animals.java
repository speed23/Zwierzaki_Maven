package com.pilecki1.Zwierzaki;

public class Animals {

		

public Animals(KindOfAnimals kind, String name, double age)
{
	this.name=name;
	this.kind=kind;
	this.age=age;
}


public void PrintAnimal()
{
	System.out.println("Name of: "+name+"\tKind of: "+ kind);
}
	

public void SetAge(double age) throws AgeException
{
	if(age < 0)
	throw new AgeException("Age don't have less than 0 because then Animals didn't born");
	
}
	
public String getName()
{
	return name;
}
	
public double age() 
{
	return age;
}
	
	
public KindOfAnimals kind()
{
	return this.kind;
}

public void SetName(String name)
{
	this.name=name;
}
	
public String toString()
{
	return this.name + " "+this.kind;
}
	
public KindOfAnimals getKindofAnimal()
{
	return this.kind;
}
	
	
private double age;
	
private KindOfAnimals kind;
	
private String name;

}
