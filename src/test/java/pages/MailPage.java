package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Constants.Constants.MYMAIL;
import static Constants.Constants.SUBJECT;


public class MailPage extends PageFactory {
    private WebDriver driver;
    @FindBy(xpath = "//*[@title=\"Написать (w, c)\"]")
    private WebElement sendLatter;
    @FindBy(className = "composeYabbles")
    private WebElement recipientMessage;
    @FindBy(name = "subject")
    private WebElement subjects;
    @FindBy(xpath = "//button[contains(@class,' Button2_size_l')]")
    private WebElement sendButton;
    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div")
    private WebElement textMassage;
    @FindBy(className = "textinput__control")
    private WebElement searchBar;
    @FindBy(xpath = "//*[text()=\"Папки\"]/parent::span/parent::button")
    private WebElement folderButton;
    @FindBy(xpath = "//div[contains(@class,'type_option')]/span[contains(text(),'Входящие')]")
    private WebElement incomingMessages;
    @FindBy(xpath = "//span[contains(@class,'Message')]/span[contains(text(),'пис')]")
    public WebElement numberOfLetters;
    @FindBy(xpath = "//*[contains(@class,'search-input__form-button')]")
    private WebElement searchMailButton;
    @FindBy(xpath= "//span[contains(@title,'Проверить, есть ли новые письма (F9)')]")
    public WebElement refreshButton;


    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*
    Отправка сообщения с темой "Simbirsoft theme"
    */
    @Step("Отправка сообщения")
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
    @Step("Поиск количества писем с темой 'Simbirsoft theme'")
    public void searchSimbirsoftTheme() throws InterruptedException {
        searchBar.click();
        searchBar.sendKeys(SUBJECT, Keys.ENTER);
        folderButton.click();
        incomingMessages.click();
        searchMailButton.click();
        Thread.sleep(1500);
    }
    /*
    Сбор количества писем с темой 'Simbirsoft theme'
    */
    @Step("Сбор количества писем с темой 'Simbirsoft theme")
    public int getCountMassages(){
        int CountMassage = Integer.parseInt(numberOfLetters.getText().replaceAll("\\D+", ""));
        return CountMassage;
    }

    /*
    Поиск количества писем с темой "Simbirsoft theme" после отправки сообщения
    */
    @Step("Обновление страницы с поиском писем с темой 'Simbirsoft theme'")
    public void newSearchSimbirsoftTheme() throws InterruptedException {
        searchMailButton.click();
        Thread.sleep(1000);
        refreshButton.click();
        Thread.sleep(2000);
    }

}
