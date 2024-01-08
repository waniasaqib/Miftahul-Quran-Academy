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

@Route("okayMood")
public class OkayMood extends VerticalLayout {
	public OkayMood() {
	Image happy = new Image("images/okay.png", "Mood: Okay");
	happy.setWidth("210px");
	happy.setHeight("197px");
	H2 intro = new H2 (" Having an average day I see! \r\n"
			+ "A good dua to promote happiness and a peaceful life is:");
	intro.setWidth("600px");
	Image dua = new Image("images/okayWrite.png", "Mood: Okay");
	dua.setHeight("100px");
	Paragraph meaning = new Paragraph("Allahummaj alissa adata tagmuruna tunsina ma abkana wama ahzanana O Allah, allow happiness to surround us, making us forget what made us cry and what made us sad");
	meaning.setWidth("520px");
	Button continuee = new Button("Continue", e->{
		UI.getCurrent().navigate("welcome");
	});
    continuee.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
    Button cancelButton  = new Button("Back", e-> {
    	UI.getCurrent().navigate("started");
    });
    cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_SUCCESS);
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
