package packSelPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ToursFlightsPage {
	WebDriver dr;
	
	public ToursFlightsPage(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements( dr,this);
	}
}
