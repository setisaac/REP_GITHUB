package com.idsiom.combinationbets.filtros;

import java.util.ArrayList;
import java.util.List;

import org.paukov.combinatorics.ICombinatoricsVector;
import org.paukov.combinatorics.IFilter;

import com.idsiom.combinationbets.bo.ApCombinadaBO;
import com.idsiom.combinationbets.bo.ApSimpleBO;
import com.idsiom.combinationbets.bo.EscenarioBO;
import com.idsiom.combinationbets.bo.IAp;
import com.idsiom.combinationbets.context.SessionVars;

public class FiltroCombPerdedoras implements  IFilter<ICombinatoricsVector<IAp>> {

	/*
	@Override
	public boolean accepted(long arg0, ICombinatoricsVector<IAp> arg1) {
		return true;
	}
	*/
	
	
	
	
	@Override
	public boolean accepted(long arg0, ICombinatoricsVector<IAp> arg1) {
		List<EscenarioBO> escenarios = SessionVars.getEscenarios();
		int cantJuegosIncluidos;
		
		// Si estan incluidos todos los juegos del escenario
		cantJuegosIncluidos = calCantJuegosIncluidos(arg1);
		
		if(cantJuegosIncluidos != escenarios.get(0).getResultados().size()) {
			return false;
		}
		
		// Si existe por lo menos un escenario en el que la presente combinacion de apuestas de positiva
		// la misma se acepta
		for(EscenarioBO e : escenarios) {
			if( calcularResultante(e, arg1) > 0) {
				return true;
			}
			
		}
		
		return false;
	}
	
	
	
	private int calCantJuegosIncluidos(ICombinatoricsVector<IAp> arg1) {
		ArrayList<Integer> idGames = new ArrayList<Integer>();
		for(IAp a : arg1) {
			if(a instanceof ApSimpleBO) {
				if(!idGames.contains(((ApSimpleBO) a).getIdG())) {
					idGames.add(((ApSimpleBO) a).getIdG());
				}
				
			} else if(a instanceof ApCombinadaBO)  {  // Si es combinada
				for(ApSimpleBO apS : ((ApCombinadaBO) a).getListApSimples() ) {
					if(!idGames.contains(apS.getIdG())) {
						idGames.add(apS.getIdG());
					}
				}
			}
		}
		
		return idGames.size();
	}



	private Double calcularResultante(EscenarioBO e, ICombinatoricsVector<IAp> icvIAp) {
		Double result = 0.0;
		int multiplicadorAcierto = 0;
		
		for(IAp a : icvIAp) {
			if(a.isAcertada(e)) {
				multiplicadorAcierto = 1;
			} else {
				multiplicadorAcierto = 0;
			}
			
			result = (multiplicadorAcierto * a.getLogro()) - 1;
			
			boolean bprint = false;
			if(bprint && a instanceof ApCombinadaBO) {
				System.out.println("Ganancia para " + a + " Con escenario " + e + "    multiplicador " + multiplicadorAcierto);
				System.out.println("result " + result);
			}
		}
		
		return result;
	}

	
}
