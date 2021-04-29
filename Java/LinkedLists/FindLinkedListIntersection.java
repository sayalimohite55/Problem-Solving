/**
* Question: Write a program to implement singly linked list in java without using any build-in data structure
* Usecases covered :
			1. Check if the two linked lists intersect
			2. If two linked lists intersect then fin the intersection point
*/


class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	Node root;
	
	LinkedList() {
		root = null;
	}
	
	private void createLinkedList(int[] data) {
		int n = data.length;
		for(int i=n-1; i>=0 ; i--) {
			Node newNode = new Node(data[i]);
			
			if(root == null)
				root = newNode;
			else {
				newNode.next = root;
				root = newNode;
			}
		}
	}
	
	private void printList() {
		if(root == null)
			System.out.println("\nList is empty");
		else {
			Node temp = root;
			System.out.println();
			while(temp != null) {
				System.out.print(temp.data+"->");
				temp = temp.next;
			}
			System.out.print("NULL");
		}
	}
	
	private static void findListIntersectionPoint(LinkedList list1, LinkedList list2) {
		int s1=0,s2=0;
		Node p1 = list1.root, p2 = list2.root;
		
		while(p1 != null) {
			s1++;
			p1=p1.next;
		}
		
		while(p2 != null) {
			s2++;
			p2=p2.next;
		}	
		
		if(s1 >= s2) {
			p1 = list1.root;
			p2 = list2.root;
		}
		else {
			p1 = list2.root;
			p2 = list1.root;
		}
		
		for(int i =0; i < Math.abs(s1-s2) ; i++) p1 = p1.next;
		
		while(p1 != null && p1 != null) {
			if(p1 == p2) {
				System.out.println("\nIntersection point is : "+p1.data);
				return;
			}
			p1 = p1.next;
			p2 = p2.next;
		}
		
		System.out.println("\nIntersection point does not exists");
	}
			
	public static void main(String args[]) {
		int[] data1 = {1,2,3,4};
		int[] data2 = {11,22,33,44,55,66,5,6,7,8,9,0};
		
		LinkedList list1 = new LinkedList();
		list1.createLinkedList(data1);
		
		LinkedList list2 = new LinkedList();
		list2.createLinkedList(data2);
	
		//creating a situation where two linkedlists merge
		Node temp1 = list1.root, temp2 =list2.root;
		while(temp1.next != null) temp1 = temp1.next;
		while(temp2.data != 5) temp2 =temp2.next; 
		temp1.next = temp2 ;
		
		System.out.print("\nList1 is : ");
		list1.printList();
		
		System.out.print("\nList2 is : ");
		list2.printList();
		
		findListIntersectionPoint(list1,list2);
	}
}

