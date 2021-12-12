Feature: E-commerce

  Scenario: Login to the website as exisiting user
    Given user loads the page
    When user input username and password
	    | username | huprajithatest1@gmail.com |
	    | password | Sample |
    Then user clicks login
    
  Scenario: Purchase a product
  	Given user loads the page
    When user input username and password
	    | username | huprajithatest1@gmail.com |
	    | password | Sample |
    Then user clicks login
    Then user search for a product
    	| product | shirt | 
    And user select a product and adding to cart productName
    	| productName | Printed Chiffon Dress |
    Then user proceed to checkout
    Then user choose payment method
     	| method | Pay by bank wire |
    Then user verify order confirmation message
    | message | ORDER CONFIRMATION |
    And user verify success message
    | message | Your order on My Store is complete. |
    Then user clicks logout
    
  Scenario: Sign up as a new user
  	Given user loads the page
    When user input email and click create account
    Then user input mandatory fields 
    | Testing |
    | Sample |
    | Password |
    | TestAddress |
    | SampleCity |
    | 40170 |
   	| 808973648291 |
		Then user verify the account creation
		Then user clicks logout
		
	Scenario: Verifying cart count after adding multiple product
  	Given user loads the page
    When user input username and password
	    | username | huprajithatest1@gmail.com |
	    | password | Sample |
    Then user clicks login
    Then user search for a product
    	| product | shirt | 
    And user select a product and adding to cart productName
    	| productName | Printed Chiffon Dress |
		Then user verify cart count
			| count| 1 |
		Then user search for a product
    	| product | shirt | 
    And user select a product and adding to cart productName
    	| productName | Faded Short Sleeve T-shirts |
    Then user verify cart count
			| count| 2 |
    Then user clicks logout
    
  Scenario: Negative scenario - Verifying validation messages for invalid login and mandatory fields
  	Given user loads the page
    When user input invalid username and password
	    | username | huprajithatest1@gmail.com |
	    | password | Sampleee |
    Then user clicks login
    Then user verify authentication message
    	| message| Authentication failed. |
  	Then user input valid email and click create account
  	Then user clicks submit button without entering mandatory fields
  	Then user verifies validation messages
  		| You must register at least one phone number. |
  		| lastname is required. |
  		| firstname is required. |
  		| passwd is required. |
  		| address1 is required. |
  		| city is required.|
  		| The Zip/Postal code you've entered is invalid. It must follow this format: 00000 |
  		| This country requires you to choose a State. |

    

