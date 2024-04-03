package packSelenium;

import java.io.IOException;
import java.util.*;
import java.io.FileInputStream;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class RadioAndCheckBox {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
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
		String url = p.getProperty("rcurl");
		driver.get(url);
		
		driver.manage().window().maximize();
		
		//Storing the radio button web elements
		List<WebElement> radioList = driver.findElements(By.xpath("//input[@type='radio']"));
		int NoOfRadioButtons = radioList.size();
		System.out.println("There are a total of "+NoOfRadioButtons+" Radio buttons");
		Assert.assertEquals(3, NoOfRadioButtons);
		WebElement radioButton1 = driver.findElement(By.id("vfb-7-1"));
		WebElement radioButton2 = driver.findElement(By.id("vfb-7-2"));
		WebElement radioButton3 = driver.findElement(By.id("vfb-7-3"));
		
		radioButton1.click();
		System.out.println("Radio Button One is Selected: "+radioButton1.isSelected());
	
		radioButton2.click();
		System.out.println("After clicking on Option2");
		System.out.println("Radio Button One is Selected: "+radioButton1.isSelected());
		System.out.println("Radio button Two is Selected: "+radioButton2.isSelected());
		
		radioButton3.click();
		System.out.println("After clicking on Option3");
		System.out.println("Radio button One is Selected: "+radioButton1.isSelected());
		System.out.println("Radio button two is selected: "+radioButton2.isSelected());
		System.out.println("Radio button three is Selected: "+radioButton3.isSelected());
		
		
		
		//Storing the check boxes web elements
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int NoOfCheckboxes = checkboxes.size();
		System.out.println("There are a total of "+NoOfCheckboxes+" Checkboxes");
		Assert.assertEquals(3, NoOfCheckboxes);
		
		WebElement checkbox1 = driver.findElement(By.id("vfb-6-0"));
		WebElement checkbox2 = driver.findElement(By.id("vfb-6-1"));
		WebElement checkbox3 = driver.findElement(By.id("vfb-6-2"));
		
		checkbox1.click();
		checkbox2.click();
		checkbox3.click();
		
		System.out.println("Checkbox one is selected: "+checkbox1.isSelected());
		System.out.println("Checkbox two is selected: "+checkbox2.isSelected());
		System.out.println("Checkbox three is selected: "+checkbox3.isSelected());
		
		driver.close();
		
	}

}
