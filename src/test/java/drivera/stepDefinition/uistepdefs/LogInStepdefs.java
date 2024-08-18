package drivera.stepDefinition.uistepdefs;

import drivera.page.LogInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static drivera.hooks.Hooks.driver;

public class LogInStepdefs {
    LogInPage login=new LogInPage();

    @Given("The user is on the log in page")
    public void theUserIsOnTheLogInPage() {
        driver.get("drivera/loginPage");
    }

    @When("The user leaves the E-mail address field blank")
    public void theUserLeavesTheEMailAddressFieldBlank() {
        login.logInEmailBox.sendKeys("", Keys.TAB);
    }

    @And("The user clicks the Log In button")
    public void theUserClicksTheLogInButton() {
        login.logInButton.click();
    }

    @Then("The warning text ERROR: Incorrect e-mail or password should appear")
    public void theWarningTextERRORIncorrectEMailOrPasswordShouldAppear() {
       Assert.assertTrue(login.theWarningTextError.isDisplayed());
    }

    @When("The user leaves the Password address field blank")
    public void theUserLeavesThePasswordAddressFieldBlank() {
        login.logInPasswordBox.sendKeys("");
    }


    @When("The user leaves the E-mail address and Password fields blank")
    public void theUserLeavesTheEMailAddressAndPasswordFieldsBlank() {
        login.logInEmailBox.sendKeys("", Keys.TAB);
        login.logInPasswordBox.sendKeys("");
    }

    @Then("The Login button should be disabled")
    public void theLoginButtonShouldBeDisabled() {
        Assert.assertFalse(login.logInButton.isSelected());

    }
}
