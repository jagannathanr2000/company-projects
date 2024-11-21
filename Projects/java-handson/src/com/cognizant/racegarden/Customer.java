package com.cognizant.racegarden;

public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String companyName;
	private String email;
	private long phno;
	
	
	public Customer() {}


	public Customer(int id, String firstName,String lastName, int age, String companyName, String email, long phno) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.companyName = companyName;
		this.email = email;
		this.phno = phno;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	





	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getPhno() {
		return phno;
	}


	public void setPhno(long phno) {
		this.phno = phno;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", age=");
		builder.append(age);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phno=");
		builder.append(phno);
		builder.append("]");
		return builder.toString();
	}


	
	

	
	
}
