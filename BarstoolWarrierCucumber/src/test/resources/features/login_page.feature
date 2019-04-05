@LoginPageFeature
Feature: Login Page Feature
  This is general login functionality for the mock website I created with Csharp MVC 5

  @SmokeTest
  Scenario Outline: Valid Login
    Given we are at the login page
    When we login with username <username> and password <password>
    Then we are relocated to Page One

    Examples: 
      | username | password |
      | mduncan  | Test1234 |
      | sharford | Test1234 |
      | tkubin   | Test1234 |
      | eangone  | Test1234 |


  @RegressionTest
  Scenario Outline: Invalid Username and Password Combination
    Given we are at the login page
    When we login with username <username> and password <password>
    Then a validation message for an invalid username and password combination is displayed

    Examples: 
      | username | password |
      | mduncan  | None1234 |
      | abcxyz   | Test1234 |


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
      