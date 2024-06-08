package com.api.runner;

import org.junit.runner.RunWith; 



import io.cucumber.junit.Cucumber; 

import io.cucumber.junit.CucumberOptions; 

 

@RunWith(Cucumber.class) 

@CucumberOptions(features = "src/test/java/Features/apiAutomation.feature" 

,glue = {"com.api.stepDefinition"}   

,monochrome = true 

 

,tags="@testGET" 

//	,tags="@testPOST" 

//	,tags="@testDELETE" 

 

) 

public class TestRunner {

}
