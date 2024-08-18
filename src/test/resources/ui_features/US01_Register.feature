@UI_TEST
@UISetUp
@UICloseDriver
@REGISTER
Feature:US01:I must be able to register as a user in the application.

  Background:
    Given the user is on the registration page

  @TC01
  Scenario:TC01:Successful user registration with valid details
    When the user enters "John" in the Name field
    And the user enters "Doe" in the Surname field
    And the user enters "john.doe@example.com" in the E-mail address field
    And the user enters "1234567890" in the Phone number field
    And the user selects "United States" in the Citizenship field
    And the user enters "01/01/1990" in the Birth of date field
    And the user enters "New York" in the Birth place field
    And the user enters "New York" in the Current location field
    And the user enters "SecurePassword123!" in the Password field
    And the user enters "SecurePassword123!" in the Confirm password field
    And the user enables Two-factor authentication
    And the user clicks the Register button
    Then the user should be successfully registered
    And the user should see a confirmation message Registration successful

  @TC02
  Scenario:TC02:First Name must be entered, when this field is blank, the warning text ‘First name is required’ should appear
    When The user leaves the Name field blank
    And  the user clicks the Register button
    Then The warning text First name is required should appear

  @TC03
  Scenario:TC03:Last Name must be entered, when this field is blank, the warning text ‘Last name is required’ should appear
    When The user leaves the Surname field blank
    And  the user clicks the Register button
    Then The warning text Last name is required should appear

  @TC04
  Scenario:TC04:Phone Number must be entered. When this field is empty, the warning text ‘Invalid phone number’ should appear
    When The user leaves the Phone number field empty
    And  the user clicks the Register button
    Then The warning text  Invalid phone number should appear

  @TC05
  Scenario:TC05:Email must be entered, when this field is empty, the warning text ‘Email is required’ should appear
    When The user leaves the E-mail address field empty
    And  the user clicks the Register button
    Then The warning text Email is required should appear

  @TC06
  Scenario:TC06:Email address must be in abc@abc.com format, ‘Invalid email’ warning text should appear in email addresses entered without using @ and .
    When The user enters an invalid email address in the "johngmailcom" E-mail address field
    And the user clicks the Register button
    Then The warning text Invalid email should appear

  @TC07
  Scenario:TC07:Citizenship must be entered, when this field is blank, the warning text ‘Citizenship is required’ must be displayed.
    When The user leaves the Citizenship field blank
    And  the user clicks the Register button
    Then The warning text Citizenship is required should appear

  @TC08
  Scenario:TC08:Date of birth is required, ‘Date of birth is required’ warning text should appear when this field is blank.
    When The user leaves the Date of birth field blank
    And  the user clicks the Register button
    Then The warning text 'Date of birth is required' should appear

  @TC09
  Scenario:TC09:Password must be entered, when this field is blank, the warning text ‘Password is required’ should appear.
    When The user leaves the Password field blank
    And  the user clicks the Register button
    Then The warning text Password is required should appear

  @TC10
  Scenario:TC10:Password must consist of at least 8 characters. It must contain uppercase letters, lowercase letters, numbers and special characters.
    When The user enters an invalid password (short) "!John02"
    And  the user clicks the Register button
    Then The warning text Password must consist of at least eight characters should appear

  @TC11
  Scenario:TC11:Confirm Password, when this field is blank, the warning text Confirm password is required should appear.
    When The user leaves the Confirm Password field blank
    And  the user clicks the Register button
    Then The warning text Confirm password is required should appear

  @TC12
  Scenario:TC12:Birthplace field must be visible
    Then The Birthplace field should be visible

  @TC13
  Scenario:TC13:Current Location must be selectable
    When The user selects a location in the Current Location field
    Then The selected location should be displayed in the Current Location field

  @TC14
  Scenario:TC14:Two Factor authentication option should be changeable
    When The user enables the Two Factor Authentication option
    Then The Two Factor Authentication option should be enabled
    When The user disables the Two Factor Authentication option
    Then The Two Factor Authentication option should be disabled

  @TC15
  Scenario:TC15:Register button should not be active without entering the required information
    When The user has not filled in all required fields
    And  the user clicks the Register button
    Then The Register button shouldn't be selected

