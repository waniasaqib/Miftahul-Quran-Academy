package com.example.test;

public class Teacher {
	  
	  //instance variables
	  private String firstName;
	  private String lastName;
	  private String password;

	  //constructor
	  public Teacher (String firstName, String lastName, String password) {
	    this.firstName = firstName;
	    this.password = password;
	    this.lastName = lastName;
	  }

	  //getter methods
	  public String getFirstName() {
	    return firstName;
	  }

	  public String getLastName() {
	    return lastName;
	  }

	  public String getPassword() {
	    return password;
	  }

	  //setter methods
	  public void setFirstName(String name) {
	    firstName = name;
	  }

	  public void setLastName(String name) {
	    lastName = name;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }
	}
