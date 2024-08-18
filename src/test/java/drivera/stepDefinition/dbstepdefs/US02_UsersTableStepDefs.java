package drivera.stepDefinition.dbstepdefs;

import drivera.Utilities.DB_Utilty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US02_UsersTableStepDefs {
    String query = "SELECT * FROM users";

    @Given("Users send query to get column names and information")
    public void usersSendQueryToGetColumnNamesAndInformation() {
        DB_Utilty.createConnection();
        DB_Utilty.executeQuery(query);
    }

    @Then("Users column names and information are verified")
    public void usersColumnNamesAndInformationAreVerified() {
        List<String> expectedDataColumns = List.of("user_id", "username", "email", "password_hash", "phone_number", "is_2fa_enabled", "method_2fa", "firs_name", "last_name","birth_date","birth_place","current_location","citizenship","consent_date","consent_type","check_phone_number","profile_picture_url","signup_method");

        List<String> actualDataColumns = DB_Utilty.getColumnNames(query);


        for (int i = 0; i < actualDataColumns.size(); i++) {

            Assert.assertEquals(expectedDataColumns.get(i), actualDataColumns.get(i));

        }

        List<Object> expectedDataInfo = List.of(2, "Ali","ali@gmail.com", "nchd01553", "5368995456",true, "fa-solid fa-hod", "Ali", "Can","08.03.2000","NewYork","Bursa","USA","15:30","onay",true,"profilurl","manuel");
        List<Object> actualDataInfo = DB_Utilty.getRowList(query);
        System.out.println(actualDataInfo);

        for (int i = 0; i < 1; i++) {

            Assert.assertEquals(expectedDataInfo.get(i), actualDataInfo.get(i));

        }
    }
}