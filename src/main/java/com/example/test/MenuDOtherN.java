package com.example.test;

import com.vaadin.flow.router.Route;

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
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

@Route(value = "menuDOtherN", layout = Welcome.class)
public class MenuDOtherN extends VerticalLayout {
	
	static Scanner fileScanner;
	static ArrayList <Student> listOfStudents = new ArrayList <Student>();
	
	public MenuDOtherN () {
		listOfStudents.removeAll(listOfStudents);
		listOfStudents = fileOneOpen();
		//introduce
		VerticalLayout tempp = new VerticalLayout();
		H2 intro = new H2 ("Set Up A New Student");
		intro.setMinWidth("700px");
	    intro.setSizeFull();
	    intro.getStyle().set("text-align", "center");
	    
	    Paragraph intro2 = new Paragraph ("Add 'n/a' where field is not applicable");
		intro2.setMinWidth("700px");
	    intro2.setSizeFull();
	    intro2.getStyle().set("text-align", "center");
	    
	    tempp.add(intro, intro2);
	    
	    Binder<Student> personBinder = new Binder<>(Student.class);
	    Student temp = new Student();
	    personBinder.setBean(temp);
	    FormLayout formLayout = createFormLayout();
	    
	    TextField fName = new TextField("First Name");
	    personBinder.forField(fName).bind(
                Student::getFirstName,
                Student::setFirstName);
	    fName.setRequired(true);
	    fName.setRequiredIndicatorVisible(true);
	    fName.setErrorMessage("This field is required");
	    
	    TextField middleName = new TextField("Middle Name");
	    personBinder.forField(middleName).bind(
	    		Student::getMiddleName,
	    		Student::setMiddleName);
	    middleName.setRequired(true);
	    middleName.setRequiredIndicatorVisible(true);
	    middleName.setErrorMessage("This field is required");
	    
	    TextField lastName = new TextField("Last Name");
	    personBinder.forField(lastName).bind(
                Student::getLastName,
                Student::setLastName
	    		);
	    lastName.setRequired(true);
	    lastName.setRequiredIndicatorVisible(true);
	    lastName.setErrorMessage("This field is required");
	    
	    TextField address = new TextField("Address");
	    personBinder.forField(address).bind(
	    		Student::getAddress,
	    		Student::setAddress);
	    address.setRequired(true);
	    address.setRequiredIndicatorVisible(true);
	    address.setErrorMessage("This field is required");
	    
	    TextField postalCode = new TextField("Postal Code");
	    personBinder.forField(postalCode).bind(
	    		Student::getPostalCode,
	    		Student::setPostalCode);
	    postalCode.setRequired(true);
	    postalCode.setRequiredIndicatorVisible(true);
	    postalCode.setErrorMessage("This field is required");
	    
	    DatePicker datePicker = new DatePicker("Date Of Birth");
	    personBinder.forField(datePicker).bind(
	    		Student::getDateOfBirthLocalDate,
	    		Student::setDateOfBirthLocalDate
	    		);
	    address.setRequired(true);
	    address.setRequiredIndicatorVisible(true);
	    address.setErrorMessage("This field is required");
	    
	    IntegerField age = new IntegerField("Age");
	    personBinder.forField(age).bind(
	    		Student::getAge,
	    		Student::setAge
	    		);
	    age.setRequiredIndicatorVisible(true);
	    age.setErrorMessage("This field is required");
	    
	    TextField language = new TextField("Language");
	    personBinder.forField(language).bind(
	    		Student::getLanguage,
	    		Student::setLanguage);
	    language.setRequired(true);
	    language.setRequiredIndicatorVisible(true);
	    language.setErrorMessage("This field is required");
	    
	    TextField country = new TextField("Country of Birth");
	    personBinder.forField(country).bind(
	    		Student::getCountryOfBirth,
	    		Student::setCountryOfBirth);
	    country.setRequired(true);
	    country.setRequiredIndicatorVisible(true);
	    country.setErrorMessage("This field is required");
	    
	    formLayout.add(fName, middleName, lastName);
	    formLayout.add(address, postalCode);
	    formLayout.add(datePicker, age, language, country);
	    
	    TextField gFirstName = new TextField("Guardian One First Name");
	    personBinder.forField(gFirstName).bind(
                Student::getGuardianOneFirstName,
                Student::setGuardianOneFirstName);
	    gFirstName.setRequired(true);
	    gFirstName.setRequiredIndicatorVisible(true);
	    gFirstName.setErrorMessage("This field is required");
	    
	    TextField gLastName = new TextField("Guardian One Last Name");
	    personBinder.forField(gLastName).bind(
                Student::getGuardianOneLastName,
                Student::setGuardianOneLastName);
	    gLastName.setRequired(true);
	    gLastName.setRequiredIndicatorVisible(true);
	    gLastName.setErrorMessage("This field is required");
	    
	    TextField gPhoneNum = new TextField("Guardian One Phone Number");
	    personBinder.forField(gPhoneNum).bind(
                Student::getGuardianOnePhoneNumber,
                Student::setGuardianOnePhoneNumber);
	    gPhoneNum.setRequired(true);
	    gPhoneNum.setRequiredIndicatorVisible(true);
	    gPhoneNum.setErrorMessage("This field is required");
	    
	    TextField gEmail = new TextField("Guardian One Email");
	    personBinder.forField(gEmail).bind(
                Student::getGuardianOneEmail,
                Student::setGuardianOneEmail);
	    gEmail.setRequired(true);
	    gEmail.setRequiredIndicatorVisible(true);
	    gEmail.setErrorMessage("This field is required");
	    
        Checkbox callAtWork1 = new Checkbox();
        callAtWork1.setLabel("Call Guardian One at Work");
        personBinder.forField(callAtWork1).bind(
                Student::isGuardianOneCallAtWork,
                Student::setGuardianOneCallAtWork);
        
        TextField gFirstName2 = new TextField("Guardian Two First Name");
	    personBinder.forField(gFirstName2).bind(
                Student::getGuardianTwoFirstName,
                Student::setGuardianTwoFirstName);
	    
	    TextField gLastName2 = new TextField("Guardian Two Last Name");
	    personBinder.forField(gLastName2).bind(
                Student::getGuardianTwoLastName,
                Student::setGuardianTwoLastName);
	    
	    TextField gPhoneNum2 = new TextField("Guardian Two Phone Number");
	    personBinder.forField(gPhoneNum2).bind(
                Student::getGuardianTwoPhoneNumber,
                Student::setGuardianTwoPhoneNumber);
	    
	    TextField gEmail2 = new TextField("Guardian Two Email");
	    personBinder.forField(gEmail2).bind(
                Student::getGuardianTwoEmail,
                Student::setGuardianTwoEmail);
        
        Checkbox callAtWork2 = new Checkbox();
        callAtWork2.setLabel("Call Guardian Two at Work");
        personBinder.forField(callAtWork2).bind(
                Student::isGuardianTwoCallAtWork,
                Student::setGuardianTwoCallAtWork);
        
        formLayout.add(gFirstName, gLastName, gPhoneNum);
        formLayout.add(gEmail, 3);
        formLayout.add(callAtWork1, 3);
        formLayout.add(gFirstName2, gLastName2, gPhoneNum2);
        formLayout.add(gEmail2, 3);
        formLayout.add(callAtWork2, 3);
        
        TextField eContactOneFirstName = new TextField("Contact One First Name");
	    personBinder.forField(eContactOneFirstName).bind(
                Student::getEmergencyContactOneFirstName,
                Student::setEmergencyContactOneFirstName);
	    
	    TextField eContactOneLastName = new TextField("Contact One Last Name");
	    personBinder.forField(eContactOneLastName).bind(
                Student::getEmergencyContactOneLastName,
                Student::setEmergencyContactOneLastName);
	    
	    TextField eContactOneRelationship = new TextField("Contact One Relationship");
	    personBinder.forField(eContactOneRelationship).bind(
                Student::getEmergencyContactOneRelationship,
                Student::setEmergencyContactOneRelationship);
	    
	    TextField eContactOneHomeNumber = new TextField("Contact One Home Number");
	    personBinder.forField(eContactOneHomeNumber).bind(
                Student::getEmergencyContactOneHomeNumber,
                Student::setEmergencyContactOneHomeNumber);
	    
	    TextField eContactOneCellNumber = new TextField("Contact One Cell Number");
	    personBinder.forField(eContactOneCellNumber).bind(
                Student::getEmergencyContactOneCellNumber,
                Student::setEmergencyContactOneCellNumber);
	    
	    TextField eContactTwoFirstName = new TextField("Contact Two First Name");
	    personBinder.forField(eContactTwoFirstName).bind(
                Student::getEmergencyContactTwoFirstName,
                Student::setEmergencyContactTwoFirstName);
	    
	    TextField eContactTwoLastName = new TextField("Contact Two Last Name");
	    personBinder.forField(eContactTwoLastName).bind(
                Student::getEmergencyContactTwoLastName,
                Student::setEmergencyContactTwoLastName);
	    
	    TextField eContactTwoRelationship = new TextField("Contact Two Relationship");
	    personBinder.forField(eContactTwoRelationship).bind(
                Student::getEmergencyContactTwoRelationship,
                Student::setEmergencyContactTwoRelationship);
	    
	    TextField eContactTwoHomeNumber = new TextField("Contact Two Home Number");
	    personBinder.forField(eContactTwoHomeNumber).bind(
                Student::getEmergencyContactTwoHomeNumber,
                Student::setEmergencyContactTwoHomeNumber);
	    
	    TextField eContactTwoCellNumber = new TextField("Contact Two Cell Number");
	    personBinder.forField(eContactTwoCellNumber).bind(
                Student::getEmergencyContactTwoCellNumber,
                Student::setEmergencyContactTwoCellNumber);
        
	    formLayout.add(eContactOneFirstName, eContactOneLastName, eContactOneRelationship, eContactOneHomeNumber);
	    formLayout.add(eContactOneCellNumber, 2);
	    formLayout.add(eContactTwoFirstName, eContactTwoLastName, eContactTwoRelationship, eContactTwoHomeNumber);
	    formLayout.add(eContactTwoCellNumber, 2);
	    
	    TextField healthFactorOneName = new TextField("Health Factor One");
	    personBinder.forField(healthFactorOneName).bind(
                Student::getHealthFactorOne,
                Student::setHealthFactorOne);
	    
	    Checkbox lifeThreatening1 = new Checkbox();
	    lifeThreatening1.setLabel("Life Threatening");
        personBinder.forField(lifeThreatening1).bind(
                Student::isHealthFactorOneLifeThreatening,
                Student::setHealthFactorOneLifeThreatening);
        
        Checkbox planOfCareRequired1 = new Checkbox();
        planOfCareRequired1.setLabel("Plan Of Care Required");
        personBinder.forField(planOfCareRequired1).bind(
                Student::isHealthFactorOnePlanOfCareRequired,
                Student::setHealthFactorOnePlanOfCareRequired);
        
        Checkbox medicationsRequired1 = new Checkbox();
        medicationsRequired1.setLabel("Medications Required");
        personBinder.forField(medicationsRequired1).bind(
                Student::isHealthFactorOneMedicationsRequired,
                Student::setHealthFactorOneMedicationsRequired);
        
        TextField healthFactorTwoName = new TextField("Health Factor Two");
	    personBinder.forField(healthFactorTwoName).bind(
                Student::getHealthFactorTwo,
                Student::setHealthFactorTwo);
	    
	    Checkbox lifeThreatening2 = new Checkbox();
	    lifeThreatening2.setLabel("Life Threatening");
        personBinder.forField(lifeThreatening2).bind(
                Student::isHealthFactorTwoLifeThreatening,
                Student::setHealthFactorTwoLifeThreatening);
        
        Checkbox planOfCareRequired2 = new Checkbox();
        planOfCareRequired2.setLabel("Plan Of Care Required");
        personBinder.forField(planOfCareRequired2).bind(
                Student::isHealthFactorTwoPlanOfCareRequired,
                Student::setHealthFactorTwoPlanOfCareRequired);
        
        Checkbox medicationsRequired2 = new Checkbox();
        medicationsRequired2.setLabel("Medications Required");
        personBinder.forField(medicationsRequired2).bind(
                Student::isHealthFactorTwoMedicationsRequired,
                Student::setHealthFactorTwoMedicationsRequired);
        
        TextField healthFactorThreeName = new TextField("Health Factor Three");
	    personBinder.forField(healthFactorThreeName).bind(
                Student::getHealthFactorThree,
                Student::setHealthFactorThree);
	    
	    Checkbox lifeThreatening3 = new Checkbox();
	    lifeThreatening3.setLabel("Life Threatening");
        personBinder.forField(lifeThreatening3).bind(
                Student::isHealthFactorThreeLifeThreatening,
                Student::setHealthFactorThreeLifeThreatening);
        
        Checkbox planOfCareRequired3 = new Checkbox();
        planOfCareRequired3.setLabel("Plan Of Care Required");
        personBinder.forField(planOfCareRequired3).bind(
                Student::isHealthFactorThreePlanOfCareRequired,
                Student::setHealthFactorThreePlanOfCareRequired);
        
        Checkbox medicationsRequired3 = new Checkbox();
        medicationsRequired3.setLabel("Medications Required");
        personBinder.forField(medicationsRequired3).bind(
                Student::isHealthFactorThreeMedicationsRequired,
                Student::setHealthFactorThreeMedicationsRequired);
        
        TextField saparasDone = new TextField("Enter Sapras Memorized (seperated by a comma)");
        personBinder.bind(saparasDone, 
        		Student -> Student.getSaparasDone(),
        		(Student, title) -> {
        			Student.setSaparasDone(saparasDone.getValue());
        		});
        
        IntegerField currentSaparaMemorizing = new IntegerField("Current Sapara Memorizing");
        personBinder.bind(currentSaparaMemorizing, 
        		Student -> Student.getCurrentSaparaMemorizing(),
        		(Student, title) -> {
        			Student.setCurrentSaparaMemorizing(currentSaparaMemorizing.getValue());
        		});
        
        IntegerField saparasMemorizedT = new IntegerField("Total Saparas Memorized");
	    personBinder.bind(saparasMemorizedT, 
	    		Student -> Student.getTotalSaparasDone(),
	    		 (Student, title) -> {
	    	            Student.setTotalSaparasDone(title);
	    	            if (saparasMemorizedT.getValue() <= 5) {
	    	                Student.setProgramChosen("beginner");
	    	              } else if (saparasMemorizedT.getValue() > 5 && saparasMemorizedT.getValue() <= 12) {
	    	            	  Student.setProgramChosen("intermediate");
	    	              } else if ((saparasMemorizedT.getValue() > 12) && (saparasMemorizedT.getValue() != 30)) {
	    	            	  Student.setProgramChosen("advanced");;
	    	              } else {
	    	            	  Student.setProgramChosen("hafiz");
	    	            	  currentSaparaMemorizing.setEnabled(false);
	    	              }
	    	            
	    	            if ((saparasMemorizedT.getValue() == 30 )) {
	    	                saparasDone.setEnabled(false);
	    	                  Student.setSaparasDone("all");
	    	                  currentSaparaMemorizing.setEnabled(false);
	    	                  Student.setCurrentSaparaMemorizing(0);
	    	                } else if ((saparasMemorizedT.getValue() == 0)) {
	    	                	saparasDone.setEnabled(false);
		    	                  Student.setSaparasDone("0");
	    	                }
	    	            
	    	        });
	    
	    IntegerField curQuarter = new IntegerField("Dour Current Quarter");
	    personBinder.forField(curQuarter).bind(
                Student::getCurrentQuarter,
                Student::setCurrentQuarter);
	    
        IntegerField curSapara = new IntegerField ("Dour Current Sapara");
        personBinder.forField(curSapara).bind(
                Student::getDourCurrentSapara,
                Student::setDourCurrentSapara);
        
        formLayout.add(saparasMemorizedT, 2);
        formLayout.add(currentSaparaMemorizing, saparasDone, curQuarter, curSapara);
        
	    formLayout.add(healthFactorOneName, 3);
	    formLayout.add(lifeThreatening1, planOfCareRequired1, medicationsRequired1);
	    
	    formLayout.add(healthFactorTwoName, 3);
	    formLayout.add(lifeThreatening2, planOfCareRequired2, medicationsRequired2);
	    
	    formLayout.add(healthFactorThreeName, 3);
	    formLayout.add(lifeThreatening3, planOfCareRequired3, medicationsRequired3);
	    
	 // Footer
	    Button done = new Button("Done", e -> {
	    	  Boolean[] dourDoneOrNot = new Boolean[30];
	    	  temp.setDourDoneOrNot(dourDoneOrNot);
		        temp.setTodayDourDoneOrNot(false);
		        int[] quarterNumDoneMonth = new int[30];
		        temp.setQuarterNumDoneMonth(quarterNumDoneMonth);
		        int todayQuartersDone, currentQuarter;
		        temp.setTodayQuartersDone(-1);
		        Boolean[] numOfDourSaparasDoneMonth = new Boolean[30];
		        temp.setNumOfDourSaparasDoneMonth(numOfDourSaparasDoneMonth);
		        Boolean todayDourSaparaDoneOrNot;
		        temp.setTodayDourSaparaDone(-1);
		        temp.setOpenDourNextFill(0);
		        temp.setLastRecord("11/11/2011");

		        Boolean[] sabaqDoneOrNot = new Boolean[30];
		        temp.setSabaqDoneOrNot(sabaqDoneOrNot);
		        temp.setOpenTodaySabaqDoneOrNot(false);
		        int[] linesMemorized = new int[30];
		        temp.setLinesMemorized(linesMemorized);
		        int todayLinesMemorized;
		        temp.setTodayLinesMemorized(0);
		        int[] mistakesMade = new int[30];
		        temp.setMistakesMade(mistakesMade);
		        int todayMistakesMade;
		        temp.setTodayMistakesMade(0);
		        Boolean[] numOfSaparasDoneMonth = new Boolean[30];
		        temp.setNumOfSaparasDoneMonth(numOfSaparasDoneMonth);
		        Boolean todaySaparaFinished;
		        temp.setTodaySaparaFinished(false);
		        int[] nameOfSaparasDoneMonth = new int[30];
		        temp.setNameOfSaparasDoneMonth(nameOfSaparasDoneMonth);
		        temp.setTodaySaparaDone(-1);
		        temp.setOpenSaparaNextFill(0);

		      
		       ArrayList<String> dates = new ArrayList<>();
		       temp.setDate(dates);
		         //Student tempS = new Student (temp.getFirstName(), temp.getMiddleName(), temp.getLastName(), temp.getAddress(), temp.getDateOfBirth(), age, postalCode, language,countryOfBirth, attendanceOfStudent, progressOfStudent, dates, guardianOneFirstName, guardianOneLastName, guardianOnePhoneNumber,guardianOneEmail, guardianOneCallAtWork, guardianTwoFirstName, guardianTwoLastName, guardianTwoPhoneNumber, guardianTwoEmail, guardianTwoCallAtWork, emergencyContactOneFirstName, emergencyContactOneLastName, emergencyContactOneRelationship, emergencyContactOneHomeNumber, emergencyContactOneCellNumber,emergencyContactTwoFirstName, emergencyContactTwoLastName, emergencyContactTwoRelationship, emergencyContactTwoHomeNumber, emergencyContactTwoCellNumber, healthFactorOne, healthFactorOneLifeThreatening, healthFactorOnePlanOfCareRequired, healthFactorOneMedicationsRequired, healthFactorTwo, healthFactorTwoLifeThreatening, healthFactorTwoPlanOfCareRequired, healthFactorTwoMedicationsRequired, healthFactorThree, healthFactorThreeLifeThreatening, healthFactorThreePlanOfCareRequired,  temp.getHeaealthFactorThreeMedicationsRequired);

		       
	    	listOfStudents.add(temp);
	    	closeFileOne(listOfStudents);
	    	UI.getCurrent().navigate("menu");
	    });
	    done.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
	    done.getStyle().set("margin-right", "var(--lumo-space-s)");

	    Button anotherStudent = new Button("Cancel", l ->{
	    	listOfStudents.removeAll(listOfStudents);
	    	UI.getCurrent().navigate("menu");
	    });
	    anotherStudent.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_CONTRAST);

