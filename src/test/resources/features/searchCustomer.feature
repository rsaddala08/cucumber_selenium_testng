Feature: Search Existing Customer for for Nop E-commerce Website
  As a user of the Nop E-commerce website
  I want to be able to search existing customer

  Scenario: Successful login with valid credentials
    Given I am on the Nop commerce login page
    When I have entered a valid username is "Username" and password is "Password"
    And I click on the login button
    Then I should be logged in successfully
    And I click on the logout button

  Scenario Outline: Search existing customer in nop e-com website
    Given I am on the Nop commerce login page
    When I have entered a valid username is "Username" and password is "Password"
    And I click on the login button
    When user click customers parent tab
    And user click customer child tab
    Then enter search details email as "<Email>" and fname as "<Firstname>" and lname as "<Lastname>" and dob of month is "<MonthOfBirth>" and day is "<DayOfBirth>"
    And user click search button

    Examples:
      | Email         |  | Firstname |  | Lastname |  | MonthOfBirth |  | DayOfBirth |
      | abc@gamil.com |  | ABC       |  | XYZ      |  | 6            |  | 10          |
