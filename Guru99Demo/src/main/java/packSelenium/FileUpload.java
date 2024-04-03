package packSelenium;

import java.io.FileInputStream;
import java.lang.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

public class FileUpload {

	public static void main(String[] args) throws IOException, InterruptedException{
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
		String url = p.getProperty("seleniumautoit");
		driver.get(url);
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		
		driver.switchTo().frame("JotFormIFrame-72320244964454");
		
		driver.findElement(By.xpath("//*[@id='input_3']")).sendKeys("Ambati Mounika");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("mounika@gmail.com");
		WebElement e =driver.findElement(By.xpath("//input[@name='q5_typeA']"));
		Actions a = new Actions(driver);
		a.moveToElement(e).click().perform();
		
		//uploading file using AutoIT
		Runtime.getRuntime().exec("C:\\autoitfiles\\File1.exe"+" "+"C:\\Users\\ambat\\OneDrive\\Pictures\\WhitePup.jpg");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='input_6']")).sendKeys("I'm interested in learning new technologies");
		driver.findElement(By.xpath("//*[@id='input_2\']")).submit();
		
		Thread.sleep(2000);
		WebElement e1 = driver.findElement(By.xpath("//body[@id='stage']"));
		System.out.println(e1.getText());
		
		driver.close();
	}

}
