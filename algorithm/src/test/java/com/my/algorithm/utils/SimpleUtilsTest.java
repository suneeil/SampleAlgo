package com.my.algorithm.utils;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleUtilsTest {
	SimpleUtils utils = null;
	@BeforeMethod
	public void init() {
		utils = new SimpleUtils();
	}
	
	@Test
	public void stringToBooleanTrueTest() {
		
		Assert.assertTrue(utils.stringToBoolean("Y"), "Expected True for Y");
		Assert.assertTrue(utils.stringToBoolean("y"), "Expected True for y");
		Assert.assertTrue(utils.stringToBoolean("yes"), "Expected True for yes");
		Assert.assertTrue(utils.stringToBoolean("YES"), "Expected True for YES");
		Assert.assertTrue(utils.stringToBoolean("true"), "Expected True for true");
		Assert.assertTrue(utils.stringToBoolean("TRUE"), "Expected True for TRUE");
	}

	@Test
	public void stringToBooleanFalseTest() {
		Assert.assertFalse(utils.stringToBoolean("N"), "Expected False for n");
		Assert.assertFalse(utils.stringToBoolean("No"), "Expected False for NO");
		Assert.assertFalse(utils.stringToBoolean("no"), "Expected False for no");
		Assert.assertFalse(utils.stringToBoolean("FALSE"), "Expected False for FALSE");
		Assert.assertFalse(utils.stringToBoolean("false"), "Expected False for false");
		Assert.assertFalse(utils.stringToBoolean(null), "Expected False for null");
		Assert.assertFalse(utils.stringToBoolean("zebra"), "Expected False for zebra");
	}
}
