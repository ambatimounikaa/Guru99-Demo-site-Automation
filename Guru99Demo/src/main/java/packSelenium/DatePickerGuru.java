package packSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DatePickerGuru {

	public static void main(String[] args) throws IOException {
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
		String url = p.getProperty("datepicker");
		driver.get(url);
		driver.manage().window().maximize();
		
		//handling datepicker
		driver.findElement(By.xpath("//input[@type='datetime-local']"));
		
		
	}

}
