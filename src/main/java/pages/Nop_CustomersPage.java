package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Nop_CustomersPage {

    private By tabCustomers = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    private By childCustomers = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
    private By txtSearchEmail = By.xpath( "//input[@id='SearchEmail']");
    private By txtSearchFname = By.xpath("//input[@id='SearchFirstName']");
    private By txtSearchLname = By.xpath("//input[@id='SearchLastName']");
    private By lstDateOfMonth = By.xpath("//select[@id='SearchMonthOfBirth']");
    private By lstDayOfBirth = By.xpath("//select[@id='SearchDayOfBirth']");
    private By btnSearch = By.xpath("//button[@id='search-customers']//i[@class='fas fa-search']");

    private By btnAddNew = By.xpath("//a[@class='btn btn-primary']");
    private By addNewCustomerHeader = By.xpath("//h1[@class='float-left']");
    private WebDriver driver;

    public Nop_CustomersPage(WebDriver driver){
       this.driver=driver;
    }


    public void clickCustomersTab(){
        driver.findElement(tabCustomers).click();
    }

    public void clickChildCustomerTab(){

        driver.findElement(childCustomers).click();
    }

    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(txtSearchEmail);
        emailInput.sendKeys(email);
    }
    public void enterFirstname(String fName) {
        WebElement eleFirstname = driver.findElement(txtSearchFname);
        eleFirstname.sendKeys(fName);
    }
    public void enterLastname(String lName) {
        WebElement eleLastname = driver.findElement(txtSearchLname);
        eleLastname.sendKeys(lName);
    }
    public void selectDateOfBirth(String month) {
        WebElement monthEle = driver.findElement(lstDateOfMonth);
        Select sc = new Select(monthEle);
        sc.selectByVisibleText(month);
    }
    public void selectDayOfBirth(String day) {
        WebElement dayEle = driver.findElement(lstDayOfBirth);
        Select sc = new Select(dayEle);
        sc.selectByVisibleText(day);
    }
    public void clickSearchButton() {
        driver.findElement(btnSearch).click();
    }
    public void clickAddNewButton() {
        driver.findElement(btnAddNew).click();
    }
    public void verifyAddNewCustomerPage(String exceptedValue){
        String pageHeader = driver.findElement(addNewCustomerHeader).getText();
        if(pageHeader.trim().equalsIgnoreCase(exceptedValue.trim())){
            System.out.println("User Navigated Successfully :" +pageHeader );
        }else {
            System.out.println("Failed to navigate");
        }
    }

}
