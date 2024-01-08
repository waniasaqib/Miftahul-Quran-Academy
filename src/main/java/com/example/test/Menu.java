package com.example.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Scanner;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

@Route(value = "menu", layout = Welcome.class)
public class Menu extends VerticalLayout {
	static Scanner fileScanner;
	static ArrayList <Student> listOfStudents = new ArrayList <Student>(); 
	static ArrayList <Teacher> teacherInformation = new ArrayList <Teacher>();
	public Menu() {
		//read from file
		listOfStudents.removeAll(listOfStudents);
		teacherInformation.removeAll(teacherInformation);
		listOfStudents = fileOneOpen();
		teacherInformation = fileTwoOpen();
		
		H1 intro = new H1 ("Let's Get Started For Today's Class!");
        intro.setMinWidth("700px");
	        MenuBar menuBar = new MenuBar();
	        menuBar.setOpenOnHover(true);
	        menuBar.setHeight("200px");
	        addItems(menuBar);
	        add(intro, menuBar);
	        addClassName("centered-content");
	        setSizeFull();
	        setJustifyContentMode(JustifyContentMode.CENTER);
	        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
	        getStyle().set("text-align", "center");
	    }

	    private void addItems(MenuBar menuBar) {
	    	
	        MenuItem attendance = menuBar.addItem("Attendance");
	        SubMenu attendanceSubMenu = attendance.getSubMenu();
	        attendanceSubMenu.addItem("Today's Attendance", e -> {
	        	UI.getCurrent().navigate("attendance");
	        });
	        attendanceSubMenu.add(new Hr());
	        MenuItem aAttendance =  attendanceSubMenu.addItem("View a student attendance");
	        SubMenu aAttendanceSubMenu = aAttendance.getSubMenu();
	        aAttendanceSubMenu.addItem("Today", e -> {
	        	Dialog dialog = new Dialog();
	    		dialog.getElement().setAttribute("aria-label", "Enter Student Information");

	    		VerticalLayout dialogLayout = createDialogLayout2(dialog);
	    		dialog.add(dialogLayout);
	    		add(dialog);
	    		dialog.open();
	        	
	        });
	       aAttendanceSubMenu.addItem("Previous date", e -> {
	        	Dialog dialog = new Dialog();
	    		dialog.getElement().setAttribute("aria-label", "Enter Student Information");

	    		VerticalLayout dialogLayout = createDialogLayout(dialog);
	    		dialog.add(dialogLayout);
	    		add(dialog);
	    		dialog.open();
	        });
	       
	       MenuItem allAttendance = attendanceSubMenu.addItem("View all student attendances");
	       SubMenu allAttendanceSubMenu = allAttendance.getSubMenu();
	       allAttendanceSubMenu.addItem("Today", e -> {
	    	   UI.getCurrent().navigate("menuAllStudentT");
	        	
	        });
	       allAttendanceSubMenu.addItem("Previous date", e -> {
	        	Dialog dialog = new Dialog();
	    		dialog.getElement().setAttribute("aria-label", "Enter Date");

	    		VerticalLayout dialogLayout = createDialogLayout3(dialog);
	    		dialog.add(dialogLayout);
	    		add(dialog);
	    		dialog.open();
	        });
	       attendanceSubMenu.addItem("View days absent", e -> {
	    	   
	    	   Dialog dialog = new Dialog();
	    		dialog.getElement().setAttribute("aria-label", "Enter Student Information");

	    		VerticalLayout dialogLayout = createDialogLayout4(dialog);
	    		dialog.add(dialogLayout);
	    		dialog.open();
	    		add(dialog);
	        });
	        
	        MenuItem sRecords = menuBar.addItem("Student Records");
	        SubMenu sRecordsSubMenu = sRecords.getSubMenu();
	        sRecordsSubMenu.addItem("View a student record", e -> {
	        	Dialog dialog = new Dialog();
	    		dialog.getElement().setAttribute("aria-label", "Enter Student Information");

	    		VerticalLayout dialogLayout = createDialogLayout5(dialog, 1);
	    		dialog.add(dialogLayout);
	    		dialog.open();
	    		add(dialog);
	        });
	        sRecordsSubMenu.addItem("Edit a student record", e -> {
	        	Dialog dialog = new Dialog();
	    		dialog.getElement().setAttribute("aria-label", "Enter Student Information");

	    		VerticalLayout dialogLayout = createDialogLayout5(dialog, 2);
	    		dialog.add(dialogLayout);
	    		dialog.open();
	    		add(dialog);
	        });
	     

	        MenuItem sProgress = menuBar.addItem("Student Progress");
	        SubMenu sProgressSubMenu = sProgress.getSubMenu();
	        sProgressSubMenu.addItem("Record Today's Progress", e-> {
	        	Dialog dialog = new Dialog();
	    		dialog.getElement().setAttribute("aria-label", "Enter Student Information");

	    		VerticalLayout dialogLayout = createDialogLayout5(dialog, 3);
	    		dialog.add(dialogLayout);
	    		dialog.open();
	    		add(dialog);
	        	});
	        sProgressSubMenu.add(new Hr());
	        MenuItem viewProgress = sProgressSubMenu.addItem("View progress");
	        SubMenu viewProgressSubMenu = viewProgress.getSubMenu();
	        viewProgressSubMenu.addItem("Daily progress", e-> {
	        	
	        	Dialog dialog = new Dialog();
	    		dialog.getElement().setAttribute("aria-label", "Enter Student Information");

	    		VerticalLayout dialogLayout = createDialogLayout5(dialog, 4);
	    		dialog.add(dialogLayout);
	    		dialog.open();
	    		add(dialog);
	        });
	        viewProgressSubMenu.addItem("Monthly progress", e -> {
	        	Dialog dialog = new Dialog();
	    		dialog.getElement().setAttribute("aria-label", "Enter Student Information");

	    		VerticalLayout dialogLayout = createDialogLayout5(dialog, 5);
	    		dialog.add(dialogLayout);
	    		dialog.open();
	    		add(dialog);
	        });
	        sProgressSubMenu.addItem("Change program chosen", e -> {
	        	Dialog dialog = new Dialog();
	    		dialog.getElement().setAttribute("aria-label", "Enter Student Information");

	    		VerticalLayout dialogLayout = createDialogLayout12(dialog);
	    		dialog.add(dialogLayout);
	    		dialog.open();
	    		add(dialog);
	        });
	        
	        MenuItem other = menuBar.addItem("Other");
	        SubMenu otherSubMenu = other.getSubMenu();
	        MenuItem otherSubMenu15 = otherSubMenu.addItem("Manage passwords and personal information");
	        SubMenu otherSubMenu1 = otherSubMenu15.getSubMenu();
	        otherSubMenu1.addItem("View teacher information", e -> {
	        	Dialog dialog = new Dialog();
	    		VerticalLayout dialogLayout = createDialogLayout6(dialog);
	    		dialog.add(dialogLayout);
	    		dialog.open();
	    		add(dialog);
	    		 getStyle().set("position", "fixed").set("top","0").set("right", "0")
	                .set("bottom", "0").set("left", "0").set("display", "flex")
	                .set("align-items", "center").set("justify-content", "center");
	        });
	        otherSubMenu1.add(new Hr());
	        otherSubMenu1.addItem("Change your first name", e -> {
	        	Dialog dialog = new Dialog();
	    		VerticalLayout dialogLayout = createDialogLayout7(dialog);
	    		dialog.add(dialogLayout);
	    		dialog.open();
	    		add(dialog);
	    		 getStyle().set("position", "fixed").set("top","0").set("right", "0")
	                .set("bottom", "0").set("left", "0").set("display", "flex")
	                .set("align-items", "center").set("justify-content", "center");
	        	
	        });
	        otherSubMenu1.addItem("Change your last name", e -> {
	        	
	        	Dialog dialog = new Dialog();
	    		VerticalLayout dialogLayout = createDialogLayout8(dialog);
	    		dialog.add(dialogLayout);
	    		dialog.open();
	    		add(dialog);
	    		 getStyle().set("position", "fixed").set("top","0").set("right", "0")
	                .set("bottom", "0").set("left", "0").set("display", "flex")
	                .set("align-items", "center").set("justify-content", "center"); 	
	        });
	        otherSubMenu1.addItem("Change your password", e -> {
	        	Dialog dialog = new Dialog();
	        	VerticalLayout dialogLayout = createDialogLayout9(dialog);
	    		dialog.add(dialogLayout);
	    		dialog.open();
	    		add(dialog);
	    		 getStyle().set("position", "fixed").set("top","0").set("right", "0")
	                .set("bottom", "0").set("left", "0").set("display", "flex")
	                .set("align-items", "center").set("justify-content", "center");
	        });
	        otherSubMenu.addItem("Display class list", e -> {
	        	Dialog dialog = new Dialog();
	            dialog.getElement().setAttribute("aria-label", "Class list");

	            VerticalLayout dialogLayout = createDialogLayout10();
	            dialog.add(dialogLayout);
	            dialog.setDraggable(true);
	            dialog.setResizable(true);
	            dialog.open();
	            add(dialog);
	        });
	        otherSubMenu.addItem("Add a new student", e -> UI.getCurrent().navigate("menuDOtherN"));
	        otherSubMenu.addItem("Delete student", e -> {
	        	
	        	Dialog dialog = new Dialog();
	    		VerticalLayout dialogLayout = createDialogLayout11(dialog);
	    		dialog.add(dialogLayout);
	    		dialog.open();
	    		add(dialog);
	    		 getStyle().set("position", "fixed").set("top","0").set("right", "0")
	                .set("bottom", "0").set("left", "0").set("display", "flex")
	                .set("align-items", "center").set("justify-content", "center"); 
	        	
	        });
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
	    	                  closeFileOne(listOfStudents);
	    			        	dialog.close();
	    	                  UI.getCurrent().navigate("menuAStudentP");
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
		
		 //dialog for entering another student's information
		private static VerticalLayout createDialogLayout12(Dialog dialog) {
	        H2 headline = new H2("Enter Student Information");
	        headline.getStyle().set("margin", "var(--lumo-space-m) 0 0 0")
	                .set("font-size", "1.5em").set("font-weight", "bold");
	        TextField firstNameField = new TextField("First Name");
	        TextField lastNameField = new TextField("Last Name");
	        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
	        radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
	        radioGroup.setLabel("Choose new program");
	        radioGroup.setItems("Beginner (less than five saparas memorized)", "Intermediate (between five to twelve saparas memorized)", "Advanced (more than twelve saparas memorized)", "Hafiz (the Qur'an memorized)");
	        VerticalLayout fieldLayout = new VerticalLayout(firstNameField,
	                lastNameField, radioGroup);
	        fieldLayout.setSpacing(false);
	        fieldLayout.setPadding(false);
	        fieldLayout.setAlignItems(FlexComponent.Alignment.STRETCH);

	        Button cancelButton = new Button("Cancel", e -> dialog.close());
	        Button saveButton = new Button("Done", e -> {
	        	int index = -2;
	            boolean found = false;
	        	for (int i = 0; i < listOfStudents.size(); i++) {
	                if (firstNameField.getValue().equals(listOfStudents.get(i).getFirstName()) && lastNameField.getValue().equals(listOfStudents.get(i).getLastName())) {
	                	found = true;
	                	 index = i;
	                	 if (radioGroup.getValue().equals("Beginner (less than five saparas memorized)")) {
	                		 listOfStudents.get(index).setProgramChosen("beginner");
	                	 } else if (radioGroup.getValue().equals("Intermediate (between five to twelve saparas memorized)")) {
	                		 listOfStudents.get(index).setProgramChosen("intermediate");
	                	 } else if (radioGroup.getValue().equals("Advanced (more than twelve saparas memorized)")) {
	                		 listOfStudents.get(index).setProgramChosen("advanced");
	                	 } else {
	                		 listOfStudents.get(index).setProgramChosen("hafiz");
	                	 }
	                	 closeFileOne(listOfStudents); 
	                	dialog.close();
	                	if (found == true) {
	                		break;
	                	}
	                } 
	              }
	        	if (!((found == true))) {
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
		
		private static VerticalLayout createDialogLayout10() {
	        H2 headline = new H2("Class List");
	        headline.getStyle().set("margin", "var(--lumo-space-m) 0 0 0")
	                .set("font-size", "1.5em").set("font-weight", "bold");

	        Grid<Student> grid = new Grid<>(Student.class, false);
	        grid.addColumn(Student::getFirstName).setHeader("First name").setAutoWidth(true).setFlexGrow(0);
	        grid.addColumn(Student::getLastName).setHeader("Last name").setAutoWidth(true).setFlexGrow(0);
	        grid.addColumn(Student::getProgramChosen).setHeader("Program chosen").setAutoWidth(true).setFlexGrow(0);
	        grid.addColumn(Student::getAge).setHeader("Age").setAutoWidth(true).setFlexGrow(0);
	        grid.addColumn(Student::getApplicable).setHeader("Applicable for Monthly Report?").setAutoWidth(true).setFlexGrow(0);
	        
	        grid.setItems(listOfStudents);

	        VerticalLayout dialogLayout = new VerticalLayout(headline, grid);
	        dialogLayout.setPadding(false);
	        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
	        dialogLayout.getStyle().set("min-width", "350px")
	                .set("max-width", "100%").set("height", "100%");

	        return dialogLayout;
	    }
		
		  private static VerticalLayout createDialogLayout7(Dialog dialog) {

		        H2 headline = new H2("Change first name");
		        headline.getStyle().set("margin-top", "0");
		        
		        Binder<Teacher> personBinder = new Binder<>(Teacher.class);
			    personBinder.setBean(teacherInformation.get(0));

		        TextField firstName = new TextField("First name");
		        personBinder.forField(firstName).bind(
		                Teacher::getFirstName,
		                Teacher::setFirstName);

		        Button cancelButton = new Button("Cancel", e -> dialog.close());
		        Button saveButton = new Button("Change", e -> {
		        	closeFileTwo();
		        	closeFileOne(listOfStudents);
		        	dialog.close();
		        	});
		        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton,
		                saveButton);
		        buttonLayout
		                .setJustifyContentMode(FlexComponent.JustifyContentMode.END);
		        buttonLayout.getStyle().set("margin-top", "var(--lumo-space-m)");

		        VerticalLayout dialogLayout = new VerticalLayout(headline, firstName,
		                buttonLayout);
		        dialogLayout.setPadding(false);
		        dialogLayout.setSpacing(false);
		        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
		        dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");

		        return dialogLayout;
		    }
		  
		  private static VerticalLayout createDialogLayout8(Dialog dialog) {

		        H2 headline = new H2("Change last name");
		        headline.getStyle().set("margin-top", "0");
		        
		        Binder<Teacher> personBinder = new Binder<>(Teacher.class);
			    personBinder.setBean(teacherInformation.get(0));

		        TextField lastName = new TextField("Last name");
		        personBinder.forField(lastName).bind(
		                Teacher::getLastName,
		                Teacher::setLastName);

		        Button cancelButton = new Button("Cancel", e -> dialog.close());
		        Button saveButton = new Button("Change", e -> {
		        	closeFileTwo();
		        	closeFileOne(listOfStudents); 
		        	dialog.close();
		        	});
		        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton,
		                saveButton);
		        buttonLayout
		                .setJustifyContentMode(FlexComponent.JustifyContentMode.END);
		        buttonLayout.getStyle().set("margin-top", "var(--lumo-space-m)");

		        VerticalLayout dialogLayout = new VerticalLayout(headline, lastName,
		                buttonLayout);
		        dialogLayout.setPadding(false);
		        dialogLayout.setSpacing(false);
		        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
		        dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");

		        return dialogLayout;
		    }
		  
		  private static VerticalLayout createDialogLayout11(Dialog dialog) {

		        H2 headline = new H2("Delete student");
		        headline.getStyle().set("margin-top", "0");
		        
		        Paragraph warn = new Paragraph ("Notice: Clicking 'Done' will remove the student forever. This cannot be undone.");
		        TextField firstName = new TextField("First name");
		        TextField lastName = new TextField("Last name");
		        
		        Button cancelButton = new Button("Cancel", e -> dialog.close());
		        Button saveButton = new Button("Done", e -> {
		        	boolean found = false;
		        	for (int i = 0; i < listOfStudents.size(); i++) {
		        		if (firstName.getValue().equals(listOfStudents.get(i).getFirstName()) && (lastName.getValue().equals(listOfStudents.get(i).getLastName()))) {
		        			found = true;
		        			listOfStudents.remove(i);
		        			closeFileOne(listOfStudents); 
		        			dialog.close();
		        		}
		        	}
		        	if (found == false) {
		        		Notification.show("Invalid name entered.",
		                         1500, Notification.Position.MIDDLE);	
		        	}
		        	closeFileOne(listOfStudents);
		        	});
		        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton,
		                saveButton);
		        buttonLayout
		                .setJustifyContentMode(FlexComponent.JustifyContentMode.END);
		        buttonLayout.getStyle().set("margin-top", "var(--lumo-space-m)");

		        VerticalLayout dialogLayout = new VerticalLayout(headline, warn, firstName, lastName,
		                buttonLayout);
		        dialogLayout.setPadding(false);
		        dialogLayout.setSpacing(false);
		        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
		        dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");

		        return dialogLayout;
		    }
		  
		  private static VerticalLayout createDialogLayout9(Dialog dialog) {

		        H2 headline = new H2("Change password");
		        headline.getStyle().set("margin-top", "0");
		        
		        Binder<Teacher> personBinder = new Binder<>(Teacher.class);
			    personBinder.setBean(teacherInformation.get(0));

			    PasswordField password = new PasswordField("Password");
			    PasswordField confirmPassword = new PasswordField("Confirm Password");

		        Button cancelButton = new Button("Cancel", e -> dialog.close());
		        Button saveButton = new Button("Change", e -> {
		        	if (password.getValue().equals(confirmPassword.getValue())) {
				    	teacherInformation.get(0).setPassword(confirmPassword.getValue());
				    	closeFileTwo();
				    	closeFileOne(listOfStudents); 
				    	dialog.close();
				    	Notification.show("Success!",
		                         1500, Notification.Position.MIDDLE);
				    } else {
				    	 Notification.show("Passwords do not match.",
		                         3000, Notification.Position.MIDDLE);
				    }
		        	});
		        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton,
		                saveButton);
		        buttonLayout
		                .setJustifyContentMode(FlexComponent.JustifyContentMode.END);
		        buttonLayout.getStyle().set("margin-top", "var(--lumo-space-m)");

		        VerticalLayout dialogLayout = new VerticalLayout(headline, password, confirmPassword,
		                buttonLayout);
		        dialogLayout.setPadding(false);
		        dialogLayout.setSpacing(false);
		        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
		        dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");

		        return dialogLayout;
		    }
		
		
		//dialog for entering another student's information
				private static VerticalLayout createDialogLayout2(Dialog dialog) {
			        H2 headline = new H2("Enter Student Information");
			        headline.getStyle().set("margin", "var(--lumo-space-m) 0 0 0")
			                .set("font-size", "1.5em").set("font-weight", "bold");
			        
			        //text fields where the client can input the student they would like to view's first and last names
			        TextField firstNameField = new TextField("First Name");
			        TextField lastNameField = new TextField("Last Name");
			        //add to fieldLayout, which gets added onto the user's screen
			        VerticalLayout fieldLayout = new VerticalLayout(firstNameField,
			                lastNameField);
			        //add styling
			        fieldLayout.setSpacing(false);
			        fieldLayout.setPadding(false);
			        fieldLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
			        
			        //cancel button to close dialog 
			        Button cancelButton = new Button("Cancel", e -> dialog.close());
			        
			        //done button to navigate user to the attendance view
			        Button saveButton = new Button("Done", e -> {
			        	int index = -2;
			            boolean studentFound = false;
			            boolean dateFound = false;
			            //search through listOfStudents ArrayList for a student with the same first and last name as the student information the client has entered 
			        	for (int i = 0; i < listOfStudents.size(); i++) {
			        		//if the match is found
			                if (firstNameField.getValue().equals(listOfStudents.get(i).getFirstName()) && lastNameField.getValue().equals(listOfStudents.get(i).getLastName())) {
			                	 studentFound = true;
			                	 //get todays date
			                	 DateTimeFormatter firstFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
			         	        LocalDateTime firstNow2 = LocalDateTime.now(ZoneId.systemDefault());  
			         	       String alreadyDoneAttendance = firstFormatter1.format(firstNow2);
			         	       //search through the student's dates ArrayList and see if todays date matches any of the dates
			                	for (int k = 0; k < listOfStudents.get(i).getDate().size(); k++) {
			                		//if the match is found
			                	  if (listOfStudents.get(i).getDate().get(k).equals(alreadyDoneAttendance)) {
			                		  dateFound = true;
			                		  index = i;
			                		  //store index of student and date into temp.txt file and close dialog
			    	                  store(index,alreadyDoneAttendance);
			    	                  closeFileOne(listOfStudents); 
			    	                  dialog.close();
			    			        //navigate to desired attendance menu
			    	                  UI.getCurrent().navigate("menuAStudentT");
			    	                  //break for loop
			    	                  break;
			                	  }
			                  }
			                	//if date is found break the second for loop as well
			                	if (dateFound == true) {
			                		break;
			                	}
			                } 
			              }
			        	//display warning messages for data entry errors
			        	if (!((studentFound == true) && (dateFound == true))) {
			            	  if (studentFound == true) {
			            		  Notification.show("Attendance for today does not exist.",
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
				
				 //dialog for entering another student's information
				private static VerticalLayout createDialogLayout3(Dialog dialog) {
			        H2 headline = new H2("Enter Date");
			        headline.getStyle().set("margin", "var(--lumo-space-m) 0 0 0")
			                .set("font-size", "1.5em").set("font-weight", "bold");

			        DateTimeFormatter firstFormatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
			        DatePicker singleFormatI18n = new DatePicker("Pick a Date");
			        VerticalLayout fieldLayout = new VerticalLayout(singleFormatI18n);
			        fieldLayout.setSpacing(false);
			        fieldLayout.setPadding(false);
			        fieldLayout.setAlignItems(FlexComponent.Alignment.STRETCH);

			        Button cancelButton = new Button("Cancel", e -> dialog.close());
			        Button saveButton = new Button("Done", e -> {
			            boolean found = false;
			        	for (int i = 0; i < listOfStudents.size(); i++) {
			                	for (int k = 0; k < listOfStudents.get(i).getDate().size(); k++) {
			                	  if (listOfStudents.get(i).getDate().get(k).equals(firstFormatter1.format(singleFormatI18n.getValue()))) {
			                		  found = true;
			    	                  store3(firstFormatter1.format(singleFormatI18n.getValue()));
			    	                  closeFileOne(listOfStudents); 
			    	                  dialog.close();
			    	                  UI.getCurrent().navigate("menuAllStudentP");
			    	                  break;
			                	  }
			                } 
			              }
			        	if (!(found == true)) {
			            		  Notification.show("Invalid date entered.",
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
				private static VerticalLayout createDialogLayout4(Dialog dialog) {
			        H2 headline = new H2("Enter Student Information");
			        headline.getStyle().set("margin", "var(--lumo-space-m) 0 0 0")
			                .set("font-size", "1.5em").set("font-weight", "bold");

			        TextField firstNameField = new TextField("First Name");
			        TextField lastNameField = new TextField("Last Name");
			        VerticalLayout fieldLayout = new VerticalLayout(firstNameField,
			                lastNameField);
			        fieldLayout.setSpacing(false);
			        fieldLayout.setPadding(false);
			        fieldLayout.setAlignItems(FlexComponent.Alignment.STRETCH);

			        Button cancelButton = new Button("Cancel", e -> dialog.close());
			        Button saveButton = new Button("Done", e -> {
			        	int index = -2;
			            boolean found = false;
			        	for (int i = 0; i < listOfStudents.size(); i++) {
			                if (firstNameField.getValue().equals(listOfStudents.get(i).getFirstName()) && lastNameField.getValue().equals(listOfStudents.get(i).getLastName())) {
			                  index = i;
			                  found = true;
			                  //store4(index);
			                  int daysAbsent = 0;
			                  for(int k = 0; k < listOfStudents.get(index).getAttendance().size(); k++) {
			                      if (listOfStudents.get(index).getAttendance().get(k) == false) {
			                        daysAbsent++;
			                      }
			            
			                    }
			                  Notification.show("Days Absent: " + daysAbsent,
			                          5000, Notification.Position.MIDDLE);
			                  closeFileOne(listOfStudents); 
					        	dialog.close();
			                  break;
			                } 
			              }

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
				
				private static VerticalLayout createDialogLayout5(Dialog dialog, int send) {
			        H2 headline = new H2("Enter Student Information");
			        headline.getStyle().set("margin", "var(--lumo-space-m) 0 0 0")
			                .set("font-size", "1.5em").set("font-weight", "bold");

			        TextField firstNameField = new TextField("First Name");
			        TextField lastNameField = new TextField("Last Name");
			        VerticalLayout fieldLayout = new VerticalLayout(firstNameField,
			                lastNameField);
			        fieldLayout.setSpacing(false);
			        fieldLayout.setPadding(false);
			        fieldLayout.setAlignItems(FlexComponent.Alignment.STRETCH);

			        Button cancelButton = new Button("Cancel", e -> dialog.close());
			        Button saveButton = new Button("Done", e -> {
			        	int index = -2;
			            boolean found = false;
			        	for (int i = 0; i < listOfStudents.size(); i++) {
			                if (firstNameField.getValue().equals(listOfStudents.get(i).getFirstName()) && lastNameField.getValue().equals(listOfStudents.get(i).getLastName())) {
			                  index = i;
			                  found = true;
			                  store4(index);
			                  closeFileOne(listOfStudents); 
			                  dialog.close();
					        	if (send == 1) {
			                  UI.getCurrent().navigate("menuBRecordsV");
					        	} else if (send == 2) {
					        		UI.getCurrent().navigate("menuBRecordsE");
					        	} else if (send == 3) {
					        		UI.getCurrent().navigate("menuCProgressR");
					        	} else if (send == 4) {
					        		UI.getCurrent().navigate("menuCProgressD");
					        	} else if (send == 5) {
					        		UI.getCurrent().navigate("menuCProgressM");
					        	}
			                  break;
			                } 
			              }

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
				

			    private static VerticalLayout createDialogLayout6(Dialog dialog) {

			        H2 headline = new H2("Teacher Information");
			        headline.getStyle().set("margin-top", "0");
			        
			        Paragraph fName = new Paragraph ("First Name: " + teacherInformation.get(0).getFirstName());
			        Paragraph lName = new Paragraph ("Last Name: " + teacherInformation.get(0).getLastName());
			        Paragraph password = new Paragraph ("Password: " + teacherInformation.get(0).getPassword());

			        Button saveButton = new Button("Done", e -> {
			        	closeFileOne(listOfStudents); 
			        	dialog.close();
			        });
			        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
			        HorizontalLayout buttonLayout = new HorizontalLayout(
			                saveButton);
			        buttonLayout
			                .setJustifyContentMode(FlexComponent.JustifyContentMode.END);
			        buttonLayout.getStyle().set("margin-top", "var(--lumo-space-m)");

			        VerticalLayout dialogLayout = new VerticalLayout(headline, fName, lName, password,
			                buttonLayout);
			        dialogLayout.setPadding(false);
			        dialogLayout.setSpacing(false);
			        dialogLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
			        dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");

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

			        //write to teacher file method
			        public static void closeFileTwo() {
			        //make new print writer called pw
			          PrintWriter pw = null;
			          //try and catch statement to assign print writer to file
			              try {
			                 pw = new PrintWriter(new File("teacher.txt"));
			              //if file not found then display error and exit program
			              } catch (FileNotFoundException e) {
			                System.err.print("couldn't open file for writing!");
			                System.exit(0);
			              }
			              //iterate through teacher information array
			              for (int y = 0; y < teacherInformation.size(); y++) {
			            	 //print the teachers information to file
			               pw.println(teacherInformation.get(y).getFirstName());
          	               pw.println(teacherInformation.get(y).getLastName());
			                pw.println(teacherInformation.get(y).getPassword());
			             }
			              //close print writer when done
			             pw.close(); 
			        } 
		  
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
		  public static void store3(String date) {
			  PrintWriter pw = null;
	          try {
	             pw = new PrintWriter(new File("../marchbreakia/temp.txt"));
	             pw.println(date);
	             pw.close();
	          } catch (FileNotFoundException e) {
	            System.err.print("couldn't open file for writing!");
	            System.exit(0);
	          }
		  }
		  public static void store4(int index) {
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
		  
		  //reading from file for teacher.txt method
		  public static ArrayList <Teacher> fileTwoOpen() {
			  //try and catch statement to assign a scanner to the text file
			     try {
			      fileScanner = new Scanner(new File("../marchbreakia/teacher.txt"));
			      //print out error and close program if not found
			    } catch (FileNotFoundException e) {
			      System.err.println("File not found! Choosing to quit now...");

			      System.exit(0);
			    }
			     
			     //variables to hold information from file
			    String fname, lname, password;
			    //while scanner has a next line, keep reading from file
			    while (fileScanner.hasNextLine()) {
			      
			    	
			      //read from file line by line and assign each line to its own variable
			      //these lines are lower cased strings too maintain ambiguity except for password
			      fname = (fileScanner.nextLine()).toLowerCase();
			      lname = (fileScanner.nextLine()).toLowerCase();
			      password = fileScanner.nextLine();
			      //make new teacher object and store with information read from file
			      Teacher tempT = new Teacher(fname, lname, password);
			        teacherInformation.add(tempT);
			    }
			    //close scanner
			    fileScanner.close();
			    //return the teacher information
			    return teacherInformation;
			   } 


}
