package com.cmro.qa.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_Report_test {
	ExtentSparkReporter spark = new ExtentSparkReporter("spark.html");
	ExtentReports extent = new ExtentReports();
	
	@BeforeSuite
	public void setup() {
		extent.attachReporter(spark);
	
	}
	
	@Test
	public void extentreport() {
		ExtentTest test = extent.createTest("verify tests");
		test.log(Status.PASS, "Tests were passed");
		test.log(Status.FAIL, "Tests were failed");
		
		}
	
	@AfterSuite
	public void teardown() {
	
		extent.flush();
		
	}

}
