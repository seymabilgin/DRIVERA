package drivera.stepDefinition.uistepdefs;

import drivera.page.LogInPage;
import drivera.page.LogOutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static drivera.hooks.Hooks.driver;

public class LogOutStepdefs {
    LogInPage login = new LogInPage();
    LogOutPage logout = new LogOutPage();

    @Given("The user is logged in and on the settings screen")
    public void theUserIsLoggedInAndOnTheSettingsScreen() {
        login.logInEmailBox.sendKeys("john@gmail.com");
        login.logInPasswordBox.sendKeys("John123!!");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logout.Profil.click();
        logout.Settings.click();
    }

    @When("The user clicks the Log Out button")
    public void theUserClicksTheButton() {
        logout.LogOut.click();
    }

    @Then("The user should be logged out successfully")
    public void theUserShouldBeLoggedOutSuccessfully() {
        Assert.assertTrue(logout.LogOutSuccessfullyText.isDisplayed());
    }

    @And("The user should be redirected to the login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        Assert.assertTrue(login.logInEmailBox.isDisplayed());
    }
}
