package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = "stepDefinitions.api",
        plugin = {"pretty", "html:target/api-cucumber-reports.html"}
        //tags = "@NegativeTest"
)
public class ApiTestRunner extends AbstractTestNGCucumberTests {
}