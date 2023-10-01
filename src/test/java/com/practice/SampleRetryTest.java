package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TMS.genericUtils.BaseClass;

public class SampleRetryTest extends BaseClass{
	@Test(retryAnalyzer =com.TMS.genericUtils.RetryImpl.class )
	public void retryTest() {
		Assert.assertEquals("A", "B");
	}
}
