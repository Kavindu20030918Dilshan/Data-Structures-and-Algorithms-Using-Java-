package LinkedList;


 class Node{
	 int data;
	 Node next;
		Node(int data){
			this.data = data;
		}
 }

class Example1{
	public static void main(String args[]){	
		Node first = new Node(100);
		
		{
			Node n1 = new Node(200);
			n1.next = first;
			first = n1;
		}
		{
			Node n1 = new Node(300);
			n1.next = first;
			first = n1;
		}
		{
			Node n1 = new Node(400);
			n1.next = first;
			first = n1;
		}
		{
			Node n1 = new Node(500);
			n1.next = first;
			first = n1;
		}
		
		System.out.print("[");
		Node temp = first;
		while (temp!=null){
			System.out.print(temp.data+", ");
			temp = temp.next;
		}
		System.out.print("\b\b]");
	}
}
