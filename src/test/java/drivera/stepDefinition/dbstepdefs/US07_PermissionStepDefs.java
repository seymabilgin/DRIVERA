package drivera.stepDefinition.dbstepdefs;

import drivera.Utilities.DB_Utilty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US07_PermissionStepDefs {
    String query = "SELECT * FROM permissions";
    @Given("Permission table send query to get column names and information")
    public void permissionTableSendQueryToGetColumnNamesAndInformation() {
        DB_Utilty.createConnection();
        DB_Utilty.executeQuery(query);
    }

    @Then("Permission table column names and information are verified")
    public void permissionTableColumnNamesAndInformationAreVerified() {
        List<String> expectedDataColumns = List.of("permission_id", "user_id", "permission_type","granted_at","expires_at","status","description");

        List<String> actualDataColumns = DB_Utilty.getColumnNames(query);


        for (int i = 0; i < actualDataColumns.size(); i++) {

            Assert.assertEquals(expectedDataColumns.get(i), actualDataColumns.get(i));

        }

        List<Object> expectedDataInfo = List.of(6,10,"permission","read","02.06.2020","02.06.2040","active","text");
        List<Object> actualDataInfo = DB_Utilty.getRowList(query);
        System.out.println(actualDataInfo);

        for (int i = 0; i < 1; i++) {

            Assert.assertEquals(expectedDataInfo.get(i), actualDataInfo.get(i));

        }
    }
}
