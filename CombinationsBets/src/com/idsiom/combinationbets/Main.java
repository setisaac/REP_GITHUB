package com.idsiom.combinationbets;

import java.util.ArrayList;
import java.util.List;

import com.idsiom.combinationbets.bo.EscenarioBO;
import com.idsiom.combinationbets.bo.LogroBO;
import com.idsiom.combinationbets.bo.MetodoAps;
import com.idsiom.combinationbets.util.PosibilidadesUtils;
import com.idsiom.combinationbets.bo.J;
import com.idsiom.combinationbets.context.SessionVars;

public class Main {
	public static void main(String args[]) {
		
		Boolean printEscenarios = true;
		Boolean nivel2 = true;
		Boolean nivel3 = true;
		
		LogroBO logro = new LogroBO(1.31, 5.4, 10.25);
		LogroBO logro2 = new LogroBO(1.23, 6.25, 11.11);
		LogroBO logro3 = new LogroBO(7, 2.3, 1.7);
		LogroBO logro4 = new LogroBO(1.3, 5.0, 12.0);
		LogroBO logro5 = new LogroBO(1.1, 8.0, 9.0);
		LogroBO logro6 = new LogroBO(1.7, 2.0, 5.0);
		
		List<J> listJ = new ArrayList<J>(); 
		
		listJ.add(new J(1, logro));
		if(nivel2) {
			listJ.add(new J(2, logro2));
			
			if(nivel3) {
				listJ.add(new J(3, logro3));
				listJ.add(new J(4, logro4));
				listJ.add(new J(5, logro5));
				listJ.add(new J(6, logro6));	
			}
		}
		
		List<EscenarioBO> escenarios = PosibilidadesUtils.obtenerPosiblesEscenarios(listJ);
		
		SessionVars.setEscenarios(escenarios);
		
		if(printEscenarios) {
			for(EscenarioBO e : escenarios) {
				System.out.println(e);
			}
			
			System.out.println("----------------------------------------------->>>>>>>>>>>>>>>>");
			System.out.println("----------------------------------------------->>>>>>>>>>>>>>>>");
			System.out.println("----------------------------------------------->>>>>>>>>>>>>>>>");
			System.out.println("   ");
			System.out.println("   ");
		}
		
		
		//--------------------------------->>>>>>>>>>
		List<MetodoAps> metodos = PosibilidadesUtils.obtenerPosiblesMetodos(listJ);
		
		
		for(MetodoAps m : metodos) {
			if( m.getId() % 1000 == 0 ) 
				System.out.println(m);
		}
		
		
		System.out.println("Para " + listJ.size() + " juegos. Cantidad total m " + metodos.size());
		for(J j : listJ)
			System.out.println(j);
		
		
	
		
		
		
		
		
	}
}
