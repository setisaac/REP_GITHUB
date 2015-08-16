package com.idsiom.combinationbets.bo;

import java.util.ArrayList;
import java.util.List;

public class CombResult {
	private List<ResultGBO> combResults;
	
	public CombResult() {
		this.combResults = new ArrayList<ResultGBO>();
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		String result;
		
		sb.append("<");
		int i =1;
		for(ResultGBO rf : this.combResults) {
			sb.append("(escenario=");
			sb.append(i);
			sb.append(" ");
			sb.append(rf.toString());
			sb.append(") ");
			sb.append("\n");
			i++;
		}
		sb.append(">");
		
		result = sb.toString();
		sb = null;
		
		return result;
	}
	
	public void add(ResultGBO r) {
		this.combResults.add(r);
	}

	public List<ResultGBO> getCombResults() {
		return combResults;
	}

	
}
