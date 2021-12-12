package starter.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends PageObject {
	
	//search
	@FindBy(id = "search_query_top")
	public WebElementFacade search;
	
	//searchSubmit
	@FindBy(name = "submit_search")
	public WebElementFacade srchSubmit;
	
	//item
	public WebElementFacade itemSelect(String item) {
		return findBy("//h5//a[contains(text(),'" + item + "')]");
	}
	
	//searchSize
	@FindBy(id = "group_1")
	public WebElementFacade itemSize;
	
	public void selectDropDownValues(){
		itemSize.selectByVisibleText("M");
		}
	
	//addToCart
	@FindBy(id = "add_to_cart")
	public WebElementFacade addCartBtn;
	
	//proceed
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	public WebElementFacade proceed;
	
	//checkoutBtn
	@FindBy(xpath = "//p[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]")
	public WebElementFacade checkoutBtn;
	
	//form
	@FindBy(xpath = "//*[@id='form']")
	public WebElementFacade forms;
	
	//terms and condition
	public WebElementFacade termsCdtn() {
		return forms.findBy("//div[@id='uniform-cgv']//span//input[@id='cgv']");
	}
	
	//terms
	@FindBy(xpath = "//*[@id='form']//div[@id='uniform-cgv']//span//input[@id='cgv']")
	public WebElementFacade terms;
	
	//paymentType 'Pay by check.'/'Pay by bank wire'
	public WebElementFacade paymenttype(String type) {
		return findBy("//a[@title='" + type + "']");
	}
	
	//confirmOrder
	@FindBy(xpath = "//button[@type='submit']//span[contains(text(),'I confirm my order')]")
	public WebElementFacade confirmOrder;
	
	//orderConfirmation 'Order confirmation'
	@FindBy(xpath = "//div[@id='center_column']//h1")
	public WebElementFacade orderConfirmation;
	
	//successMsg 'Your order on My Store is complete.'
	@FindBy(xpath = "//div[@id='center_column']//div//p//strong")
	public WebElementFacade successMsg;
	
	//continue shopping
	@FindBy(xpath = "//span[@title='Continue shopping']")
	public WebElementFacade continueShpng;
	
	//continue shopping in cart page
	@FindBy(xpath = "//a[@title='Continue shopping' and @class='button-exclusive btn btn-default']")
	public WebElementFacade cartCntShpBtn;
	
	//cart count
	@FindBy(xpath = "//b[contains(text(),'Cart')]/../span")
	public WebElementFacade cartCount;

}
