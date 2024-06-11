package packSelPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ToursFlightsPage {
	WebDriver dr;
	
	@FindBy(how=How.XPATH,using="//a[href='reservation.php']")
	WebElement flightsPageButton;
	
	@FindBy(how=How.XPATH,using="//input[@value='roundtrip']")
	WebElement typeButton;
	
	@FindBy(how=How.XPATH,using="//select[@name='passCount']")
	WebElement passengers;
	
	@FindBy(how=How.XPATH,using="//select[@name='fromPort']")
	WebElement departLocation;
	
	@FindBy(how=How.XPATH,using="//select[@name='fromMonth']")
	WebElement onMonth;
	
	@FindBy(how=How.XPATH,using="//select[@name='fromDay']")
	WebElement onDay;
	
	@FindBy(how=How.XPATH,using="//select[@name='toPort']")
	WebElement toLocation;
	
	@FindBy(how=How.XPATH,using="//select[@name='toMonth']")
	WebElement returningOn;
	
	@FindBy(how=How.XPATH,using="//select[@name='toDay']")
	WebElement returningOnDay;
	
	@FindBy(how=How.XPATH,using="//input[@value='Business']")
	WebElement serviceClassRB;
	
	@FindBy(how=How.XPATH,using="//select[@name='airline']")
	WebElement airlines;
	
	@FindBy(how=How.XPATH,using="//input[@name='findFlights']")
	WebElement continueButton;

	public ToursFlightsPage(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements( dr,this);
	}
	
	public void flightsPage() {
		flightsPageButton.click();
	}
	
	public void typeVerify() {
		Assert.assertEquals(true, typeButton.isSelected());
	}
	
	public void passengersDropdown() {
		Select s = new Select(passengers);
		s.selectByValue("1");
	}
	
	public void departLocDropdown() {
		Select s = new Select(departLocation);
		s.selectByValue("London");
	}
	
	public void monthDropdown() {
		Select s = new Select(onMonth);
		s.selectByValue("October");
	}
	
	public void dayDropdown() {
		Select s = new Select(onDay);
		s.selectByValue("22");
	}
	
	public void arrivingLocation() {
		Select s = new Select(toLocation);
		s.selectByValue("New York");
	}
	
	public void returningMonth() {
		Select s = new Select(returningOn);
		s.selectByValue("December");
	}
	
	public void returningDay() {
		Select s = new Select(returningOnDay);
		s.selectByValue("20");
	}
	
	public void serviceClass() {
		serviceClassRB.click();
	}
	
	public void airlinesDropdown() {
		Select s = new Select(airlines);
		s.selectByValue("Unified Airlines");
	}
	
	public void continueB() {
		continueButton.click();
	}
}
