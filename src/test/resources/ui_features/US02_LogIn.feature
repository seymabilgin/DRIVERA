@UI_TEST
@UISetUp
@UICloseDriver
@LOGIN
Feature: US02:I should be able to log in to the application page as a user

  Background:
    Given The user is on the log in page
@TC16
  Scenario:TC16:Given The user is on the registration page
    When The user leaves the E-mail address field blank
    And The user clicks the Log In button
    Then The warning text ERROR: Incorrect e-mail or password should appear
@TC17
  Scenario:TC17:Password must be entered, if left blank, the warning text ‘ERROR: Incorrect e-mail or password’ warning text should appear.
    When The user leaves the Password address field blank
    And The user clicks the Log In button
    Then The warning text ERROR: Incorrect e-mail or password should appear
 @TC18
 Scenario:TC18:Login button should not be clickable without entering the email address and password, login to the page should be possible by clicking the login button
   When The user leaves the E-mail address and Password fields blank
   And The user clicks the Log In button
   Then The Login button should be disabled

