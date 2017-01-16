package com.catho.opportunity.model;

import java.util.Collection;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Leandro Miserani on 15/01/17.
 */
public class Job {

    public final static String INDEX_NAME = "jobs";
    public final static String INDEX_TYPE = "jobs";
 
	private String title;
    
	private String description;
	private String salario;
	private Collection<String> cidade;
	private Collection<String> cidadeFormated;
	
	@Id
	@JsonIgnore
	private Integer id;

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public Collection<String> getCidade() {
		return cidade;
	}

	public void setCidade(Collection<String> cidade) {
		this.cidade = cidade;
	}

	public Collection<String> getCidadeFormated() {
		return cidadeFormated;
	}

	public void setCidadeFormated(Collection<String> cidadeFormated) {
		this.cidadeFormated = cidadeFormated;
	}
	
}
