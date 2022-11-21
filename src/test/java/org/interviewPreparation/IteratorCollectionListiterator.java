package org.interviewPreparation;

import java.util.ListIterator;
import java.util.Vector;

public class IteratorCollectionListiterator {
	
	public static void main(String[] args) {
		Vector<Integer> v =new Vector<Integer>();
		v.add(10);
		v.add(30);
		v.add(60);
		v.add(80);
		v.add(10);
		
		//Used only for List
		//traverse in both Forward and Backward direction
		//remove can be used
		
		ListIterator<Integer> iterator = v.listIterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			System.out.println(next);
			if(next==30)
				iterator.remove();			
		}
		System.out.println("After Removing");
		for (Integer integer : v) {
			System.out.println(integer);
		}
		
		System.out.println("Reverse Order");
		
		while(iterator.hasPrevious())
		{
			System.out.println(iterator.previous());
		}
	}

}
