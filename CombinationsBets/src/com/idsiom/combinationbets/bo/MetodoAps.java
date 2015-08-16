package com.idsiom.combinationbets.bo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.paukov.combinatorics.ICombinatoricsVector;

public class MetodoAps {
	private Integer id;
	private List<IAp> conjuntoAps;

	public MetodoAps(Integer id, ICombinatoricsVector<IAp> c) {
		this.id = id;
		this.conjuntoAps = new ArrayList<IAp>();
		
		Iterator<IAp> iterator = c.iterator();
		while (iterator.hasNext()) {
			this.conjuntoAps.add( iterator.next() );
		}
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		String result;
		
		sb.append("Metodo ");
		sb.append(this.id);
		sb.append(" :: ");
		
		for(IAp ap : this.conjuntoAps) {
			sb.append(ap);
		}
		
		result = sb.toString();
		sb = null;
		
		return result;
	}
	
	public Double calcularResultante(EscenarioBO e) {
		Double result = 0.0;
		int multiplicadorAcierto = 0;
		
		for(IAp a : this.conjuntoAps) {
			if(a.isAcertada(e)) {
				multiplicadorAcierto = 1;
			} else {
				multiplicadorAcierto = 0;
			}
			
			result = (multiplicadorAcierto * a.getLogro()) - 1;
		}
		
		return result;
	}
	
	public List<IAp> getConjuntoAps() {
		return conjuntoAps;
	}

	public void setConjuntoAps(List<IAp> conjuntoAps) {
		this.conjuntoAps = conjuntoAps;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	/*
	public Double calcularResultante(EscenarioBO escenario) {
		
	}
	*/
	
}
