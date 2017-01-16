package com.catho.opportunity.utils;

import java.util.Collection;
import java.util.HashSet;

import org.elasticsearch.search.SearchHit;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
public class Utils {

    @SuppressWarnings("unchecked")
	public static Collection<String> getCollection(SearchHit hit, String key) {
        if (hit !=null && hit.getSource() != null && hit.getSource() != null && hit.getSource().containsKey(key)) {
            return (Collection<String>) hit.getSource().get(key);
        }
		return new HashSet<String>();
    }
    
    public static String getString(SearchHit hit, String key){
    	 if (hit !=null && hit.getSource() != null && hit.getSource().containsKey(key)) {
             return hit.getSource().get(key).toString();
         }
 		return "";
    }

}