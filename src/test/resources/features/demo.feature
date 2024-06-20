Feature: Gmail Login

  As a user of the Nop E-commerce website

  Scenario: Successful login with valid credentials
    Given I am on the Nop commerce login page
    When I have entered a valid username and password
    And I click on the login button
    Then I should be logged in successfully
    And I click on the logout button