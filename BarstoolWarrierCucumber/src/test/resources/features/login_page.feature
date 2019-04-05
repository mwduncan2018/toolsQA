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


  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
