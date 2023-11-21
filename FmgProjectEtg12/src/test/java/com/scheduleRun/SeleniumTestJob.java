package com.scheduleRun;

import java.util.ArrayList;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.testng.TestNG;

public class SeleniumTestJob implements Job {

	 public void execute(JobExecutionContext context) throws JobExecutionException {
		    // Create an instance of TestNG
		    TestNG testNG = new TestNG();

		    // Create a list of test suite XML files
		    List<String> testSuites = new ArrayList<>();
		    testSuites.add("C:\\Users\\user\\git\\compressedCode\\proVidioETG\\GuestUser.xml");
		    testSuites.add("C:\\Users\\user\\git\\compressedCode\\proVidioETG\\RegUser.xml");

		    // Set the test suite classes or packages to be executed
		    testNG.setTestSuites(testSuites);

		    // Run the test suite
		    testNG.run();
	 }
}

