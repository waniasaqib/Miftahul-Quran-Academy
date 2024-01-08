package com.example.test;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "welcome2", layout = Welcome.class)
public class Welcome2 extends VerticalLayout {
	
	public Welcome2 () {
		
		 H1 intro = new H1 ("Welcome!");
	       setSizeFull();
	        setJustifyContentMode(JustifyContentMode.CENTER);
	        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
	        getStyle().set("text-align", "center");
	 	   add(intro);
	 	   
		
	}
}
