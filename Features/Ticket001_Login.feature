Feature: Login

Background: Here are the common steps for every scenario
		Given User launch chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And User clicks login


Scenario: User is able to login in and out of the system
    Then Verify page title is "Dashboard / nopCommerce administration"
    When User clicks on Logout link
    Then Verify page title is "Your store. Login"
    And Close Browser
    
