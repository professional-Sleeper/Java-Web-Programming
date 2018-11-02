package com.scsa.sax;

import java.io.Serializable;

public class Person implements Serializable{
	
	//¸â¹öº¯¼ö
	public String name;
	public int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		//System.out.println("Person().........");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}



