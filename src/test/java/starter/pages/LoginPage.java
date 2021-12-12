package starter.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {
	
	//sign in button
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	public WebElementFacade button_sign_in;
	
	//sign out button
	@FindBy(xpath = "//a[contains(text(),'Sign out') and @class='logout']")
	public WebElementFacade button_sign_out;
		
	// input username
	@FindBy(xpath = "//input[@id='email']")
	public WebElementFacade input_username;

	// input password
	@FindBy(xpath = "//input[@id='passwd']")
	public WebElementFacade input_password;
	
	//login button
	@FindBy(xpath = "//button[@id='SubmitLogin']//span")
	public WebElementFacade button_login;
	
	//my account
	@FindBy(xpath = "//div[@id='center_column']//h1")
	public WebElementFacade myAccount;
	
	//invalid login validation message
	@FindBy(xpath = "//div[@class='alert alert-danger']//ol//li")
	public WebElementFacade authenticationMsg;
	
}
