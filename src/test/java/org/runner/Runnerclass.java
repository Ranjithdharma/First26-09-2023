package org.runner;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\mranj\\eclipse-workspace"
		+ "\\MavenCucumber\\featurefiles\\files.feature",glue= {"org.stepdefinittions",
"org.hook"},dryRun = false,monochrome = true,plugin = {"html:C:\\Users\\mranj\\eclipse-workspace\\"
				+ "MavenCucumber\\target\\rep1.html","json:C:\\Users\\mranj\\eclipse-workspace"
						+ "\\MavenCucumber\\target\\ree1.json","junit:C:\\Users\\mranj\\"
								+ "eclipse-workspace\\MavenCucumber\\target\\report1.xml"})
public class Runnerclass {
	
	

}
