package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packSelPageObjects.GuruBankingPO;

public class StepsforGuruBanking {
	WebDriver dr;
	GuruBankingPO gb;
	
	public StepsforGuruBanking(){
		dr = HooksGuruBanking.dr;
	}
	@Given("user is on the login page of application")
	public void user_is_on_the_login_page_of_application() throws IOException {
		gb = new GuruBankingPO(dr);
		gb.getProperty();
	    gb.launchHomepage();
	}

	@Given("make sure the login & reset button is displayed")
	public void make_sure_the_login_reset_button_is_displayed() {
		gb = new GuruBankingPO(dr);
	    gb.buttonsCheck();
	}

	@When("user enters the {string} and {string}")
	public void user_enters_the_mngr564027_and_unesagy(String arg1,String arg2) {
		gb = new GuruBankingPO(dr);
	    gb.enterIDPassword(arg1,arg2);
	}

	@When("click on the login button")
	public void click_on_the_login_button() {
		gb = new GuruBankingPO(dr);
	    gb.loginIntoApp();
	   
	}

	@Then("Gtpl bank page with welcome message should be displayed")
	public void gtpl_bank_page_with_welcome_message_should_be_displayed() {
	    gb = new GuruBankingPO(dr);
	    gb.welcomeTextVerification();
	    
	}


}
