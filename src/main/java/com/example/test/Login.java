package com.example.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("login")
public class Login extends VerticalLayout {
	static ArrayList <Teacher> teacherInformation = new ArrayList <Teacher>();
	static Scanner fileScanner;

	public Login() {
		
		teacherInformation.removeAll(teacherInformation);
		fileTwoOpen();
		
		H2 intro = new H2 ("Log in");
		
		TextField fname = new TextField();
	    fname.setLabel("First Name");
	    fname.setRequiredIndicatorVisible(true);
	    fname.setErrorMessage("This field is required");
	   
	    TextField lname = new TextField();
	    lname.setLabel("Last Name");
	    lname.setRequiredIndicatorVisible(true);
	    lname.setErrorMessage("This field is required");
	    
	    PasswordField password = new PasswordField();
	    password.setLabel("Password");
	    password.setErrorMessage("This field is required");
	    
	    Button login = new Button("Log in", e->{
	    	boolean flag = false;
	    	for (int i = 0; i < teacherInformation.size(); i++) {
		          if (fname.getValue().equals(teacherInformation.get(i).getFirstName()) && lname.getValue().equals(teacherInformation.get(i).getLastName()) && password.getValue().equals(teacherInformation.get(i).getPassword())) {
		            UI.getCurrent().navigate("emergencyOrNot");
		            flag = true;
		            break;
		          } 
		        }
	    	if (flag == false) {
		        	  Notification notification = new Notification();
		        	  notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

		        	  Div text = new Div(new Text("Incorrect name or password entered"));

		        	  Button closeButton = new Button(new Icon("lumo", "cross"));
		        	  closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
		        	  closeButton.getElement().setAttribute("aria-label", "Close");
		        	  closeButton.addClickListener(event -> {
		        	    notification.close();
		        	  });

		        	  HorizontalLayout layout = new HorizontalLayout(text, closeButton);
		        	  layout.setAlignItems(Alignment.CENTER);

		        	  notification.add(layout);
		        	  notification.open();
	    	}
	    });
	    login.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
	    Button cancel = new Button("Cancel", e-> {
	    	UI.getCurrent().navigate("");
	    });

	    HorizontalLayout buttonLayout = new HorizontalLayout(login, cancel);
	    
	 // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content");

	    add (intro, fname, lname, password, buttonLayout);
	    
	    setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
		     
    }
	
	//open teacher file 
	  public static ArrayList <Teacher> fileTwoOpen() {
	     try {
	      fileScanner = new Scanner(new File("../marchbreakia/teacher.txt"));
	    } catch (FileNotFoundException e) {
	      System.err.println("File not found! Choosing to quit now...");

	      System.exit(0);
	    }

	    String fname, lname, password;

	    while (fileScanner.hasNextLine()) {
	      
	      fname = (fileScanner.nextLine()).toLowerCase();
	      lname = (fileScanner.nextLine()).toLowerCase();
	      password = fileScanner.nextLine();

	      Teacher tempT = new Teacher(fname, lname, password);
	        teacherInformation.add(tempT);
	    }
	    fileScanner.close();

	    return teacherInformation;
	   } 
}

