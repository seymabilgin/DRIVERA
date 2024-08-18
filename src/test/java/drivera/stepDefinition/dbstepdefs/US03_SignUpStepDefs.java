package drivera.stepDefinition.dbstepdefs;

import drivera.Utilities.DB_Utilty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US03_SignUpStepDefs {
    String query = "SELECT * FROM signup_method";
    @Given("Signup send query to get column names and information")
    public void signupSendQueryToGetColumnNamesAndInformation() {
        DB_Utilty.createConnection();
        DB_Utilty.executeQuery(query);
    }

    @Then("Signup column names and information are verified")
    public void signupColumnNamesAndInformationAreVerified() {
        List<String> expectedDataColumns = List.of("signup_method_id", "user_id", "method");

        List<String> actualDataColumns = DB_Utilty.getColumnNames(query);


        for (int i = 0; i < actualDataColumns.size(); i++) {

            Assert.assertEquals(expectedDataColumns.get(i), actualDataColumns.get(i));

        }

        List<Object> expectedDataInfo = List.of(3, 5, "google");
        List<Object> actualDataInfo = DB_Utilty.getRowList(query);
        System.out.println(actualDataInfo);

        for (int i = 0; i < 1; i++) {

            Assert.assertEquals(expectedDataInfo.get(i), actualDataInfo.get(i));

        }
    }
}
