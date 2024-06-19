Feature: Login Functionality for Nop E-commerce Website

  As a user of the Nop E-commerce website

  Background:
    Given I am on the Nop commerce login page

   @Paral
  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully
  @Paral
  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username            | password | error_message                                                    |
      | abc@email.com       | admin1   | Login was unsuccessful. Please correct the errors and try again. |
      | xys@gmail.com       | admin    | Login was unsuccessful. Please correct the errors and try again. |
      | admin@yourstore.com | admin14  | Login was unsuccessful. Please correct the errors and try again. |


