package main;


import helper.DriverFactory;
import helper.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import timeout.Timeout;

public class NaviTest{

    private static final String Prefix = "file:///" + System.getProperty("user.dir")+"\\src\\web\\";

@Test
public void basicNaviTest(){
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.get(Prefix+"index.html");
    Timeout.pause();
    driver.get(Prefix+"loans.html");
    Timeout.pause();
    driver.get(Prefix+"savings.html");
    Timeout.pause();
    driver.navigate().back();
    Timeout.pause();
    driver.navigate().forward();
    Timeout.pause();
    driver.navigate().refresh();

    driver.quit();



}
@Test
public void basicNaviTestRefactored(){
    WebDriver driver = DriverFactory.newDriver();
    driver.get(Pages.home());
    Timeout.pause();
    driver.get(Pages.loans());
    Timeout.pause();
    driver.get(Pages.savings());
    Timeout.pause();
    driver.navigate().back();
    Timeout.pause();
    driver.navigate().forward();
    Timeout.pause();
    driver.navigate().refresh();


    driver.quit();
}


}
