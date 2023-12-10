package interactions;

import helper.DriverFactory;
import helper.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import timeout.Timeout;


public class SavingsPageTest {
    @Test
    public void savingsInputTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(Pages.savings());

        WebElement deposit = driver.findElement(By.id("deposit"));
        WebElement period = driver.findElement(By.id("period"));

        deposit.sendKeys("10000");
        Select select = new Select(period);
        select.selectByValue("6 months");
        Timeout.pause();
        select.selectByVisibleText("1 Year");
        Timeout.pause();
        select.selectByIndex(2);

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "After 2 Years you will earn $1200.00 on your deposit");
        driver.quit();
    }

}
