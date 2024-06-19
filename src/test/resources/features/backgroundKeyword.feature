Feature: Search Existing Customer for for Nop E-commerce Website
  As a user of the Nop E-commerce website
  I want to be able to search existing customer

  Background:
    Given I am on the Nop commerce login page
    When I have entered a valid username is "Username" and password is "Password"
    And I click on the login button
    Then I should be logged in successfully

    @Back
  Scenario Outline: Search existing customer in nop e-com website
    Given user click customers parent tab
    When user click customer child tab
    Then enter search details email as "<Email>" and fname as "<Firstname>" and lname as "<Lastname>" and dob of month is "<MonthOfBirth>" and day is "<DayOfBirth>"
    And user click search button
    Then I click on the logout button

      Examples:
        | Email         |  | Firstname |  | Lastname |  | MonthOfBirth |  | DayOfBirth |
        | abc@gamil.com |  | ABC       |  | XYZ      |  | 6            |  | 10          |

    @Back
  Scenario: Add new customer
    Given user click customers parent tab
    When user click customer child tab
    And I click on the add new customer button
    Then Navigate to add new customer page successfully
    And  I click on the logout button

