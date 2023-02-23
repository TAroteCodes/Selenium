package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Login/Login.feature"}, glue = {"Defination"},dryRun = false)
public class Test_runner extends AbstractTestNGCucumberTests {

}
