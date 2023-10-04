package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Login.feature",
glue= {"stepDefinitions"},
monochrome = true,
plugin = {"html:target/HtmlReports/report.html",
		"json:target/JSONReports/report.jsom",
		"junit:target/JUnitReports/report.xml"},
tags="@Functionality")
public class TestRunner {

}
