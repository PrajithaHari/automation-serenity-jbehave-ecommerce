package starter.stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import starter.pages.HomePage;

public class HomeStepdefinitions extends PageObject {
	
	HomePage homepage;
	
	@Then("user search for a product")
	public void userSearchProduct(DataTable testData) throws InterruptedException {
		Map<String, String> data = testData.asMap(String.class, String.class);
		homepage.search.type(data.get("product"));
		homepage.srchSubmit.click();
	}
	
	@And("user select a product and adding to cart productName")
	public void selectProduct(DataTable testData) throws InterruptedException {
		Map<String, String> data = testData.asMap(String.class, String.class);
		homepage.itemSelect(data.get("productName")).click();
		Thread.sleep(3000);
		homepage.addCartBtn.click();
	}
	
	@Then("user proceed to checkout")
	public void proceedCheckout() throws InterruptedException {
		homepage.proceed.click();
		homepage.checkoutBtn.click();
		homepage.checkoutBtn.click();
		Thread.sleep(5000);
		Actions actions = new Actions(getDriver());
		actions.moveToElement(homepage.termsCdtn());
		actions.click().build().perform();
		homepage.checkoutBtn.click();
	}
	
	@Then("user choose payment method")
	public void paymentMethod(DataTable testData) throws InterruptedException {
		Map<String, String> data = testData.asMap(String.class, String.class);
		homepage.paymenttype(data.get("method")).click();
		homepage.confirmOrder.click();
	}
	
	@Then("user verify order confirmation message")
	public void orderConfirmation(DataTable testData) throws InterruptedException {
		Map<String, String> data = testData.asMap(String.class, String.class);
		assertEquals(data.get("message"), homepage.orderConfirmation.getAttribute("innerText"));
	}
	
	@And("user verify success message")
	public void successMessage(DataTable testData) throws InterruptedException {
		Map<String, String> data = testData.asMap(String.class, String.class);
		assertEquals(data.get("message"), homepage.successMsg.getAttribute("innerText"));
	}
	
	@Then("user verify cart count")
	public void cartCount(DataTable testData) throws InterruptedException {
		Map<String, String> data = testData.asMap(String.class, String.class);
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Continue shopping']")));
		homepage.continueShpng.click();
		assertEquals(data.get("count"), homepage.cartCount.getAttribute("innerText"));
	}
	
}
