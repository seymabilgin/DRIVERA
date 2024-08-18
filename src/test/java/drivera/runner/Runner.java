package drivera.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports1.html",
                "json:target/json-reports/cucumber1.json",
                "junit:target/xml-report/cucumber1.xml",
                "rerun:TestOutPut/failed_scenario.txt"},
        features = "src/test/resources",
        glue = {"drivera/stepDefinition", "drivera/hooks"},
        tags = "@UI_TEST",
        dryRun = false,
        monochrome = false


)

public class Runner {
}
