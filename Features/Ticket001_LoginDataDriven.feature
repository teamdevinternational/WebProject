@RegressionFeature
Feature: Login Data Driven

   @regressiontest
  Scenario Outline: Sucessful login with valid credentials
    Given User launch chrome browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    And User enters email as "<email>" and password as "<password>"
    And User clicks login
    Then Verify page title is "Dashboard / nopCommerce administration"
    When User clicks on Logout link
    Then Verify page title is "Your store. Login"
    And Close Browser

    Examples: 
      |email|password|
      |admin@yourstore.com|admin| 
      |admin1@yourstore.com|admin123|