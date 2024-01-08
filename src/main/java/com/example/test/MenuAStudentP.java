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
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(value = "menuAStudentP", layout = Welcome.class)
public class MenuAStudentP extends VerticalLayout {
	
	static Scanner fileScanner;
	static ArrayList <Student> listOfStudents = new ArrayList <Student>();
	static int index;
	static String date;
	
	public MenuAStudentP() {
		
		 //read from files
		listOfStudents.removeAll(listOfStudents);
		listOfStudents = fileOneOpen();
		info();
		
		H2 intro = new H2("Attendance for " + listOfStudents.get(index).getFullName());
        intro.setMinWidth("700px");
        intro.setSizeFull();
        intro.getStyle().set("text-align", "center");
		
        H4 date1 = new H4("Date: " + date);
		date1.setMinWidth("700px");
        date1.setSizeFull();
        date1.getStyle().set("text-align", "center");
        
		
	    
	    //find index of date in the date arraylist of student
	    int dateIndex = -1;
	    for (int i = 0; i < listOfStudents.get(index).getDate().size(); i++) {
	    	if (listOfStudents.get(index).getDate().get(i).equals(date)) {
	    		dateIndex = i;
	    	}
	    }
	    
	    Select<String> select = new Select<>();
	    select.setLabel("Attendance");
	    select.setItems("Present", "Absent");
	    if ((listOfStudents.get(index).getAttendance().get(dateIndex)) == true) {
	    	select.setValue("Present");
	    } else {
	    	select.setValue("Absent");
	    }
	    
	    TextField textField = new TextField("Reason Absent");
		 textField.setPlaceholder(listOfStudents.get(index).getReasonAbsent().get(dateIndex));
		 
		 Select<String> select2 = new Select<>();
		    select2.setLabel("COVID Screening");
		    select2.setItems("Complete", "Incomplete");
		    if ((listOfStudents.get(index).getCovidScreening().get(dateIndex)) == true) {
		    	select2.setValue("Complete");
		    } else {
		    	select2.setValue("Incomplete");
		    }
		 
		 TextField textField2 = new TextField("Reason Incomplete");
		 textField2.setPlaceholder(listOfStudents.get(index).getReasonCovidScreening().get(dateIndex));
		 
		 HorizontalLayout edit = new HorizontalLayout(select, textField, select2, textField2);
	        edit.setSizeFull();
	        edit.getStyle().set("text-align", "center");
	        edit.setJustifyContentMode(JustifyContentMode.CENTER);
	        edit.setHeight("200px");
	    
	        
	     // Footer
		    Button done = new Button("Done", e -> {
		    	 int ind = -1;

		           for (int k = 0; k < listOfStudents.get(index).getDate().size(); k++) {
		          if ((listOfStudents.get(index).getDate().get(k)).equals(date)) {
		          ind = k;
		          boolean set;
		          if (select.getValue() == "Present") {
		        	  set = true;
		          } else {
		        	  set = false;
		          }
		          listOfStudents.get(index).getAttendance().set(ind, set);
		          listOfStudents.get(index).getReasonAbsent().set(ind, textField.getValue());
		          boolean set2;
		          if (select2.getValue() == "Present") {
		        	  set2 = true;
		          } else {
		        	  set2 = false;
		          }
		          listOfStudents.get(index).getCovidScreening().set(ind, set2);
		          listOfStudents.get(index).getReasonCovidScreening().set(ind, textField2.getValue());
		        } 
		      }
		           closeFileOne(listOfStudents);
		           listOfStudents.removeAll(listOfStudents);
		    	   UI.getCurrent().navigate("menu");
		    });
		    done.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		    done.getStyle().set("margin-right", "var(--lumo-space-s)");

		    Button anotherStudent = new Button("Another Student", l ->{
		    	closeFileOne(listOfStudents);
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
	        footer.setSizeFull();
	        setJustifyContentMode(JustifyContentMode.CENTER);
	        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
	        getStyle().set("text-align", "center");
		 
		 add(intro, date1, edit, footer);
		 
		 setAlignItems(Alignment.STRETCH);
		    setPadding(false);
		    setSpacing(false);
		    getStyle().set("border", "1px solid var(--lumo-contrast-20pct)");
		
		
	}
	
	//store student index to temp file
		 public static void store(int index, String date) {
			  PrintWriter pw = null;
	         try {
	            pw = new PrintWriter(new File("../marchbreakia/temp.txt"));
	            pw.println(index);
	            pw.println(date);
	            pw.close();
	         } catch (FileNotFoundException e) {
	           System.err.print("couldn't open file for writing!");
	           System.exit(0);
	         }
		  }
	
	//access stored index of student in temp file
		public static void info () {
			index = -1;
			 try {
			     fileScanner = new Scanner(new File("temp.txt"));
			     index = Integer.parseInt(fileScanner.nextLine());
			     date = fileScanner.nextLine();
			     
				 fileScanner.close();
			   } catch (FileNotFoundException e) {
			     System.err.println("File not found! Choosing to quit now...");
			 
			     System.exit(0);
			   }
		}
		
		//dialog for entering another student's information
				private static VerticalLayout createDialogLayout(Dialog dialog) {
			        H2 headline = new H2("Enter Student Information");
			        headline.getStyle().set("margin", "var(--lumo-space-m) 0 0 0")
			                .set("font-size", "1.5em").set("font-weight", "bold");

			        TextField firstNameField = new TextField("First Name");
			        TextField lastNameField = new TextField("Last Name");
			        DateTimeFormatter firstFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
			        DatePicker singleFormatI18n = new DatePicker("Pick a Date");
			        VerticalLayout fieldLayout = new VerticalLayout(firstNameField,
			                lastNameField, singleFormatI18n);
			        fieldLayout.setSpacing(false);
			        fieldLayout.setPadding(false);
			        fieldLayout.setAlignItems(FlexComponent.Alignment.STRETCH);

			        Button cancelButton = new Button("Cancel", e -> dialog.close());
			        Button saveButton = new Button("Done", e -> {
			        	int index = -2;
			            boolean found = false;
			            boolean found2 = false;
			        	for (int i = 0; i < listOfStudents.size(); i++) {
			                if (firstNameField.getValue().equals(listOfStudents.get(i).getFirstName()) && lastNameField.getValue().equals(listOfStudents.get(i).getLastName())) {
			                	 found = true;
			                	for (int k = 0; k < listOfStudents.get(i).getDate().size(); k++) {
			                	  if (listOfStudents.get(i).getDate().get(k).equals(firstFormatter1.format(singleFormatI18n.getValue()))) {
			                		  found2 = true;
			                		  index = i;
			    	                  store(index, firstFormatter1.format(singleFormatI18n.getValue()));
			    			        	dialog.close();
			    	                  UI.getCurrent().navigate("menuAStudentP");
			    	                  UI.getCurrent().getPage().reload();
			    	                  break;
			                	  }
			                  }
			                	if (found2 == true) {
			                		break;
			                	}
			                } 
			              }
			        	if (!((found == true) && (found2 == true))) {
			            	  if (found == true) {
			            		  Notification.show("Invalid date entered.",
				                          3000, Notification.Position.MIDDLE);
			            	  } else {
			           	   Notification.show("Invalid name entered.",
			                          3000, Notification.Position.MIDDLE);
			            	  }
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
	
	

}
