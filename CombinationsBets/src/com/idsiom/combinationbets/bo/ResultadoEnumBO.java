package com.idsiom.combinationbets.bo;

public enum ResultadoEnumBO {
	H, X, V;
	
	public String getAbreviatura() {
		if(this.equals(ResultadoEnumBO.H)) {
			return "H";
		}
		
		if(this.equals(ResultadoEnumBO.X)) {
			return "X";
		}
		
		if(this.equals(ResultadoEnumBO.V)) {
			return "V";
		}
		
		return null;
	}
}
