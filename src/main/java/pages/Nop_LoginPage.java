package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Nop_LoginPage {

    private WebDriver driver;

    // Locators
    private By emailInputLocator = By.xpath("//input[@id='Email']");
    private By passwordInputLocator = By.xpath("//input[@id='Password']");
    private By loginButtonLocator = By.xpath("//button[@type='submit']");
    private By forgottenPasswordLinkLocator = By.linkText("Forgotten Password");
    private By logoutLinkLocator = By.linkText("Logout");
    public By loginErrorMessage = By.xpath("//div[contains(@class,'validation-summary-errors')]");


    // Constructor
    public Nop_LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    // Methods
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void clickForgottenPasswordLink() {
        WebElement forgottenPasswordLink = driver.findElement(forgottenPasswordLinkLocator);
        forgottenPasswordLink.click();
    }

    public void verifyHomePage(String exceptedValue){
        String title = driver.getTitle();
        if(title.contains(exceptedValue)){
            System.out.println("User Navigated Successfully to home page :" +title );
        }else {
            System.out.println("Failed to navigate home page.");
        }
    }
    public boolean checkForgotPwdLink(){
        return driver.findElement(forgottenPasswordLinkLocator).isDisplayed();
    }

    public void clickLogoutLink(){

        driver.findElement(logoutLinkLocator).click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getForgotPwdPageUrl(){
        String forgotPwdPageUrl = driver.getCurrentUrl();
        return forgotPwdPageUrl;
    }


}
