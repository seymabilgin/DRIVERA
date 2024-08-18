package drivera.stepDefinition.dbstepdefs;

import drivera.Utilities.DB_Utilty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US04_LoginHistoryStepDefs {
    String query = "SELECT * FROM login_history";
    @Given("Login History table send query to get column names and information")
    public void loginHistoryTableSendQueryToGetColumnNamesAndInformation() {
        DB_Utilty.createConnection();
        DB_Utilty.executeQuery(query);
    }

    @Then("Login History table column names and information are verified")
    public void loginHistoryTableColumnNamesAndInformationAreVerified() {
        List<String> expectedDataColumns = List.of("login_id", "user_id", "login_time","logout_time","ip_address","device_info");

        List<String> actualDataColumns = DB_Utilty.getColumnNames(query);


        for (int i = 0; i < actualDataColumns.size(); i++) {

            Assert.assertEquals(expectedDataColumns.get(i), actualDataColumns.get(i));

        }

        List<Object> expectedDataInfo = List.of(7, 9, "21:08", " 16:25:42.570894","ipadress", "device");
        List<Object> actualDataInfo = DB_Utilty.getRowList(query);
        System.out.println(actualDataInfo);

        for (int i = 0; i < 1; i++) {

            Assert.assertEquals(expectedDataInfo.get(i), actualDataInfo.get(i));

        }
    }
}
