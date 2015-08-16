package com.idsiom.combinationbets.bo;

import java.util.ArrayList;
import java.util.List;

public class J {
	private Integer id;
	
	private LogroBO logros;
	
	public J(Integer id, LogroBO logros) {
		this.id = id;
		this.logros = logros;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		String result;
		
		sb.append("J");
		sb.append(this.id);
		sb.append(" logros ");
		sb.append(this.logros);
		
		result = sb.toString();
		sb = null;
		
		return result;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LogroBO getLogros() {
		return logros;
	}

	public void setLogros(LogroBO logros) {
		this.logros = logros;
	}
	
	public List<ResultGBO> getPosiblesResultados() {
		List<ResultGBO> result = new ArrayList<ResultGBO>();
		
		result.add(new ResultGBO(this.id, ResultadoEnumBO.H));
		result.add(new ResultGBO(this.id, ResultadoEnumBO.X));
		result.add(new ResultGBO(this.id, ResultadoEnumBO.V));
		
		return result;
	}
	
	public List<ApSimpleBO> getPosiblesApsSencillas() {
		List<ApSimpleBO> simples = new ArrayList<ApSimpleBO>();
		
		simples.add( new ApSimpleBO(this.id, ResultadoEnumBO.H, this.logros.getLogroH()) );
		simples.add( new ApSimpleBO(this.id, ResultadoEnumBO.X, this.logros.getLogroX()) );
		simples.add( new ApSimpleBO(this.id, ResultadoEnumBO.V, this.logros.getLogroV()) );
		
		return simples;
		
	}
	
	public ResultadoEnumBO generarResultadoAletaorio() {
		ResultadoEnumBO result = null;
		
		Double rand = Math.random();
		
		Double invH = 1/this.logros.getLogroH();
		Double invX = 1/this.logros.getLogroX();
		Double invV = 1/this.logros.getLogroV();
		
		Double porcTotal =  invH + invX + invV;
		
		// 1     ...   porcTotal
		// rand  ...   x
		
		Double randEnProporcion = rand * porcTotal;
		
		Double limX = invH + invX;
		
		/*
		System.out.println("InvH " + invH + "  ; invX " + invX + "  ; invV " + invV);
		System.out.println("porcTotal " + porcTotal + "  ; rand " + rand + "  ; randEnProporcion " + randEnProporcion);
		System.out.println("limX " + limX );
		*/
		if(randEnProporcion <= invH) {
			//System.out.println("H");
			return ResultadoEnumBO.H;
		}
		
		if(invH < randEnProporcion && randEnProporcion <= limX) {
			//System.out.println("X");
			return ResultadoEnumBO.X;
		}
		
		if(limX < randEnProporcion) {
			//System.out.println("V");
			return ResultadoEnumBO.V;
		}
		
		return result;
	}

	public Double getLogro(String string) {
		
		if(ResultadoEnumBO.H.getAbreviatura().equals(string)) {
			return this.getLogros().getLogroH();
		}
		
		if(ResultadoEnumBO.X.getAbreviatura().equals(string)) {
			return this.getLogros().getLogroX();
		}
		
		if(ResultadoEnumBO.V.getAbreviatura().equals(string)) {
			return this.getLogros().getLogroV();
		}
		
		return null;
	}
	
	
}
