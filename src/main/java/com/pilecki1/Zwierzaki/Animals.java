package com.pilecki1.Zwierzaki;

public class Animals {
	
	
	public int id;
	public String name;
	public int age;
	public KiOfAnim kind;
	
	
	
	public Animals(String name, int age, KiOfAnim kind) {
		this.name = name;
		this.age = age;
		this.kind = kind;
	}
	
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public KiOfAnim getKinOfAnim() {
		return kind;
	}
	
	
	public String printAnimals() {
		String PrintAnimals = "\t" + name + " Age: " + age  + " Kind: " + kind;
		System.out.println(PrintAnimals);
		return PrintAnimals;
	}

	
	public void setKiOfAnim(KiOfAnim kind) {
		this.kind = kind;
	}
	
	
	public int setAge(int age) throws AgeLessThanZeroException {
		if(age < 0) {
			throw new AgeLessThanZeroException("Age Can not less than zero");
		}else{
			
			return this.age = age;
		}
	}

}

