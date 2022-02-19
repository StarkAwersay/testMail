package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static contants.Constants.LOGIN;
import static contants.Constants.PASSWORD;

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
    public void authorization() {
        authorizationButton.click();
        login.click();
        login.sendKeys(LOGIN, Keys.ENTER);
        password.click();
        password.sendKeys(PASSWORD, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}

