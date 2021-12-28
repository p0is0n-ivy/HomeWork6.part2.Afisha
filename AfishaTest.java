import PageObjects.LoginBlock;
import PageObjects.MainPage;
import PageObjects.MovieBlockInMainMenu;
import PageObjects.NewsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AfishaTest {
    WebDriver driver;
    MainPage mainPage;
    LoginBlock loginBlock;
    private final static String AFISHA_BASE_URL = "https://afisha.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginBlock = new LoginBlock(driver);
        driver.get(AFISHA_BASE_URL);

    }

    @Test
    void addToFavoriteMovieFromNewsPage() throws InterruptedException {
        new MainPage(driver).clickLoginButton();
        new LoginBlock(driver)
                .switchToLoginFrame()
                .fillLoginInput("irinasiv230@mail.ru")
                .fillPasswordInput("QWErty123")
                .submitLoginButtonClick();
        new MovieBlockInMainMenu(driver)
                .hoverMovieElement()
                .newsElementClick();
        new NewsPage(driver)
                .scrollSearchNewsElementLikeButton()
                .likeButtonClick()
                .scrollBackToMainMenu()
                .personalAccountElementClick()
                .favouritesClickAndAssert();

    }

    @Test
    void FindFilm() throws InterruptedException {
        new MainPage(driver).clickLoginButton();
        new LoginBlock(driver)
                .switchToLoginFrame()
                .fillLoginInput("irinasiv230@mail.ru")
                .fillPasswordInput("QWErty123")
                .submitLoginButtonClick();
        new MainPage(driver)
                .searchButtonClick()
                .searchFilmInput("Человек-паук")
                .startSearchingClick()
                .SearchResultAndAssert();

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}



