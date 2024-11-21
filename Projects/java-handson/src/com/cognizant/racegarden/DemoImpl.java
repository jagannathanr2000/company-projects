package com.cognizant.racegarden;

interface Demo {
	
	public static final int i=10;
	void display();
	void print();
	static void displayStatic() {
		System.out.print("Static Interface");
	}
	
	default void displayDefault() {
		System.out.println("Jagan");
	}
	
	
	int disInt(int i) ;
}

class DemoImpl implements Demo {

	public static final int i=10;
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Display");
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Print");
		
	}

	@Override
	public int disInt(int i) {
		// TODO Auto-generated method stub
		return i;
	}
	
	
	
	public static void displayStatic() {
		System.out.println("Class Static ");
	}
	
	
	public  void displayDefault() {
		System.out.println("Display Default Class");
	}
	
	
	public static void main(String[] args) {
		DemoImpl d = new DemoImpl();
		
		d.display();
		d.displayDefault();
		d.disInt(i);
		d.print();
		
		Demo.displayStatic();
		
		DemoImpl.displayStatic();
		
//		super.displayDefault
	}
}
