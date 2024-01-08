package com.example.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "studentInfo", layout = Welcome.class)
public class StudentInfo extends VerticalLayout {
	static Scanner fileScanner;
	static ArrayList <Student> listOfStudents = new ArrayList <Student>(); 
	
	
	public StudentInfo() {
		listOfStudents.removeAll(listOfStudents);
		listOfStudents = fileOneOpen();
		
		H2 intro = new H2 ("Student Information");
		
		TextField fname = new TextField();
	    fname.setLabel("First Name");
	    fname.setRequiredIndicatorVisible(true);
	    fname.setErrorMessage("This field is required");
	   
	    TextField lname = new TextField();
	    lname.setLabel("Last Name");
	    lname.setRequiredIndicatorVisible(true);
	    lname.setErrorMessage("This field is required");
	    lname.setHeight("75px");
	    
        Button saveButton = new Button("Done", e -> {
        	int index = -2;
            boolean found = false;
        	for (int i = 0; i < listOfStudents.size(); i++) {
                if (fname.getValue().equals(listOfStudents.get(i).getFirstName()) && lname.getValue().equals(listOfStudents.get(i).getLastName())) {
                  index = i;
                  found = true;
                  store(index);
                  UI.getCurrent().navigate("emergency1");
                  break;
                } 
              }

              if (found == false) {
           	   Notification.show("Invalid name entered.",
                          3000, Notification.Position.MIDDLE);
              }
        	
        	
        });
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        saveButton.setWidth("200px");
        
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
        add(intro, fname, lname, saveButton);

	}
	
	
	
	  public static void store(int index) {
		  PrintWriter pw = null;
          try {
             pw = new PrintWriter(new File("../marchbreakia/temp.txt"));
             pw.println(index);
             pw.close();
          } catch (FileNotFoundException e) {
            System.err.print("couldn't open file for writing!");
            System.exit(0);
          }
	  }
	
