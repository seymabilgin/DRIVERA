package drivera.stepDefinition.dbstepdefs;

import drivera.Utilities.DB_Utilty;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class US06_OtpVerificationStepDefs {
    String query = "SELECT * FROM otp_verifications";
    @Given("OTP Verification table send query to get column names and information")
    public void otpVerificationTableSendQueryToGetColumnNamesAndInformation() {
        DB_Utilty.createConnection();
        DB_Utilty.executeQuery(query);
    }

    @Then("OTP Verification table column names and information are verified")
    public void otpVerificationTableColumnNamesAndInformationAreVerified() {
        List<String> expectedDataColumns = List.of("otp_id", "user_id", "phone_number","otp_code","is_verified","expiry_date","created_at");

        List<String> actualDataColumns = DB_Utilty.getColumnNames(query);


        for (int i = 0; i < actualDataColumns.size(); i++) {

            Assert.assertEquals(expectedDataColumns.get(i), actualDataColumns.get(i));

        }

        List<Object> expectedDataInfo = List.of(3, 5, "5325658565","otpcode",true,"15.04.2035","25.04.2022");
        List<Object> actualDataInfo = DB_Utilty.getRowList(query);
        System.out.println(actualDataInfo);

        for (int i = 0; i < 1; i++) {

            Assert.assertEquals(expectedDataInfo.get(i), actualDataInfo.get(i));

        }
    }
}
