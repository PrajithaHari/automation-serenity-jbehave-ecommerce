package starter.pages;

import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegistrationPage extends PageObject {
	
	//email_create
	@FindBy(id = "email_create")
	public WebElementFacade email_create;
	
	//createAccount button
	@FindBy(id = "SubmitCreate")
	public WebElementFacade createAccBtn;
	
	//firstname
	@FindBy(id = "customer_firstname")
	public WebElementFacade firstname;
	
	//lastname
	@FindBy(id = "passwd")
	public WebElementFacade password;
	
	//password
	@FindBy(id = "customer_lastname")
	public WebElementFacade lastname;
	
	//address1
	@FindBy(id = "address1")
	public WebElementFacade address;
	
	//city
	@FindBy(id = "city")
	public WebElementFacade city;
	
	//form
	@FindBy(xpath = "//*[@id='account-creation_form']")
	public WebElementFacade forms;
	
	//state
	@FindBy(xpath = "//select[@id='id_state']")
	public WebElementFacade state;
	
	//stateValue
	@FindBy(xpath = "//option[text()='Kentucky']")
	public WebElementFacade stateValue;
	
	public WebElementFacade selectState() {
		return forms.findBy("//select[@id='id_state']");
	}
	
	public void  selectStates() {
		Select drpCountry = new Select(selectState());
		drpCountry.selectByVisibleText("Kentucky");
	}
	
	//country
	@FindBy(id = "id_country")
	public WebElementFacade country;
	
	//zipcode
	@FindBy(id = "postcode")
	public WebElementFacade zipcode;
	
	//phone
	@FindBy(id = "phone_mobile")
	public WebElementFacade phone;
	
	//registerBtn
	@FindBy(id = "submitAccount")
	public WebElementFacade submitBtn;
	
	//validation message
	@FindBy(xpath = "//div[@class='alert alert-danger']//ol//li")
	public WebElementFacade validationMsg;

}
