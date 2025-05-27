package sauceLocators;
import com.microsoft.playwright.*;

public class SDLocators {
	public Locator usernameInput;
    public Locator passwordInput;
    public Locator loginButton;
    public Locator errorMessage;
    public Locator productName;
    public Locator filterProducts;
    public Locator addToCartBtn;
    public Locator cartBtn;
    public Locator cartBadge;
    public Locator cartItem;
    public Locator cartItemPrice;
    public Locator checkoutBtn;
    public Locator firstName;
    public Locator lastName;
    public Locator zipPostalCode;
    public Locator contBtn;
    public Locator infoError;
    public Locator paymentInfo;
    public Locator shippingInfo;
    public Locator subTotal;
    public Locator taxTotal;
    public Locator totalBill;
    public Locator finishBtn;
    public Locator orderConfirmed;
    public Locator backHomeBtn;
    public Locator sideNavBtn;
    public Locator logoutLink;
    
    
	public SDLocators(Page page) {
		//Login page locators
		this.usernameInput = page.locator("//input[@id='user-name']");
        this.passwordInput = page.locator("input[data-test='password']");
        this.loginButton = page.locator("input[data-test='login-button']");
        this.errorMessage = page.locator("[data-test='error']");
        
        //Main page locators
        this.productName = page.locator("a#item_4_title_link>div");
        this.filterProducts = page.locator("//select[@class='product_sort_container']");
        this.addToCartBtn = page.locator("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
        this.cartBtn = page.locator("//div[@id='shopping_cart_container']");
        this.cartBadge = page.locator("//span[@class='shopping_cart_badge']");
        
        //Checkout page locators
        this.cartItem = page.locator("//div[@class='inventory_item_name']");
        this.cartItemPrice = page.locator("//div[@class='inventory_item_price']");
        this.checkoutBtn = page.locator("//button[@id='checkout']");
        this.firstName = page.getByPlaceholder("First Name");
        this.lastName = page.getByPlaceholder("Last Name");
        this.zipPostalCode = page.getByPlaceholder("Zip/Postal Code");
        this.contBtn = page.locator("//input[@id='continue']");
        this.infoError = page.locator("//h3[@data-test='error']");
        this.paymentInfo = page.locator("//div[@data-test='payment-info-value']");
        this.shippingInfo = page.locator("//div[@data-test='shipping-info-value']");
        this.subTotal = page.locator("//div[@data-test='subtotal-label']");
        this.taxTotal = page.locator("//div[@data-test='tax-label']");
        this.totalBill = page.locator("//div[@data-test='total-label']");
        this.finishBtn = page.locator("//button[@id='finish']");
        this.orderConfirmed = page.locator("//div//h2[@class='complete-header']");
        
        //Logout locators
        this.backHomeBtn = page.locator("//button[@id='back-to-products']");
        this.sideNavBtn = page.locator("//button[@id='react-burger-menu-btn']");
        this.logoutLink = page.locator("//a[@id='logout_sidebar_link']");
       
        
	}

}
