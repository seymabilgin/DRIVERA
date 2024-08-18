package drivera.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class RegisterPage {
    private AppiumDriver<MobileElement> driver;

    public RegisterPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(id = "com.example.yourapp:id/nameField")
    public MobileElement nameField;

    @AndroidFindBy(id = "com.example.yourapp:id/surnameField")
    public MobileElement surnameField;

    @AndroidFindBy(id = "com.example.yourapp:id/emailField")
    public MobileElement emailField;

    @AndroidFindBy(id = "com.example.yourapp:id/phoneNumberField")
    public MobileElement phoneNumberField;

    @AndroidFindBy(id = "com.example.yourapp:id/citizenshipField")
    public MobileElement citizenshipField;

    @AndroidFindBy(id = "com.example.yourapp:id/birthDateField")
    public MobileElement birthDateField;

    @AndroidFindBy(id = "com.example.yourapp:id/birthPlaceField")
    public MobileElement birthPlaceField;

    @AndroidFindBy(id = "com.example.yourapp:id/currentLocationField")
    public MobileElement currentLocationField;

    @AndroidFindBy(id = "com.example.yourapp:id/passwordField")
    public MobileElement passwordField;

    @AndroidFindBy(id = "com.example.yourapp:id/confirmPasswordField")
    public MobileElement confirmPasswordField;

    @AndroidFindBy(id = "com.example.yourapp:id/twoFactorAuthToggle")
    public MobileElement twoFactorAuthToggle;

    @AndroidFindBy(id = "com.example.yourapp:id/registerButton")
    public MobileElement registerButton;

    @AndroidFindBy(xpath = "//span[text()='Welcome']")
    public MobileElement welcomeText;

    @AndroidFindBy(id = "com.example.yourapp:id/successMessage")
    public MobileElement successMessage;

    @AndroidFindBy(className = "nameIsRequired")
    public MobileElement theWarningTextFirstNameIsRequired;
    @AndroidFindBy(className = "LastnameIsRequired")
    public MobileElement theWarningTextLastNameIsRequired;
    @AndroidFindBy(className = "PhoneNumberIsRequired")
    public MobileElement theWarningTextInvalidPhoneNumber;
    @AndroidFindBy(id= "EmailAddressIsRequired")
    public MobileElement theWarningTextInvalidEmailAddress;

    @AndroidFindBy(xpath ="//input[@id='CitizenshipIsRequired'")
    public MobileElement theWarningTextCitizenshipIsRequired;

    @AndroidFindBy(xpath ="//input[@id='BirthDateIsRequired'")
    public MobileElement theWarningTextBirthDateIsRequired;

    @AndroidFindBy(xpath ="//input[@id='PasswordIsRequired'")
    public MobileElement theWarningTextPasswordIsRequired;
    @AndroidFindBy(xpath ="//input[@id='PasswordIsRequired'")
    public MobileElement theWarningTextInvalidPassword;
    @AndroidFindBy(xpath ="//input[@id='PasswordIsRequired'")
    public MobileElement theWarningTextConfirmPasswordIsRequired;
    @AndroidFindBy(xpath ="//input[@id='toggleButton'")
    public MobileElement toggleButton;


}
