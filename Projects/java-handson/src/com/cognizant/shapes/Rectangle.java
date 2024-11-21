package com.cognizant.shapes;

public class Rectangle {
	
	private int l;
	private int b;
	
	public Rectangle(int l,int b) {
		this.l = l;
		this.b = b;
	}
	public int calculateArea() {
		return l*b;
	}

}
