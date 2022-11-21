package org.interviewPreparation;

import java.util.Iterator;
import java.util.Vector;

public class IteratorCollectionIterator {
	
	public static void main(String[] args) {
		
		Vector<Integer> v= new Vector<Integer>();
		v.add(10);
		v.add(30);
		v.add(60);
		v.add(80);
		v.add(10);
		
		//Iterate for Collection objects
		//Traverse only in forward direction
		//remove() method can be used here
		
		Iterator<Integer> iterator = v.iterator();
		while(iterator.hasNext())
		{
			Integer next = iterator.next();
			System.out.println(next);
			if(next==30)
				iterator.remove();
		}
		System.out.println("After Removing");
		for (Integer integer : v) {
			System.out.println(integer);
		}		
	}
}
