@LoginPageFeature
Feature: Login Page Feature
  This is general login functionality for the mock website I created with C sharp MVC 5

	@RegressionTest
  Scenario: Username Is Required
    Given we are at the login page
    When we login with an empty username field 
    Then a validation message is displayed that indicates username is a required field


	@RegressionTest
  Scenario: Password Is Required
    Given we are at the login page
    When we login with an empty password field 
    Then a validation message is displayed that indicates password is a required field
      
      
  @RegressionTest
  Scenario: Username and Password Are Required
    Given we are at the login page
    When we login with an empty username field and an empty password field 
    Then a validation message is displayed that indicates username is a required field
		And a validation message is displayed that indicates password is a required field