	  public static ArrayList <Student> fileOneOpen() { 
	        try {
	         fileScanner = new Scanner(new File("../marchbreakia/student.txt"));
	       } catch (FileNotFoundException e) {
	         System.err.println("File not found! Choosing to quit now...");
	     
	         System.exit(0);
	       }
	     
	       //programChosen  - CHECK CONSTRUCTORS
	       //add health factors to printing out in emergency situation stuff
	     
	       String firstName, middleName, lastName, address, dateOfBirth, postalCode, language, countryOfBirth, tempAttendance, tempReasonAttendance, tempCovid, tempReasonCovid;

	        Boolean[] dourDoneOrNot;
	        Boolean todayDourDoneOrNot;
	        int[] quarterNumDoneMonth;
	        int todayQuartersDone, currentQuarter;
	        Boolean[] numOfDourSaparasDoneMonth;
	        Boolean todayDourSaparaDoneOrNot;
	        int todayDourSaparaDone;
	        int dourCurrentSapara, dourNextFill;

	        String programChosen;
	        String lastRecord;

	        Boolean[] sabaqDoneOrNot;
	        Boolean todaySabaqDoneOrNot;
	        int[] linesMemorized;
	        int todayLinesMemorized;
	        int[] mistakesMade;
	        int todayMistakesMade;
	        Boolean[] numOfSaparasDoneMonth;
	        Boolean todaySaparaFinished;
	        int[] nameOfSaparasDoneMonth;
	        int totalSaparasDone;
	        int todaySaparaDone;
	        String saparasDone;
	        int currentSaparaMemorizing;
	        int saparaNextFill = 0;

	       int age;
	      
	       String tempDate;
	       ArrayList<String> dates;
	     
	      
	       String guardianOneFirstName, guardianOneLastName, guardianOnePhoneNumber;
	       String guardianOneEmail;
	       Boolean guardianOneCallAtWork;
	       String guardianTwoFirstName, guardianTwoLastName;
	       String guardianTwoPhoneNumber;
	       String guardianTwoEmail;
	       Boolean guardianTwoCallAtWork;
	      
	       String emergencyContactOneFirstName, emergencyContactOneLastName, emergencyContactOneRelationship;
	       String emergencyContactOneHomeNumber, emergencyContactOneCellNumber;
	       String emergencyContactTwoFirstName, emergencyContactTwoLastName, emergencyContactTwoRelationship;
	       String emergencyContactTwoHomeNumber, emergencyContactTwoCellNumber;
	      
	       String healthFactorOne;
	       Boolean healthFactorOneLifeThreatening,healthFactorOnePlanOfCareRequired, healthFactorOneMedicationsRequired;
	       String healthFactorTwo;
	       Boolean healthFactorTwoLifeThreatening, healthFactorTwoPlanOfCareRequired, healthFactorTwoMedicationsRequired;
	       String healthFactorThree;
	       Boolean healthFactorThreeLifeThreatening, healthFactorThreePlanOfCareRequired, healthFactorThreeMedicationsRequired;
	      
	       Attendance attendanceOfStudent;
	       StudentProgress progressOfStudent;
	     
	       while (fileScanner.hasNextLine()) {
	    	   dourDoneOrNot = new Boolean[30];
		        quarterNumDoneMonth = new int[30];
		       numOfDourSaparasDoneMonth = new Boolean[30];
		       sabaqDoneOrNot = new Boolean[30];
		        linesMemorized = new int[30];
		        mistakesMade = new int[30];
		        numOfSaparasDoneMonth = new Boolean[30];
		       nameOfSaparasDoneMonth = new int[30];
	        
	         firstName = (fileScanner.nextLine()).toLowerCase();
	         middleName = (fileScanner.nextLine()).toLowerCase();
	         lastName = (fileScanner.nextLine()).toLowerCase();
	         address = (fileScanner.nextLine()).toLowerCase();
	         dateOfBirth = fileScanner.nextLine();
	         age = Integer.parseInt(fileScanner.nextLine());
	         postalCode = (fileScanner.nextLine()).toLowerCase();
	         language = (fileScanner.nextLine()).toLowerCase();
	         countryOfBirth = (fileScanner.nextLine()).toLowerCase();

	         //progress of student
	         programChosen = (fileScanner.nextLine()).toLowerCase();
	         progressOfStudent = new StudentProgress();
	         progressOfStudent.setProgramChosen(programChosen);

	         lastRecord = (fileScanner.nextLine());
	         progressOfStudent.setLastRecord(lastRecord);

	         
	         String tempDourDoneOrNot = fileScanner.nextLine();
	         String strDourDoneOrNot[] = tempDourDoneOrNot.split(",");
	         for (int i = 0; i < strDourDoneOrNot.length; i++) {
	           dourDoneOrNot [i] = Boolean.parseBoolean(strDourDoneOrNot[i]);
	         }
	    progressOfStudent.setOpenDourDoneOrNot(dourDoneOrNot);

	         String tempQuarterNumDoneMonth = fileScanner.nextLine();
	         String strQuarterNumDoneMonth[] = tempQuarterNumDoneMonth.split(",");
	         for (int i = 0; i < strQuarterNumDoneMonth.length; i++) {
	           quarterNumDoneMonth [i] = Integer.parseInt(strQuarterNumDoneMonth[i]);
	         }
	    progressOfStudent.setQuarterNumDoneMonth(quarterNumDoneMonth);

	         currentQuarter = Integer.parseInt(fileScanner.nextLine());     progressOfStudent.setOpenCurrentQuarter(currentQuarter);

	         String tempNumOfDourSaparasDoneMonth = fileScanner.nextLine();
	         String strNumOfDourSaparasDoneMonth[] = tempNumOfDourSaparasDoneMonth.split(",");
	         for (int i = 0; i < strNumOfDourSaparasDoneMonth.length; i++) {
	           numOfDourSaparasDoneMonth [i] = Boolean.parseBoolean(strNumOfDourSaparasDoneMonth[i]);
	         }
	    progressOfStudent.setNumOfDourSaparasDoneMonth(numOfDourSaparasDoneMonth);

	         dourCurrentSapara = Integer.parseInt(fileScanner.nextLine());  progressOfStudent.setOpenDourCurrentSapara(dourCurrentSapara);

	         dourNextFill = Integer.parseInt(fileScanner.nextLine());
	    progressOfStudent.setOpenDourNextFill(dourNextFill);
	         
	         DateTimeFormatter firstFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
	            LocalDateTime firstNow = LocalDateTime.now();  
	           String alreadyDone = firstFormatter.format(firstNow);
	         
	         if (!(alreadyDone.equals(lastRecord))) {
	           if (programChosen.equals("hafiz")) {
	             Boolean temporary = Boolean.parseBoolean(fileScanner.nextLine());
	             int holder = Integer.parseInt(fileScanner.nextLine());
	             temporary = Boolean.parseBoolean(fileScanner.nextLine());
	             holder = Integer.parseInt(fileScanner.nextLine());
	              temporary = Boolean.parseBoolean(fileScanner.nextLine()); 
	             holder = Integer.parseInt(fileScanner.nextLine());
	             holder = Integer.parseInt(fileScanner.nextLine());
	             temporary = Boolean.parseBoolean(fileScanner.nextLine());
	             holder = Integer.parseInt(fileScanner.nextLine());
	             
	             todayDourDoneOrNot = false;
	             todayDourSaparaDoneOrNot = false;
	             todayQuartersDone = 0;
	             todayDourSaparaDone = 0;
	             progressOfStudent.setOpenTodayDourDoneOrNot(todayDourDoneOrNot);
	    progressOfStudent.setOpenTodayQuartersDone(todayQuartersDone);
	    progressOfStudent.setOpenTodayDourSaparaDoneOrNot(todayDourSaparaDoneOrNot);
	    progressOfStudent.setOpenTodayDourSaparaDone(todayDourSaparaDone);
	           
	           } else {
	             Boolean temporary = Boolean.parseBoolean(fileScanner.nextLine());
	             int holder = Integer.parseInt(fileScanner.nextLine());
	             temporary = Boolean.parseBoolean(fileScanner.nextLine());
	             holder = Integer.parseInt(fileScanner.nextLine());
	              temporary = Boolean.parseBoolean(fileScanner.nextLine()); 
	             holder = Integer.parseInt(fileScanner.nextLine());
	             holder = Integer.parseInt(fileScanner.nextLine());
	             temporary = Boolean.parseBoolean(fileScanner.nextLine());
	             holder = Integer.parseInt(fileScanner.nextLine());
	             todayDourDoneOrNot = false;
	              todayQuartersDone = 0;
	              todayDourSaparaDoneOrNot = false;
	             todayDourSaparaDone = 0;
	              todaySabaqDoneOrNot = false;
	             todayLinesMemorized = 0;
	             todayMistakesMade = 0;
	             todaySaparaFinished = false;
	             todaySaparaDone = 0;
	             progressOfStudent.setOpenTodayDourDoneOrNot(todayDourDoneOrNot);
	    progressOfStudent.setOpenTodayQuartersDone(todayQuartersDone);
	    progressOfStudent.setOpenTodayDourSaparaDoneOrNot(todayDourSaparaDoneOrNot);
	    progressOfStudent.setOpenTodayDourSaparaDone(todayDourSaparaDone);
	    progressOfStudent.setOpenTodaySabaqDoneOrNot(todaySabaqDoneOrNot);
	    progressOfStudent.setOpenTodayLinesMemorized(todayLinesMemorized);
	    progressOfStudent.setOpenTodayMistakesMade(todayMistakesMade);
	    progressOfStudent.setOpenTodaySaparaFinished(todaySaparaFinished);
	    progressOfStudent.setOpenTodaySaparaDone(todaySaparaDone);
	         }

	           
	         } else {
	           todayDourDoneOrNot = Boolean.parseBoolean(fileScanner.nextLine());
	           progressOfStudent.setOpenTodayDourDoneOrNot(todayDourDoneOrNot);

	           todayQuartersDone = Integer.parseInt(fileScanner.nextLine());
	           progressOfStudent.setOpenTodayQuartersDone(todayQuartersDone);

	           todayDourSaparaDoneOrNot = Boolean.parseBoolean(fileScanner.nextLine());
	          progressOfStudent.setOpenTodayDourSaparaDoneOrNot(todayDourSaparaDoneOrNot);

	          todayDourSaparaDone = Integer.parseInt(fileScanner.nextLine());
	          progressOfStudent.setOpenTodayDourSaparaDone(todayDourSaparaDone);

	           if (!(programChosen.equals("hafiz"))) {
	             
	         todaySabaqDoneOrNot = Boolean.parseBoolean(fileScanner.nextLine());   progressOfStudent.setOpenTodaySabaqDoneOrNot(todaySabaqDoneOrNot);
	             
	             todayLinesMemorized = Integer.parseInt(fileScanner.nextLine());
	    progressOfStudent.setOpenTodayLinesMemorized(todayLinesMemorized);
	             
	             todayMistakesMade = Integer.parseInt(fileScanner.nextLine());
	    progressOfStudent.setOpenTodayMistakesMade(todayMistakesMade);
	             
	             todaySaparaFinished = Boolean.parseBoolean(fileScanner.nextLine());
	    progressOfStudent.setTodaySaparaFinished(todaySaparaFinished);
	             
	             todaySaparaDone = Integer.parseInt(fileScanner.nextLine());
	    progressOfStudent.setOpenTodaySaparaDone(todaySaparaDone);
	           } else {
	             Boolean temporary = Boolean.parseBoolean(fileScanner.nextLine()); 
	             int holder = Integer.parseInt(fileScanner.nextLine());
	             holder = Integer.parseInt(fileScanner.nextLine());
	             temporary = Boolean.parseBoolean(fileScanner.nextLine());
	             holder = Integer.parseInt(fileScanner.nextLine());
	           }
	         }

	         

	         if (!(programChosen.equals("hafiz"))) {
	           String tempSabaqDoneOrNot = fileScanner.nextLine();
	         String strSabaqDoneOrNot[] = tempSabaqDoneOrNot.split(",");
	         for (int i = 0; i < strSabaqDoneOrNot.length; i++) {
	           sabaqDoneOrNot [i] = Boolean.parseBoolean(strSabaqDoneOrNot[i]);
	         }
	    progressOfStudent.setOpenSabaqDoneOrNot(sabaqDoneOrNot);

	         String tempLinesMemorized = fileScanner.nextLine();
	         String strLinesMemorized[] = tempLinesMemorized.split(",");
	         for (int i = 0; i < strLinesMemorized.length; i++) {
	           linesMemorized [i] = Integer.parseInt(strLinesMemorized[i]);
	         }
	         progressOfStudent.setOpenLinesMemorized(linesMemorized);

	         String tempMistakesMade = fileScanner.nextLine();
	         String strMistakesMade[] = tempMistakesMade.split(",");
	         for (int i = 0; i < strMistakesMade.length; i++) {
	           mistakesMade [i] = Integer.parseInt(strMistakesMade[i]);
	         }
	         progressOfStudent.setOpenMistakesMade(mistakesMade);

	         String tempNumOfSaparasFinished = fileScanner.nextLine();
	         String strNumOfSaparasFinished [] = tempNumOfSaparasFinished.split(",");
	         for (int i = 0; i < strNumOfSaparasFinished.length; i++) {
	          numOfSaparasDoneMonth [i] = Boolean.parseBoolean(strNumOfSaparasFinished[i]);
	         }
	         progressOfStudent.setOpenNumOfSaparasDoneMonth(numOfSaparasDoneMonth);

	         String tempNameOfSaparasFinished = fileScanner.nextLine();
	         String strNameOfSaparasFinished [] = tempNameOfSaparasFinished.split(",");
	         for (int i = 0; i < strNameOfSaparasFinished.length; i++) {
	          nameOfSaparasDoneMonth [i] = Integer.parseInt(strNameOfSaparasFinished[i]);
	         }
	         progressOfStudent.setOpenNameOfSaparasDoneMonth(nameOfSaparasDoneMonth);

	         totalSaparasDone = Integer.parseInt(fileScanner.nextLine());
	         progressOfStudent.setOpenTotalSaparasDone(totalSaparasDone);

	         saparasDone = fileScanner.nextLine();
	         progressOfStudent.setOpenSaparasDone(saparasDone);

	         currentSaparaMemorizing = Integer.parseInt(fileScanner.nextLine());
	    progressOfStudent.setOpenCurrentSaparaMemorizing(currentSaparaMemorizing);

	         saparaNextFill = Integer.parseInt(fileScanner.nextLine());
	         progressOfStudent.setOpenSaparaNextFill(saparaNextFill);
	         } else {
	           String hold = fileScanner.nextLine();
	           hold = fileScanner.nextLine();
	           hold = fileScanner.nextLine();
	           hold = fileScanner.nextLine();
	           hold = fileScanner.nextLine();
	           hold = fileScanner.nextLine();
	           hold = fileScanner.nextLine();
	           hold = fileScanner.nextLine();
	           hold = fileScanner.nextLine();
	         }
	         
	     
	         //attendance
	         
	         tempAttendance = fileScanner.nextLine();
	         String attendance[] = tempAttendance.split(",");
	         attendanceOfStudent = new Attendance();
	         for (int i = 0; i < attendance.length; i++ ) {
	           attendanceOfStudent.addAttendance(Boolean.parseBoolean(attendance[i]));
	           }
	         tempReasonAttendance = fileScanner.nextLine();
	         String tempReason[] = tempReasonAttendance.split(",");
	         for (int i = 0; i < tempReason.length; i++ ) {
	           attendanceOfStudent.addReasonAbsent(tempReason[i]);   
	           }
	         tempCovid = fileScanner.nextLine();
	         String covid[] = tempCovid.split(",");
	         for (int i = 0; i < covid.length; i++ ) {
	           attendanceOfStudent.addCovidScreening(Boolean.parseBoolean(covid[i]));
	           }
	         tempReasonCovid = fileScanner.nextLine();
	         String reasonCov[] = tempReasonCovid.split(",");
	         for (int i = 0; i < reasonCov.length; i++ ) {
	           attendanceOfStudent.addReasonCovidScreening(reasonCov[i]);   
	           }
	     
	           dates = new ArrayList<String>();
	     
	           tempDate = fileScanner.nextLine();
	         String date[] = tempDate.split(",");
	         for (int i = 0; i < date.length; i++ ) {
	           dates.add(date[i]);
	           }
	     
	           guardianOneFirstName = (fileScanner.nextLine()).toLowerCase();
	           guardianOneLastName = (fileScanner.nextLine()).toLowerCase();
	           guardianOnePhoneNumber = fileScanner.nextLine();
	           guardianOneEmail = (fileScanner.nextLine()).toLowerCase();
	           guardianOneCallAtWork = Boolean.parseBoolean(fileScanner.nextLine());
	           guardianTwoFirstName = (fileScanner.nextLine()).toLowerCase();
	           guardianTwoLastName = (fileScanner.nextLine()).toLowerCase();
	           guardianTwoPhoneNumber = fileScanner.nextLine();
	           guardianTwoEmail = (fileScanner.nextLine()).toLowerCase();
	           guardianTwoCallAtWork = Boolean.parseBoolean(fileScanner.nextLine());
	          
	           emergencyContactOneFirstName = (fileScanner.nextLine()).toLowerCase();
	           emergencyContactOneLastName = (fileScanner.nextLine()).toLowerCase();
	           emergencyContactOneRelationship = (fileScanner.nextLine()).toLowerCase();
	           emergencyContactOneHomeNumber = (fileScanner.nextLine());
	           emergencyContactOneCellNumber = (fileScanner.nextLine());
	           emergencyContactTwoFirstName = (fileScanner.nextLine()).toLowerCase();
	           emergencyContactTwoLastName = (fileScanner.nextLine()).toLowerCase();
	           emergencyContactTwoRelationship = (fileScanner.nextLine()).toLowerCase();
	           emergencyContactTwoHomeNumber = (fileScanner.nextLine());
	           emergencyContactTwoCellNumber = (fileScanner.nextLine());
	     
	           healthFactorOne = (fileScanner.nextLine()).toLowerCase();
	           healthFactorOneLifeThreatening = Boolean.parseBoolean(fileScanner.nextLine());
	           healthFactorOnePlanOfCareRequired = Boolean.parseBoolean(fileScanner.nextLine());
	           healthFactorOneMedicationsRequired = Boolean.parseBoolean(fileScanner.nextLine());
	           healthFactorTwo = (fileScanner.nextLine()).toLowerCase();
	           healthFactorTwoLifeThreatening = Boolean.parseBoolean(fileScanner.nextLine());
	           healthFactorTwoPlanOfCareRequired = Boolean.parseBoolean(fileScanner.nextLine());
	           healthFactorTwoMedicationsRequired = Boolean.parseBoolean(fileScanner.nextLine());
	           healthFactorThree = (fileScanner.nextLine()).toLowerCase();
	           healthFactorThreeLifeThreatening = Boolean.parseBoolean(fileScanner.nextLine());
	           healthFactorThreePlanOfCareRequired = Boolean.parseBoolean(fileScanner.nextLine());
	           healthFactorThreeMedicationsRequired = Boolean.parseBoolean(fileScanner.nextLine());
	     
	         Student tempS = new Student (firstName, middleName, lastName, address, dateOfBirth, age, postalCode, language,countryOfBirth, attendanceOfStudent, progressOfStudent, dates, guardianOneFirstName, guardianOneLastName, guardianOnePhoneNumber,guardianOneEmail, guardianOneCallAtWork, guardianTwoFirstName, guardianTwoLastName, guardianTwoPhoneNumber, guardianTwoEmail, guardianTwoCallAtWork, emergencyContactOneFirstName, emergencyContactOneLastName, emergencyContactOneRelationship, emergencyContactOneHomeNumber, emergencyContactOneCellNumber,emergencyContactTwoFirstName, emergencyContactTwoLastName, emergencyContactTwoRelationship, emergencyContactTwoHomeNumber, emergencyContactTwoCellNumber, healthFactorOne, healthFactorOneLifeThreatening, healthFactorOnePlanOfCareRequired, healthFactorOneMedicationsRequired, healthFactorTwo, healthFactorTwoLifeThreatening, healthFactorTwoPlanOfCareRequired, healthFactorTwoMedicationsRequired, healthFactorThree, healthFactorThreeLifeThreatening, healthFactorThreePlanOfCareRequired,  healthFactorThreeMedicationsRequired);
	          listOfStudents.add(tempS);
	       }
	       fileScanner.close();
	     
	       return listOfStudents;
	      }
}