	    Footer footer = new Footer(done, anotherStudent);
	    footer.getStyle().set("padding", "var(--lumo-space-wide-m)");
	    
        footer.getStyle().set("text-align", "center");
	    
	    setAlignItems(Alignment.STRETCH);
	    setPadding(false);
	    setSpacing(false);
	    getStyle().set("border", "1px solid var(--lumo-contrast-20pct)");
	    
        tempp.add(formLayout, footer);
        tempp.setPadding(true);
        add(tempp);
	}
	
	 public static void closeFileOne(ArrayList <Student> listOfStudents) { 
		    PrintWriter pw = null;
		          try {
		             pw = new PrintWriter(new File("../marchbreakia/student.txt"));
		          } catch (FileNotFoundException e) {
		            System.err.print("couldn't open file for writing!");
		            System.exit(0);
		          }
		    

		          
		          for (int y = 0; y < listOfStudents.size(); y++) {

		            if (y == 0) {
		           pw.println(listOfStudents.get(y).getFirstName());
		            } else {
		              pw.println(listOfStudents.get(y).getFirstName());
		            }
		            pw.println(listOfStudents.get(y).getMiddleName());
		           pw.println(listOfStudents.get(y).getLastName());
		           pw.println(listOfStudents.get(y).getAddress());
		           pw.println(listOfStudents.get(y).getDateOfBirth());
		           pw.println(listOfStudents.get(y).getAge());
		           pw.println(listOfStudents.get(y).getPostalCode());
		           pw.println(listOfStudents.get(y).getLanguage());
		           pw.println(listOfStudents.get(y).getCountryOfBirth());
		pw.println(listOfStudents.get(y).getProgramChosen());
		            pw.println(listOfStudents.get(y).getLastRecord());


		       String holder = "";
		      for (int k = 0; k < listOfStudents.get(y).getDourDoneOrNot().length; k++) {
		           if (k == 0) {
		 holder = "" + listOfStudents.get(y).getDourDoneOrNot()[0];
		          } else {
		          holder = holder + "," + listOfStudents.get(y).getDourDoneOrNot()[k];
		          }
		          }
		            pw.println(holder);
		            
		            holder = "";
		    for (int k = 0; k < listOfStudents.get(y).getQuarterNumDoneMonth().length; k++) {
		           if (k == 0) {
		            holder = "" + listOfStudents.get(y).getQuarterNumDoneMonth()[0];
		          } else {
		          holder = holder + "," + listOfStudents.get(y).getQuarterNumDoneMonth()[k];
		          }  
		          }
		            pw.println(holder);

		   pw.println(listOfStudents.get(y).getCurrentQuarter()); 
		   
		   holder = "";
		            for (int k = 0; k < listOfStudents.get(y).getNumOfDourSaparasDoneMonth().length; k++) {
		           if (k == 0) {
		            holder = "" + listOfStudents.get(y).getNumOfDourSaparasDoneMonth()[0];
		          } else {
		          holder = holder + "," + listOfStudents.get(y).getNumOfDourSaparasDoneMonth()[k];
		          }
		          }
		            pw.println(holder);
		     pw.println(listOfStudents.get(y).getDourCurrentSapara()); pw.println(listOfStudents.get(y).getDourNextFill());
		     
		     DateTimeFormatter firstFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		        LocalDateTime firstNow = LocalDateTime.now();  
		       String alreadyDone = firstFormatter.format(firstNow);
		     
		     if (!(alreadyDone.equals(listOfStudents.get(y).getLastRecord()))) {
		         pw.println(false);
		         pw.println(-1);
		         pw.println(false);
		         pw.println(-1);
		         pw.println(false);
		         pw.println(-1);
		         pw.println(-1);
		         pw.println(false);
		         pw.println(-1);
		     } else {
		          pw.println(listOfStudents.get(y).isTodayDourDoneOrNot());
		          pw.println(listOfStudents.get(y).getTodayQuartersDone());
		          pw.println(listOfStudents.get(y).isTodayDourSaparaDoneOrNot());
		          pw.println(listOfStudents.get(y).getTodayDourSaparaDone());

		       if (!(listOfStudents.get(y).getProgramChosen().equals("hafiz"))) {     
		    	   pw.println(listOfStudents.get(y).getTodaySabaqDoneOrNot());         
		    	   pw.println(listOfStudents.get(y).getTodayLinesMemorized());        
		    	   pw.println(listOfStudents.get(y).getTodayMistakesMade());       
		    	   pw.println(listOfStudents.get(y).isTodaySaparaFinished());         
		    	   pw.println(listOfStudents.get(y).getTodaySaparaDone());    
		       } else {
		         pw.println(false);
		         pw.println(-1);
		         pw.println(-1);
		         pw.println(false);
		         pw.println(-1);
		       }
		     }

		     

		     if (!(listOfStudents.get(y).getProgramChosen().equals("hafiz"))) {
		    	 holder = "";
		       for (int k = 0; k < listOfStudents.get(y).getSabaqDoneOrNot().length; k++) {
		           if (k == 0) {
		            holder = "" + (listOfStudents.get(y).getSabaqDoneOrNot()[0]);
		          } else {
		          holder = holder + ("," + listOfStudents.get(y).getSabaqDoneOrNot()[k]);
		          }
		          }
		       pw.println(holder);
		       
		       holder = "";
		     for (int k = 0; k < listOfStudents.get(y).getLinesMemorized().length; k++) {
		           if (k == 0) {
		            holder = "" + (listOfStudents.get(y).getLinesMemorized()[0]);
		          } else {
		          holder = holder + ("," + listOfStudents.get(y).getLinesMemorized()[k]);
		          }
		          }
		     pw.println(holder);
		     
		     holder = "";
		     for (int k = 0; k < listOfStudents.get(y).getMistakesMade().length; k++) {
		           if (k == 0) {
		            holder = "" + (listOfStudents.get(y).getMistakesMade()[0]);
		          } else {
		          holder = holder + ("," + listOfStudents.get(y).getMistakesMade()[k]);
		          }
		          }
		     pw.println(holder);
		     
		     holder = "";
		       for (int k = 0; k < listOfStudents.get(y).getNumOfSaparasDoneMonth().length; k++) {
		           if (k == 0) {
		            holder = "" + (listOfStudents.get(y).getNumOfSaparasDoneMonth()[0]);
		          } else {
		          holder = holder + ("," + listOfStudents.get(y).getNumOfSaparasDoneMonth()[k]);
		          }
		          }
		       pw.println(holder);
		       
		       holder = "";
		       for (int k = 0; k < listOfStudents.get(y).getNameOfSaparasDoneMonth().length; k++) {
		           if (k == 0) {
		            holder = "" + (listOfStudents.get(y).getNameOfSaparasDoneMonth()[0]);
		          } else {
		          holder = holder + ("," + listOfStudents.get(y).getNameOfSaparasDoneMonth()[k]);
		          }
		          }
		       pw.println(holder);
		     pw.println(listOfStudents.get(y).getTotalSaparasDone());
		          pw.println(listOfStudents.get(y).getSaparasDone());
		pw.println(listOfStudents.get(y).getCurrentSaparaMemorizing()); pw.println(listOfStudents.get(y).getSaparaNextFill());
		     } else {
		       pw.println(false);
		       pw.println(0);
		       pw.println(0);
		       pw.println(false);
		       pw.println(0);
		       pw.println(0);
		       pw.println(0);
		       pw.println(0);
		       pw.println(0);
		     }
		     
		 
		     //attendance
		    //printing to file for attendance
		     holder = "";
		           for (int k = 0; k < listOfStudents.get(y).getAttendance().size(); k++) {
		           
		           if (k == 0) {
		            holder = "" + (listOfStudents.get(y).getAttendance().get(k));
		          
		          } else {
		          holder = holder + ("," + listOfStudents.get(y).getAttendance().get(k));
		          
		          }
		             }
		           pw.println(holder);
		           
		           holder = "";
		          //printing to file for reason absent
		          for (int d = 0; d < listOfStudents.get(y).getReasonAbsent().size(); d++) {
		           
		           if (d == 0) {
		            holder = "" + (listOfStudents.get(y).getReasonAbsent().get(d));
		          
		          } else {
		          holder = holder + ("," + listOfStudents.get(y).getReasonAbsent().get(d));
		          
		          }
		            }
		          pw.println(holder);
		          //printing to file for covid screening
		          holder = "";
		          for (int r = 0; r < listOfStudents.get(y).getCovidScreening().size(); r++) {
		           
		           if (r == 0) {
		            holder = "" + (listOfStudents.get(y).getCovidScreening().get(r));
		          
		          } else {
		          holder = holder + ("," + listOfStudents.get(y).getCovidScreening().get(r));
		          
		          }
		        }
		          pw.println(holder);
		          
		        //printing to file for reason covid screening was not done
		          holder = "";
		          for (int p = 0; p < listOfStudents.get(y).getReasonCovidScreening().size(); p++) {
		           
		           if (p == 0) {
		            holder = "" + (listOfStudents.get(y).getReasonCovidScreening().get(p));
		          
		          } else {
		          holder = holder + ("," + listOfStudents.get(y).getReasonCovidScreening().get(p));
		          
		          }
		        }
		          pw.println(holder);
		          
		        //printing to file for dates
		          holder = "";
		        for (int z = 0; z < listOfStudents.get(y).getDate().size(); z++) {
		           
		           if (z == 0) {
		            holder = ""+(listOfStudents.get(y).getDate().get(z));
		          
		          } else {
		          holder = holder + ("," + listOfStudents.get(y).getDate().get(z));
		          
		          }
		        }
		        pw.println(holder);
		        pw.println(listOfStudents.get(y).getGuardianOneFirstName());
		        pw.println(listOfStudents.get(y).getGuardianOneLastName());
		        pw.println(listOfStudents.get(y).getGuardianOnePhoneNumber());
		        pw.println(listOfStudents.get(y).getGuardianOneEmail());
		        pw.println(listOfStudents.get(y).isGuardianOneCallAtWork());
		        pw.println(listOfStudents.get(y).getGuardianTwoFirstName());
		        pw.println(listOfStudents.get(y).getGuardianTwoLastName());
		        pw.println(listOfStudents.get(y).getGuardianTwoPhoneNumber());
		        pw.println(listOfStudents.get(y).getGuardianTwoEmail());
		        pw.println(listOfStudents.get(y).isGuardianTwoCallAtWork());

		        pw.println(listOfStudents.get(y).getEmergencyContactOneFirstName());
		        pw.println(listOfStudents.get(y).getEmergencyContactOneLastName());
		        pw.println(listOfStudents.get(y).getEmergencyContactOneRelationship());
		        pw.println(listOfStudents.get(y).getEmergencyContactOneHomeNumber());
		        pw.println(listOfStudents.get(y).getEmergencyContactOneCellNumber());
		        pw.println(listOfStudents.get(y).getEmergencyContactTwoFirstName());
		        pw.println(listOfStudents.get(y).getEmergencyContactTwoLastName());
		        pw.println(listOfStudents.get(y).getEmergencyContactTwoRelationship());
		        pw.println(listOfStudents.get(y).getEmergencyContactTwoHomeNumber());
		        pw.println(listOfStudents.get(y).getEmergencyContactTwoCellNumber());

		        pw.println(listOfStudents.get(y).getHealthFactorOne());
		        pw.println(listOfStudents.get(y).isHealthFactorOneLifeThreatening());
		        pw.println(listOfStudents.get(y).isHealthFactorOnePlanOfCareRequired());
		        pw.println(listOfStudents.get(y).isHealthFactorOneMedicationsRequired());
		        pw.println(listOfStudents.get(y).getHealthFactorTwo());
		        pw.println(listOfStudents.get(y).isHealthFactorTwoLifeThreatening());
		        pw.println(listOfStudents.get(y).isHealthFactorTwoPlanOfCareRequired());
		        pw.println(listOfStudents.get(y).isHealthFactorTwoMedicationsRequired());
		        pw.println(listOfStudents.get(y).getHealthFactorThree());
		        pw.println(listOfStudents.get(y).isHealthFactorThreeLifeThreatening());
		        pw.println(listOfStudents.get(y).isHealthFactorThreePlanOfCareRequired());
		        pw.println(listOfStudents.get(y).isHealthFactorThreeMedicationsRequired());
		            
		            }
		   pw.close();

		  
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
	
	
	   //make new form layout
	   private FormLayout createFormLayout() {
	        FormLayout billingAddressFormLayout = new FormLayout();
	        billingAddressFormLayout.setResponsiveSteps(
	        		new ResponsiveStep("0", 1),
	                new ResponsiveStep("320px", 2),
	                new ResponsiveStep("500px", 3)
	        );
	        return billingAddressFormLayout;
	    }

}
