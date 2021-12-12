package starter.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import starter.pages.LoginPage;
import starter.pages.RegistrationPage;

public class RegistrationStepdefenitions extends PageObject {
	
	RegistrationPage registrationgpo;
	LoginPage loginpo;
	
	@When("user input email and click create account")
	@Then("user input valid email and click create account")
    public void createUser() throws InterruptedException {
		Thread.sleep(3000);
        String email = String.format("automationqa+%s@gmail.com", new Random().nextInt(10000));
        registrationgpo.email_create.type(email);
        registrationgpo.createAccBtn.click();
    }
	
	@Then("user input mandatory fields")
	public void userInputMandatoryFields(DataTable testData) throws Throwable {
    	Thread.sleep(10000);
    	List<String> fields = testData.asList(String.class);
    	registrationgpo.firstname.type(fields.get(0));
    	registrationgpo.lastname.type(fields.get(1));
    	registrationgpo.password.type(fields.get(2));
    	registrationgpo.address.type(fields.get(3));
    	registrationgpo.city.type(fields.get(4));
    	Actions actions = new Actions(getDriver());
    	actions.moveToElement(registrationgpo.selectState());
		actions.click().build().perform();
		registrationgpo.stateValue.click();
    	registrationgpo.zipcode.type(fields.get(5));
    	registrationgpo.phone.type(fields.get(6));
    	registrationgpo.submitBtn.click();
	}
	
	 @Then("user verify the account creation")
		public void userClicksLogin() throws InterruptedException {
	    	Thread.sleep(2000);
	    	loginpo.myAccount.shouldBeVisible();
	    	assertTrue(loginpo.myAccount.isDisplayed());
	}
	 
	 @Then("user verifies validation messages")
		public void userVerifyValidationMsg(DataTable testData) throws InterruptedException {
		 List<String> messages = testData.asList(String.class);
		 List <WebElement> list = getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//ol//li"));
		 int i =0;
		 for (WebElement li : list) {
				assertEquals(messages.get(i), li.getAttribute("innerText"));
				i++;
			}
		}
	 
	 @Then("user clicks submit button without entering mandatory fields")
		public void createUserSubmit() {
		 registrationgpo.submitBtn.click();
		}
	 

}
