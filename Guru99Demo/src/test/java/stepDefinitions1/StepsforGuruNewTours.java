package stepDefinitions1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packSelPageObjects.ToursFlightsPage;
import packSelPageObjects.ToursHomePage;
import stepDefinitions.HooksGuruBanking;

public class StepsforGuruNewTours {
	WebDriver dr;
	ToursHomePage tp;
	ToursFlightsPage fp;
	
	public StepsforGuruNewTours() {
		dr = HooksGuruTours.dr;
	}
	//Homepage Login functionality
	@Given("user is on the homepage")
	public void user_is_on_the_homepage() throws IOException {
	    tp = new ToursHomePage (dr);
	    tp.getProperty();
	    tp.launchPage();
	    tp.ButtonCount();
	}

	@When("I click on signin then username and password field should be displayed")
	public void i_click_on_signin_then_username_and_password_field_should_be_displayed() {
		tp = new ToursHomePage (dr);
	    tp.signInButton();
	    tp.textFieldsCheck();
	}

	@Then("enter the {string} and {string}")
	public void enter_the_mounika_and_pass123(String arg1,String arg2) {
		tp = new ToursHomePage (dr);
	    tp.enterIdPassword(arg1, arg2);
	}

	@Then("click on submit button and verify the sucessfull login")
	public void click_on_submit_button_and_verify_the_sucessfull_login() {
		tp = new ToursHomePage (dr);
	    tp.signIn();
	    tp.verifyLogin();
	}

	//Flights page Functionality
	@Given("User is on the flights page")
	public void user_is_on_the_flights_page() {
	    fp  = new ToursFlightsPage(dr);
	    fp.flightsPage();
	}

	@Then("make sure round trip type is selected")
	public void make_sure_round_trip_type_is_selected() {
		  fp  = new ToursFlightsPage(dr);
		  fp.typeVerify();
	}

	@Then("mention all the flight details")
	public void mention_all_the_flight_details() {
		  fp  = new ToursFlightsPage(dr);
		  fp.passengersDropdown();
		  fp.departLocDropdown();
		  fp.monthDropdown();
		  fp.dayDropdown();
		  fp.arrivingLocation();
		  fp.returningMonth();
		  fp.returningDay();
	}

	@Then("specify the preferences and click on continue")
	public void specify_the_preferences_and_click_on_continue() {
		  fp  = new ToursFlightsPage(dr);
		  fp.serviceClass();
		  fp.airlinesDropdown();
		  fp.continueB();
	}


}
