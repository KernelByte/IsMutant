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
	private String nombres;
	private String apellidos;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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
