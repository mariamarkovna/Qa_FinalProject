package e2e_cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(plugin = {"json:build/cucumber-report/cucumber.json", "pretty"},
        features = "src/test/resources/features", publish = true)

public class RunCucumberTest extends AbstractTestNGCucumberTests {
}

