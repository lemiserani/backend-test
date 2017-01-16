package com.catho.opportunity.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.catho.opportunity.factory.FactoryJob;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
public class ParseJsonUtilsTest {

	@Test
	public void testToJson() {
		assertEquals(ParseJsonUtils.toJson(FactoryJob.createJob()).length(), 152);
	}	
	
	@Test
	public void testFromJson() {
		assertEquals(ParseJsonUtils.fromJson("Catho", String.class), "Catho");
	}	

	
}
