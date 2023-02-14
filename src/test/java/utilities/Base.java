package utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Base {

    static String hubURL = "http://192.168.1.26:4444";

    public WebDriver setDriver(WebDriver driver, String browser) {

        if (browser.equals("chrome")) {

            try {
                driver = new RemoteWebDriver(new URL(hubURL),new ChromeOptions());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        if (browser.equals("edge")) {


            try {
                driver = new RemoteWebDriver(new URL(hubURL),new EdgeOptions());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


        return driver;
    }


}

