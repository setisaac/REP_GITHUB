package com.idsiom.combinationbets.bo;

public class Obj {
		private String str;
		private Double porc;
		
		public Obj(String str, Double porc) {
			this.str = str;
			this.porc = porc;
		}
		
		public String toString() {
			StringBuffer sb = new StringBuffer();
			
			sb.append(this.str);
			sb.append(" ");
			sb.append(this.porc);
			
			String result = sb.toString();
			sb = null;
			
			
			return result;
		}
		
		public String getStr() {
			return str;
		}
		public void setStr(String str) {
			this.str = str;
		}
		public Double getPorc() {
			return porc;
		}
		public void setPorc(Double porc) {
			this.porc = porc;
		}
		
		
	
}
