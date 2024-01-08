package com.example.test;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("welcome")
public class Welcome extends AppLayout {
	
	public Welcome() {
		
		 DrawerToggle toggle = new DrawerToggle();

 	    H1 title = new H1("Miftahul Quran Academy");
 	    title.getStyle()
 	      .set("font-size", "var(--lumo-font-size-l)")
 	      .set("margin", "0");

 	    Tabs tabs = getTabs();

 	    addToDrawer(tabs);
 	    addToNavbar(toggle, title);
 	    
 	    H1 intro = new H1 ("Welcome!");
 	   intro.addClassName("centered-content");
       intro.setSizeFull();
       intro.getStyle().set("text-align", "center");
 	    setContent(intro);
		
	}
	
	 private Tabs getTabs() {
		    Tabs tabs = new Tabs();
		    tabs.add(
		      createTab(VaadinIcon.HOME, "Home", 0),
		      createTab(VaadinIcon.BULLETS, "Main Menu", 2),
		      createTab(VaadinIcon.EXCLAMATION_CIRCLE, "Emergency", 1),
		      createTab(VaadinIcon.SIGN_OUT, "Log Out", 7)
		    );
		    tabs.setOrientation(Tabs.Orientation.VERTICAL);
		    return tabs;
		  }

		  private Tab createTab(VaadinIcon viewIcon, String viewName, int i) {
		    Icon icon = viewIcon.create();
		    icon.getStyle()
		            .set("box-sizing", "border-box")
		            .set("margin-inline-end", "var(--lumo-space-m)")
		            .set("margin-inline-start", "var(--lumo-space-xs)")
		            .set("padding", "var(--lumo-space-xs)");
		    
		    if (i == 1) {
		    RouterLink link = new RouterLink();
		    link.add(icon, new Span(viewName));
		    link.setRoute(StudentInfo.class);
		    
		    link.setTabIndex(-1);
		    
		    return new Tab(link);
		    } else if (i == 0) {
		    	RouterLink link = new RouterLink();
			    link.add(icon, new Span(viewName));
			    link.setRoute(Welcome2.class);
			    
			    link.setTabIndex(-1);
			    
			   
			    
			    return new Tab(link);	
		    } else if (i == 2){
		    	RouterLink link = new RouterLink();
			    link.add(icon, new Span(viewName));
			    link.setRoute(Menu.class);
			    
			    link.setTabIndex(-1);
			    
			    return new Tab(link);
		    	
		    } else {
		    	RouterLink link = new RouterLink();
			    link.add(icon, new Span(viewName));
			    link.setRoute(MainView.class);
			    
			    link.setTabIndex(-1);
			    
			    return new Tab(link);
		    }
		    }

}
