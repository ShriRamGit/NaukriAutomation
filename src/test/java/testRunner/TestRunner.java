package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",tags="@second",
				  glue={"stepDefinitions","hooks"},
				  plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		  )
public class TestRunner {

}
