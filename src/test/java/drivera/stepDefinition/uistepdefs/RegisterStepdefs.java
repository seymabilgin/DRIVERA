package drivera.stepDefinition.uistepdefs;

import drivera.page.RegisterPage;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static drivera.hooks.Hooks.driver;
import static org.testng.Assert.assertTrue;


public class RegisterStepdefs {
    RegisterPage registerPage = new RegisterPage();
    private MobileElement ddm;


    @Given("the user is on the registration page")
    public void theUserIsOnTheRegistrationPage() {
        driver.get("www.drivera/register");
    }

    @When("the user enters {string} in the Name field")
    public void theUserEntersInTheNameField(String name) {
        registerPage.nameField.sendKeys(name);
    }

    @And("the user enters {string} in the Surname field")
    public void theUserEntersInTheSurnameField(String surname) {
        registerPage.surnameField.sendKeys(surname);
    }

    @And("the user enters {string} in the E-mail address field")
    public void theUserEntersInTheEMailAddressField(String email) {
        registerPage.emailField.sendKeys(email);
    }

    @And("the user enters {string} in the Phone number field")
    public void theUserEntersInThePhoneNumberField(String phoneNumber) {
        registerPage.phoneNumberField.sendKeys(phoneNumber);

    }

    @And("the user selects {string} in the Citizenship field")
    public void theUserSelectsInTheCitizenshipField(String citizenship) {
        registerPage.citizenshipField.sendKeys(citizenship);
    }

    @And("the user enters {string} in the Birth of date field")
    public void theUserEntersInTheBirthOfDateField(String birthOfDate) {
        registerPage.birthDateField.sendKeys(birthOfDate);
    }

    @And("the user enters {string} in the Birth place field")
    public void theUserEntersInTheBirthPlaceField(String birthPlace) {
        registerPage.birthPlaceField.sendKeys(birthPlace);

    }

    @And("the user enters {string} in the Current location field")
    public void theUserEntersInTheCurrentLocationField(String currentLocation) {

        ddm = registerPage.currentLocationField;
        Select select = new Select(ddm);
        select.selectByVisibleText("New York");
    }

    @And("the user enters {string} in the Password field")
    public void theUserEntersInThePasswordField(String password) {
        registerPage.passwordField.sendKeys(password);

    }

    @And("the user enters {string} in the Confirm password field")
    public void theUserEntersInTheConfirmPasswordField(String confirmPassword) {

        registerPage.confirmPasswordField.sendKeys(confirmPassword);
    }

    @And("the user enables Two-factor authentication")
    public void theUserEnablesTwoFactorAuthentication() {
        MobileElement twoFactorAuthToggle = registerPage.twoFactorAuthToggle;
        if (!twoFactorAuthToggle.isSelected()) {
            twoFactorAuthToggle.click();
        }

    }

    @And("the user clicks the Register button")
    public void theUserClicksTheRegisterButton() {
        registerPage.registerButton.click();
    }

    @Then("the user should be successfully registered")
    public void theUserShouldBeSuccessfullyRegistered() {
        assertTrue(registerPage.welcomeText.isDisplayed());
    }

    @And("the user should see a confirmation message Registration successful")
    public void theUserShouldSeeAConfirmationMessageRegistrationSuccessful() {
        assertTrue(registerPage.successMessage.isDisplayed(), "Welcome appears.Verification successful");
    }


    @When("The user leaves the Name field blank")
    public void theUserLeavesTheNameFieldBlank() {
        registerPage.nameField.click();
    }

    @Then("The warning text First name is required should appear")
    public void theWarningTextFirstNameIsRequiredShouldAppear() {
        assertTrue(registerPage.theWarningTextFirstNameIsRequired.isDisplayed());
    }


    @When("The user leaves the Surname field blank")
    public void theUserLeavesTheSurnameFieldBlank() {
        registerPage.surnameField.click();
    }

    @Then("The warning text Last name is required should appear")
    public void theWarningTextLastNameIsRequiredShouldAppear() {
        assertTrue(registerPage.theWarningTextFirstNameIsRequired.isDisplayed());
    }


    @When("The user leaves the Phone number field empty")
    public void theUserLeavesThePhoneNumberFieldEmpty() {
        registerPage.phoneNumberField.click();
    }

    @Then("The warning text  Invalid phone number should appear")
    public void theWarningTextInvalidPhoneNumberShouldAppear() {
        assertTrue(registerPage.theWarningTextInvalidPhoneNumber.isDisplayed());
    }

    @When("The user leaves the E-mail address field empty")
    public void theUserLeavesTheEMailAddressFieldEmpty() {
        registerPage.emailField.click();
    }

