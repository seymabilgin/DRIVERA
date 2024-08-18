@UI_TEST
@UISetUp
@UICloseDriver
@LOGOUT
Feature:US03:As a user, I want to be able to log out of the application securely

  @TC19
  Scenario:TC19:The user should be able to log out by clicking the ‘Log Out’ button on the settings screen.
    Given The user is logged in and on the settings screen
    When The user clicks the Log Out button
    Then The user should be logged out successfully


  @TC20
  Scenario:TC20:After logging out, the user should be directed to the login screen.
    Given The user is logged in and on the settings screen
    When The user clicks the Log Out button
    Then The user should be redirected to the login page