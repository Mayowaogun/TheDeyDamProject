package deydam.assessment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeyDamProject {
    WebDriver driver;
    WebDriverWait wait;

    public void deyDamLogin(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the DeyDam Page
        driver.get("https://www.deydam.com/");
        // Maximize the browser window
        driver.manage().window().maximize();
        //Get page Title
        Assert.assertEquals(driver.getTitle(), "Deydam:");
        // Click login link
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span>a")));
        driver.findElement(By.cssSelector("span>a")).click();
        // Insert the username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name=\"username\"]")));
        driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys("Mayor01");
        // Insert the password
        driver.findElement(By.cssSelector("#password")).sendKeys("Password1@");
        // Click the login button
        driver.findElement(By.cssSelector("button")).click();
        // Logout Procedure
        // Click on the profile name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div:nth-of-type(4) h4")));
        driver.findElement(By.cssSelector("div:nth-of-type(4) h4")).click();
        // Click on Logout Button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bg-red-600.cursor-pointer.flex.items-center.justify-between.px-2\\.5.py-2.rounded-xl.w-full")));
        driver.findElement(By.cssSelector(".bg-red-600.cursor-pointer.flex.items-center.justify-between.px-2\\.5.py-2.rounded-xl.w-full")).click();
        //Quit the Browser
        driver.quit();

    }

    public static void main(String [] args){
        DeyDamProject deyDam = new DeyDamProject();
        deyDam.deyDamLogin();
    }
}
