package org.example;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class chromeStandaloneTest {
    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities cap= DesiredCapabilities.chrome();
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
        driver.get("http://google.com");
        System.out.println(driver.getTitle());

        cap= DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"),cap);
        driver.get("http://google.com");
        System.out.println(driver.getTitle());




    }
}
