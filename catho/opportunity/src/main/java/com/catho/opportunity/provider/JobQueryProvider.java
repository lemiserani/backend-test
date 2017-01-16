package com.catho.opportunity.provider;

import org.elasticsearch.action.search.SearchResponse;

import java.util.Map;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
public interface JobQueryProvider {

    SearchResponse search(Map<String, String[]> parameterMap);

}
