package com.catho.opportunity.utils;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.elasticsearch.search.SearchHit;
import org.junit.Test;

import com.catho.opportunity.enums.JobEnum;

public class UtilsTest {

	 @Test
	 public void testGetCollectionWithoutkey() {
		 SearchHit hits = null;
		 assertEquals(Utils.getCollection(hits, JobEnum.TITLE.getField()), new HashSet<String>());
	 }
	 
	 @Test
	 public void testGetStringWithoutkey() {
		 SearchHit hits = null;
		 assertEquals(Utils.getString(hits, JobEnum.TITLE.getField()), "");
	 }	
}
