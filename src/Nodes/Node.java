package Nodes;

 class Node{
	 int data;
	 Node next;
		Node(int data){
			this.data = data;
		}
 }

class Example1{
	public static void main(String args[]){	
		Node n1 = new Node(100);
		n1.next = new Node(200);
		n1.next.next = new Node(300);
		n1.next.next.next = new Node(400);
		n1.next.next.next.next = new Node(500);
		n1.next.next.next.next.next = new Node(600);
		
		Node temp = n1;
		
		System.out.print("[");
		while(temp != null){
			System.out.print(temp.data+", ");
			temp = temp.next;
		}
		System.out.println("\b\b]");
		
		
		
		temp = n1;
		System.out.print("[");
		while(temp != null){
			System.out.print(temp.data+", ");
			temp = temp.next;
		}
		System.out.println("\b\b]");
		
		int index = -1;
		temp = n1;
		while (temp != null){
			index++;
			if (temp.data == 400){
				break;
			}
			temp = temp.next;
		}
		
		if (temp == null){
			index = -1;
		}
		System.out.println("Index of 400 is :"+index);
		
		
	}
}
