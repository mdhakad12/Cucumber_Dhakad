package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features ="FeatureFiles/adminlogin.feature",glue = "stepdefinitions",dryRun =false,
tags =("@Adminlogin,@Invalidlogin"),plugin={"com.cucumber.listener.ExtentCucumberFormatter:Reports/loginresult.html"})
public class TestAdminLogin extends AbstractTestNGCucumberTests
{

}