    @Then("The warning text Email is required should appear")
    public void theWarningTextEmailIsRequiredShouldAppear() {
        assertTrue(registerPage.theWarningTextInvalidEmailAddress.isDisplayed());
    }

    @When("The user enters an invalid email address in the {string} E-mail address field")
    public void theUserEntersAnInvalidEmailAddressInTheEMailAddressField(String invalidEmail) {
        registerPage.emailField.sendKeys(invalidEmail);
    }

    @Then("The warning text Invalid email should appear")
    public void theWarningTextInvalidEmailShouldAppear() {
        assertTrue(registerPage.theWarningTextInvalidEmailAddress.isDisplayed());


    }

    @When("The user leaves the Citizenship field blank")
    public void theUserLeavesTheCitizenshipFieldBlank() {
        registerPage.citizenshipField.click();
    }

    @Then("The warning text Citizenship is required should appear")
    public void theWarningTextCitizenshipIsRequiredShouldAppear() {
        assertTrue(registerPage.theWarningTextCitizenshipIsRequired.isDisplayed());
    }

    @When("The user leaves the Date of birth field blank")
    public void theUserLeavesTheDateOfBirthFieldBlank() {
        registerPage.birthDateField.click();
    }

    @Then("The warning text {string} should appear")
    public void theWarningTextDateOfBirthIsRequiredShouldAppear(String BirthDateIsRequired) {
        Assert.assertEquals(registerPage.theWarningTextBirthDateIsRequired.getText(), BirthDateIsRequired);
    }

    @When("The user leaves the Password field blank")
    public void theUserLeavesThePasswordFieldBlank() {
        registerPage.passwordField.click();

    }

    @Then("The warning text Password is required should appear")
    public void theWarningTextPasswordIsRequiredShouldAppear() {
       assertTrue( registerPage.theWarningTextPasswordIsRequired.isDisplayed());
    }

    @When("The user enters an invalid password \\(short) {string}")
    public void theUserEntersAnInvalidPasswordShort(String invalidPassword) {
        registerPage.passwordField.sendKeys(invalidPassword);
    }

    @Then("The warning text Password must consist of at least eight characters should appear")
    public void theWarningTextPasswordMustConsistOfAtLeastEightCharactersShouldAppear() {
        assertTrue(registerPage.theWarningTextInvalidPassword.isDisplayed());
    }

    @When("The user leaves the Confirm Password field blank")
    public void theUserLeavesTheConfirmPasswordFieldBlank() {
        registerPage.confirmPasswordField.click();
    }

    @Then("The warning text Confirm password is required should appear")
    public void theWarningTextConfirmPasswordIsRequiredShouldAppear() {
        assertTrue(registerPage.theWarningTextConfirmPasswordIsRequired.isDisplayed());
    }

    @Then("The Birthplace field should be visible")
    public void theFieldShouldBeVisible() {
        assertTrue(registerPage.birthPlaceField.isDisplayed());

    }

    @When("The user selects a location in the Current Location field")
    public void theUserSelectsALocationInTheCurrentLocationField() {
        ddm = registerPage.currentLocationField;
        Select select = new Select(ddm);
        select.selectByVisibleText("Mersin");
    }

    @Then("The selected location should be displayed in the Current Location field")
    public void theSelectedLocationShouldBeDisplayedInTheCurrentLocationField() {
        assertTrue(ddm.getText().contains("Mersin"));
    }


    @When("The user enables the Two Factor Authentication option")
    public void theUserEnablesTheOption() {
            if (!registerPage.toggleButton.isSelected()) {
            registerPage.toggleButton.click();
            }

    }

    @Then("The Two Factor Authentication option should be enabled")
    public void theTwoFactorAuthenticationOptionShouldBeEnabled() {
        Assert.assertTrue(registerPage.toggleButton.isSelected());
    }


    @When("The user disables the Two Factor Authentication option")
    public void theUserDisablesTheTwoFactorAuthenticationOption() {
        if (registerPage.toggleButton.isSelected()) {
            registerPage.toggleButton.click();
        }
    }

    @Then("The Two Factor Authentication option should be disabled")
    public void theTwoFactorAuthenticationOptionShouldBeDisabled() {
        Assert.assertFalse(registerPage.toggleButton.isSelected());
    }

    @When("The user has not filled in all required fields")
    public void theUserHasNotFilledInAllRequiredFields() {
        registerPage.nameField.click();
        registerPage.surnameField.click();
        registerPage.emailField.click();
        registerPage.phoneNumberField.click();

    }


    @Then("The Register button shouldn't be selected")
    public void theRegisterButtonShouldnTBeSelected() {
        Assert.assertFalse(registerPage.registerButton.isSelected());
    }
}
