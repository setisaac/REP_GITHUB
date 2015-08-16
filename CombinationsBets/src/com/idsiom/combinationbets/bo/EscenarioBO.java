package com.idsiom.combinationbets.bo;

import java.util.ArrayList;
import java.util.List;

import org.paukov.combinatorics.ICombinatoricsVector;

public class EscenarioBO {
	private Integer id;
	private List<ResultGBO> resultados;
	
	public EscenarioBO(Integer id, ICombinatoricsVector<ResultGBO> icv) {
		this.id = id;
		this.resultados = new ArrayList<ResultGBO>();
		
		for(ResultGBO r : icv) {
			this.resultados.add(r);
		}
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		String result;
		
		sb.append("Escenario ");
		sb.append(this.id);
		sb.append(" :: ");
		for(ResultGBO r : resultados) {
			sb.append(r);
			sb.append(", ");
		}
		
		
		result = sb.toString();
		sb = null;
		
		return result;
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<ResultGBO> getResultados() {
		return resultados;
	}
	public void setResultados(List<ResultGBO> resultados) {
		this.resultados = resultados;
	}
	
	
}
