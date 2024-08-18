package drivera.hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileElement;


public class Hooks {
//--------------------UI------------------------------------------------------//
    public static AppiumDriver<MobileElement> driver;

    @Before("@UISetUp")
    public static void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("appPackage", "com.example.yourapp");
        capabilities.setCapability("appActivity", "com.example.yourapp.MainActivity");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After("@UICloseDriver")
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    //----------------------------------------------DB---------------------------------------------------//
    public static Connection connection;
    public static Statement statement;

    @Before("@DB")
    public void connection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://64.227.123.49:5432/prettierhomes",
                "tech_pro_edu","testingIsFun");
        statement = connection.createStatement();
    }

    @After("@DB")
    public void closeConnection() throws SQLException {
        if (!(statement == null) && !statement.isClosed()) {
            statement.close();
            connection.close();
        }
    }
}

