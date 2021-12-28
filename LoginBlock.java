package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginBlock extends BaseView{

    public LoginBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[.='Войти']")
    private WebElement entryButton;

    public LoginBlock entryButtonClick() {
        entryButton.click();
        return this;
    }

    @FindBy(xpath = "//iframe[contains(@src,'rambler.ru/login')]")
    private WebElement loginFrame;

    public LoginBlock switchToLoginFrame() {
        driver.switchTo().frame(loginFrame);
        return this;
    }

    private final static String loginInputLocatorById = "login";
    @FindBy(id = loginInputLocatorById)
    private WebElement loginInput;

    public LoginBlock fillLoginInput(String login) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginInputLocatorById)));
        loginInput.sendKeys(login);
        return this;
    }

    @FindBy(id = "password")
    private WebElement passwordInput;

    public LoginBlock fillPasswordInput(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @FindBy(xpath = "//span[@class='rui-Button-content']")
    private WebElement submitLoginButton;

    public MainPage submitLoginButtonClick() {
        submitLoginButton.click();
        return new MainPage(driver);
    }
}
