package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static Constants.Constants.LOGIN;
import static Constants.Constants.PASSWORD;

public class MainPage extends PageFactory {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]")
    private WebElement authorizationButton;
    @FindBy(id = "passp-field-login")
    private WebElement login;
    @FindBy(className = "Textinput-Control")
    private WebElement password;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*
    Авторизация на почте яндекса
    */
    @Step("Авторизация на Яндекс почте")
    public void authorization() {
        authorizationButton.click();
        login.click();
        login.sendKeys(LOGIN, Keys.ENTER);
        password.click();
        password.sendKeys(PASSWORD, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}