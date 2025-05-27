package stepDefinitions;

import io.cucumber.java.en.*;
import sauceDemoFunctions.sauceFunctions;
import sauceDemoFunctions.sauceUser;
import sauceDemoFunctions.filterOptions;

public class SauceSteps {
	
	    sauceFunctions sf = new sauceFunctions();
	   
	    @Given("the user navigates to the Swag Labs website")
	    public void userNavigatesToSwagLabs() {
	    	sf.setUp();
	    }
	    
	    @And("the user logs in with username \"standard_user\" and password \"secret_sauce\"")
	    public void userLogsInWithStandardUser() {
	    	sf.login(sauceUser.STANDARD);
	    }
	    
	    @And("the user logs in with username \"locked_out_user\" and password \"secret_sauce\"")
	    public void userLogsInWithLockedUser() {
	    	sf.login(sauceUser.LOCKED_OUT);
	    }
	    
	    @Then("the inventory page should be displayed")
	    public void verifyLoginResults() {
	    	sf.verifyLogin();
	    }
	    
	    @Then("an error message should be displayed indicating the user is locked out")
	    public void verifyLockedLoginResults() {
	    	sf.verifyLogin();
	    }
	    
	    @When("the user filters products by {string}")
	    public void userFiltersProductsBy(String option) {
	        if (option.equals("hilo")) {
	            sf.filterProducts(filterOptions.PRICE_HIGH_LOW.getValue());
	        }
	    }
	    
	    @And("the user adds a product to the cart")
	    public void userAddsProductToCart() {
	    	sf.addToCart();
	    }
	    
	    @And("the user proceeds to checkout to enter user information")
	    public void userInputsInformation() {
	    	sf.fillInformation();
	    }
	    
	    @Then("the checkout summary should be displayed")
	    public void checkoutSummaryDisplayed() {
	    	sf.checkoutSummary();
	    }
	    
	    @When("the user confirms the purchase")
	    public void userConfirmsPurchase() {
	    	sf.orderCompleted();
	    }
	    
	    @Then("an order confirmation message should be displayed")
	    public void confirmationMessageDisplayed() {
	    	sf.orderConfirmation();
	    }
	    
	    @And("the user logs out from the application")
	    public void userLogsOut() {
	    	sf.logoutUser();
		    sf.endTest();
	    }

	}
