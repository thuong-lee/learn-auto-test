package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/ui",
        glue = "stepDefinitions.ui",
        plugin = {"pretty", "html:target/ui-cucumber-reports.html"}
        //tags = "@NegativeTest"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}