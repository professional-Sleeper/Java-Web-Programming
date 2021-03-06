package com.scsa.jadv.test;

import java.io.Serializable;

public class Employee implements Serializable {
	private int empNo;
	private String name;
	private String division;
	private String position;
	
	public Employee() {
		
	}
	
	public Employee(int empNo, String name, String division, String position) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.division = division;
		this.position = position;
	}


	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", name=" + name + ", division=" + division + ", position=" + position
				+ "]";
	}
	
}
