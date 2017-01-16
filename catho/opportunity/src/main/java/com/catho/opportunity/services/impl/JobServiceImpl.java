package com.catho.opportunity.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.catho.opportunity.model.Job;
import com.catho.opportunity.provider.JobQueryProvider;
import com.catho.opportunity.services.JobService;
import com.catho.opportunity.to.ResultTO;
import com.catho.opportunity.utils.ParseJsonUtils;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
@Service
public class JobServiceImpl implements JobService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobServiceImpl.class);

    @Autowired
    private Client client;

    @Autowired
    private JobQueryProvider jobQueryProvider;

    @Autowired
    private JobService jobService;
    
    @Value("${elasticsearch.jobs.file.name}")
    private String fileName;

    private Integer id;

    private Map<String, Job> jobTerms = new HashMap<>();

    public void save() {
    	id = 0;
		Date startDate = new Date();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(streanJob -> {
				Job job = ParseJsonUtils.fromJson(streanJob, Job.class);
				id++;
				job.setId(id);
				indexJob(job);

			});
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		Date endDate = new Date();
		LOGGER.info("Start date: " + startDate.toString());
		LOGGER.info("End date: " + endDate.toString());
		LOGGER.info("Total time in mm: "
				+ ((endDate.getTime() - startDate.getTime()) / 1000 / 60));
		jobTerms.clear();
    }

    public ResultTO search(Map<String, String[]> parameterMap) {
    	Map<String, String[]> parameterMapNew = new HashMap<>();
    	parameterMapNew.putAll(parameterMap);
    	
    	SearchResponse searchResponse = jobQueryProvider.search(parameterMapNew);
          
    	ResultTO searchResultTO = ResultTO.newInstance(searchResponse, parameterMap);
    	searchResultTO.setParameterMap(parameterMapNew);
         
    	return searchResultTO;
    }
    
    private void indexJob(Job job) {
    	jobTerms.put(job.getTitle(), job);
        IndexResponse response = client.prepareIndex(Job.INDEX_NAME, Job.INDEX_TYPE, job.getId().toString())
                .setSource(ParseJsonUtils.toJson(job))
                .get();

        LOGGER.info("Job indexed with success! " + job.getTitle());
        LOGGER.info("StatusCode " + response.status().getStatus());
    }
    
    public void delete(){
    	try {
    		client.admin().indices().delete(new DeleteIndexRequest(Job.INDEX_NAME)).actionGet();
    	} catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}
