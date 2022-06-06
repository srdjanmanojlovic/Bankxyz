import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.rmi.server.ExportException;
import java.time.Duration;
import java.util.List;
import com.paulhammant.*;

public class TestMenager {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private BankMenager bankMenager;

    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zli\\Desktop\\QAbootcamp\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        ngWebDriver.waitForAngularRequestsToFinish();


    }
    @AfterMethod
    public void afterMethod(){
        driver.findElement(ByAngular.buttonText("Home")).click();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 3)
    public void menagerTest(){
        driver.findElement(ByAngular.buttonText("Bank Manager Login")).click();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        ngWebDriver.waitForAngularRequestsToFinish();
        driver.findElement(ByAngular.buttonText("Add Customer")).click();
        ngWebDriver.waitForAngularRequestsToFinish();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")).sendKeys("Petar");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")).sendKeys("Petrovic");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")).sendKeys("21000");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(ByAngular.buttonText("OK")).click();
        ngWebDriver.waitForAngularRequestsToFinish();
      driver.findElement(ByAngular.buttonText("Logout")).click();
        ngWebDriver.waitForAngularRequestsToFinish();
    }

    @Test(priority = 2)
    public void testCustomer(){

        NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        driver.findElement(ByAngular.buttonText("Customer Login")).click();
        ngWebDriver.waitForAngularRequestsToFinish();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Select drop = new Select(driver.findElement(By.id("userSelect")));
   //     drop.selectByVisibleText("Petar Petrovic");
        drop.selectByVisibleText("Harry Potter");
        driver.findElement(ByAngular.buttonText("Login")).click();
        ngWebDriver.waitForAngularRequestsToFinish();
        driver.findElement(ByAngular.buttonText("Deposit")).click();
        ngWebDriver.waitForAngularRequestsToFinish();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys("500");
        driver.findElement(ByAngular.buttonText("Deposit")).click();
        ngWebDriver.waitForAngularRequestsToFinish();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(ByAngular.buttonText("Withdrawl")).click();
        ngWebDriver.waitForAngularRequestsToFinish();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys("300");
        driver.findElement(ByAngular.buttonText("Withdrawl")).click();
        ngWebDriver.waitForAngularRequestsToFinish();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(ByAngular.buttonText("Logout")).click();
        ngWebDriver.waitForAngularRequestsToFinish();

    }




}
