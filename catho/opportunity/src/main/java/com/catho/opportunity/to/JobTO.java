package com.catho.opportunity.to;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.search.SearchHit;

import com.catho.opportunity.enums.JobEnum;
import com.catho.opportunity.model.Job;
import com.catho.opportunity.utils.Utils;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
class JobTO {

    static List<Job> newInstance(SearchHit[] hits, Map<String, String[]> parameterMap) {
        List<Job> jobs = new ArrayList<Job>();
        for (SearchHit hit : hits) {
            Job job = new Job();
            job.setTitle(Utils.getString(hit, JobEnum.TITLE.getField()));
            job.setSalario(Utils.getString(hit, JobEnum.SALARIO.getField()));
            job.setDescription(Utils.getString(hit, JobEnum.DESCRIPTION.getField()));
            job.setCidade(Utils.getCollection(hit, JobEnum.CIDADE.getField()));
            job.setCidadeFormated(Utils.getCollection(hit, JobEnum.CIDADEFORMATED.getField()));
            jobs.add(job);
        }
        return jobs;
    }
}
