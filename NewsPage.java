package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsPage extends BaseView {

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    private final static String NEWS_ELEMENT_LIKE_BUTTON_LOCATOR =
            "//div[@class='HfGWu _3U5bB'][contains(., 'Драма о последних днях Анны Болейн')]//following-sibling::div/div";
    @FindBy(xpath = NEWS_ELEMENT_LIKE_BUTTON_LOCATOR)
    public WebElement newsElementLikeButton;

    public NewsPage scrollSearchNewsElementLikeButton() {
        driver.navigate().to(driver.getCurrentUrl());
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        int i = driver.findElements(By.xpath(NEWS_ELEMENT_LIKE_BUTTON_LOCATOR)).size();
        while (i == 0) {
            jse.executeScript("scroll(0, 1000);");
        }
        return this;
    }
    public NewsPage likeButtonClick() {
        newsElementLikeButton.click();
        return this;
    }

    private final static String PERSONAL_ACCOUNT_iMAGE_LOCATOR =
            "//div[@data-test='IMAGE FALLBACK']";
    @FindBy(xpath = PERSONAL_ACCOUNT_iMAGE_LOCATOR)
    private WebElement personalAccountElement;

    public NewsPage scrollBackToMainMenu() {
        driver.navigate().to(driver.getCurrentUrl());
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        int i = driver.findElements(By.xpath(PERSONAL_ACCOUNT_iMAGE_LOCATOR)).size();
        while (i == 0) {
            jse.executeScript("scroll(0, -1000);");
        }
        return this;
    }

    public PersonalAccountPage personalAccountElementClick() {
        personalAccountElement.click();
        return new PersonalAccountPage (driver);
    }
}


