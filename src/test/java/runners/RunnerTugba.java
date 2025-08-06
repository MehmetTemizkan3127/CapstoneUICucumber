package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@deleteDepartment",
        plugin = {"html:target/reports/report.html",
                "rerun:target/failed_tests/failed_scenarios.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "pretty"},
        dryRun = false
)

public class RunnerTugba extends AbstractTestNGCucumberTests {

}
