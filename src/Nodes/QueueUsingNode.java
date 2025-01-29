package Nodes;


class Queue{
	 Node front;
	 
	 public void add(int data){
		 Node n1 = new Node(data);
		 // Find last node
		 if (front == null){
				front = n1;
		 }else{
			 
			Node last = front;
			while (last.next != null){
				last = last.next;
			}
			last.next = n1;
		 }
	 }
	 
	 public void remove(){
		 if (front != null){
			 front = front.next;
		 }
	 }
	 
	 public void printQueue(){
		Node temp = front;
		System.out.print("[");
		while(temp != null){
			System.out.print(temp.data+", ");
			temp = temp.next;
		} 
		System.out.println(isEmpty()?"empty]":"\b\b]");
	 }
	 
	 public int search(int data){
		 Node temp = front;
		 int index =-1;
		 while (temp!= null){
			 index++;
			 if (temp.data == data){
				 return index;
			 }
			 temp = temp.next;
		 }
		 return -1;
	 }
	 
	 public int size(){
		 Node temp = front;
		 int index = 0;
		 while (temp != null){
			 index++;
			 temp = temp.next;
		 }
		 return index;
	 }
	 public boolean isEmpty(){
		 return front == null;
	 }
	 public void clear(){
		  front = null;
	 }
	 
	 public int peek(){
		 return front != null?front.data:-1;
	 }
	 
	 public int poll(){
		if (isEmpty()){
			return -1;
		}
		int frontData = front.data;
		remove();
		return frontData;
	 }
	 
	class Node{
		 private int data;
		 private Node next;
			Node(int data){
				this.data = data;
			}
	}
 }

class Example1{
	public static void main(String args[]){	
		Queue q1 = new Queue();
		q1.printQueue();// [empty]
		System.out.println("Size of Queue : "+q1.size()); // 0
		q1.add(10);
		q1.add(20);
		q1.add(30);
		q1.add(40);
		q1.add(50);
		
		q1.printQueue(); // [10,20,30,30,50]
		
		q1.remove();
		q1.printQueue();// [20,30,40,50]
		System.out.println("Index 0f 40 :"+q1.search(40));
		System.out.println("Index 0f 99 :"+q1.search(99));
		
		
		int frontData = q1.peek(); // return front element
		System.out.println("front data :"+frontData); // 40
		System.out.println("After Calling peek....");
		q1.printQueue(); // [40,30,20,10]
		System.out.println();
		
		
		frontData = q1.poll();
		System.out.println("front data :"+frontData); // 40
		System.out.println("After Calling poll....");
		q1.printQueue(); // [30,20,10]
		System.out.println();
		
		q1.clear();
		System.out.println("After Calling clear....");
		q1.printQueue();// [empty]
		System.out.println("Size of Queue : "+q1.size()); // 0
		
		
		
		
		
	}
}
