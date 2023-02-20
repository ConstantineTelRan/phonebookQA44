package ui.page.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.tests.TestBase;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "defaultRegisterFormEmail")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name ='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@routerlink='/user/registration']")
    private WebElement registerLink;

    @FindBy(id = "error-message")
    private WebElement errorMsg;

    @FindBy(id = "email-error-required")
    private WebElement emailErrorMsg;

    @FindBy(id = "password-error-required")
    private WebElement passwordErrorMsg;

    @FindBy(xpath = "//h3[@data-value=\"Content Writing - May 2021\"]")
    private WebElement header;

    @FindBy(xpath = "//div[@class=\"card-body\"]//h2")
    WebElement appHeader;

    public void getAuth(String email, String password) {
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}