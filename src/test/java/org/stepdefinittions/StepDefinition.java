package org.stepdefinittions;

import java.io.IOException;

import org.baseclass.Baseclass;
import org.facebook.Facebooklogin;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends Baseclass {

	Facebooklogin login;
	
	@Given("Facebook url loading")
	@Given("Facebook URL is launched")
	public void facebook_url_is_launched() {
		browserLaunch("chrome");
		maximizeWindow();
		loadUrl("https://www.facebook.com/");
		login = new Facebooklogin();
	}

	@When("User Enters the Usernama and password")
	public void user_enters_the_usernama_and_password() {
		login.getUsername().sendKeys("ranith");
		login.getPassword().sendKeys("12343556");
	}

	@When("click login button")
	public void click_login_button() {

		WebElement getlogin = login.getlogin();
		clickIt(getlogin);

	}

	@Then("Take screenshot")
	public void take_screenshot() throws IOException {

		takeScreenShot("C:\\Users\\mranj\\eclipse-workspace\\MavenCucumber\\target\\screen.png");

	}
	
	
	@When("User Enters the {string} and {string}")
	public void user_enters_the_and(String string, String string2) {
		login.getUsername().sendKeys(string);
		login.getPassword().sendKeys(string2);
		
	}
	@Then("Take {string}")
	public void take(String string) throws IOException {
		takeScreenShot("C:\\Users\\mranj\\eclipse-workspace\\MavenCucumber\\target\\"+string+".png");
  
		
	}

	
	
	@When("User Click Forgot Password")
	public void user_click_forgot_password() {
	   login.getClickForgot().click();
		
	}
	@When("User Enter email and Click search")
	public void user_enter_email_and_click_search() {
	   login.getEnterEmail().sendKeys("ranjithdharma");
		
	}
	@Then("Take ScreenShot Of Result")
	public void take_screen_shot_of_result() throws IOException {
	   
		takeScreenShot("C:\\Users\\mranj\\eclipse-workspace\\MavenCucumber\\target\\scrnshot.png");
		
	}


	
	
	
	
	
	
	
	
	
	
	
	

		
		
	@Given("Bg Given")
	public void bg_given() {
	  
		System.out.println("Bg given");
		
	}
	@When("Bg When")
	public void bg_when() {
	 
		System.out.println("Bg when");
		
	}
	@Then("Bg Then")
	public void bg_then() {
	   
		System.out.println("Bg then");	
		
	}
	@Given("First given")
	public void first_given() {
	   
		System.out.println("first given");	
		
	}
	@When("First then")
	public void first_then() {
	    
		System.out.println("first then");
		
	}


	@Given("Second given")
	public void second_given() {
	  
		System.out.println("second given");
		
	}
	@When("Second when")
	public void second_when() {
		
		System.out.println("second when");
		
	}



	
	
	
	
	
	



}
