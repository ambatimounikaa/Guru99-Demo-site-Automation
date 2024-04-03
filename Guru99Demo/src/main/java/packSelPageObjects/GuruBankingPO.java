package packSelPageObjects;

import java.util.*;
import java.io.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GuruBankingPO {
	WebDriver dr;
	String url="";

	public GuruBankingPO(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	@FindBy(how=How.XPATH,using="//input[@name='uid']")
	WebElement userId;
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement password;
	
	@FindBy(how=How.XPATH,using="//input[@name='btnLogin']")
	WebElement loginButton;
	
	@FindBy(how=How.XPATH,using="//input[@name='btnReset']")
	WebElement resetButton;
	
	@FindBy(how=How.XPATH,using="//marquee[@class='heading3']")
	WebElement welcomeMsg;
	
	public void getProperty() throws IOException {
	Properties p = new Properties();
	FileInputStream fin  = new FileInputStream("Guru99.properties");
	p.load(fin);
	url = p.getProperty("bankingURL");
	}
	
	public void launchHomepage() {
		dr.get(url);
	}
	
	public void enterIDPassword(String arg1, String arg2) {
		userId.sendKeys(arg1);
		password.sendKeys(arg2);
	}
	
	public void buttonsCheck() {
		System.out.println(loginButton.isDisplayed());
		System.out.println(resetButton.isDisplayed());
	}
	
	public void loginIntoApp() {
		loginButton.click();
	}
	
	public void welcomeTextVerification() {
		String msg = welcomeMsg.getText();
		System.out.println(msg);
		Assert.assertEquals(msg, "Welcome To Manager's Page of GTPL Bank");
	}
}
