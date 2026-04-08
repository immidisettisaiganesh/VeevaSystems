package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	private static final Logger logger = LogManager.getLogger(TestListener.class);

//	public void onStart(ITestContext context) {
//		logger.info("Suite Started.."+context.getSuite().getName());
//	}
//
//	public void onFinish(ITestContext context) {
//		logger.info("Suite finished "+context.getSuite().getName());
//	}

	public void onTestStart(ITestResult result) {
		logger.info("Test Started.."+result.getMethod().getMethodName());
		logger.info("Description--"+result.getMethod().getDescription());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info("Test passed sucessfully--"+result.getMethod().getMethodName());
		logger.info("Description--"+result.getMethod().getDescription());
	}

	public void onTestFailure(ITestResult result) {
		logger.error("test Failed"+result.getMethod().getMethodName());
		logger.info("Description--"+result.getMethod().getDescription());
	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Test skipped"+result.getMethod().getMethodName());
	}

}
