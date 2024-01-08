package com.example.test;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("started")
public class started extends VerticalLayout {
    public started() {
    	H1 intro = new H1 ("How Are You Feeling Today?");
        intro.setMinWidth("700px");
    	
        Image happy = new Image("images/happy.png", "Mood: Happy");
    	happy.setWidth("300px");
    	happy.setHeight("280px");
        Button happyButton = new Button(happy, e -> {
        	UI.getCurrent().navigate("happyMood");
        });
        happyButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        happyButton.setWidth("300px");
        happyButton.setHeight("280px");
        
        Image okay = new Image("images/okay.png", "Mood: Okay");
    	okay.setWidth("300px");
    	okay.setHeight("280px");
        Button okayButton = new Button(okay, e -> {
        	UI.getCurrent().navigate("okayMood");
        });
        okayButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        okayButton.setWidth("300px");
        okayButton.setHeight("280px");
        
        Image sad = new Image("images/sad.png", "Mood: Sad");
    	sad.setWidth("300px");
    	sad.setHeight("280px");
        Button sadButton = new Button(sad, e -> {
        	UI.getCurrent().navigate("sadMood");
        });
        sadButton.addThemeVariants(ButtonVariant.LUMO_ICON);
        sadButton.setWidth("300px");
        sadButton.setHeight("280px");
        HorizontalLayout images = new HorizontalLayout(happyButton, okayButton, sadButton);
        
        Button cancelButton  = new Button("Back", e-> {
        	UI.getCurrent().navigate("emergencyOrNot");
        });
        cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        
        add(intro, images, cancelButton);
        
        addClassName("centered-content");
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
