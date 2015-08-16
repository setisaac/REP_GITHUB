package com.idsiom.combinationbets;

import com.idsiom.combinationbets.bo.J;
import com.idsiom.combinationbets.bo.LogroBO;
import com.idsiom.combinationbets.bo.ResultadoEnumBO;

public class MainPrueba {

	public static void main(String[] args) {
		//LogroBO logro = new LogroBO(2, 3.2, 2.1);
		LogroBO logro = new LogroBO(1.31, 5.4, 10.25);
		ResultadoEnumBO r;
		J j = new J(1, logro);
		
		int cantH = 0;
		int cantX = 0;
		int cantV = 0;
		int repeticiones = 100;
		
		System.out.println(j);
		
		System.out.println("repeticiones " + repeticiones);
		
		for(int i = 1; i < repeticiones; i++) {
			//System.out.println("------------>>>>>>>>>>>>" );
			r = j.generarResultadoAletaorio();
			//System.out.println("MAIN_RESULT :: " + r);
			//System.out.println("--->>>" );
			
			if(r.equals(ResultadoEnumBO.H)) {
				cantH++;
			}
			
			if(r.equals(ResultadoEnumBO.X)) {
				cantX++;			
			}
			
			if(r.equals(ResultadoEnumBO.V)) {
				cantV++;
			}
			
		}
		
		System.out.println("cantH " + cantH + ";  cantX " + cantX + ";  cantV " + cantV);
		System.out.println("cantH% " + ((cantH*100)/(cantH + cantX + cantV)) );
		System.out.println("cantX% " + ((cantX*100)/(cantH + cantX + cantV)) );
		System.out.println("cantV% " + ((cantV*100)/(cantH + cantX + cantV)) );
		
	}
}
