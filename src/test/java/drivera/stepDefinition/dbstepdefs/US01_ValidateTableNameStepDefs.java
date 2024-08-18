package drivera.stepDefinition.dbstepdefs;

import drivera.Utilities.DB_Utilty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import static drivera.hooks.Hooks.connection;

public class US01_ValidateTableNameStepDefs {


    ResultSet resultSet;

    @Given("A query is sent to get the registered table names")
    public void kayıtlıTabloIsimleriniAlmakIcinQueryGonderilir() throws SQLException {
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'");

    }

    @Then("Validate registered table names")
    public void kayitliTabloIsimleriDogrulanır() throws SQLException {
        List<String> expectedData = List.of("users", "signup_method", "login_history", "social_logins", "otp_verifications", "permissions");

        List<String> actualData = new ArrayList<>();

        while (resultSet.next()) {
            actualData.add(resultSet.getString("table_name"));

        }
        for (int i = 0; i < actualData.size(); i++) {

            Assert.assertEquals(expectedData.get(i), actualData.get(i));

        }


    }

}
