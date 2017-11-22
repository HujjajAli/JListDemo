package com.beanClasses;

public class Student 
{
	private String name;
	private String rollNo;

	public Student(String name,String rollNo) 
	{
		this.name = name;
		this.rollNo = rollNo;
	}
	
	public String toString()
	{
		
		return name+"                      2k15-ITC-"+rollNo;
		
	}

}
