package com.idsiom.combinationbets.filtros;

import org.paukov.combinatorics.ICombinatoricsVector;
import org.paukov.combinatorics.IFilter;

import com.idsiom.combinationbets.bo.ResultGBO;

public class FiltroPosiblesResultados implements  IFilter<ICombinatoricsVector<ResultGBO>> {

	@Override
	public boolean accepted(long arg0, ICombinatoricsVector<ResultGBO> arg1) {
		String strVal = "";
		String rConca = "";
		
		for(int i = 1; i <= arg1.getSize(); i++) {
			strVal = strVal.concat(Integer.toString(i));
			strVal = strVal.concat(";");
		}
		
		
		for(ResultGBO r : arg1.getVector()) {
			rConca = rConca.concat(Integer.toString(r.getIdG()));
			rConca = rConca.concat(";");
		}
		
		return ( strVal.equals(rConca) );
	}

}
