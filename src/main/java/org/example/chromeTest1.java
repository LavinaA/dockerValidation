package org.example;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class chromeTest1 {

        @BeforeTest
        public void startDockerScale() throws Exception {
                File f = new File("/Users/lavinaagrawal/TechProjects/dockerValidation/output.txt");
                if(f.delete()){
                        System.out.println("Output File deleted successfully");
                }
                startDocker docker = new startDocker();
                docker.start();
        }

        @AfterTest
        public void stopDockerDeleteFile() throws Exception {
                stopDocker docker = new stopDocker();
                docker.stopDocker();
        }

        @Test
        public void test1() throws MalformedURLException {
        DesiredCapabilities cap= DesiredCapabilities.chrome();
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
        driver.get("http://google.com");
        System.out.println(driver.getTitle());

    }


}
