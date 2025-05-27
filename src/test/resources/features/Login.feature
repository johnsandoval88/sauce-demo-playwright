Feature: Sauce Demo End-to-End Test

  Scenario: Standard user completes a purchase successfully
    Given the user navigates to the Swag Labs website
    And the user logs in with username "standard_user" and password "secret_sauce"
    Then the inventory page should be displayed

    When the user filters products by "Price (High to Low)"
    And the user adds a product to the cart
    And the user proceeds to checkout to enter user information
    Then the checkout summary should be displayed

    When the user confirms the purchase
    Then an order confirmation message should be displayed
    And the user logs out from the application

    
   Scenario: Locked out user attempts to login
    Given the user navigates to the Swag Labs website
    And the user logs in with username "locked_out_user" and password "secret_sauce"
    Then an error message should be displayed indicating the user is locked out