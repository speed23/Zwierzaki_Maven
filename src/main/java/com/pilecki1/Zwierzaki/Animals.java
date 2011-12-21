package com.pilecki1.Zwierzaki;

public class Animals {

		
	private long id;
	private double age1;
	private KindOfAnimals kind;
	private String name;

public Animals(KindOfAnimals kind, String name, double age1)
{
	this.name=name;
	this.kind=kind;
	this.age1=age1;
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
	return age1;
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}


public void setName(String name) {
	this.name = name;
}
public double getAge() {
	return age1;
}
public void setAge(double age1) {
	this.age1 = age1;
}
	
	
public KindOfAnimals kind()
{
	return this.kind;
}

public String getKind() {
	return kind.toString();
}

public String setKind() {
	 return kind.toString();
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
	

	

	

	


}
