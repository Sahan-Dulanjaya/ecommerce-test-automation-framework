package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/cucumber",
        glue = "rahulshettyacademy.stepDefinition",
        plugin = { "pretty", "html:target/cucumber-reports/cucumber.html" },
        monochrome = true
)
public class testNGTestRunner extends AbstractTestNGCucumberTests {

    

}
