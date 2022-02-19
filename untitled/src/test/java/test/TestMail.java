package test;

import chromeDriver.GetChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MailPage;
import pages.MainPage;

import static contants.Constants.MAILPAGE;

public class TestMail {
    private WebDriver driver;
    /*
    Открываем браузер в максимальном разрешении
    */
    @BeforeMethod
    public void BeforeTest() {
        driver = GetChromeDriver.getChromeDriver();
        driver.manage().window().maximize();
    }

    /*
    Тест почты
    */
    @Test
    public void mailTest() throws InterruptedException {
        MainPage mp = new MainPage(driver);
        MailPage mlp = new MailPage(driver);
        driver.get(MAILPAGE);
        mp.authorization();
        mlp.searchSimbirsoftTheme();
        Thread.sleep(3000);
        int oldCountMassage = Integer.parseInt(mlp.numberOfLetters.getText().replaceAll("\\D+", ""));
        mlp.sendMassage();
        mlp.newSearchSimbirsoftTheme();
        Thread.sleep(2000);
        int newCountMassage = Integer.parseInt(mlp.numberOfLetters.getText().replaceAll("\\D+", ""));
        Assert.assertEquals(newCountMassage, oldCountMassage + 1, "Количество писем с темой 'Simbirsoft theme' не увеличилось ");

    }

    /*
    Закрываем драйвер
    */
    @AfterMethod
    public void close() {
        driver.close();
    }
}