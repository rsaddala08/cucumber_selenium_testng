Feature: Login Functionality for Nop E-commerce Website

  As a user of the Nop E-commerce website
  I want to be able to log in with my account
  So that I can access my account-related features and manage my orders

  @Table
  Scenario: Successful login with valid credentials
    Given I am on the Nop commerce login page
    When I have entered a valid username and password with list data
     | admin@yourstore.com | admin |
    And I click on the login button
    Then I should be logged in successfully
    And I click on the logout button
