package starter.stepdefinitions;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import starter.pages.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

public class LoginStepdefenitions extends PageObject {
	
	LoginPage loginpo;
	
	private final int FULLSCREEN_WIDTH = 1920;

	private final int FULLSCREEN_HEIGHT = 1080;
	
	public void enlargeTestScreen() {
		Dimension currentD = getDriver().manage().window().getSize();
		if (currentD.width != FULLSCREEN_WIDTH || currentD.height != FULLSCREEN_HEIGHT) {
			Dimension fullD = new Dimension(FULLSCREEN_WIDTH, FULLSCREEN_HEIGHT - 40);
			Point targetPosition = new Point(0, 0);
			getDriver().manage().window().setSize(fullD);
			getDriver().manage().window().setPosition(targetPosition);
		}
	}

    @Given("user loads the page")
    public void loadURL() throws InterruptedException {
    	EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String Url = variables.getProperty("base.url");
		getDriver().navigate().to(Url);
		enlargeTestScreen();
		Thread.sleep(3000);
		loginpo.button_sign_in.click();
    }
    
    @When("user input username and password")
	public void userInputUsername(DataTable testData) throws Throwable {
    	Map<String, String> data = testData.asMap(String.class, String.class);
    	Thread.sleep(3000);
    	loginpo.input_username.type(data.get("username"));
    	loginpo.input_password.type(data.get("password"));
	}
    
    @Then("user clicks login")
	public void userClicksLogin() throws InterruptedException {
    	loginpo.button_login.click();
    	Thread.sleep(2000);
    	loginpo.myAccount.shouldBeVisible();
    	assertTrue(loginpo.myAccount.isDisplayed());
	}
    
    @Then("user clicks logout")
	public void userLogout() {
    	loginpo.button_sign_out.click();
	}
    
    @When("user input invalid username and password")
	public void userInputInvalidUsername(DataTable testData) throws Throwable {
    	Map<String, String> data = testData.asMap(String.class, String.class);
    	Thread.sleep(3000);
    	loginpo.input_username.type(data.get("username"));
    	loginpo.input_password.type(data.get("password"));
	}
    
    @Then("user verify authentication message")
	public void authenticationMessage(DataTable testData) throws InterruptedException {
    	Map<String, String> data = testData.asMap(String.class, String.class);
		assertEquals(data.get("message"), loginpo.authenticationMsg.getAttribute("innerText"));
	}

}
