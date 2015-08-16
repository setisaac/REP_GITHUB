package com.idsiom.combinationbets.bo;

import java.text.DecimalFormat;

public class LogroBO {
	private Double logroH;
	
	private Double logroX;
	
	private Double logroV;
	
	private Double pH;
	
	private Double pX;
	
	private Double pV;
	
	private Double pTot;
	
	private Double difP;
	
	private DecimalFormat formateador = new DecimalFormat("%###.##");
	
	public LogroBO(double logroH, double logroX, double logroV) {
		this.setLogroH(logroH); 
		this.setLogroX(logroX);
		this.setLogroV(logroV);
	}
	
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		String result;
		
		sb.append( "(logroH=" );
		sb.append( this.logroH );
		sb.append( " " );
		sb.append( this.getStrPH() );
		
		sb.append( "; logroX=" );
		sb.append( this.logroX );
		sb.append( " " );
		sb.append( this.getStrPX() );
		
		
		sb.append( "; logroV=" );
		sb.append( this.logroV );
		sb.append( " " );
		sb.append( this.getStrPV() );
		
		
		sb.append("; Total=");
		sb.append( this.getStrPTot() );
		sb.append("; Dif=");
		sb.append( this.getStrDif() );
		sb.append( ")" );
		
		result = sb.toString();
		sb = null;
		
		return result;
		
	}
	
	private void calcularProbT() {
		if(this.pH != null && this.pX != null && this.pV != null) {
			this.pTot = this.pH + this.pX + this.pV;
			this.difP = 1.00 - this.pTot;
			
		} else {
			this.pTot = null;
			this.difP = null;
		}
	}

	private String getStrDif() {
		
		return formateador.format(this.difP);
	}

	private String getStrPTot() {
		
		return formateador.format(this.pTot);
	}

	public double getLogroH() {
		return logroH;
	}
	
	public String getStrPH() {
		return formateador.format(this.pH);
	}

	public void setLogroH(double logroH) {
		
		if(logroH != 0) {
			this.pH =  (1/logroH);
		} else {
			this.pH = null;
		}
		
		this.logroH = logroH;
		
		calcularProbT();
	}

	public double getLogroX() {
		return logroX;
	}
	
	public String getStrPX() {
		return formateador.format(this.pX);
	}

	public void setLogroX(double logroX) {
		if(logroX != 0) {
			this.pX =  (1/logroX);
		} else {
			this.pX = null;
		}
		
		
		this.logroX = logroX;
		
		calcularProbT();
	}

	public double getLogroV() {
		return logroV;
	}
	
	public String getStrPV() {
		return formateador.format(this.pV);
	}

	public void setLogroV(double logroV) {
		if(logroV != 0) {
			this.pV =  (1/logroV);
		} else {
			this.pV = null;
		}
		
		this.logroV = logroV;
		
		calcularProbT();
	}
	
	
}
