package com.prj.bean;

public class My {
	private String name;
	private double number;
	public String getName() {
		return name;
	}
	public My() {
	}
	public My(String name, double number) {
		super();
		this.name = name;
		this.number = number;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getNumber() {
		return number;
	}
	public void setNumber(double number) {
		this.number = number;
	}
}
