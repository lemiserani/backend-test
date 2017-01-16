package com.catho.opportunity.utils;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
public class ParameterMapTest {
	 
	 @Test
	 public void testWithoutFormatQ() {
		 ParameterMap parameterMap =  new ParameterMap(createMap("outher", "Auxiliar Administrativo"));
		 assertEquals(parameterMap.formatQ(), "");
	 }	
	
	 @Test
	 public void testWithFormatQ() {
		 ParameterMap parameterMap =  new ParameterMap(createMap("q", "Auxiliar Administrativo"));
		 assertEquals(parameterMap.formatQ(), "Auxiliar Administrativo");
	 }
	 
	 @Test
	 public void testWithoutFormatPage() {
		 ParameterMap parameterMap =  new ParameterMap(createMap("outher", "2"));
		 assertEquals(parameterMap.formatPage().intValue(), 0);
	 }
	 
	 @Test
	 public void testWithFormatPage() {
		 ParameterMap parameterMap =  new ParameterMap(createMap("page", "2"));
		 assertEquals(parameterMap.formatPage().intValue(), 2);
	 }
	 
	 @Test
	 public void testWithoutFormatLimit() {
		 ParameterMap parameterMap =  new ParameterMap(createMap("outher", "200"));
		 assertEquals(parameterMap.formatLimit().intValue(), 10);
	 }
	 
	 @Test
	 public void testWithFormatLimit() {
		 ParameterMap parameterMap =  new ParameterMap(createMap("limit", "200"));
		 assertEquals(parameterMap.formatLimit().intValue(), 200);
	 }
	 
	 @Test
	 public void testWithoutFormatOrderBy() {
		 ParameterMap parameterMap =  new ParameterMap(createMap("outher", "title"));
		 assertEquals(parameterMap.formatOrderBy(), "salario");
	 }
	 
	 @Test
	 public void testWithFormatOrderBy() {
		 ParameterMap parameterMap =  new ParameterMap(createMap("orderby", "title"));
		 assertEquals(parameterMap.formatOrderBy(), "title");
	 }
	 
	 @Test
	 public void testWithoutFormatSorted() {
		 ParameterMap parameterMap =  new ParameterMap(createMap("outher", "desc"));
		 assertEquals(parameterMap.formatSorted(), SortOrder.ASC);
	 }
	 
	 @Test
	 public void testWithFormatSorted() {
		 ParameterMap parameterMap =  new ParameterMap(createMap("sorted", "desc"));
		 assertEquals(parameterMap.formatSorted(), SortOrder.DESC);
	 }
	 
	 @Test
	 public void testWithoutFormatFields() {
		 ParameterMap parameterMap =  new ParameterMap(createMap("outher", "title,description"));
		 assertEquals(parameterMap.formatFields().length,  4);
	 }
	 
	 @Test
	 public void testWithFormatFields() {
		 ParameterMap parameterMap =  new ParameterMap(createMap("fields", "title,description"));
		 assertEquals(parameterMap.formatFields().length,  2);
	 }
	 
	 private HashMap<String, String[]> createMap(String field, String value ){
		 HashMap<String, String[]> hashMap = new HashMap<String, String[]>();
		 hashMap.put(field, new String[]{value}); 
		 return hashMap;
	 }
}
