package interactions;

import helper.DriverFactory;
import helper.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import timeout.Timeout;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class LoansPageTest {

    @Test
    public void uploadFileTest() throws IOException {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(Pages.loans());
        Timeout.pause();

        WebElement upload = driver.findElement(By.cssSelector("input[type=file]"));
        Path path = File.createTempFile("file", ".txt").toPath();
        String fileName = path.toAbsolutePath().toString();
        System.out.println(fileName);

        Timeout.pause();
        upload.sendKeys(fileName);

        Timeout.pause();
        driver.quit();

    }
    @Test
    public void clickApplyButtonTest(){
        WebDriver driver = DriverFactory.newDriver();
        driver.get(Pages.loans());
        Timeout.pause();

        var apply = driver.findElement(By.cssSelector("input[type=submit]"));
        apply.click();
    }

}
