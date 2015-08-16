package com.idsiom.combinationbets.bo;


public class MiComparador implements java.util.Comparator<Obj> {

		@Override
		public int compare(Obj o1, Obj o2) {
			// TODO Auto-generated method stub
			
			double d1 = o1.getPorc();
			double d2 = o2.getPorc();
			
			return ((int)d2) - ((int)d1);
		}

		
		
	
}
