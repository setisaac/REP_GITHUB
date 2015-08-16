package com.idsiom.combinationbets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import com.idsiom.combinationbets.bo.J;
import com.idsiom.combinationbets.bo.LogroBO;
import com.idsiom.combinationbets.bo.MiComparador;
import com.idsiom.combinationbets.bo.Obj;
import com.idsiom.combinationbets.bo.ResultadoEnumBO;

public class MainMapaEscenarios {
	
	
	
	
	
	
	private static HashMap<String, Integer> mapRs = new HashMap<String, Integer>();
	//private static SortedMap<String, Integer> mapRs  = new TreeMap<String, Integer>(java.util.Collections.reverseOrder());
	//private static SortedMap<String, Integer> mapRs  = new TreeMap<String, Integer>();
	
	public static void main(String args[]) {
		System.out.println("Proceso iniciado");
		
		Integer cantVeces = 20000;
		
		
		Boolean nivel2 = true;
		Boolean nivel3 = true;
		
		LogroBO logro = new LogroBO(2.4, 3.3, 3.1);
		LogroBO logro2 = new LogroBO(2.5, 3.2, 3.1);
		LogroBO logro3 = new LogroBO(2.1, 3.3, 3.6);
		LogroBO logro4 = new LogroBO(2.3, 3.1, 3.4);
		
		
		LogroBO logro5 = new LogroBO(1.1, 8.0, 9.0);
		LogroBO logro6 = new LogroBO(1.7, 2.0, 5.0);
		
		List<J> listJ = new ArrayList<J>(); 
		
		listJ.add(new J(1, logro));
		if(nivel2) {
			listJ.add(new J(2, logro2));
			listJ.add(new J(3, logro3));
			
			if(nivel3) {
				listJ.add(new J(4, logro4));
				//listJ.add(new J(5, logro5));
				//listJ.add(new J(6, logro6));	
			}
		}
		
		//List<EscenarioBO> escenarios = PosibilidadesUtils.obtenerPosiblesEscenarios(listJ);
		
		
		// Suponiendo 1 es 125
		// Valor ran cuanto es
		// ran * 125
		
		ResultadoEnumBO r;
		
		String strR;
		Integer newCant;
		StringBuffer sb;
		// Se cicla tantas veces se quiera repetir el proceso
		for(int i = 0; i < cantVeces; i++) {
			//System.out.println(i);
			
			sb = new StringBuffer();
			// Se cicla por cada J del escenario
			for(J j : listJ) {
				// Se obtiene resultado, en base al aleatorio y los porcentajes
				r = j.generarResultadoAletaorio();
			
				// Se crea el string de resultados
				sb.append(r.toString());
				sb.append("_");
			// En el Map, incrementar en un el resultado obtenido	
			}
			
			strR = sb.toString();
			sb = null;
			
			if(!mapRs.containsKey(strR)) {
				mapRs.put(strR, 1);
			} else {
				newCant = mapRs.get(strR) + 1;
				mapRs.put(strR, newCant);
			}
		}
		
		// Realizar los calculos finales, y hacer el ordenamiento del escenario
		System.out.println(mapRs);
		
		// Realizar la impresión de los escenarios en orden, comparando con la probabilidad original.
		//for(String key : mapRs.keySet()) {
		//	System.out.println(key + "%  " + (mapRs.get(key)*100.00/cantVeces));
		//}
		
	
		Iterator<String> iterator = mapRs.keySet().iterator();
		List<Obj> lista = new ArrayList<Obj>();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			Double d = (mapRs.get(key)*100.00/cantVeces);
			//System.out.println(key + "%  " + d);
			
			lista.add(new Obj(key, d));
			
		}
		
		
		for(J j : listJ) {
			System.out.println(j);
		}
		
		System.out.println("---------------->>>>>>>>>>>>>>>>>>>>");
		Collections.sort(lista, new MiComparador());
		Iterator<Obj> iterator2 = lista.iterator();
		while (iterator2.hasNext()) {
			Obj o = iterator2.next();
			System.out.println(imprimirResumen(listJ, o));
			
		}
		
		
		
	}
	
	
	public static String imprimirResumen(List<J> listJ, Obj o) {
		StringBuffer sb = new StringBuffer();
		
		double porcOriginal = 1.0;
		double porcAcumulado;
		double perdidaPorGanarAcumulado;
		double perdidaSinGanar;
		double gananciaIndividual;
		double gananciaMenosPerdida;
		double logroComb = 1.0;
		
		String[] args = o.getStr().split("_");
		double logro;
		for(int i = 0; i < args.length - 1; i++) {
			
			logro = listJ.get(i).getLogro(args[i]);
			porcOriginal = porcOriginal * logro;
			
			logroComb = logroComb * logro;
		}
		
		
		
		sb.append(o.getStr());
		sb.append(";");
		sb.append(o.getPorc());
		sb.append(";");
		sb.append(1/porcOriginal);
		sb.append(";");
		sb.append(logroComb - 1);
		
		
		String result = sb.toString();
		sb = null;
		
		return result;
	}
	
}
