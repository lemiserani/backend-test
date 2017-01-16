package com.catho.opportunity.to;

import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;

import com.catho.opportunity.model.Job;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultTO {

	private long qTime;
	private long totalTime;
	private long hits;
	private Map<String, String[]> parameterMap;
	private List<Job> docs;

	public ResultTO(long qTime, long hits, List<Job> docs) {
		super();
		this.qTime = qTime;
		this.hits = hits;
		this.docs = docs;
	}

	public static ResultTO newInstance(SearchResponse searchResponse,
			Map<String, String[]> parameterMap) {
		return new ResultTO(searchResponse.getTookInMillis(), searchResponse
				.getHits().totalHits(), JobTO.newInstance(searchResponse
				.getHits().getHits(), parameterMap));
	}

	public long getqTime() {
		return qTime;
	}

	public void setqTime(long qTime) {
		this.qTime = qTime;
	}

	public long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

	public long getHits() {
		return hits;
	}

	public void setHits(long hits) {
		this.hits = hits;
	}

	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(Map<String, String[]> parameterMap) {
		this.parameterMap = parameterMap;
	}

	public List<Job> getDocs() {
		return docs;
	}

	public void setDocs(List<Job> docs) {
		this.docs = docs;
	}
}
