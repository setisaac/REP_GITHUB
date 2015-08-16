package com.idsiom.combinationbets.util;

import java.util.ArrayList;
import java.util.List;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import com.idsiom.combinationbets.bo.ApCombinadaBO;
import com.idsiom.combinationbets.bo.ApSimpleBO;
import com.idsiom.combinationbets.bo.EscenarioBO;
import com.idsiom.combinationbets.bo.IAp;
import com.idsiom.combinationbets.bo.J;
import com.idsiom.combinationbets.bo.MetodoAps;
import com.idsiom.combinationbets.bo.ResultGBO;
import com.idsiom.combinationbets.filtros.FiltroCombPerdedoras;
import com.idsiom.combinationbets.filtros.FiltroPosiblesApsCombinadas;
import com.idsiom.combinationbets.filtros.FiltroPosiblesResultados;

public class PosibilidadesUtils {
	public static List<EscenarioBO> obtenerPosiblesEscenarios(List<J> listJ) {
		List<EscenarioBO> result = new ArrayList<EscenarioBO>();
		
		List<ResultGBO> rSimples = new ArrayList<ResultGBO>();
		
		for(J j : listJ) {
			rSimples.addAll(j.getPosiblesResultados());
		}
		
		//result.addAll( todosLosGrupos( rIndividuales, listJs.size() ) )
		ICombinatoricsVector<ResultGBO> icvRSimples = Factory.createVector(rSimples);
		Generator<ResultGBO> gen = Factory.createSimpleCombinationGenerator(icvRSimples, listJ.size());
		
		//result = Aplicar filtro de result para sacar las combinaciones donde se repite alg�n j
		List<ICombinatoricsVector<ResultGBO>> licvResultadosFiltrados = gen.generateFilteredObjects(new FiltroPosiblesResultados());
		
		int i = 1;
		for(ICombinatoricsVector<ResultGBO> icv : licvResultadosFiltrados) {
			result.add( new EscenarioBO(i, icv) );
			i++;
		}
		
		return result;
	}
	
	public static List<MetodoAps> obtenerPosiblesMetodos(List<J> listJ) {
		List<MetodoAps> result = new ArrayList<MetodoAps>();
		List<ApSimpleBO> sencillos = new ArrayList<ApSimpleBO>();
		List<ApCombinadaBO> combinadas = new ArrayList<ApCombinadaBO>();
		List<IAp> senc_y_comb = new ArrayList<IAp>();
		
		//Suponiendo que la lista es de 2 -- Creo que aplica la misma l�gica para las dem�s APs
		//sencillas.addAll( j1.posiblesApsSencillas() )	
		//sencillas.addAll( j2.posiblesApsSencillas() )
		sencillos = new ArrayList<ApSimpleBO>();
		for(J j : listJ) {
			sencillos.addAll(j.getPosiblesApsSencillas());
		}

		//combinadas.addAll( grupos(sencillas,2) )
		ICombinatoricsVector<ApSimpleBO> icvRsencillos = Factory.createVector(sencillos);
		
		for(int iComb = 2; iComb <= sencillos.size(); iComb++) {
			Generator<ApSimpleBO> gen = Factory.createSimpleCombinationGenerator(icvRsencillos, iComb);
	
			//combinadas = Aplicar el filtro de para eliminar las combinadas que tienen al mismo juego.
			List<ICombinatoricsVector<ApSimpleBO>> licvResultadosFiltrados = gen.generateFilteredObjects(new FiltroPosiblesApsCombinadas());
	
			//transformar la lista a una lista de ApsCombinadas
			for(ICombinatoricsVector<ApSimpleBO> icvApS : licvResultadosFiltrados) {
				combinadas.add(new ApCombinadaBO(icvApS));
			}
		}

		//senc_y_comb.addAll(sencillas)
		//senc_y_comb.addAll(combinadas)
		senc_y_comb.addAll( sencillos );
		senc_y_comb.addAll( combinadas );
		
		System.out.println("Se encuentran la lista de las sencillas y las combinadas. Con un total :: " + senc_y_comb.size());

		//for(int i = 1; i < senc_y_comb.size)
		//	result.addAll( todosLosGruposDeTamanio(senc_y_comb, i) )
		ICombinatoricsVector<IAp> icvIAp = Factory.createVector(senc_y_comb);
		int i2 = 1;
		for(int i = 1; i <= senc_y_comb.size(); i++) {
			Generator<IAp> genIAp = Factory.createSimpleCombinationGenerator(icvIAp, i);
			
			//result = aplicar el filtro correspondiente a las Aps que sean obviamente negativas.
			List<ICombinatoricsVector<IAp>> licvIAp = genIAp.generateFilteredObjects(new FiltroCombPerdedoras());
			
			
			
			for(ICombinatoricsVector<IAp> c : licvIAp) {
				result.add( new MetodoAps(i2, c) );
				i2++;
			}
			
			System.out.println("listo los grupos finales de " + i);
			
		}

		return result;
	}
}
