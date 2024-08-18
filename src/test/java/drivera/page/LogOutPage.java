package drivera.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LogOutPage {
    private AppiumDriver<MobileElement> driver;
    public LogOutPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @AndroidFindBy(id = "Profil")
    public MobileElement Profil;
    @AndroidFindBy(id = "Settings")
    public MobileElement Settings;
    @AndroidFindBy(id = "LogOut")
    public MobileElement LogOut;
    @AndroidFindBy(xpath ="//span[text()='logged out successfully'")
    public MobileElement LogOutSuccessfullyText;

}
