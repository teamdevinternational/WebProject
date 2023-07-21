package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features= ".//Features//Ticket001_Login.feature", 
// THIS ALLOWS MULTIPLE FEATURE FILES TO RUN --- features={"","",""}
// THIS ALLOWS ALL FEATURE FILES TO RUN --- feature={"src/test/java/Features/"}
glue= "stepDefinitions",
monochrome= true,
plugin= {"pretty","html:target/HtmlReports"},
tags="", //"@Sanity, @Regression" => or ====> {"@Sanity","@Regression"}=>and 
dryRun=false
)




public class TestRunner {

	
	
	
	
	
	
}
