package com.idsiom.combinationbets.bo;

public class ApSimpleBO implements IAp {
	private int idG;
	private Double logro;
	private ResultadoEnumBO resultado;
	
	public ApSimpleBO(int idG, ResultadoEnumBO resultado, Double logro) {
		this.idG = idG;
		this.resultado = resultado;
		this.logro = logro;
	}
	

	public String toString() {
		String result;
		StringBuffer sb = new StringBuffer();
		
		sb.append("(");
		sb.append(idG);
		sb.append(";");
		sb.append(resultado);
		sb.append("-");
		sb.append(logro.toString());
		sb.append(")");
		
		result = sb.toString();
		sb = null;
		
		return result;
	}
	
	public Double getLogro() {
		return logro;
	}

	public void setLogro(double logro) {
		this.logro = logro;
	}
	
	public ResultadoEnumBO getResultado() {
		return resultado;
	}


	public void setResultado(ResultadoEnumBO resultado) {
		this.resultado = resultado;
	}


	public int getIdG() {
		return idG;
	}


	public void setIdG(int idG) {
		this.idG = idG;
	}


	@Override
	public Boolean isAcertada(EscenarioBO escenario) {
		
		
		for(ResultGBO r : escenario.getResultados()) {
			if(r.getIdG() == this.idG && r.getResult().equals( this.resultado )) {
				return true;
			}
		}
		
		
		return false;
	}
}
