package stepDefinitions1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksGuruTours {
	static WebDriver dr=null;
    @Before("@tag1")
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        dr = new ChromeDriver();
        dr.manage().window().maximize();
    }
    @After("@tag1")
    public void tearDown() {
        dr.close();
    }
}
