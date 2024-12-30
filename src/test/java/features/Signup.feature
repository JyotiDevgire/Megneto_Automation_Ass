Feature: User Sign-Up Flow

Scenario: Sign up with valid credentials
    Given the user navigates to the sign-up page
    When the user enters valid random credentials
    And click on the create an account button 
    Then the account should be created successfully
