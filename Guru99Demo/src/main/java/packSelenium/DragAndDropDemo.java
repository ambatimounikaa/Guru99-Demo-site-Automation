package packSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.*;

public class DragAndDropDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Enter browser name: ");
		Scanner sc = new Scanner(System.in);
		String browsername = sc.nextLine();
		WebDriver driver = null;
		//lauching browser of own choice
		if(browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("Edge")){
			System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			 driver = new EdgeDriver();
		}
		else
			System.out.println("Please enter browser name to proceed");
		
		//Getting values from Properties file
		Properties p = new Properties();
		FileInputStream fin = new FileInputStream("Guru99.properties");
		p.load(fin);
		String url = p.getProperty("dragAndDropLink");
		driver.get(url);
		driver.manage().window().maximize();
		
		//To scroll the window
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		
		//performing drag and drop using Actions class
		Actions ac = new Actions(driver);
		WebElement source = driver.findElement(By.id("credit2"));
		WebElement destination = driver.findElement(By.xpath("//li[@class='placeholder']"));
	
		//ac.dragAndDrop(source, destination);
		ac.clickAndHold(source).moveToElement(destination).click().build().perform();
		
		WebElement source1 = driver.findElement(By.xpath("//li[@id='fourth'][1]"));
		WebElement destination1 = driver.findElement(By.xpath("//li[@class='placeholder'][1]"));
		ac.clickAndHold(source1).moveToElement(destination1).click().build().perform();
		
		WebElement source2 = driver.findElement(By.xpath("//li[@id='credit1']"));
		WebElement destination2 = driver.findElement(By.xpath("//ol[@id='loan']/li[@class='placeholder']"));
		ac.clickAndHold(source2).moveToElement(destination2).click().build().perform();
		

		WebElement source3 = driver.findElement(By.xpath("//li[@id='fourth'][2]"));
		WebElement destination3 = driver.findElement(By.xpath("//ol[@id='amt8']/li[@class='placeholder']"));
		ac.clickAndHold(source3).moveToElement(destination3).click().build().perform();
		
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		WebElement s = driver.findElement(By.xpath("//div[@id='equal'][1]/a"));
		System.out.println(s.getText());
		
		driver.close();
		
	}

}
