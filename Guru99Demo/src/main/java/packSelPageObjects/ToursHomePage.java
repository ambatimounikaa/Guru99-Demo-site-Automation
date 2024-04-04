package packSelPageObjects;

import java.util.List;
import java.util.*;
import java.io.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ToursHomePage {
	WebDriver dr;
	String url="";
	
	public ToursHomePage(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements( dr,this);
	}
	
	@FindBy(how=How.XPATH,using="//tr/td[@class='mouseOut']")
	List<WebElement> hpButtons;
	
	@FindBy(how=How.XPATH,using="//a[@href='login.php']")
	WebElement signin;
	
	@FindBy(how=How.XPATH,using="//input[@name='userName']")
	WebElement username;
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement password;
	
	@FindBy(how=How.XPATH,using="//input[@name='submit']")
	WebElement submitButton;
	
	@FindBy(how=How.XPATH,using="//tr/td/h3")
	WebElement successMsg;
	
	@FindBy(how=How.XPATH,using="//tr/td/p/font/b")
	WebElement thanksMsg;
	
	public void getProperty() throws IOException {
		Properties p = new Properties();
		FileInputStream fin = new FileInputStream("Guru99.properties");
		p.load(fin);
		url = p.getProperty("newToursURL");
		
	}
	
	public void launchPage() {
		dr.get(url);
	}
	
	public void ButtonCount() {
		Assert.assertEquals(4, hpButtons.size());
	}
	
	public void signInButton() {
		signin.click();
	}
	
	public void textFieldsCheck() {
		Assert.assertEquals(true, username.isDisplayed());
		Assert.assertEquals(true, password.isDisplayed());
	}
	
	public void enterIdPassword(String arg1,String arg2) {
		username.sendKeys(arg1);
		password.sendKeys(arg2);
	}
	
	public void signIn() {
		submitButton.click();
	}
	
	public void verifyLogin() {
		String msg1 = successMsg.getText();
		System.out.println(msg1);
		String msg2 = thanksMsg.getText();
		System.out.println(msg2);
		Assert.assertEquals(msg1, "Login Successfully");
		Assert.assertEquals(msg2, "Thank you for Loggin.");
	}
}
