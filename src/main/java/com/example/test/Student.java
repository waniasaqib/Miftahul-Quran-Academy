package com.example.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class Student {
  
  //instance variables
  //information of student
  private String firstName;
  private String middleName;
  private String lastName;
  private String address;
  private String dateOfBirth;
  private int age;
  private String postalCode;
  private String language;
  private String countryOfBirth;

  //attendance
  private Attendance attendanceOfStudent;
  private StudentProgress progressOfStudent;
  private ArrayList<String> date;
  
  //parent/guardian information
  private String guardianOneFirstName;
  private String guardianOneLastName;
  private String guardianOnePhoneNumber;
  private String guardianOneEmail;
  private Boolean guardianOneCallAtWork;

  private String guardianTwoFirstName;
  private String guardianTwoLastName;
  private String guardianTwoPhoneNumber;
  private String guardianTwoEmail;
  private Boolean guardianTwoCallAtWork;
  
  //emergency contacts
  private String emergencyContactOneFirstName;
  private String emergencyContactOneLastName;
  private String emergencyContactOneRelationship;
  private String emergencyContactOneHomeNumber;
  private String emergencyContactOneCellNumber;
  
  private String emergencyContactTwoFirstName;
  private String emergencyContactTwoLastName;
  private String emergencyContactTwoRelationship;
  private String emergencyContactTwoHomeNumber;
  private String emergencyContactTwoCellNumber;

  //health information
  private String healthFactorOne;
  private Boolean healthFactorOneLifeThreatening;
  private Boolean healthFactorOnePlanOfCareRequired;
  private Boolean healthFactorOneMedicationsRequired;

  private String healthFactorTwo;
  private Boolean healthFactorTwoLifeThreatening;
  private Boolean healthFactorTwoPlanOfCareRequired;
  private Boolean healthFactorTwoMedicationsRequired;

  private String healthFactorThree;
  private Boolean healthFactorThreeLifeThreatening;
  private Boolean healthFactorThreePlanOfCareRequired;
  private Boolean healthFactorThreeMedicationsRequired;
  
  private String tempReason = "";
  private String tempReason2 = "";
  private boolean aDone = true;
  private boolean cDone = true;
  
  //constructors
  public Student () {
    dateOfBirth = "11/11/1111";
    progressOfStudent = new StudentProgress();
    attendanceOfStudent = new Attendance();
  }

  public Student (String firstName, String middleName, String lastName, String address, String dateOfBirth, int age, String postalCode, String language, String countryOfBirth, Attendance attendanceOfStudent, StudentProgress progressOfStudent, ArrayList<String> date, String guardianOneFirstName, String guardianOneLastName, String guardianOnePhoneNumber, String guardianOneEmail, Boolean guardianOneCallAtWork, String guardianTwoFirstName, String guardianTwoLastName, String guardianTwoPhoneNumber, String guardianTwoEmail, Boolean guardianTwoCallAtWork, String emergencyContactOneFirstName, String emergencyContactOneLastName, String emergencyContactOneRelationship, String emergencyContactOneHomeNumber, String emergencyContactOneCellNumber, String emergencyContactTwoFirstName, String emergencyContactTwoLastName, String emergencyContactTwoRelationship, String emergencyContactTwoHomeNumber, String emergencyContactTwoCellNumber, String healthFactorOne, Boolean healthFactorOneLifeThreatening, Boolean healthFactorOnePlanOfCareRequired, Boolean healthFactorOneMedicationsRequired, String healthFactorTwo, Boolean healthFactorTwoLifeThreatening, Boolean healthFactorTwoPlanOfCareRequired, Boolean healthFactorTwoMedicationsRequired, String healthFactorThree, Boolean healthFactorThreeLifeThreatening, Boolean healthFactorThreePlanOfCareRequired, Boolean healthFactorThreeMedicationsRequired) {

  this.firstName = firstName;
  this.middleName = middleName;
  this.lastName = lastName;
  this.address = address;
  this.dateOfBirth = dateOfBirth;
  this.age = age;
  this.postalCode = postalCode;
  this.language = language;
  this.countryOfBirth = countryOfBirth;
  this.attendanceOfStudent = attendanceOfStudent;
  this.progressOfStudent = progressOfStudent;
  this.date = date;
  this.guardianOneFirstName = guardianOneFirstName;
  this.guardianOneLastName = guardianOneLastName;
  this.guardianOnePhoneNumber = guardianOnePhoneNumber;
  this.guardianOneEmail = guardianOneEmail;
  this.guardianOneCallAtWork = guardianOneCallAtWork;
  this.guardianTwoFirstName = guardianTwoFirstName;
  this.guardianTwoLastName = guardianTwoLastName;
  this.guardianTwoPhoneNumber = guardianTwoPhoneNumber;
  this.guardianTwoEmail = guardianTwoEmail;
  this.guardianTwoCallAtWork = guardianTwoCallAtWork;
  this.emergencyContactOneFirstName = emergencyContactOneFirstName;
  this.emergencyContactOneLastName = emergencyContactOneLastName;
  this.emergencyContactOneRelationship = emergencyContactOneRelationship;
  this.emergencyContactOneHomeNumber = emergencyContactOneHomeNumber;
  this.emergencyContactOneCellNumber = emergencyContactOneCellNumber;
  this.emergencyContactTwoFirstName = emergencyContactTwoFirstName;
  this.emergencyContactTwoLastName = emergencyContactTwoLastName;
  this.emergencyContactTwoRelationship = emergencyContactTwoRelationship;
  this.emergencyContactTwoHomeNumber = emergencyContactTwoHomeNumber;
  this.emergencyContactTwoCellNumber = emergencyContactTwoCellNumber;
  this.healthFactorOne = healthFactorOne;
  this.healthFactorOneLifeThreatening = healthFactorOneLifeThreatening;
  this.healthFactorOnePlanOfCareRequired = healthFactorOnePlanOfCareRequired;
  this.healthFactorOneMedicationsRequired = healthFactorOneMedicationsRequired;
  this.healthFactorTwo = healthFactorTwo;
  this.healthFactorTwoLifeThreatening = healthFactorTwoLifeThreatening;
  this.healthFactorTwoPlanOfCareRequired = healthFactorTwoPlanOfCareRequired;
  this.healthFactorTwoMedicationsRequired = healthFactorTwoMedicationsRequired;
  this.healthFactorThree = healthFactorThree;
  this.healthFactorThreeLifeThreatening = healthFactorThreeLifeThreatening;
  this.healthFactorThreePlanOfCareRequired = healthFactorThreePlanOfCareRequired;
  this.healthFactorThreeMedicationsRequired = healthFactorThreeMedicationsRequired;

  }

  public Student (String firstName, String middleName, String lastName, String address, String dateOfBirth, int age, String postalCode, String language, String countryOfBirth, String programChosen,String saparasDone, int totalSaparasDone, int currentSaparaMemorizing, int dourCurrentQuarter, int dourCurrentSapara, String guardianOneFirstName, String guardianOneLastName,String guardianOnePhoneNumber, String guardianOneEmail, Boolean guardianOneCallAtWork, String guardianTwoFirstName, String guardianTwoLastName, String guardianTwoPhoneNumber, String guardianTwoEmail, Boolean guardianTwoCallAtWork, String emergencyContactOneFirstName, String emergencyContactOneLastName, String emergencyContactOneRelationship, String emergencyContactOneHomeNumber, String emergencyContactOneCellNumber, String emergencyContactTwoFirstName, String emergencyContactTwoLastName, String emergencyContactTwoRelationship, String emergencyContactTwoHomeNumber, String emergencyContactTwoCellNumber, String healthFactorOne, Boolean healthFactorOneLifeThreatening, Boolean healthFactorOnePlanOfCareRequired, Boolean healthFactorOneMedicationsRequired, String healthFactorTwo, Boolean healthFactorTwoLifeThreatening, Boolean healthFactorTwoPlanOfCareRequired, Boolean healthFactorTwoMedicationsRequired, String healthFactorThree, Boolean healthFactorThreeLifeThreatening, Boolean healthFactorThreePlanOfCareRequired, Boolean healthFactorThreeMedicationsRequired) {

  this.firstName = firstName;
  this.middleName = middleName;
  this.lastName = lastName;
  this.address = address;
  this.dateOfBirth = dateOfBirth;
  this.age = age;
  this.postalCode = postalCode;
  this.language = language;
  this.countryOfBirth = countryOfBirth;
  attendanceOfStudent = new Attendance();
  progressOfStudent = new StudentProgress(programChosen, saparasDone, totalSaparasDone, currentSaparaMemorizing, dourCurrentQuarter, dourCurrentSapara);
  this.guardianOneFirstName = guardianOneFirstName;
  this.guardianOneLastName = guardianOneLastName;
  this.guardianOnePhoneNumber = guardianOnePhoneNumber;
  this.guardianOneEmail = guardianOneEmail;
  this.guardianOneCallAtWork = guardianOneCallAtWork;
  this.guardianTwoFirstName = guardianTwoFirstName;
  this.guardianTwoLastName = guardianTwoLastName;
  this.guardianTwoPhoneNumber = guardianTwoPhoneNumber;
  this.guardianTwoEmail = guardianTwoEmail;
  this.guardianTwoCallAtWork = guardianTwoCallAtWork;
  this.emergencyContactOneFirstName = emergencyContactOneFirstName;
  this.emergencyContactOneLastName = emergencyContactOneLastName;
  this.emergencyContactOneRelationship = emergencyContactOneRelationship;
  this.emergencyContactOneHomeNumber = emergencyContactOneHomeNumber;
  this.emergencyContactOneCellNumber = emergencyContactOneCellNumber;
  this.emergencyContactTwoFirstName = emergencyContactTwoFirstName;
  this.emergencyContactTwoLastName = emergencyContactTwoLastName;
  this.emergencyContactTwoRelationship = emergencyContactTwoRelationship;
  this.emergencyContactTwoHomeNumber = emergencyContactTwoHomeNumber;
  this.emergencyContactTwoCellNumber = emergencyContactTwoCellNumber;
  this.healthFactorOne = healthFactorOne;
  this.healthFactorOneLifeThreatening = healthFactorOneLifeThreatening;
  this.healthFactorOnePlanOfCareRequired = healthFactorOnePlanOfCareRequired;
  this.healthFactorOneMedicationsRequired = healthFactorOneMedicationsRequired;
  this.healthFactorTwo = healthFactorTwo;
  this.healthFactorTwoLifeThreatening = healthFactorTwoLifeThreatening;
  this.healthFactorTwoPlanOfCareRequired = healthFactorTwoPlanOfCareRequired;
  this.healthFactorTwoMedicationsRequired = healthFactorTwoMedicationsRequired;
  this.healthFactorThree = healthFactorThree;
  this.healthFactorThreeLifeThreatening = healthFactorThreeLifeThreatening;
  this.healthFactorThreePlanOfCareRequired = healthFactorThreePlanOfCareRequired;
  this.healthFactorThreeMedicationsRequired = healthFactorThreeMedicationsRequired;
  
  }



  //getters & setters 
  //STUDENT
 
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
		return middleName;
	}
 
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public LocalDate getDateOfBirthLocalDate() {
      
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	  String temp = dateOfBirth;
	  LocalDate date1 = LocalDate.parse(temp, formatter);
	  return date1;
  }
  
  public void setDateOfBirthLocalDate(LocalDate date) {
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	  String temp = formatter.format(date);
	  this.dateOfBirth = temp;
  }
  
  public String getFullName() {
	  char firstLetter = firstName.charAt(0);
  	firstLetter = Character.toUpperCase(firstLetter);
  	String restOfName = firstName.substring(1);
  	String firstName2 =  firstLetter + restOfName;
  	
  	char firstLetter2 = lastName.charAt(0);
  	firstLetter2 = Character.toUpperCase(firstLetter2);
  	String restOfName2 = lastName.substring(1);
  	String lastName2 =  firstLetter2 + restOfName2;
	  return firstName2 + " " + lastName2;
  }

  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

 public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
  
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }

		public String getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		public String getLanguage() {
			return language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}
		public String getCountryOfBirth() {
			return countryOfBirth;
		}
		public void setCountryOfBirth(String countryOfBirth) {
			this.countryOfBirth = countryOfBirth;
		}


  //ATTENDANCE
  public ArrayList <Boolean> getAttendance() {
    return attendanceOfStudent.getAttendance();
  }
  public void addAttendance(Boolean pOrA) {
    attendanceOfStudent.addAttendance(pOrA);
  }

  public ArrayList <String> getReasonAbsent() {
    return attendanceOfStudent.getReasonAbsent();
  }
  public void addReasonAbsent(String reason) {
    attendanceOfStudent.addReasonAbsent(reason);
  }


  public ArrayList <Boolean> getCovidScreening() {
    return attendanceOfStudent.getCovidScreening();
  }
  public void addCovidScreening(Boolean screening) {
    attendanceOfStudent.addCovidScreening(screening);
  }


  public ArrayList <String> getReasonCovidScreening () {
    return attendanceOfStudent.getReasonCovidScreening();
  }
  public void addReasonCovidScreening(String reason2) {
    attendanceOfStudent.addReasonCovidScreening(reason2);
  }

  //STUDENT PROGRESS 
  public String getProgramChosen() {
    return progressOfStudent.getProgramChosen();
  }
  public void setProgramChosen(String programChosen) {
    progressOfStudent.setProgramChosen(programChosen);
  }

    public Boolean[] getSabaqDoneOrNot() {
			return progressOfStudent.getSabaqDoneOrNot();
		}

		public void setSabaqDoneOrNot(Boolean[] sabaqDoneOrNot) {
			progressOfStudent.setSabaqDoneOrNot(sabaqDoneOrNot);
		}

		public Boolean getTodaySabaqDoneOrNot() {
			return progressOfStudent.getTodaySabaqDoneOrNot();
		}

    public int getSaparaNextFill() {
    return progressOfStudent.getSaparaNextFill();
  }

  public int getDourNextFill() {
    return progressOfStudent.getDourNextFill();
  }


		public void setTodaySabaqDoneOrNot(Boolean todaySabaqDoneOrNot) {
		  progressOfStudent.setTodaySabaqDoneOrNot(todaySabaqDoneOrNot);
      if (todaySabaqDoneOrNot == false) {
        progressOfStudent.setTodayLinesMemorized(0);
        progressOfStudent.setTodayMistakesMade(0);
        progressOfStudent.setTodaySaparaFinished(false);
      }
		}

		public int[] getLinesMemorized() {
			return progressOfStudent.getLinesMemorized();
		}

		public void setLinesMemorized(int[] linesMemorized) {
			progressOfStudent.setLinesMemorized(linesMemorized);
		}

		public int getTodayLinesMemorized() {
			return progressOfStudent.getTodayLinesMemorized();
		}

		public void setTodayLinesMemorized(int todayLinesMemorized) {
			progressOfStudent.setTodayLinesMemorized(todayLinesMemorized);
		}

		public int[] getMistakesMade() {
			return progressOfStudent.getMistakesMade();
		}

		public void setMistakesMade(int[] mistakesMade) {
			progressOfStudent.setMistakesMade(mistakesMade);
		}

		public int getTodayMistakesMade() {
			return progressOfStudent.getTodayMistakesMade();
		}

		public void setTodayMistakesMade(int todayMistakesMade) {
			progressOfStudent.setTodayMistakesMade(todayMistakesMade);
		}

		public Boolean[] getNumOfSaparasDoneMonth() {
			return progressOfStudent.getNumOfSaparasDoneMonth();
		}

		public void setNumOfSaparasDoneMonth(Boolean[] numOfSaparasDoneMonth) {
			progressOfStudent.setNumOfSaparasDoneMonth(numOfSaparasDoneMonth);
		}

		public Boolean isTodaySaparaFinished() {
			return progressOfStudent.isTodaySaparaFinished();
		}

		public void setTodaySaparaFinished(Boolean todaySaparaFinished) {
			progressOfStudent.setTodaySaparaFinished(todaySaparaFinished);
		}

		public int[] getNameOfSaparasDoneMonth() {
			return progressOfStudent.getNameOfSaparasDoneMonth();
		}

		public void setNameOfSaparasDoneMonth(int[] nameOfSaparasDoneMonth) {
			progressOfStudent.setNameOfSaparasDoneMonth(nameOfSaparasDoneMonth);
		}

		public int getTotalSaparasDone() {
			return progressOfStudent.getTotalSaparasDone();
		}

		public void setTotalSaparasDone(int totalSaparasDone) {
			progressOfStudent.setTotalSaparasDone(totalSaparasDone);
		}

		public int getTodaySaparaDone() {
			return progressOfStudent.getTodaySaparaDone();
		}

		public void setTodaySaparaDone(int todaySaparaDone) {
			progressOfStudent.setTodaySaparaDone(todaySaparaDone);
		}

		public String getSaparasDone() {
			return progressOfStudent.getSaparasDone();
		}

		public void addSaparasDone(int saparasDone) {
			progressOfStudent.addSaparasDone(saparasDone);
		}

    public void setSaparasDone(String saparasDone) {
			progressOfStudent.setOpenSaparasDone(saparasDone);
		}

		public int getCurrentSaparaMemorizing() {
			return progressOfStudent.getCurrentSaparaMemorizing();
		}

		public void setCurrentSaparaMemorizing(int currentSaparaMemorizing) {
			progressOfStudent.setCurrentSaparaMemorizing(currentSaparaMemorizing);
		}

    //DOUR
		public Boolean[] getDourDoneOrNot() {
			return progressOfStudent.getDourDoneOrNot();
		}

		public void setDourDoneOrNot(Boolean[] dourDoneOrNot) {
			progressOfStudent.setDourDoneOrNot(dourDoneOrNot);
		}

		public Boolean isTodayDourDoneOrNot() {
			return progressOfStudent.isTodayDourDoneOrNot();
		}

		public void setTodayDourDoneOrNot(Boolean todayDourDoneOrNot) {
			progressOfStudent.setTodayDourDoneOrNot(todayDourDoneOrNot);
      if (todayDourDoneOrNot == false) {
        progressOfStudent.setTodayQuartersDone(0);
        progressOfStudent.setTodayDourSaparaDoneOrNot(false);
      }
		}

		public int[] getQuarterNumDoneMonth() {
			return progressOfStudent.getQuarterNumDoneMonth();
		}

		public void setQuarterNumDoneMonth(int[] quarterNumDoneMonth) {
			progressOfStudent.setQuarterNumDoneMonth(quarterNumDoneMonth);
		}

		public int getTodayQuartersDone() {
			return progressOfStudent.getTodayQuartersDone();
		}

		public void setTodayQuartersDone(int todayQuartersDone) {
			progressOfStudent.setTodayQuartersDone(todayQuartersDone);
		}

		public int getCurrentQuarter() {
			return progressOfStudent.getCurrentQuarter();
		}

		public void setCurrentQuarter(int currentQuarter) {
			progressOfStudent.setCurrentQuarter(currentQuarter);
		}

		public Boolean[] getNumOfDourSaparasDoneMonth() {
			return progressOfStudent.getNumOfDourSaparasDoneMonth();
		}

		public void setNumOfDourSaparasDoneMonth(Boolean[] numOfDourSaparasDoneMonth) {
			progressOfStudent.setNumOfDourSaparasDoneMonth(numOfDourSaparasDoneMonth);
		}

		public Boolean isTodayDourSaparaDoneOrNot() {
			return progressOfStudent.isTodayDourSaparaDoneOrNot();
		}

		public void setTodayDourSaparaDoneOrNot(Boolean todayDourSaparaDoneOrNot) {
			progressOfStudent.setTodayDourSaparaDoneOrNot(todayDourSaparaDoneOrNot);
		}

		public int getTodayDourSaparaDone() {
			return progressOfStudent.getTodayDourSaparaDone();
		}

		public void setTodayDourSaparaDone(int todayDourSaparaDone) {
			progressOfStudent.setTodayDourSaparaDone(todayDourSaparaDone);
		}

		public int getDourCurrentSapara() {
			return progressOfStudent.getDourCurrentSapara();
		}

		public void setDourCurrentSapara(int dourCurrentSapara) {
			 progressOfStudent.setDourCurrentSapara(dourCurrentSapara);
		}

  
  //PROGRESS - DATE 
  public String getLastRecord() {
		return progressOfStudent.getLastRecord();
	}

	public void setLastRecord(String lastRecord) {
		progressOfStudent.setLastRecord(lastRecord);
	}
  
  

  //DATE 
  public ArrayList<String> getDate() {
		return date;
	}

	public void addDate(String dates) {
		date.add(dates);
  }
	public void setDate(ArrayList <String> date1) {
		date = date1;
	}
		

  //GUARDIAN 
  public String getGuardianOneFirstName() {
    return guardianOneFirstName;
  }
  public void setGuardianOneFirstName(String guardianOneFirstName) {
    this.guardianOneFirstName = guardianOneFirstName;
  }
  public String getGuardianOneLastName() {
    return guardianOneLastName;
  }
  public void setGuardianOneLastName(String guardianOneLastName) {
    this.guardianOneLastName = guardianOneLastName;
  }
  public String getGuardianOnePhoneNumber() {
		return guardianOnePhoneNumber;
	}
	public void setGuardianOnePhoneNumber(String guardianOnePhoneNumber) {
		this.guardianOnePhoneNumber = guardianOnePhoneNumber;
	}
	public String getGuardianOneEmail() {
		return guardianOneEmail;
	}
	public void setGuardianOneEmail(String guardianOneEmail) {
		this.guardianOneEmail = guardianOneEmail;
	}
	public Boolean isGuardianOneCallAtWork() {
		return guardianOneCallAtWork;
	}
	public void setGuardianOneCallAtWork(Boolean guardianOneCallAtWork) {
		this.guardianOneCallAtWork = guardianOneCallAtWork;
	}
	public String getGuardianTwoFirstName() {
		return guardianTwoFirstName;
	}
	public void setGuardianTwoFirstName(String guardianTwoFirstName) {
		this.guardianTwoFirstName = guardianTwoFirstName;
	}
	public String getGuardianTwoLastName() {
		return guardianTwoLastName;
	}
	public void setGuardianTwoLastName(String guardianTwoLastName) {
		this.guardianTwoLastName = guardianTwoLastName;
	}
	public String getGuardianTwoPhoneNumber() {
		return guardianTwoPhoneNumber;
	}
	public void setGuardianTwoPhoneNumber(String guardianTwoPhoneNumber) {
		this.guardianTwoPhoneNumber = guardianTwoPhoneNumber;
	}
	public String getGuardianTwoEmail() {
		return guardianTwoEmail;
	}
	public void setGuardianTwoEmail(String guardianTwoEmail) {
		this.guardianTwoEmail = guardianTwoEmail;
	}
	public Boolean isGuardianTwoCallAtWork() {
		return guardianTwoCallAtWork;
	}
	public void setGuardianTwoCallAtWork(Boolean guardianTwoCallAtWork) {
		this.guardianTwoCallAtWork = guardianTwoCallAtWork;
	}

  //EMERGENCY 
  public String getEmergencyContactOneFirstName() {
		return emergencyContactOneFirstName;
	}
	public void setEmergencyContactOneFirstName(String emergencyContactOneFirstName) {
		this.emergencyContactOneFirstName = emergencyContactOneFirstName;
	}
	public String getEmergencyContactOneLastName() {
		return emergencyContactOneLastName;
	}
	public void setEmergencyContactOneLastName(String emergencyContactOneLastName) {
		this.emergencyContactOneLastName = emergencyContactOneLastName;
	}
	public String getEmergencyContactOneRelationship() {
		return emergencyContactOneRelationship;
	}
	public void setEmergencyContactOneRelationship(String emergencyContactOneRelationship) {
		this.emergencyContactOneRelationship = emergencyContactOneRelationship;
	}
	public String getEmergencyContactOneHomeNumber() {
		return emergencyContactOneHomeNumber;
	}
	public void setEmergencyContactOneHomeNumber(String emergencyContactOneHomeNumber) {
		this.emergencyContactOneHomeNumber = emergencyContactOneHomeNumber;
	}
	public String getEmergencyContactOneCellNumber() {
		return emergencyContactOneCellNumber;
	}
	public void setEmergencyContactOneCellNumber(String emergencyContactOneCellNumber) {
		this.emergencyContactOneCellNumber = emergencyContactOneCellNumber;
	}
	public String getEmergencyContactTwoFirstName() {
		return emergencyContactTwoFirstName;
	}
	public void setEmergencyContactTwoFirstName(String emergencyContactTwoFirstName) {
		this.emergencyContactTwoFirstName = emergencyContactTwoFirstName;
	}
	public String getEmergencyContactTwoLastName() {
		return emergencyContactTwoLastName;
	}
	public void setEmergencyContactTwoLastName(String emergencyContactTwoLastName) {
		this.emergencyContactTwoLastName = emergencyContactTwoLastName;
	}
	public String getEmergencyContactTwoRelationship() {
		return emergencyContactTwoRelationship;
	}
	public void setEmergencyContactTwoRelationship(String emergencyContactTwoRelationship) {
		this.emergencyContactTwoRelationship = emergencyContactTwoRelationship;
	}
	public String getEmergencyContactTwoHomeNumber() {
		return emergencyContactTwoHomeNumber;
	}
	public void setEmergencyContactTwoHomeNumber(String emergencyContactTwoHomeNumber) {
		this.emergencyContactTwoHomeNumber = emergencyContactTwoHomeNumber;
	}
	public String getEmergencyContactTwoCellNumber() {
		return emergencyContactTwoCellNumber;
	}
	public void setEmergencyContactTwoCellNumber(String emergencyContactTwoCellNumber) {
		this.emergencyContactTwoCellNumber = emergencyContactTwoCellNumber;
	}

  //HEALTH FACTORS 
  public String getHealthFactorOne() {
		return healthFactorOne;
	}
	public void setHealthFactorOne(String healthFactorOne) {
		this.healthFactorOne = healthFactorOne;
	}
	public Boolean isHealthFactorOneLifeThreatening() {
		return healthFactorOneLifeThreatening;
	}
	public void setHealthFactorOneLifeThreatening(Boolean healthFactorOneLifeThreatening) {
		this.healthFactorOneLifeThreatening = healthFactorOneLifeThreatening;
	}
	public Boolean isHealthFactorOnePlanOfCareRequired() {
		return healthFactorOnePlanOfCareRequired;
	}
	public void setHealthFactorOnePlanOfCareRequired(Boolean healthFactorOnePlanOfCareRequired) {
		this.healthFactorOnePlanOfCareRequired = healthFactorOnePlanOfCareRequired;
	}
	public Boolean isHealthFactorOneMedicationsRequired() {
		return healthFactorOneMedicationsRequired;
	}
	public void setHealthFactorOneMedicationsRequired(Boolean healthFactorOneMedicationsRequired) {
		this.healthFactorOneMedicationsRequired = healthFactorOneMedicationsRequired;
	}
	public String getHealthFactorTwo() {
		return healthFactorTwo;
	}
	public void setHealthFactorTwo(String healthFactorTwo) {
		this.healthFactorTwo = healthFactorTwo;
	}
	public Boolean isHealthFactorTwoLifeThreatening() {
		return healthFactorTwoLifeThreatening;
	}
	public void setHealthFactorTwoLifeThreatening(Boolean healthFactorTwoLifeThreatening) {
		this.healthFactorTwoLifeThreatening = healthFactorTwoLifeThreatening;
	}
	public Boolean isHealthFactorTwoPlanOfCareRequired() {
		return healthFactorTwoPlanOfCareRequired;
	}
	public void setHealthFactorTwoPlanOfCareRequired(Boolean healthFactorTwoPlanOfCareRequired) {
		this.healthFactorTwoPlanOfCareRequired = healthFactorTwoPlanOfCareRequired;
	}
	public Boolean isHealthFactorTwoMedicationsRequired() {
		return healthFactorTwoMedicationsRequired;
	}
	public void setHealthFactorTwoMedicationsRequired(Boolean healthFactorTwoMedicationsRequired) {
		this.healthFactorTwoMedicationsRequired = healthFactorTwoMedicationsRequired;
	}
	public String getHealthFactorThree() {
		return healthFactorThree;
	}
	public void setHealthFactorThree(String healthFactorThree) {
		this.healthFactorThree = healthFactorThree;
	}
	public Boolean isHealthFactorThreeLifeThreatening() {
		return healthFactorThreeLifeThreatening;
	}
	public void setHealthFactorThreeLifeThreatening(Boolean healthFactorThreeLifeThreatening) {
		this.healthFactorThreeLifeThreatening = healthFactorThreeLifeThreatening;
	}
	public Boolean isHealthFactorThreePlanOfCareRequired() {
		return healthFactorThreePlanOfCareRequired;
	}
	public void setHealthFactorThreePlanOfCareRequired(Boolean healthFactorThreePlanOfCareRequired) {
		this.healthFactorThreePlanOfCareRequired = healthFactorThreePlanOfCareRequired;
	}
	public Boolean isHealthFactorThreeMedicationsRequired() {
		return healthFactorThreeMedicationsRequired;
	}
	public void setHealthFactorThreeMedicationsRequired(Boolean healthFactorThreeMedicationsRequired) {
		this.healthFactorThreeMedicationsRequired = healthFactorThreeMedicationsRequired;
	}




  //OTHER - FILE OPEN SETTERS 

  public void setOpenProgramChosen(String programChosen) {
		progressOfStudent.setOpenProgramChosen(programChosen);
	}

	public void setOpenProgressOfStudentDaily(String progressOfStudentDaily) {
		progressOfStudent.setOpenProgressOfStudentDaily(progressOfStudentDaily);
	}

	public void setOpenProgressOfStudentMonthly(String progressOfStudentMonthly) {
    progressOfStudent.setOpenProgressOfStudentMonthly(progressOfStudentMonthly);
	}

	public void setOpenSabaqDoneOrNot(Boolean[] sabaqDoneOrNot) {
		progressOfStudent.setOpenSabaqDoneOrNot(sabaqDoneOrNot);
	}

	public void setOpenTodaySabaqDoneOrNot(Boolean todaySabaqDoneOrNot) {
		progressOfStudent.setOpenTodaySabaqDoneOrNot(todaySabaqDoneOrNot);
	}

	public void setOpenLinesMemorized(int[] linesMemorized) {
		progressOfStudent.setOpenLinesMemorized(linesMemorized);
	}

	public void setOpenTodayLinesMemorized(int todayLinesMemorized) {
    progressOfStudent.setOpenTodayLinesMemorized(todayLinesMemorized);
	}

	public void setOpenMistakesMade(int[] mistakesMade) {
    progressOfStudent.setOpenMistakesMade(mistakesMade);
	}

	public void setOpenTodayMistakesMade(int todayMistakesMade) {
    progressOfStudent.setOpenTodayMistakesMade(todayMistakesMade);
	}

	public void setOpenNumOfSaparasDoneMonth(Boolean[] numOfSaparasDoneMonth) {
    progressOfStudent.setOpenNumOfSaparasDoneMonth(numOfSaparasDoneMonth);
	}

	public void setOpenTodaySaparaFinished(Boolean todaySaparaFinished) {
    progressOfStudent.setOpenTodaySaparaFinished(todaySaparaFinished);
	}

	public void setOpenNameOfSaparasDoneMonth(int[] nameOfSaparasDoneMonth) {
    progressOfStudent.setOpenNameOfSaparasDoneMonth(nameOfSaparasDoneMonth);
	}

	public void setOpenTotalSaparasDone(int totalSaparasDone) {
    progressOfStudent.setOpenTotalSaparasDone(totalSaparasDone);
	}

	public void setOpenTodaySaparaDone(int todaySaparaDone) {
    progressOfStudent.setOpenTodaySaparaDone(todaySaparaDone);
	}

	public void setOpenSaparasDone(String saparasDone) {
    progressOfStudent.setOpenSaparasDone(saparasDone);
	}

	public void setOpenCurrentSaparaMemorizing(int currentSaparaMemorizing) {
    progressOfStudent.setOpenCurrentSaparaMemorizing(currentSaparaMemorizing);
	}

	public void setOpenSaparaNextFill(int saparaNextFill) {
    progressOfStudent.setOpenSaparaNextFill(saparaNextFill);
	}

	public void setOpenDourDoneOrNot(Boolean[] dourDoneOrNot) {
    progressOfStudent.setOpenDourDoneOrNot(dourDoneOrNot);
	}

	public void setOpenTodayDourDoneOrNot(Boolean todayDourDoneOrNot) {
    progressOfStudent.setOpenTodayDourDoneOrNot(todayDourDoneOrNot);
	}

	public void setOpenQuarterNumDoneMonth(int[] quarterNumDoneMonth) {
    progressOfStudent.setOpenQuarterNumDoneMonth(quarterNumDoneMonth);
	}

	public void setOpenTodayQuartersDone(int todayQuartersDone) {
    progressOfStudent.setOpenTodayQuartersDone(todayQuartersDone);
	}

	public void setOpenCurrentQuarter(int currentQuarter) {
    progressOfStudent.setOpenCurrentQuarter(currentQuarter);
	}

	public void setOpenNumOfDourSaparasDoneMonth(Boolean[] numOfDourSaparasDoneMonth) {
    progressOfStudent.setOpenNumOfDourSaparasDoneMonth(numOfDourSaparasDoneMonth);
	}

	public void setOpenTodayDourSaparaDoneOrNot(Boolean todayDourSaparaDoneOrNot) {
    progressOfStudent.setOpenTodayDourSaparaDoneOrNot(todayDourSaparaDoneOrNot);
	}

	public void setOpenDourCurrentSapara(int dourCurrentSapara) {
    progressOfStudent.setOpenDourCurrentSapara(dourCurrentSapara);
	}

	public void setOpenDourNextFill(int dourNextFill) {
    progressOfStudent.setOpenDourNextFill(dourNextFill);
	}
	
	public String getApplicable() {
		if ((progressOfStudent.getSabaqDoneOrNot()[29] == null) || (progressOfStudent.getDourDoneOrNot() [29] == null)||(progressOfStudent.getLastRecord().equals("11/11/2011")) || (progressOfStudent.getDourNextFill() < 29)) {
			return "No";
		} else {
			return "Yes";
		}
	}
	
	 //required for GUI
	  public boolean getTempAttendance() {
		  return aDone;
	  }
	  public void setTempAttendance(boolean temp) {
		  aDone = temp;
	  }
	  public boolean getTempScreening() {
		  return cDone;
	  }
	  public void setTempScreening(boolean temp1) {
		  cDone = temp1;
	  }
	  
	  public void setTempReason(String temp) {
		  tempReason = temp;
		  
	  }
	  public String getTempReason() {
		  return tempReason;
	  }
	  public void setTempReason2(String temp) {
		  tempReason2 = temp;
		  
	  }
	  public String getTempReason2() {
		  return tempReason2;
	  }
  
}
