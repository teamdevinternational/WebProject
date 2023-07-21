Feature: Customer

  Scenario: User is able to add a new customer
   Given User launch chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And User clicks login
    Then User can view dashboard
    When User clicks on Customer menu
    And Clicks on Customer menu item
    And Clicks on Add new button
    Then User can view Add new customer page
    When User enter cutomer information
    And Click on Save buttton
    Then User can view configuration message "The new customer has been added sucessfully"
    And Close browser
    
  Scenario: User is able to modify a customer
  