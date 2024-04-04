package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/features/GuruTours.feature"},
					glue= {"stepDefinitions1"},
					plugin= {"pretty","html:target/html-reports/report.html"},
					monochrome=true)
public class TestToursGuru {

}
