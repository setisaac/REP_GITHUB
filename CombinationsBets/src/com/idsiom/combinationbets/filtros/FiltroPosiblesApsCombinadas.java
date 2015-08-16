package com.idsiom.combinationbets.filtros;

import java.util.ArrayList;

import org.paukov.combinatorics.ICombinatoricsVector;
import org.paukov.combinatorics.IFilter;

import com.idsiom.combinationbets.bo.ApSimpleBO;

public class FiltroPosiblesApsCombinadas implements  IFilter<ICombinatoricsVector<ApSimpleBO>> {

	@Override
	public boolean accepted(long arg0, ICombinatoricsVector<ApSimpleBO> arg1) {
		ArrayList<Integer> juegosAgregados = new ArrayList<Integer>();
		
		for(ApSimpleBO r : arg1.getVector()) {
			if(juegosAgregados.contains(r.getIdG())) {
				return false;
			} else {
				juegosAgregados.add(r.getIdG());
			}
		}
		
		return true;
	}

}
