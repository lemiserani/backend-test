package com.catho.opportunity.provider.impl;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.catho.opportunity.model.Job;
import com.catho.opportunity.provider.JobQueryProvider;
import com.catho.opportunity.utils.ParameterMap;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
@Component
public class JobQueryProviderImpl implements JobQueryProvider {

    @Autowired
    private Client client;

    public SearchResponse search(Map<String, String[]> parameterMap) {
    	ParameterMap parameter = new ParameterMap(parameterMap);
		
        return client.prepareSearch()
        		.addSort(parameter.formatOrderBy(),parameter.formatSorted())
        		.setQuery(multiMatchQuery(parameter.formatQ(), parameter.formatFields()))      
                .setIndices(Job.INDEX_NAME)
                .setTypes(Job.INDEX_TYPE)
                .setFrom(parameter.formatPage())
                .setSize(parameter.formatLimit())
                .execute()
                .actionGet();
    }
    
}

