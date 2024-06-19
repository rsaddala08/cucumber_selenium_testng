package StepDefenations;

import browser.factory.DriverFactory;
import com.util.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.Nop_LoginPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Nop_LoginStepDef {

     private Nop_LoginPage loginPage = new Nop_LoginPage(DriverFactory.getDriver());

    @Given("I am on the Nop commerce login page")
    public void i_am_on_the_nop_commerce_login_page() {
        DriverFactory.getDriver().get( new ConfigReader().init_prop().getProperty("url"));
    }
    @When("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        loginPage.enterEmail(new ConfigReader().init_prop().getProperty("Username"));
        loginPage.enterPassword(new ConfigReader().init_prop().getProperty("Password"));
    }
    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        loginPage.verifyHomePage("Dashboard");
    }

    @And("I click on the logout button")
    public void iClickOnTheLogoutButton() {
        loginPage.clickLogoutLink();
    }

    @When("I have entered a valid username is {string} and password is {string}")
    public void iHaveEnteredAValidUsernameIsAndPasswordIs(String userName, String password) {
       // loginPage.enterEmail(userName);
     //   loginPage.enterPassword(password);

        loginPage.enterEmail("admin@yourstore.com");
       loginPage.enterPassword("admin");
    }

    @When("I have entered a valid username and password with list data")
    public void iHaveEnteredAValidUsernameAndPasswordWithListData(DataTable usercredentials) {
        //Write the code to handle Data Table
        List<List<String>> dataRows = usercredentials.asLists(String.class);
        //This is to get the first data of the set (First Row + First Column)
        loginPage.enterEmail(dataRows.get(0).get(0));
        //This is to get the first data of the set (First Row + Second Column)
        loginPage.enterPassword(dataRows.get(0).get(1));

    }

    @When("I have entered a valid username and password with map data")
    public void iHaveEnteredAValidUsernameAndPasswordWithMapData(DataTable usercredentials) {
        //Write the code to handle Data Table

        List<Map<String, String>> user = usercredentials.asMaps(String.class, String.class);

       for (Map<String, String> data : usercredentials.asMaps(String.class, String.class)) {

            loginPage.enterEmail(data.get("Username"));
            loginPage.enterPassword(data.get("Password"));
        }
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @Then("I should see an error message indicating {string}")
    public void iShouldSeeAnErrorMessageIndicating(String errorMessage) {
        // Assert that an error message is displayed on the page matching the expected error message
        Assert.assertEquals( DriverFactory.getDriver().findElement(loginPage.loginErrorMessage).isDisplayed(), true);
    }
}
