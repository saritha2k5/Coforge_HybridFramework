package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    String projectpath;

    protected WebDriver driver;

    public void setup() throws IOException {

        projectpath = System.getProperty("user.dir");

        Properties prob = new Properties();

        FileInputStream fis = new FileInputStream(
                projectpath
                + "\\src\\test\\resources\\config.properties");

        prob.load(fis);

        String url = prob.getProperty("url");

        WebDriverManager.edgedriver().setup();

        driver = new EdgeDriver();

        driver.manage()
              .timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        driver.manage()
              .window()
              .maximize();

        driver.get(url);

        fis.close();
    }

    public void teardown() {

        if (driver != null) {

            driver.quit();
        }
    }

    public WebDriver getDriver() {

        return driver;
    }
}