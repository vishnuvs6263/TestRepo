Feature: To test login functionality

  Scenario Outline: Check login is suuccessful with valid credentials
    Given user is on the login page
    When user enters username and password
    And click on login button
    Then user is able to add biller
    Then user is able to add beneficiary
