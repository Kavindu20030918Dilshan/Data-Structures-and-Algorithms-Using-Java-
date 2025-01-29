package Nodes;



 

class Stack{
	 Node top;
	 
	 public void push(int data){
		 Node n1 = new Node(data);
		 n1.next = top;
		 top = n1;
	 }
	 
	 public void pop(){
		 if (top != null){
			 top = top.next;
		 }
	 }
	 
	 public void printStack(){
		Node temp = top;
		System.out.print("[");
		while(temp != null){
			System.out.print(temp.data+", ");
			temp = temp.next;
		} 
		System.out.println(isEmpty()?"empty]":"\b\b]");
	 }
	 
	 public int search(int data){
		 Node temp = top;
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
		 Node temp = top;
		 int index = 0;
		 while (temp != null){
			 index++;
			 temp = temp.next;
		 }
		 return index;
	 }
	 public boolean isEmpty(){
		 return top == null;
	 }
	 public void clear(){
		  top = null;
	 }
	 
	 public int peek(){
		 return top != null?top.data:-1;
	 }
	 
	 public int poll(){
		if (isEmpty()){
			return -1;
		}
		int topData = top.data;
		pop();
		return topData;
	 }
 // ------------------------------------------ Inner Class ---------------------
	class Node{
		 private int data;
		 private Node next;
			Node(int data){
				this.data = data;
			}
	}
	
// ------------------------------------------  Inner Class ---------------------
 }

class Example1{
	public static void main(String args[]){	
		Stack s1 = new Stack();
		s1.printStack();// [empty]
		System.out.println("Size of Stack : "+s1.size()); // 0
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
		s1.push(50);
		
		s1.printStack(); // [50,40,30,20,10]
		
		s1.pop();
		s1.printStack();// [40,30,20,10]
		System.out.println("Index 0f 40 :"+s1.search(40));
		System.out.println("Index 0f 99 :"+s1.search(99));
		
		
		int topData = s1.peek(); // return top element
		System.out.println("Top data :"+topData); // 40
		System.out.println("After Calling peek....");
		s1.printStack(); // [40,30,20,10]
		System.out.println();
		
		
		topData = s1.poll();
		System.out.println("Top data :"+topData); // 40
		System.out.println("After Calling poll....");
		s1.printStack(); // [30,20,10]
		System.out.println();
		
		s1.clear();
		System.out.println("After Calling clear....");
		s1.printStack();// [empty]
		System.out.println("Size of Stack : "+s1.size()); // 0
		
		
		
		
		
	}
}
