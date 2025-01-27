package Queue;

import java.util.*;

class Queue{
	private int[] dataArray;
	private int nextIndex;
	private double loadFactor;
	private int initsize;
	Queue(int initsize,double loadFactor){
		dataArray = new int[initsize];
		nextIndex = 0;
		this.loadFactor = loadFactor;
		this.initsize = initsize;
	}
	
	public void add(int data){
		if (nextIndex>=dataArray.length){
			extendArray();
		}
		dataArray[nextIndex] = data;
		nextIndex++;
		
	}
	
	private void extendArray(){
		int size = dataArray.length+(int)(dataArray.length*loadFactor);
		int[] tempArray = new int[size];
		for (int i = 0; i <dataArray.length; i++){
			tempArray[i] = dataArray[i];
		}
		
		dataArray = tempArray;
	} 
	
	public void printQueue(){
		System.out.print("[");
		for (int i =0; i<nextIndex; i++){
			System.out.print(dataArray[i]+", ");
		}
		System.out.println(nextIndex<=0?"empty]":"\b\b]");
	}
	
	private boolean isEmpty(){
		return nextIndex<=0;
	}
	public void remove(){
		if (!isEmpty()){
			for (int i = 0; i <nextIndex-1; i++){
				dataArray[i] = dataArray[i+1];
			}
			nextIndex--;
		}
		
	}  
	
	public int capacity(){
		return dataArray.length;
	}
	
	public int size(){
		return nextIndex;
		
		
	}
	
	public void clear(){
		nextIndex = 0;
		dataArray = new int[initsize];
		
	} 
	
	public int peek(){
		if (isEmpty()){
			return -1;
		}
		return dataArray[0];
	}
	
	public int poll(){
		if (isEmpty()){
			return -1;
		}
		int frontData = dataArray[0];
		remove();
		return frontData;
	}
	
	public int search(int data){
		for (int i = 0; i <nextIndex; i++){
			if (dataArray[i] == data){
				return i;
			}
		}
		
		return -1;
		
	}
	
	public int[] toArray(){
		int[] temArray = new int[nextIndex];
		for (int i = 0; i <temArray.length; i++){
			temArray[i] = dataArray[i];
		}
		
		return temArray;
	}
	
	
	
	
}

class Example1{
		public static void main(String [] args){
			Queue q1 = new Queue(10,0.5); // %
			q1.printQueue();
			System.out.println("Capacity :"+q1.capacity()); // 10
			System.out.println("Size :"+q1.size()); // 0
			System.out.println();
			
			q1.add(10);
			q1.add(20);
			q1.add(30);
			q1.add(40);
			q1.add(50);
			q1.add(60);
			q1.add(70);
			q1.add(80);
			q1.add(90);
			q1.add(100);
			
			q1.printQueue(); // [100,90,80,70,60,50,40,30,20,10]
			System.out.println("Capacity :"+q1.capacity());
			System.out.println("Size of Queue :"+q1.size());
			System.out.println();
			q1.add(200);
			
			System.out.println("Index of 40 :"+q1.search(40)); // 6
			System.out.println("Index of 99 :"+q1.search(99)); // -1
			
			System.out.println();
			
			System.out.println("Front Data :"+q1.peek());
			System.out.println("After Calling peek......."); //  100
			q1.printQueue(); // [200,100,90,80,70,60,50,40,30,20,10]
			
			
			System.out.println("Front Data :"+q1.poll());
			System.out.println("After Calling poll......."); //  100
			q1.printQueue(); // [100,90,80,70,60,50,40,30,20,10]
			
			int[] ar = q1.toArray();
			System.out.println("calling toArray :"+Arrays.toString(ar)); // [100,90,80,70,60,50,40,30,20,10]
			
			
			q1.printQueue(); // [200,100,90,80,70,60,50,40,30,20,10]
			System.out.println("Capacity :"+q1.capacity());
			System.out.println("Size of Queue :"+q1.size());
			System.out.println();
			
			
			
			
			q1.clear();
			q1.printQueue(); // [empty]
			System.out.println("Capacity :"+q1.capacity()); // 10
			System.out.println("Size of Queue :"+q1.size()); // 0
			
			
			
			
			
			
			
		}
}
	

 
