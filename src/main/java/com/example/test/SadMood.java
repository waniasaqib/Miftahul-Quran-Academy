package com.example.test;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("sadMood")
public class SadMood extends VerticalLayout{
	public SadMood() {
	Image sad = new Image("images/sad.png", "Mood: Sad");
	sad.setWidth("194px");
	sad.setHeight("176px");
	H2 intro = new H2 ("Oh no! Having a pretty bad day I see...\r\n"
			+ "A good dua to say in times of hardship and distress is: ");
	intro.setWidth("700px");
	Image dua = new Image("images/sadWrite.png", "Mood: Sad");
	dua.setHeight("80px");
	Paragraph meaning = new Paragraph("Allahumma inni a’udhu bika minal-hammi wal-Ḥuzni wal-‘ajazi wal-kasli wal-bukhli wal-jubni wa ḍala’id-dayni wa ghalabatir-rijal.\r\n"
			+ "“O Allah, I take refuge in You from anxiety and sorrow, weakness and laziness, miserliness and cowardice, the burden of debts and from being overpowered by men.” (Bukhari)");
	meaning.setWidth("470px");
	Button continuee = new Button("Continue", e->{
		UI.getCurrent().navigate("welcome");
	});
	continuee.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
    Button cancelButton  = new Button("Back", e-> {
    	UI.getCurrent().navigate("started");
    });
    cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_ERROR);
    HorizontalLayout btns = new HorizontalLayout(cancelButton, continuee);
    btns
            .setJustifyContentMode(FlexComponent.JustifyContentMode.END);
    
	add(sad,intro, dua, meaning, btns);
	
	addClassName("centered-content");
	setSizeFull();
    setJustifyContentMode(JustifyContentMode.CENTER);
    setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    getStyle().set("text-align", "center");
}
}
