package PageObjects;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class PersonalAccountPage extends BaseView {

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-test='IMAGE FALLBACK']")
    WebElement personalAccountElement;

    public PersonalAccountPage personalAccountElementClick() {
        personalAccountElement.click();
        return this;
    }
    @FindBy(xpath = "//a[contains(., 'Избранное')]")
    WebElement favourites;

    private final static String LIKED_ELEMENT_LOCATOR =
            "//section[@data-test='PAGE-SECTION'] [contains(., 'Болейн')]";
    @FindBy(xpath = LIKED_ELEMENT_LOCATOR)
    WebElement likedElement;

    public PersonalAccountPage favouritesClickAndAssert() throws InterruptedException {
        favourites.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LIKED_ELEMENT_LOCATOR)));
        assertThat(likedElement, isDisplayed());
        String actualString = likedElement.getText();
        Assert.assertTrue(actualString.contains("Анна Болейн"));
        return this;
    }
}
