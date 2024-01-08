package com.example.test;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;

@Route("happyMood")
public class HappyMood extends VerticalLayout{
	public HappyMood() {
		Image happy = new Image("images/happy.png", "Mood: Happy");
    	happy.setWidth("200px");
    	happy.setHeight("185px");
		H2 intro = new H2 ("Nice to hear that you are having feeling happy! A good dua to read in times of happiness is:");
		intro.setWidth("600px");
		Image dua = new Image("images/happyWrite.png", "Mood: Happy");
    	dua.setWidth("300px");
    	Paragraph meaning = new Paragraph("Subhaanallaah Allaahu 'Akbar\r\n"
    			+ "Glory is to Allah. Allah is the Most Great.");
    	Button continuee = new Button("Continue", e->{
    		UI.getCurrent().navigate("welcome");
    	});
        continuee.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        Button cancelButton  = new Button("Back", e-> {
        	UI.getCurrent().navigate("started");
        });
        cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        HorizontalLayout btns = new HorizontalLayout(cancelButton, continuee);
        btns
                .setJustifyContentMode(FlexComponent.JustifyContentMode.END);
        
		add(happy,intro, dua, meaning, btns);
		
		addClassName("centered-content");
		setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
	}
}
