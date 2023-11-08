package introLabs;

import java.io.*;
import java.util.*;

public class Queue1{
	public static void main (String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("input.txt"));
		Queue<Integer> myQueue = new LinkedList<Integer>();
		while(sc.hasNextInt()) {
			int  num= sc.nextInt();
			myQueue.offer(num);
		}
		
		Queue<Integer> evenQueue = new LinkedList<Integer>();
		Queue<Integer> oddQueue = new LinkedList<Integer>();
		for(int n : myQueue) {
			if(n%2==0) {
				evenQueue.offer(n);
			}
			else {
				oddQueue.offer(n);
			}
		}
		System.out.println(myQueue);
		System.out.println(evenQueue + "\n" +oddQueue);
		
		
	}
///////////////////////////////////////////////////////////////////////////
//
//    		Write a program that implements a Queue data structure.
//          Given an initial myQueue, create two new queues, 
//          oddQueue and evenQueue, so that oddQueue contains the odd
//          elements of myQueue and evenQueue contains the even elements.
//
//  e.g.
//      as in dealing a deck of cards
//
//  e.g.
//      myQueue   -->   43 92 41 39 10 32 62 17 29 51 35 44 24 15 73 66
//
//      oddQueue  -->   43 41 39 17 29 51 35 15 73
//      evenQueue -->   92 10 32 62 44 24 66
//      
//
///////////////////////////////////////////////////////////////////////////
}


