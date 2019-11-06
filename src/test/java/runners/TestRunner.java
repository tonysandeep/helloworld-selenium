package runners; 

import org.junit.runner.RunWith; 

import cucumber.api.CucumberOptions; 

import cucumber.api.junit.Cucumber; 

  

@RunWith(Cucumber.class) 

@CucumberOptions(plugin = {"html:target/htmlReport" 

        ,"json:target/cucumber-reports/Cucumber.json"}, 

         

features = "src/test/resources/features", 

         glue= {"stepDefinition"} 

) 

public class TestRunner {} 