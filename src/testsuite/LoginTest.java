package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class LoginTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // //find Username field and insert value
        WebElement validUserName = driver.findElement(By.xpath("//input[@type='text']"));
        validUserName.sendKeys("AbcXyz");
        //find password field and insert value
        WebElement validPassword = driver.findElement(By.xpath("//input[@type='password']"));
        validPassword.sendKeys("abc123");
        //find login button and click it
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit' ]"));
        loginBtn.click();
        // from requirement store value
        String expetedMessage = "Accounts Overview";

        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[@class=\"title\"]"));
        String actualMessage = actualMessageElement.getText();
        // verify actual message with expected message
        Assert.assertEquals("Login message not matched.",expetedMessage,actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        // //find Username field and invalid insert value
        WebElement validUserName = driver.findElement(By.xpath("//input[@type='text']"));
        validUserName.sendKeys("Abc");
        //find password field and invalid insert value
        WebElement validPassword = driver.findElement(By.xpath("//input[@type='password']"));
        validPassword.sendKeys("abc");
        //find login button and click it
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit' ]"));
        loginBtn.click();
        // from requirement store value
        String expetedMessage = "The username and password could not be verified.";

        WebElement actualMessageElement = driver.findElement(By.xpath("//p[@class=\"error\"]"));
        String actualMessage = actualMessageElement.getText();
        // verify actual message with expected message
        Assert.assertEquals("Login message not matched.",expetedMessage,actualMessage);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        // //find Username field and insert value
        WebElement validUserName = driver.findElement(By.xpath("//input[@type='text']"));
        validUserName.sendKeys("AbcXyz");
        //find password field and insert value
        WebElement validPassword = driver.findElement(By.xpath("//input[@type='password']"));
        validPassword.sendKeys("abc123");
        //find login button and click it
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit' ]"));
        loginBtn.click();
        //find log out button and click it
        WebElement logOutBtn = driver.findElement(By.xpath(("//a[@href='/parabank/logout.htm']")));
        logOutBtn.click();
        // from requirement store value
        String expetedMessage = "Customer Login";

        WebElement actualMessageElement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        String actualMessage = actualMessageElement.getText();
        // verify actual message with expected message
        Assert.assertEquals("Login message not matched.",expetedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
