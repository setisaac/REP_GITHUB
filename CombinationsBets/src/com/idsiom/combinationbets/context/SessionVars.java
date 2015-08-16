package com.idsiom.combinationbets.context;

import java.util.List;

import com.idsiom.combinationbets.bo.EscenarioBO;

public class SessionVars {
	private static List<EscenarioBO> escenarios;
	
	public static void setEscenarios(List<EscenarioBO> escenarios) {
		SessionVars.escenarios = escenarios;
	}

	public static List<EscenarioBO> getEscenarios() {
		
		
		return escenarios;
	}
	
	
}
