package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/Features", glue = "Steps", tags = "@tag", plugin = { "pretty",
				"html:target/report.html" }, monochrome = true, snippets = SnippetType.CAMELCASE, dryRun = false)


public class Runner {

}
