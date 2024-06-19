package StepDefenations;

import browser.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Nop_CustomersPage;

public class Nop_CustomerStepDef {

    private Nop_CustomersPage custmPage = new Nop_CustomersPage(DriverFactory.getDriver()) ;

    @When("user click customers parent tab")
    public void userClickCustomersParentTab() {
        custmPage.clickCustomersTab();
    }


    @And("user click customer child tab")
    public void userClickCustomerChildTab() {
        custmPage.clickChildCustomerTab();
    }

    @Then("enter search details email as {string} and fname as {string} and lname as {string} and dob of month is {string} and day is {string}")
    public void enterSearchDetailsEmailAsAndFnameAsAndLnameAsAndDobOfMonthIsAndDayIs(String email, String fname, String lname, String month, String day) {
        custmPage.enterEmail(email);
        custmPage.enterFirstname(fname);
        custmPage.enterLastname(lname);
        custmPage.selectDateOfBirth(month);
        custmPage.selectDayOfBirth(day);
    }

    @And("user click search button")
    public void userClickSearchButton() {
        custmPage.clickSearchButton();
    }

    @And("I click on the add new customer button")
    public void iClickOnTheAddNewCustomerButton() {
        custmPage.clickAddNewButton();
    }

    @Then("Navigate to add new customer page successfully")
    public void navigateToAddNewCustomerPageSuccessfully() {
            custmPage.verifyAddNewCustomerPage("Add a new customer");
    }
}
