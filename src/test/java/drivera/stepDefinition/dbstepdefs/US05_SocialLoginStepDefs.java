package drivera.stepDefinition.dbstepdefs;

import drivera.Utilities.DB_Utilty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US05_SocialLoginStepDefs {
    String query = "SELECT * FROM social_logins";
    @Given("Social Login table send query to get column names and information")
    public void socialLoginTableSendQueryToGetColumnNamesAndInformation() {
        DB_Utilty.createConnection();
        DB_Utilty.executeQuery(query);
    }

    @Then("Social Login table column names and information are verified")
    public void socialLoginTableColumnNamesAndInformationAreVerified() {
        List<String> expectedDataColumns = List.of("social_login_id", "user_id", "provider","provider_user_id","access_token","refresh_token");

        List<String> actualDataColumns = DB_Utilty.getColumnNames(query);


        for (int i = 0; i < actualDataColumns.size(); i++) {

            Assert.assertEquals(expectedDataColumns.get(i), actualDataColumns.get(i));

        }

        List<Object> expectedDataInfo = List.of(1,3,"provider","userid","accesstoken","refresh");
        List<Object> actualDataInfo = DB_Utilty.getRowList(query);
        System.out.println(actualDataInfo);

        for (int i = 0; i < 1; i++) {

            Assert.assertEquals(expectedDataInfo.get(i), actualDataInfo.get(i));

        }
    }
}
