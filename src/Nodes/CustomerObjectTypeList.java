package Nodes;
class Customer{
	private String id;
	private String name;
	private String address;
	private double salary;
	
	Customer(){}
	Customer(String id, String name, String address, double salary){
		this.id=id;
		this.name=name;
		this.address=address;
		this.salary=salary;
	}
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	public double getSalary(){
		return salary;
	}
	public void setId(String id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public void setSalary(double salary){
		this.salary=salary;
	}
	public boolean equals(Customer customer){
		return this.id.equalsIgnoreCase(customer.id);
	}
	public String toString(){
		return "["+id+"-"+name+"-"+address+"-"+salary+"]";
	}
}


 
 class List{
	 private Node start;
	 
	 public void addLast(Customer customer){
		 Node n1 = new Node(customer);
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
	 
	 public void addFirst(Customer customer){ // push()
		 Node n1 = new Node(customer);
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
	 public void add(Customer customerata){ // add to the last
		 addLast(customerata);
	 }
	 
	 public void add(int index , Customer customer){
		if (index>=0 && index<=size()){
			if (index == 0){
				addFirst(customer);
			}else{
				Node n1  = new Node(customer); // 1
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
	
	 
	 public Customer get(int index){
		 if (index >=0 && index<size()){
			 int i=0;
			 Node temp = start;
			 while(i<index){
				 temp = temp.next;
				 i++;
			 }
			 return temp.customer;
		 }
		 return null;
	 }
	 
	 
	 

	 
	  public String toString(){
		Node temp = start;
		String list = "[";
		while(temp != null){
			list+=temp.customer+", "; // customer.toString()
			temp = temp.next;
		} 
		return isEmpty()? "{empty}":list+"\b\b}";
	 }
	 
	 public int search(Customer customer){
		 Node temp = start;
		 int index =-1;
		 while (temp!= null){
			 index++;
			 if (customer.equals(temp.customer)){
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
		 private Customer customer;
		 private Node next;
			Node(Customer customer){
				this.customer = customer;
			}
	}
 }

class Example1{
	public static void main(String args[]){	
		List customerList = new List();
		customerList.add(new Customer("C001","Danapala","Dabulla",4000));
		customerList.add(new Customer("C002","Amarapala","Colombo",5000));
		customerList.add(new Customer("C003","Samarapala","Maharagama",6000));
		customerList.add(new Customer("C004","Jinarathna","Tissamaharama",7000));
		customerList.add(new Customer("C005","Wasantha","Kataragama",8000));
		customerList.add(new Customer("C006","Anura","Galle",9000));
		
		System.out.println(customerList);
	}
}
