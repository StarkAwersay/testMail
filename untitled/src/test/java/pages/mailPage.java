package pages;

import chromeDriver.getChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static contants.contants.MYMAIL;
import static contants.contants.SUBJECT;


public class mailPage extends mainPage {
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[3]/div[2]/div[1]/div/div/div/a")
    private WebElement sendLatter;
    @FindBy(className = "composeYabbles")
    private WebElement recipientMessage;
    @FindBy(name = "subject")
    private WebElement subjects;
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[10]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button")
    private WebElement sendButton;
    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div")
    private WebElement textMassage;
    @FindBy(className = "textinput__control")
    private WebElement searchBar;
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]/form/div/span/div/button[1]")
    private WebElement searchOptions;
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[3]/div[3]/div[1]/div/div/button[3]")
    private WebElement folderButton;
    @FindBy(xpath = "//div[contains(@class,'control menu__item menu__item_type_option')]/span[contains(text(),'Входящие')]")
    private WebElement incomingMessages;
    @FindBy(xpath = "//div[contains(@class,'mail-MessagesSearchInfo js-messages-header')]/span[contains(@class,'mail-MessagesSearchInfo-Title')]/span[contains(@class,'mail-MessagesSearchInfo-Title_misc nb-with-xs-left-gap')]")
    public WebElement numberOfLetters;
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[2]/div/div/div[1]/div[2]/div/div/div/div[1]/form/button")
    private WebElement searchMailButton;
    @FindBy(css = "[class='mail-ComposeButton-Refresh js-main-action-refresh ns-action']")
    public WebElement refreshButton;


    public mailPage(WebDriver driver) {
        super(driver);
    }

    /*
    Отправка сообщения с темой "Simbirsoft theme"
    */
    public void sendMassage() {
        sendLatter.click();
        recipientMessage.click();
        recipientMessage.sendKeys(MYMAIL);
        subjects.click();
        subjects.sendKeys(SUBJECT);
        textMassage.click();
        textMassage.sendKeys("Найдено " + numberOfLetters.getText());
        sendButton.click();
        searchMailButton.click();

    }

    /*
    Поиск количества писем с темой "Simbirsoft theme"
    */
    public void searchSimbirsoftTheme() {
        searchBar.click();
        searchBar.sendKeys(SUBJECT, Keys.ENTER);
        folderButton.click();
        incomingMessages.click();
    }

    /*
    Поиск количества писем с темой "Simbirsoft theme" после отправки сообщения
    */
    public void newSearchSimbirsoftTheme() throws InterruptedException {
        searchMailButton.click();
        Thread.sleep(2000);
        refreshButton.click();
    }

}
