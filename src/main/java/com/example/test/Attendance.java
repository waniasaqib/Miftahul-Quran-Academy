package com.example.test;

import java.util.ArrayList;

public class Attendance {
  
  //instance variables - more need to be added
  private ArrayList<Boolean> presentOrAbsent = new ArrayList<Boolean>();
  private ArrayList<String> reasonAbsent = new ArrayList<String>();
  private ArrayList<Boolean> covidScreening= new ArrayList<Boolean>();
  private ArrayList<String> reasonCovidScreening =  new ArrayList<String>();

  //constructor
  public Attendance () {
    
  }

  //getter methods
  public ArrayList <Boolean> getAttendance() {
    return presentOrAbsent;
  }

  public ArrayList <String> getReasonAbsent() {
    return reasonAbsent;
  }

  public ArrayList <Boolean> getCovidScreening() {
    return covidScreening;
  }

  public ArrayList <String> getReasonCovidScreening () {
    return reasonCovidScreening;
  }

  //setter adding methods
  public void addAttendance(boolean pOrA) {
    presentOrAbsent.add(pOrA);
  }

  public void addReasonAbsent(String reason) {
    reasonAbsent.add(reason);
  }

  public void addCovidScreening(boolean screening) {
    covidScreening.add(screening);
  }

  public void addReasonCovidScreening(String reason2) {
    reasonCovidScreening.add(reason2);
  }
}
