package main;


import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TestDrive {

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }




}
