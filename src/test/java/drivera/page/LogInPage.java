package drivera.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LogInPage {
    private AppiumDriver<MobileElement> driver;

    public LogInPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
    @AndroidFindBy(id = "id/emailField")
    public MobileElement logInEmailBox;
    @AndroidFindBy(id = "id/emailField")
    public MobileElement logInPasswordBox;

    @AndroidFindBy(id = "id/LogInButton")
    public MobileElement logInButton;
    @AndroidFindBy(id = "id/theWarningTextError")
    public MobileElement theWarningTextError;



}
