package org.interviewPreparation;

import java.util.Enumeration;
import java.util.Vector;

public class IterateCollectionEnumeration {
	
	public static void main(String[] args) {
		Vector<Integer> v=new Vector<Integer>();
		v.add(10);
		v.add(30);
		v.add(60);
		v.add(80);
		v.add(10);
		
		//mainly used for legacy classes Eg: vector, Hashtable
		//Remove() method cannot be used
		Enumeration<Integer> elements = v.elements();
		while(elements.hasMoreElements())
		{
			Integer nextElement = elements.nextElement();
			System.out.println(nextElement);
		}
		
		
		
	}

}
