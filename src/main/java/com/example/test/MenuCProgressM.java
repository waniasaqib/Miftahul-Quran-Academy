package com.example.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "menuCProgressM", layout = Welcome.class)
public class MenuCProgressM extends VerticalLayout {
	
	static Scanner fileScanner;
	static ArrayList <Student> listOfStudents = new ArrayList <Student>();
	static int index = -1;
	
	public MenuCProgressM () {
		
		//read from files
		listOfStudents.removeAll(listOfStudents);
		listOfStudents = fileOneOpen();
		index();
		
		//make the header
		 // Header
	    Header header = new Header();
	    header.getStyle()
	            .set("align-items", "center")
	            .set("border-bottom", "1px solid var(--lumo-contrast-20pct)")
	            .set("display", "flex")
	            .set("padding", "var(--lumo-space-m)");
		
		H2 intro = new H2 ("Monthly Progress for " + listOfStudents.get(index).getFullName());
		intro.getStyle().set("margin", "0");
		
		header.add(intro);
		add(header);
		
	      if ((listOfStudents.get(index).getSabaqDoneOrNot()[29] == null)|| ( listOfStudents.get(index).getDourDoneOrNot() [29] == null)||(listOfStudents.get(index).getLastRecord().equals("11/11/2011") || (listOfStudents.get(index).getDourNextFill() < 29))) {
	        Paragraph send = new Paragraph("Sorry, not enough information to display monthly progress. Check back after 30 days.");
	        send.setWidthFull();
	        Scroller scroller = new Scroller(new Div(send));
		    scroller.setScrollDirection(Scroller.ScrollDirection.VERTICAL);
		    scroller.getStyle()
		            .set("border-bottom", "1px solid var(--lumo-contrast-20pct)")
		            .set("padding", "var(--lumo-space-m)");
		    add(scroller);

			Button incomplete = new Button("Back", e -> {
		   	  UI.getCurrent().navigate("menu");
		     });
		     
		   	incomplete.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		   	incomplete.setMinWidth("250px");
		       incomplete.addClickShortcut(Key.ENTER);
		       
		       setSizeFull();
		       setJustifyContentMode(JustifyContentMode.CENTER);
		       setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		       getStyle().set("text-align", "center");

		   	add(intro, scroller, incomplete);
	      } else {
	    	  
	    	  H3 sabaqTitle = new H3("Sabaq Progress");
	  	    Section sabaq = new Section(sabaqTitle);
	  	    
	  	    H3 dourTitle = new H3("Dour Progress");
	  	    Section dour = new Section(dourTitle);
	  	    
	        int numTimesSaparaNotDone;
	        int averageLineMemorized;
	        int averageMistakesMade;
	        int numSaparasDone;
	        String nameSaparasDone;
	        int numTimesDourNotDone;
	        int averageNumQuartersDone;
	        int numDourSaparasDone;
	        
	        //use methods to calculate the monthly progress of student
	        numTimesSaparaNotDone = timesNotDone(listOfStudents.get(index).getSabaqDoneOrNot());
	        numTimesDourNotDone = timesNotDone(listOfStudents.get(index).getDourDoneOrNot());
	        averageLineMemorized = findAverage(listOfStudents.get(index).getLinesMemorized());
	        averageMistakesMade = findAverage(listOfStudents.get(index).getMistakesMade());
	        averageNumQuartersDone = findAverage(listOfStudents.get(index).getQuarterNumDoneMonth());
	        numSaparasDone = timesDone(listOfStudents.get(index).getNumOfSaparasDoneMonth());
	        numDourSaparasDone = timesDone(listOfStudents.get(index).getNumOfDourSaparasDoneMonth());
	        nameSaparasDone = findName(listOfStudents.get(index).getNameOfSaparasDoneMonth());
	        
	        //display the calculated progress in paragraphs
	        if (!(listOfStudents.get(index).getProgramChosen().equals("hafiz"))) {
	          Paragraph one = new Paragraph ("Total Number Of Times Sapara Not Done: " + numTimesSaparaNotDone);
	          one.setWidthFull();
	          Paragraph two = new Paragraph("Average Number Of Lines Memorized Per Day: " + averageLineMemorized);
	          two.setWidthFull();
	          Paragraph three = new Paragraph ("Average Mistakes Made Per Day: " + averageMistakesMade);
	          three.setWidthFull();
	          Paragraph four = new Paragraph ("Total Number Of Saparas Done: " + numSaparasDone);
	          four.setWidthFull();
	          
	          //SEQUENTIAL SORT 
	          //turn string that is to be sorted into an integer array called temp
	          String temp2 = nameSaparasDone;
	          temp2 = temp2.replaceAll(" ", "");
	          String strTemp[] = temp2.split(",");
	          int temp[] = new int [strTemp.length];
	          for (int i = 0; i < strTemp.length; i++) {
	      		         temp [i] = Integer.parseInt(strTemp[i]);
	      		       }
	          //traverse through the temp array until it is sorted
	          for (int index = 0; index < temp.length-1; index++) {
	        	//pick the current index.
	            int minIndex = index;
	          //find minimum in the rest of the array
	            for (int i = index; i < temp.length; i++) {
	              if (temp [i] < temp[minIndex]) {
	                minIndex = i;
	              }
	            }
	          //swap to put the minimum in current position.
	            int tempValue = temp [index];
	            temp [index] = temp [minIndex];
	            temp [minIndex] = tempValue;
	          //value at current index is sorted
	           //repeated for the rest of the array
	          }
	          //make sorted array into a string and print
	      String print = "";
	           for (int k = 0; k < temp.length; k++) {
	                 if (k == 0) {
	      print = print + temp [k];
	                } else {
	                print = print + ", " + temp [k];
	                }
	             }
	          nameSaparasDone = print;
	          Paragraph five = new Paragraph ("Saparas That Were Done: " + nameSaparasDone);
	          five.setWidthFull();
	          sabaq.add(one, two, three, four, five);
	        } else {
	          Paragraph one = new Paragraph("Sabaq not applicable to this student.");
	          one.setWidthFull();
	          sabaq.add(one);
	        }

	        Paragraph onee = new Paragraph("Total Number Of Times Dour Not Done: " + numTimesDourNotDone);
	        onee.setWidthFull();
	        Paragraph twoo = new Paragraph("Average Number of Dour Quarters Done Per Day: " + averageNumQuartersDone);
	        twoo.setWidthFull();
	        Paragraph three = new Paragraph("Number Of Saparas Done In Dour: " + numDourSaparasDone);
	        three.setWidthFull();
	        dour.add(onee,twoo,three);
	        
	        Scroller scroller = new Scroller(new Div(sabaq, dour));
		    scroller.setScrollDirection(Scroller.ScrollDirection.VERTICAL);
		    scroller.getStyle()
		            .set("border-bottom", "1px solid var(--lumo-contrast-20pct)")
		            .set("padding", "var(--lumo-space-m)");

			Button incomplete = new Button("Back", e -> {
		   	  UI.getCurrent().navigate("menu");
		     });
		     
		   	incomplete.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		   	incomplete.setMinWidth("250px");
		       incomplete.addClickShortcut(Key.ENTER);
		       
		       setSizeFull();
		       setJustifyContentMode(JustifyContentMode.CENTER);
		       setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		       getStyle().set("text-align", "center");

		   	add(intro, scroller, incomplete);
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
	  
	//access stored index of student in temp file
			public static void index() {
				index = -1;
				 try {
				     fileScanner = new Scanner(new File("temp.txt"));
				     index = Integer.parseInt(fileScanner.nextLine());
				     
					 fileScanner.close();
				   } catch (FileNotFoundException e) {
				     System.err.println("File not found! Choosing to quit now...");
				 
				     System.exit(0);
				   }
			}
			
			 //METHODS
			
			//find the number of times sabaq/dour was not done
		    public static int timesNotDone(Boolean[] array) {
		     
		    	//counter
		    	int times = 0;
		      for (int i = 0; i < array.length; i++) {
		    	  
		    	  //if boolean at index i of array is false, this means it was incomplete
		        if (array [i] == false) {
		        times++;
		        }
		      }
		      return times;
		    }
		    
		    //find the number of times sabaq/dour was done
		    public static int timesDone(Boolean[] array) {
		    	
		    	//counter
		      int times = 0;
		      for (int i = 0; i < array.length; i++) {
		    	  
		    	//if boolean at index i of array is true, this means it was complete
		        if (array [i] == true) {
		        times++;
		        }
		      }
		      return times;
		    }
		    
		    //find average method
		    public static int findAverage(int [] array) {
		      int average = 0;
		      int total = 0;
		      int counter = 0;
		      //calculate total
		      for (int i = 0; i < array.length; i++) {
		        total = total + array [i];
		        counter ++;
		      }
		      //divide total by counter to find average
		      average = total/counter;

		      return average;
		    } 
		    
		    

		    //find total method of integers in an array
		    public static int findTotal(int [] array) {
		      int total = 0;
		      for (int i = 0; i < array.length; i++) {
		        total = total + array [i];
		      }
		      return total;
		    }
		    
		    
		    
		    
		    public static String findName(int [] array) {
		      String name = "";
		      int count = 0;
		      for (int i = 0; i < array.length; i++) {
		        if ((array [i] != 0) && (count == 0)) {
		          name = "" + array [i];
		          count++;
		        } else if ((array [i] != 0)) {
		        	name = name + ", " + array [i];
		        }
		      }
		      return name;

		    }

}
