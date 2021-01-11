Feature: To check the functionality of sign in

  Scenario: User is able to navigate to the url and click on sign in
    Given User navigates to the home application
    And User click on sign in button
    When User enter email address "dipali.divate14@gmail.com"
    And User click on create an account
    Then User navigates to registration form

  Scenario: User fill all the personal information into the registration form
    Given User navigates to the home application
    And User click on sign in button
   And User enter email address "dipali.divate14@gmail.com"
    And User click on create an account
    And User navigates to registration form
    When User select the title "Mrs."
    And User enter first name "Dipali"
    And User enter last name "Shinde"
    #And User enter email address "dipali.divate14@gmail.com"
    And User enter password "abc123"
    And User selects date of birth from dropdown as day "12", month "December" and year "1991"




