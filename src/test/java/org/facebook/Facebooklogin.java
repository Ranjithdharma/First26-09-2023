package org.facebook;

import org.baseclass.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Facebooklogin extends Baseclass {

	public Facebooklogin() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "email")
	private WebElement username;
	@FindBy(name = "pass")
	private WebElement password;
	@FindBy(name = "login")
	private WebElement login;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getlogin() {
		return login;
	}

	@FindBy(linkText = "Forgotten password?")
	private WebElement clickForgot;
	
	@FindBy(id = "identify_email")
	private WebElement enterEmail;

	public WebElement getClickForgot() {
		return clickForgot;
	}

	public WebElement getEnterEmail() {
		return enterEmail;
	}
	
	
	
	
	
	
}
