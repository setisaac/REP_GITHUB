package com.idsiom.combinationbets.bo;

public class ResultGBO {
	private int idG;
	private ResultadoEnumBO result;
	
	public ResultGBO(int idG, ResultadoEnumBO result) {
		this.idG = idG;
		this.result = result;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		String str;
		
		sb.append("idG=");
		sb.append(idG);
		sb.append(" ");
		sb.append(result);
		
		str = sb.toString();
		sb = null;
		
		return str;
	}
	
	public Boolean equals(ResultGBO other) {
		if(this.idG == other.getIdG() && this.result.equals(other.getResult())) {
			return true;
		}
		
		return false;
		
	}
	
	
	public int getIdG() {
		return idG;
	}
	public void setIdG(int idG) {
		this.idG = idG;
	}
	public ResultadoEnumBO getResult() {
		return result;
	}
	public void setResult(ResultadoEnumBO result) {
		this.result = result;
	}
	
	
}
