package com.idsiom.combinationbets.bo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.paukov.combinatorics.ICombinatoricsVector;

public class ApCombinadaBO implements IAp {

	private List<ApSimpleBO> listAps;
	
	public ApCombinadaBO(ApSimpleBO ... apsSimples ) {
		this.listAps = new ArrayList<ApSimpleBO>( Arrays.asList(apsSimples) );
	}
	
	public ApCombinadaBO(ICombinatoricsVector<ApSimpleBO> icvApS) {
		this.listAps = new ArrayList<ApSimpleBO>();
		
		Iterator<ApSimpleBO> iterator = icvApS.iterator();
		while (iterator.hasNext()) {
			this.listAps.add( iterator.next() );
		}
		
		
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		String result;
		
		sb.append( "< C :: " );
		
		for(ApSimpleBO s : this.listAps) {
			sb.append(s);
			sb.append(", ");
		}
		
		sb.append( ">" );
		result = sb.toString();
		sb = null;
		
		return result;
		
	}
	
	
	
	public List<ApSimpleBO> getListApSimples() {
		return listAps;
	}

	@Override
	public Double getLogro() {
		Double result = 1.0;
		
		for(ApSimpleBO apS : listAps) {
			result = result * apS.getLogro();
		}
		
		return result;
	}

	@Override
	public Boolean isAcertada(EscenarioBO escenario) {
		Boolean result = true;
		
		for(ApSimpleBO apS : listAps) {
			result = result || apS.isAcertada(escenario);
		}
		
		return result;
		
	}
	
}
