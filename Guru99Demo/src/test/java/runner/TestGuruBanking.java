package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/features/GuruBanking.feature"},
				glue= {"stepDefinitions"},
				plugin= {"pretty","html:target/html-reports/report.html"},
				monochrome= true)
public class TestGuruBanking {
	

}
