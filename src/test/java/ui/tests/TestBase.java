package ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;

public class TestBase {
    protected WebDriver driver;

    protected final String EMAIL = "test@gmail.com";
    protected final String PASSWORD = "test@gmail.com";

    protected Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void setUp(Method m) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("The browser was opened");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://phonebook.telran-edu.de:8080/user/login");
        logger.info("The test method " + m.getName()+ " was started");
    }

    @AfterMethod
    public void tearDown(Method m){
        driver.quit();
        logger.info("The browser was closed");
        logger.info("=========================================================================");
    }

    @AfterMethod(alwaysRun=true)
    public void afterMLogout(ITestResult result){
        logger.info(result.getMethod().getTestClass().toString());
        if (result.isSuccess()) {
            logger.info("PASSED " + result.getMethod().getMethodName());
        } else {
            logger.info("FAILED " + result.getMethod().getMethodName());
            logger.info(result.getThrowable().toString());
        }

    }
}
