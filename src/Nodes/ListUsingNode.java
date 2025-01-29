package Nodes;



 
 class List{
	 private Node start;
	 
	 public void addLast(int data){
		 Node n1 = new Node(data);
		 // Find last node
		 if (start == null){
				start = n1;
		 }else{
			 
			Node last = start;
			while (last.next != null){
				last = last.next;
			}
			last.next = n1;
		 }
	 }
	 
	 public void addFirst(int data){ // push()
		 Node n1 = new Node(data);
		 n1.next = start;
		 start = n1;
	 }
	 
	 public void removeFirst(){ // pop()
		 if (start != null){
			 start = start.next;
		 }
	 }
	 
	 public void removeLast(){
		 if (isEmpty()){
			 return;
		 }
		 
		 if (start.next == null){
			 start = null;
		 }else{
			Node beforeLast = start;
			while (beforeLast.next.next != null){
				beforeLast = beforeLast.next;
			}
			beforeLast.next = null;
		 }
	
	 }
	 public void add(int data){ // add to the last
		 addLast(data);
	 }
	 
	 public void add(int index , int data){
		if (index>=0 && index<=size()){
			if (index == 0){
				addFirst(data);
			}else{
				Node n1  = new Node(data); // 1
				Node temp = start;
				int i = 0;
				while (i<index-1){
					temp = temp.next;
					i++;
				}
				n1.next = temp.next;
				temp.next = n1;
			}
		
		}
		 
		 
	 }
	 public void remove(int index){
		if(index>=0 && index<=size()){
			if (index == 0){
				removeFirst();
			}else{
				
				Node temp = start;
				int i = 0;
				while(i<index-1){
					temp = temp.next;
					i++;
				}
				temp.next = temp.next.next;
			}
		}
	}
	
	 
	 public int get(int index){
		 if (index >=0 && index<size()){
			 int i=0;
			 Node temp = start;
			 while(i<index){
				 temp = temp.next;
				 i++;
			 }
			 return temp.data;
		 }
		 return -1;
	 }
	 
	 
	 
	 public void printList(){
		Node temp = start;
		System.out.print("[");
		while(temp != null){
			System.out.print(temp.data+", ");
			temp = temp.next;
		} 
		System.out.println(isEmpty()?"empty]":"\b\b]");
	 }
	 
	  public String toString(){
		Node temp = start;
		String list = "[";
		while(temp != null){
			list+=temp.data+", ";
			temp = temp.next;
		} 
		return isEmpty()? "empty]":list+"\b\b]";
	 }
	 
	 public int search(int data){
		 Node temp = start;
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
		 Node temp = start;
		 int index = 0;
		 while (temp != null){
			 index++;
			 temp = temp.next;
		 }
		 return index;
	 }
	 public boolean isEmpty(){
		 return start == null;
	 }
	 public void clear(){
		  start = null;
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
		List list1 = new List();
		list1.addLast(10);
		list1.addLast(20);
		list1.addLast(30);
		list1.addLast(40);
		list1.addLast(50);
		list1.printList(); // [10,20,30,40,50]   insertion order
		
		
		list1.addFirst(100);
		list1.printList(); // [100,10,20,22,30,40,50]   insertion order
		
		list1.removeLast();
		list1.printList();// [100,10,20,22,30,40]
	
		list1.add(2,999);
		list1.printList(); // // [100,10,999,20,22,30,40]
		
		list1.add(0,111);
		list1.printList(); // // [111,100,10,999,20,22,30,40]
		
		list1.add(list1.size(),222);
		list1.printList(); // // [111,100,10,999,20,22,30,40]
		
		int data = list1.get(2);
		System.out.println(data); // 999
		
		System.out.println();
		
		for (int i = 0; i < list1.size(); i++){
			System.out.print(list1.get(i)+" ");
		}
		System.out.println();
		list1.printList();
		
		list1.remove(1);
		list1.printList();// 
		
		list1.remove(list1.size()-1);
		list1.printList();// 
		
		System.out.println();
		System.out.println();
		
		System.out.println(list1);
		System.out.println(list1.toString());
		
		System.out.println();
		System.out.println();
		



		list1.remove(0);
		list1.printList();// 
		
		
	}
}
