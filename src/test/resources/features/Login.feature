Feature: Login feature
  Background:
    Given I open Login Page

  Scenario: Login Success
    When I enter email "nita.jadhav@testpro.io"
    And I enter password "te$t$tudent"
    And I click submit
    Then I am logged in

  Scenario: Login With Not Existing Email
    When I enter email "Notexisting@gmail.com"
    And I enter password "te$t$tudent"
    And I click submit
    Then I am not logged in

  Scenario: Login With Incorrect Password
    When I enter email "nita.jadhav@testpro.com"
    And I enter password "Incorrect"
    And I click submit
    Then I am not logged in

  Scenario: Login With Empty Email
    When I enter email " "
    And I enter password "te$t$tudent"
    And I click submit
    Then I am not logged in

  Scenario: Login With Empty Password
    When I enter email "nita.jadhav@testpro.com"
    And I enter password " "
    And I click submit
    Then I am not logged in
