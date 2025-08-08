package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@SmokeDemo",
        plugin = {"html:target/reports/report.html",
                "rerun:target/failed_tests/failed_scenarios.txt",
                "json:target/reports/json_report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "pretty"}
)
public class RunnerFerhat extends AbstractTestNGCucumberTests {
}