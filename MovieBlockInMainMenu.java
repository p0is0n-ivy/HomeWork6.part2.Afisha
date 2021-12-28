package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MovieBlockInMainMenu extends BaseView{
    public MovieBlockInMainMenu(WebDriver driver) {
        super(driver);
    }
    private final static String MOVIE_LOCATOR_IN_MAIN_MENU =
            "//nav/a[contains(., 'КИНО')]";

    @FindBy(xpath = MOVIE_LOCATOR_IN_MAIN_MENU)
    WebElement movieElement;

    public MovieBlockInMainMenu hoverMovieElement() throws InterruptedException {

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav/a[contains(., 'КИНО')]")));
        actions.moveToElement(movieElement).build().perform();
        Thread.sleep(3000);

        return this;
    }
    @FindBy(xpath = "//a[contains(., 'Почему темнокожие Анна Болейн, Золушка и Русалочка — это нормально')]")
    WebElement newsElement;

    public NewsPage newsElementClick() {
       newsElement.click();
        return new NewsPage(driver);
    }
}
