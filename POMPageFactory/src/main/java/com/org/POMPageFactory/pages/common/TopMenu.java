package com.org.POMPageFactory.pages.common;

import org.openqa.selenium.WebDriver;


//Every Page has a Top menu
public class TopMenu {
	public WebDriver driver;
	
	public TopMenu(WebDriver driver){
		this.driver = driver;
	}
	
	public void logout(){
		System.out.println("Logging out");
	}
	
	public void search(){
		System.out.println("Search from top menu");
	}
}
