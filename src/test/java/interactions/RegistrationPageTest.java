package interactions;

import helper.DriverFactory;
import helper.Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import timeout.Timeout;

import java.sql.Time;
import java.util.Set;

public class RegistrationPageTest {
    @Test
    public void registrationPageInputTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(Pages.home());
        Timeout.pause();

        WebElement first = driver.findElement(By.id("firstName"));
        WebElement last = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement dob = driver.findElement(By.id("dob"));

        first.sendKeys("Jeremiah");
        last.sendKeys("Lizarraga");
        email.sendKeys("Jere.Liz@cognizant.com");
        Timeout.pause();
        email.clear();
        email.sendKeys("Jeremia.Lizarra@cognizant.com");

        dob.sendKeys("01/01/1980");

        Timeout.pause();
        driver.quit();
    }
    @Test
    public void registrationPageClickTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(Pages.home());
        Timeout.pause();
        WebElement first = driver.findElement(By.id("firstName"));
        WebElement last = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement dob = driver.findElement(By.id("dob"));
        WebElement checkbox = driver.findElement(By.id("heard-about"));
        WebElement write = driver.findElement(By.id("textarea"));
        WebElement register = driver.findElement(By.id("register"));

        first.sendKeys("Jeremiah");
        last.sendKeys("Lizarraga");
        email.sendKeys("Jere.Liz@cognizant.com");
        email.clear();
        email.sendKeys("Jeremia.Lizarra@cognizant.com");
        dob.sendKeys("01/01/1980");
        checkbox.click();
        write.sendKeys("I found it by google");
        Timeout.pause();

        Actions actions = new Actions(driver);
        actions.contextClick(checkbox).perform();
        Timeout.pause();

        register.click();

        Timeout.pause();
        driver.quit();
    }
    @Test
    public void isEnabledTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(Pages.home());
        Timeout.pause();

        WebElement textarea = driver.findElement(By.id("textarea"));
        Assert.assertFalse(textarea.isEnabled());

        if(textarea.isEnabled()){
            textarea.sendKeys("testing");
            }


        driver.quit();
    }
    @Test
    public void isDisplayedTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(Pages.home());

        WebElement feedback = driver.findElement(By.className("invalid-feedback"));
        Assert.assertFalse(feedback.isDisplayed());
        driver.findElement(By.id("register")).click();
        Assert.assertTrue(feedback.isDisplayed());
        driver.quit();
    }
    @Test
    public void dismissAlertTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(Pages.home());
        Timeout.pause();

        WebElement first = driver.findElement(By.id("firstName"));
        WebElement last = driver.findElement(By.id("lastName"));
        first.sendKeys("Jeremiah");
        last.sendKeys("Lizarraga");
        Timeout.pause();

        driver.findElement(By.id("clear")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        Assert.assertEquals(first.getAttribute("value"), "Jeremiah");
        Assert.assertEquals(last.getAttribute("value"), "Lizarraga");
        driver.quit();

    }
    @Test
    public void acceptAlertTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(Pages.home());
        Timeout.pause();

        WebElement first = driver.findElement(By.id("firstName"));
        WebElement last = driver.findElement(By.id("lastName"));
        first.sendKeys("Jeremiah");
        last.sendKeys("Lizarraga");
        Timeout.pause();

        driver.findElement(By.id("clear")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        Assert.assertEquals(first.getAttribute("value"), "");
        Assert.assertEquals(last.getAttribute("value"), "");
        driver.quit();

    }
    @Test
    public void storageTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(Pages.home());
        Timeout.pause();

        WebElement first = driver.findElement(By.id("firstName"));
        WebElement last = driver.findElement(By.id("lastName"));
        WebElement save = driver.findElement(By.id("save"));
        Timeout.pause();

        first.sendKeys("Jeremiah");
        last.sendKeys("Lizarraga");
        save.click();
        WebStorage webStorage = (WebStorage) driver;
        SessionStorage storage = webStorage.getSessionStorage();
        storage.keySet().forEach(key -> System.out.println(key + "="  + storage.getItem(key)));
        Timeout.pause();

        driver.get(Pages.loans());
        driver.navigate().back();
        Timeout.pause();

        var first_1 = driver.findElement(By.id("firstName"));
        var last_1 = driver.findElement(By.id("lastName"));
        Assert.assertEquals(first_1.getAttribute("value"), "Jeremiah");
        Assert.assertEquals(last_1.getAttribute("value"), "Lizarraga");
        storage.clear();
        driver.navigate().refresh();
        driver.quit();


    }
    @Test
    public void cookiesTest(){
        WebDriver driver = DriverFactory.newDriver();
        WebDriver.Options options = driver.manage();
        Set<Cookies> cookies = options.getCookies();
        Cookie thing = options.getCookieNamed("thing");
        options.deleteAllCookies();
    }
}
