package com.TMS.genericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpl implements IRetryAnalyzer{
	int count=0;
	int upperLmt=3;
	@Override
	public boolean retry(ITestResult result) {
		if(count<upperLmt) {
			count++;
			return true;
		}
		return false;
	}

}
