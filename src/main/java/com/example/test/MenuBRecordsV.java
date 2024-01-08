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
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "menuBRecordsV", layout = Welcome.class)
public class MenuBRecordsV extends VerticalLayout{
	
	public static ArrayList <Student> listOfStudents = new ArrayList <Student>();
	public static Scanner fileScanner;
	
	public static final String PERSONAL_TITLE_ID = "personal-title";
	public static final String EMPLOYMENT_TITLE_ID = "employment-title";
	
	public MenuBRecordsV() {
		listOfStudents.removeAll(listOfStudents);
		listOfStudents = fileOneOpen();
		int index = index();
		
		// Header
	    Header header = new Header();
	    header.getStyle()
	            .set("align-items", "center")
	            .set("border-bottom", "1px solid var(--lumo-contrast-20pct)")
	            .set("display", "flex")
	            .set("padding", "var(--lumo-space-m)");
	    
	    //capitalize first letter of student's name and store
    	String studentName =  listOfStudents.get(index).getFullName();

	    H2 editEmployee = new H2(studentName + "'s Information");
	    editEmployee.getStyle().set("margin", "0");

	    header.add(editEmployee);
	    add(header);
	    
	    //Student Information
	    H3 studentTitle = new H3("Student Information");
	    Section studentInformation = new Section(studentTitle);
	    
	    Paragraph firstName = new Paragraph("First Name: " + listOfStudents.get(index).getFirstName());
	    firstName.setWidthFull();
		studentInformation.add(firstName);
		Paragraph middleName = new Paragraph("Middle Name: " + listOfStudents.get(index).getMiddleName());
        middleName.setWidthFull();
        studentInformation.add(middleName);
        Paragraph lastName = new Paragraph("Last Name: " + listOfStudents.get(index).getLastName());
        lastName.setWidthFull();
        studentInformation.add(lastName);
        Paragraph address = new Paragraph("Address: " + listOfStudents.get(index).getAddress());
        address.setWidthFull();
        studentInformation.add(address);
        Paragraph dateOfBirth = new Paragraph ("Date Of Birth: " + listOfStudents.get(index).getDateOfBirth());
        dateOfBirth.setWidthFull();
        studentInformation.add(dateOfBirth);
        Paragraph age = new Paragraph ("Age: " + listOfStudents.get(index).getAge());
        age.setWidthFull();
        studentInformation.add(age);
        Paragraph pCode = new Paragraph ("Postal Code: " + listOfStudents.get(index).getPostalCode());
        pCode.setWidthFull();
        studentInformation.add(pCode);
        Paragraph language = new Paragraph ("Language: " + listOfStudents.get(index).getLanguage());
        language.setWidthFull();
        studentInformation.add(language);
        Paragraph country = new Paragraph ("Country Of Birth: " + listOfStudents.get(index).getCountryOfBirth());
        country.setWidthFull();
        studentInformation.add(country);

	    // Personal information
	    H3 personalTitle = new H3("Guardian Information");
	    Section personalInformation = new Section(personalTitle);
	    
	    Paragraph guardianOneFirstName = new Paragraph ("Guardian One First Name: " + listOfStudents.get(index).getGuardianOneFirstName());
        guardianOneFirstName.setWidthFull();
        personalInformation.add(guardianOneFirstName);
	    Paragraph guardianOneLastName = new Paragraph ("Guardian One Last Name: " + listOfStudents.get(index).getGuardianOneLastName());
	    guardianOneLastName.setWidthFull();
	    personalInformation.add(guardianOneLastName);
	    Paragraph guardianOnePhoneNum = new Paragraph ("Guardian One Phone Number: " + listOfStudents.get(index).getGuardianOnePhoneNumber());
        guardianOnePhoneNum.setWidthFull();
        personalInformation.add(guardianOnePhoneNum);
	    Paragraph guardianOneEmail = new Paragraph ("Guardian One Email: " + listOfStudents.get(index).getGuardianOneEmail());
        guardianOneEmail.setWidthFull();
        personalInformation.add(guardianOneEmail);
        if (listOfStudents.get(index).isGuardianOneCallAtWork() == false) {
          Paragraph guardianOneCall = new Paragraph ("Call This Guardian At Work: No");
          guardianOneCall.setWidthFull();
          personalInformation.add(guardianOneCall);
        } else {
          Paragraph guardianOneCall = new Paragraph ("Call This Guardian At Work: Yes");
          guardianOneCall.setWidthFull();
          personalInformation.add(guardianOneCall);
        }
        if (!(listOfStudents.get(index).getGuardianTwoFirstName().equals("n/a"))) {
          Paragraph guardianTwoFirstName = new Paragraph ("Guardian Two First Name: " + listOfStudents.get(index).getGuardianTwoFirstName());
          guardianTwoFirstName.setWidthFull();
          personalInformation.add(guardianTwoFirstName);
          Paragraph guardianTwoLastName = new Paragraph ("Guardian Two Last Name: " + listOfStudents.get(index).getGuardianTwoLastName());
          guardianTwoLastName.setWidthFull();
          personalInformation.add(guardianTwoLastName);
          Paragraph guardianTwoPhoneNum = new Paragraph ("Guardian Two Phone Number: " + listOfStudents.get(index).getGuardianTwoPhoneNumber());
          guardianTwoPhoneNum.setWidthFull();
          personalInformation.add(guardianTwoPhoneNum);
          Paragraph guardianTwoEmail = new Paragraph ("Guardian Two Email: " + listOfStudents.get(index).getGuardianTwoEmail());
          guardianTwoEmail.setWidthFull();
          personalInformation.add(guardianTwoEmail);
        if (listOfStudents.get(index).isGuardianOneCallAtWork() == false) {
          Paragraph guardianTwoCall = new Paragraph ("Call This Guardian At Work: No");
          guardianTwoCall.setWidthFull();
          personalInformation.add(guardianTwoCall);
        } else {
          Paragraph guardianTwoCall = new Paragraph ("Call This Guardian At Work: Yes");
          guardianTwoCall.setWidthFull();
          personalInformation.add(guardianTwoCall);
        }
        } else {
        Paragraph guardianTwoFirstName = new Paragraph ("Guardian Two First Name: " + listOfStudents.get(index).getGuardianTwoFirstName());
        guardianTwoFirstName.setWidthFull();
        personalInformation.add(guardianTwoFirstName);
        Paragraph guardianTwoLastName = new Paragraph ("Guardian Two Last Name: " + listOfStudents.get(index).getGuardianTwoLastName());
        guardianTwoLastName.setWidthFull();
        personalInformation.add(guardianTwoLastName);
        Paragraph guardianTwoPhoneNum = new Paragraph ("Guardian Two Phone Number: " + listOfStudents.get(index).getGuardianTwoPhoneNumber());
        guardianTwoPhoneNum.setWidthFull();
        personalInformation.add(guardianTwoPhoneNum);
        Paragraph guardianTwoEmail = new Paragraph ("Guardian Two Email: " + listOfStudents.get(index).getGuardianTwoEmail());
        guardianTwoEmail.setWidthFull();
        personalInformation.add(guardianTwoEmail);
        Paragraph guardianTwoCall = new Paragraph ("Call This Guardian At Work: n/a");
        guardianTwoCall.setWidthFull();
        personalInformation.add(guardianTwoCall);
        }

	    // Emergency Contact Information
	    H3 emergencyContactTitle = new H3("Emergency Contact Information");

	    Paragraph contactOneFirstName = new Paragraph("Contact One First Name: " + listOfStudents.get(index).getEmergencyContactOneFirstName());
	    contactOneFirstName.setWidthFull();
	    Paragraph contactOneLastName = new Paragraph ("Contact One Last Name: " + listOfStudents.get(index).getEmergencyContactOneLastName());
	    contactOneLastName.setWidthFull();
	    Paragraph relationshipOne = new Paragraph("Relationship: " + listOfStudents.get(index).getEmergencyContactOneRelationship());
	    relationshipOne.setWidthFull();
	    Paragraph homeOne = new Paragraph("Home Number: " + listOfStudents.get(index).getEmergencyContactOneHomeNumber());
	    homeOne.setWidthFull();
	    Paragraph cellOne = new Paragraph("Cell Number: " + listOfStudents.get(index).getEmergencyContactOneCellNumber());
	    cellOne.setWidthFull();
	    
	    Paragraph filler = new Paragraph ("");
	    filler.setWidthFull();
	    Paragraph contactTwoFirstName = new Paragraph("Contact Two First Name: " + listOfStudents.get(index).getEmergencyContactTwoFirstName());
	    contactTwoFirstName.setWidthFull();
	    Paragraph contactTwoLastName = new Paragraph ("Contact Two Last Name: " + listOfStudents.get(index).getEmergencyContactTwoLastName());
	    contactTwoLastName.setWidthFull();
	    Paragraph relationshipTwo = new Paragraph("Relationship: " + listOfStudents.get(index).getEmergencyContactTwoRelationship());
	    relationshipTwo.setWidthFull();
	    Paragraph homeTwo = new Paragraph("Home Number: " + listOfStudents.get(index).getEmergencyContactTwoHomeNumber());
	    homeTwo.setWidthFull();
	    Paragraph cellTwo = new Paragraph("Cell Number: " + listOfStudents.get(index).getEmergencyContactTwoCellNumber());
	    cellTwo.setWidthFull();
	    Section emergencyContactInformation = new Section(emergencyContactTitle, contactOneFirstName, contactOneLastName, relationshipOne, homeOne, cellOne, filler, contactTwoFirstName, contactTwoLastName, relationshipTwo, homeTwo, cellTwo);
	    
	    //Health Information
	    H3 healthInformationTitle = new H3("Health Information");
	    Section healthInformation = new Section(healthInformationTitle);
	    if (listOfStudents.get(index).getHealthFactorOne().equals("n/a")) {
	    	Paragraph none = new Paragraph("No health factors were provided.");
	    	none.setWidthFull();
	    	healthInformation.add(none);
	    }
	    if(!(listOfStudents.get(index).getHealthFactorOne().equals("n/a"))) {
	        Paragraph healthOne = new Paragraph("Health Factor 1: " + listOfStudents.get(index).getHealthFactorOne());
	        healthOne.setWidthFull();
	        healthInformation.add(healthOne);
	        if ((listOfStudents.get(index).isHealthFactorOneLifeThreatening()) == true) {
	          Paragraph threateningOne = new Paragraph("Life Threatening: yes");
	          threateningOne.setWidthFull();
	          healthInformation.add(threateningOne);
	        } else {
	        	Paragraph threateningOne = new Paragraph("Life Threatening: no");
		          threateningOne.setWidthFull();
		          healthInformation.add(threateningOne);
	        }
	        if ((listOfStudents.get(index).isHealthFactorOnePlanOfCareRequired()) == true) {
	          Paragraph careOne = new Paragraph ("Plan Of Care Required: yes");
	          careOne.setWidthFull();
	          healthInformation.add(careOne);
	        } else {
	        	Paragraph careOne = new Paragraph ("Plan Of Care Required: no");
		          careOne.setWidthFull();
		          healthInformation.add(careOne);
	        }
	        if ((listOfStudents.get(index).isHealthFactorOneMedicationsRequired()) == true) {
	          Paragraph medicationsOne = new Paragraph("Medications Required: yes");
	          medicationsOne.setWidthFull();
	          healthInformation.add(medicationsOne);
	        } else {
	        	Paragraph medicationsOne = new Paragraph("Medications Required: no");
		          medicationsOne.setWidthFull();
		          healthInformation.add(medicationsOne);
	        }
	        
	      } else {
	    	  Paragraph healthFactor1 = new Paragraph ("Health Factor 1: n/a");
	    	  healthFactor1.setWidthFull();
	    	  healthInformation.add(healthFactor1);
	    	  Paragraph lifeThreatening1 = new Paragraph ("Life Threatening: n/a");
	    	  lifeThreatening1.setWidthFull();
	    	  healthInformation.add(lifeThreatening1);
	    	  Paragraph care1 = new Paragraph ("Plan Of Care: n/a");
	    	  care1.setWidthFull();
	    	  healthInformation.add(care1);
	    	  Paragraph medications1 = new Paragraph ("Medications Required: n/a");
	    	  medications1.setWidthFull();
	    	  healthInformation.add(medications1);
	      }
	      if(!(listOfStudents.get(index).getHealthFactorTwo().equals("n/a"))) {
	    	  Paragraph healthTwo = new Paragraph("Health Factor 2: " + listOfStudents.get(index).getHealthFactorTwo());
		        healthTwo.setWidthFull();
		        healthInformation.add(healthTwo);
	        if ((listOfStudents.get(index).isHealthFactorTwoLifeThreatening()) == true) {
	        	Paragraph threateningTwo = new Paragraph("Life Threatening: yes");
		          threateningTwo.setWidthFull();
		          healthInformation.add(threateningTwo);
	        } else {
	        	Paragraph threateningTwo = new Paragraph("Life Threatening: no");
		          threateningTwo.setWidthFull();
		          healthInformation.add(threateningTwo);
	        }
	        if ((listOfStudents.get(index).isHealthFactorTwoPlanOfCareRequired()) == true) {
	        	Paragraph careTwo = new Paragraph ("Plan Of Care Required: yes");
		          careTwo.setWidthFull();
		          healthInformation.add(careTwo);
	        } else {
	        	Paragraph careTwo = new Paragraph ("Plan Of Care Required: no");
		          careTwo.setWidthFull();
		          healthInformation.add(careTwo);
	        }
	        if ((listOfStudents.get(index).isHealthFactorTwoMedicationsRequired()) == true) {
	        	Paragraph medicationsTwo = new Paragraph("Medications Required: yes");
		        medicationsTwo.setWidthFull();
		        healthInformation.add(medicationsTwo);
	        } else {
	        	Paragraph medicationsTwo = new Paragraph("Medications Required: no");
		        medicationsTwo.setWidthFull();
		        healthInformation.add(medicationsTwo);
	        }
	      } else {
	    	  Paragraph healthFactor2 = new Paragraph ("Health Factor 2: n/a");
	    	  healthFactor2.setWidthFull();
	    	  healthInformation.add(healthFactor2);
	    	  Paragraph lifeThreatening3 = new Paragraph ("Life Threatening: n/a");
	    	  lifeThreatening3.setWidthFull();
	    	  healthInformation.add(lifeThreatening3);
	    	  Paragraph care3 = new Paragraph ("Plan Of Care: n/a");
	    	  care3.setWidthFull();
	    	  healthInformation.add(care3);
	    	  Paragraph medications3 = new Paragraph ("Medications Required: n/a");
	    	  medications3.setWidthFull();
	    	  healthInformation.add(medications3);
	      }
	      if(!(listOfStudents.get(index).getHealthFactorThree().equals("n/a"))) {
	    	  Paragraph healthThree = new Paragraph("Health Factor 3: " + listOfStudents.get(index).getHealthFactorThree());
		        healthThree.setWidthFull();
		        healthInformation.add(healthThree);
	        if ((listOfStudents.get(index).isHealthFactorThreeLifeThreatening()) == true) {
	        	Paragraph threateningThree = new Paragraph("Life Threatening: yes");
		        threateningThree.setWidthFull();
		        healthInformation.add(threateningThree);
	        } else {
	        	Paragraph threateningThree = new Paragraph("Life Threatening: no");
		        threateningThree.setWidthFull();
		        healthInformation.add(threateningThree);
	        }
	        if ((listOfStudents.get(index).isHealthFactorThreePlanOfCareRequired()) == true) {
	        	Paragraph careThree = new Paragraph ("Plan Of Care Required: yes");
		        careThree.setWidthFull();
		        healthInformation.add(careThree);
	        } else {
	        	Paragraph careThree = new Paragraph ("Plan Of Care Required: no");
		        careThree.setWidthFull();
		        healthInformation.add(careThree);
	        }
	        if ((listOfStudents.get(index).isHealthFactorThreeMedicationsRequired()) == true) {
	        	Paragraph medicationsThree = new Paragraph("Medications Required: Yes");
		        medicationsThree.setWidthFull();
		        healthInformation.add(medicationsThree);
	        } else {
	        	Paragraph medicationsThree = new Paragraph("Medications Required: No");
		        medicationsThree.setWidthFull();
		        healthInformation.add(medicationsThree);
	        }
	      } else {
	    	  Paragraph healthFactor3 = new Paragraph ("Health Factor 3: n/a");
	    	  healthFactor3.setWidthFull();
	    	  healthInformation.add(healthFactor3);
	    	  Paragraph lifeThreateningThree = new Paragraph ("Life Threatening: n/a");
	    	  lifeThreateningThree.setWidthFull();
	    	  healthInformation.add(lifeThreateningThree);
	    	  Paragraph careThree = new Paragraph ("Plan Of Care: n/a");
	    	  careThree.setWidthFull();
	    	  healthInformation.add(careThree);
	    	  Paragraph medicationsThree = new Paragraph ("Medications Required: n/a");
	    	  medicationsThree.setWidthFull();
	    	  healthInformation.add(medicationsThree);
	      }

	   
	    
	    // NOTE
	    // We are using inline styles here to keep the example simple.
	    // We recommend placing CSS in a separate style sheet and to
	    // encapsulating the styling in a new component.
	    Scroller scroller = new Scroller(new Div(studentInformation, personalInformation, emergencyContactInformation, healthInformation));
	    scroller.setScrollDirection(Scroller.ScrollDirection.VERTICAL);
	    scroller.getStyle()
	            .set("border-bottom", "1px solid var(--lumo-contrast-20pct)")
	            .set("padding", "var(--lumo-space-m)");
	    add(scroller);

	    // Footer
	    Button done = new Button("Done", e -> {
	    	UI.getCurrent().navigate("menu");
	    });
	    done.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	    done.getStyle().set("margin-right", "var(--lumo-space-s)");

	    Button anotherStudent = new Button("Another Student", l ->{
	    	Dialog dialog = new Dialog();
    		dialog.getElement().setAttribute("aria-label", "Enter Student Information");

    		VerticalLayout dialogLayout = createDialogLayout(dialog);
    		dialog.add(dialogLayout);
    		dialog.open();
    		add(dialog);
	    });
	    anotherStudent.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

	    Footer footer = new Footer(done, anotherStudent);
	    footer.getStyle().set("padding", "var(--lumo-space-wide-m)");
	    add(footer);
	    
	    setAlignItems(Alignment.STRETCH);
	    //setHeight("400px");
	    //setMaxWidth("100%");
	    setPadding(false);
	    setSpacing(false);
	    //setWidth("360px");
	    getStyle().set("border", "1px solid var(--lumo-contrast-20pct)");
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
			public static int index () {
				int index = -1;
				 try {
				     fileScanner = new Scanner(new File("temp.txt"));
				     index = Integer.parseInt(fileScanner.nextLine());
				     
					 fileScanner.close();
				   } catch (FileNotFoundException e) {
				     System.err.println("File not found! Choosing to quit now...");
				 
				     System.exit(0);
				   }
				 return index;
			}
			
			private static VerticalLayout createDialogLayout(Dialog dialog) {
		        H2 headline = new H2("Enter Student Information");
		        headline.getStyle().set("margin", "var(--lumo-space-m) 0 0 0")
		                .set("font-size", "1.5em").set("font-weight", "bold");
		        
		        //take in student's first and last name
		        TextField firstNameField = new TextField("First Name");
		        TextField lastNameField = new TextField("Last Name");
		        //styling of fields
		        VerticalLayout fieldLayout = new VerticalLayout(firstNameField,
		                lastNameField);
		        fieldLayout.setSpacing(false);
		        fieldLayout.setPadding(false);
		        fieldLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
		        //cancel button tp leave menu
		        Button cancelButton = new Button("Cancel", e -> dialog.close());
		        //done button to start search
		        Button saveButton = new Button("Done", e -> {
		        	int index = -2;
		            boolean found = false;
		            //search through listOfStudents ArrayList for a match with the entered first and last names 
		        	for (int i = 0; i < listOfStudents.size(); i++) {
		        		//if match is found
		                if (firstNameField.getValue().equals(listOfStudents.get(i).getFirstName()) && lastNameField.getValue().equals(listOfStudents.get(i).getLastName())) {
		                  index = i;
		                  found = true;
		                  //store index into temp.txt file and close dialog
		                  store(index);
				        	dialog.close();
				          //reload page and navigate to desired page
			              UI.getCurrent().getPage().reload();
		                  UI.getCurrent().navigate("menuBRecordsV");
		                  //break for loop
		                  break;
		                } 
		              }
		        	//if match was not found, display a warning message
		              if (found == false) {
		           	   Notification.show("Invalid name entered.",
		                          3000, Notification.Position.MIDDLE);
		              }
		        	
		        	
		        });
		        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton,
		                saveButton);
		        buttonLayout
		                .setJustifyContentMode(FlexComponent.JustifyContentMode.END);

		        VerticalLayout dialogLayout = new VerticalLayout(headline, fieldLayout,
		                buttonLayout);
		        dialogLayout.setPadding(false);
		        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
		        dialogLayout.getStyle().set("width", "300px").set("max-width", "100%");

		        return dialogLayout;
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
 
}
