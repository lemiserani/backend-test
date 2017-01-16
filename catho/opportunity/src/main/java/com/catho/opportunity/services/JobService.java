package com.catho.opportunity.services;

import java.util.Map;

import com.catho.opportunity.to.ResultTO;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
public interface JobService {

    void save();

    ResultTO search(Map<String, String[]> parameterMap);
    
    void delete();
    
}
