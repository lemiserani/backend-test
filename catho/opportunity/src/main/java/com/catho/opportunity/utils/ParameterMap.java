package com.catho.opportunity.utils;

import java.util.Map;

import org.elasticsearch.search.sort.SortOrder;

import com.catho.opportunity.enums.JobEnum;
import com.catho.opportunity.enums.SearchEnum;

public class ParameterMap {
	
	private Map<String, String[]> parameterMap;
	
	public ParameterMap(Map<String, String[]> parameterMap) {
		super();
		this.parameterMap = parameterMap;
	}

	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(Map<String, String[]> parameterMap) {
		this.parameterMap = parameterMap;
	}

	public String formatQ(){
		return parameterMap.get(SearchEnum.Q.getField()) == null? "" : parameterMap.get(SearchEnum.Q.getField())[0];
	}
	
	public Integer formatPage(){
		return parameterMap.get(SearchEnum.PAGE.getField()) == null? 0 : Integer.parseInt(parameterMap.get(SearchEnum.PAGE.getField())[0]);
	}
	
	public Integer formatLimit(){
		return parameterMap.get(SearchEnum.LIMIT.getField()) == null? 10 : Integer.parseInt(parameterMap.get(SearchEnum.LIMIT.getField())[0]);
	}
	
	public String formatOrderBy(){
		return parameterMap.get(SearchEnum.ORDERBY.getField()) == null? JobEnum.SALARIO.getField() : parameterMap.get(SearchEnum.ORDERBY.getField())[0];
	}
	
	public SortOrder formatSorted(){
	    if (parameterMap.get(SearchEnum.SORTED.getField()) != null && parameterMap.get(SearchEnum.SORTED.getField())[0].equals(SortOrder.DESC.toString())){
	    	return SortOrder.DESC;
	    }
		
	    return SortOrder.ASC;	
	    
	}
	
	public String[] formatFields(){
	    if (parameterMap.get(SearchEnum.FIELDS.getField()) == null)
			return new String[]{JobEnum.DESCRIPTION.getField(), JobEnum.TITLE.getField(), JobEnum.SALARIO.getField(), JobEnum.CIDADE.getField()};
	    
	    return parameterMap.get(SearchEnum.FIELDS.getField())[0].split(",");
	    
	}
}
