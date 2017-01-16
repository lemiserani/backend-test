package com.catho.opportunity.factory;

import java.util.HashSet;

import com.catho.opportunity.model.Job;

public class FactoryJob {
	public static Job createJob(){
		Job job = new Job();
		job.setId(1);
		job.setDescription("Catho is excellent company");
		job.setSalario("10000");
		job.setTitle("Senior Developer");
		HashSet<String> city = new HashSet<String>();
		city.add("Alphaville");
		job.setCidade(city);
		job.setCidadeFormated(city);
		return job;
	}
}
