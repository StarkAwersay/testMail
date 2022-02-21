package test;

import chromeDriver.GetChromeDriver;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MailPage;
import pages.MainPage;

import static Constants.Constants.MAILPAGE;

public class TestMail {
    private WebDriver driver;

    /*
    Открываем браузер в максимальном разрешении
    */
    @BeforeMethod
    public void BeforeMethod() {
        driver = GetChromeDriver.getChromeDriver();
        driver.manage().window().maximize();
    }

    /*
    Тест почты
    */
    @Test
    @Description("Тест почты")
    public void mailTest() throws InterruptedException {
        MainPage mp = new MainPage(driver);
        MailPage mlp = new MailPage(driver);
        driver.get(MAILPAGE);
        mp.authorization();
        mlp.searchSimbirsoftTheme();
        int oldCountMassage = mlp.getCountMassages();
        mlp.sendMassage();
        mlp.newSearchSimbirsoftTheme();
        int newCountMassage = mlp.getCountMassages();
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
