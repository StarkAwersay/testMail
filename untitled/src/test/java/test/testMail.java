package test;

import chromeDriver.getChromeDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.mailPage;
import pages.mainPage;

import static contants.contants.MAILPAIG;

public class testMail {
    private WebDriver driver;

    /*
    Открываем браузер в максимальном разрешении
    */
    @BeforeMethod
    public void BeforeTest() {
        driver = getChromeDriver.getChromeDriver();
        driver.manage().window().maximize();
    }

    /*
    Сам тест почты
    */
    @Test
    public void mailTest() throws InterruptedException {
        mainPage mp = new mainPage(driver);
        mailPage mlp = new mailPage(driver);
        driver.get(MAILPAIG);
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
        System.out.println("Test close!");
    }
}