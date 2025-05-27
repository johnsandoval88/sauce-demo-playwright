package sauceDemoFunctions;

import java.nio.file.Paths;
import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.options.WaitForSelectorState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import sauceLocators.SDLocators;

public class sauceFunctions {
    Playwright playwright;
    Browser browser;
    Page page;
    SDLocators sDLocators;

   //Setup
    public void setUp() {
        playwright = Playwright.create(); 
        browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
        page = browser.newPage();
        sDLocators = new SDLocators(page);
    }
		
    
    public void login(sauceUser user) {
    	
    	page.navigate("https://www.saucedemo.com/");
    	
		sDLocators.usernameInput.fill(user.getUsername());
		sDLocators.passwordInput.fill(user.getPassword());
		sDLocators.loginButton.click();
	    
		}
    
    public void verifyLogin() {
        String currentUrl = page.url();

        if (currentUrl.contains("inventory.html")) {
        	assertThat(sDLocators.productName).isVisible();
            System.out.println("User successfully logged in and inventory is visible.");
        } else {
        	assertThat(sDLocators.errorMessage).isVisible();
            System.out.println("Login failed");
            ScreenshotOptions screenshotOptions = new ScreenshotOptions();
            page.screenshot(screenshotOptions.setPath(Paths.get("./scr/login-failed.png")));
            page.close();
            browser.close();
            playwright.close();
        }
    }
    
    public void filterProducts(String option) {
    	sDLocators.filterProducts.isVisible();
    	sDLocators.filterProducts.click();
    	sDLocators.filterProducts.selectOption(option);
    	System.out.println("Successfully filtered products");
    }
    
    public void addToCart() {
   
    	sDLocators.addToCartBtn.click();
    	System.out.println("Successfully added to cart");
    	sDLocators.cartBadge.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
    	assertThat(sDLocators.cartBadge).hasText("1");
    	sDLocators.cartBtn.click();
    	assertThat(sDLocators.cartItem).isVisible();
    	assertThat(sDLocators.cartItemPrice).isVisible();
    	System.out.println("Item in cart displayed successfully");
    }
    
    public void fillInformation() {
    	sDLocators.checkoutBtn.click();
    	sDLocators.firstName.fill("Test");
    	sDLocators.lastName.fill("User");
    	sDLocators.contBtn.click();
    	assertThat(sDLocators.infoError).isVisible();
    	sDLocators.zipPostalCode.fill("1740");
    	System.out.println("Succcessfully fill in First Name, Last Name and Zip/Postal Code");
    }
    
    public void checkoutSummary() {
    	sDLocators.contBtn.click();
    	assertThat(sDLocators.cartItem).isVisible();
    	assertThat(sDLocators.cartItemPrice).isVisible();
    	assertThat(sDLocators.paymentInfo).isVisible();
    	assertThat(sDLocators.shippingInfo).isVisible();
    	assertThat(sDLocators.subTotal).isVisible();
    	assertThat(sDLocators.taxTotal).isVisible();
    	assertThat(sDLocators.totalBill).isVisible();
    	System.out.println("Checkout summary displayed successfully");
    }
    
    public void orderCompleted() {
    	sDLocators.finishBtn.click();
    }
    
    public void orderConfirmation() {
    	assertThat(sDLocators.orderConfirmed).hasText("Thank you for your order!");
    	System.out.println("Order checkout completed successfully");
    }
    
    public void logoutUser() {
    	sDLocators.backHomeBtn.click();
    	sDLocators.sideNavBtn.click();
    	sDLocators.logoutLink.click();
    	assertThat(sDLocators.loginButton).isVisible();
    	System.out.println("User successfully logged out");
    }
    
   
        
    public void endTest() {
    	page.close();
        browser.close();
        playwright.close();
    }


}
