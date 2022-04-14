package com.KernelByte.ProjectIsMutant.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value = "CadenaADN")
@Data

public class Mutant {
	@Id
	private String id;
	private String[] cadenaDna;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String[] getCadenaDna() {
		return cadenaDna;
	}
	public void setCadenaDna(String[] cadenaDna) {
		this.cadenaDna = cadenaDna;
	}
	
	public Mutant(List<String> dna) {
		super();
		this.dna = dna;
	}

	public Mutant() {
	}

	private List<String> dna;

	public List<String> getDna() {
		return dna;
	}
	
	
}
