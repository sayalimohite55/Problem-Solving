/**
* Question: Write a program to implement singly linked list in java without using any build-in data structure
* Usecases covered :
			1. Create, insert, delete from linkedlist and print linkedlist
			2. Remove Duplicates
			3. Return Kth element to the last element
			4. Delete the middle node
			5. Loop Detection
*/

import java.util.Scanner;
import java.util.HashSet;


class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class SinglyLinkedList {
	private Node root;
	
	SinglyLinkedList() {
		root = null;
	}
	
	private void add(int data) {
		Node newNode = new Node(data);
		
		if(root == null)
			root = newNode;
		else {
			Node temp = root;
			while(temp.next != null)
				temp = temp.next;
			temp.next = newNode;
		}
	}
	
	private void removeLast() {
		if(root == null)
			System.out.println("\nList is empty");
		else if(root.next ==  null) {
			System.out.println("\nRemoved Element : "+root.data);
			root = null;
		}
		else {
			Node temp = root;
			while(temp.next.next != null)
				temp = temp.next;
			
			System.out.println("\nRemoved Element : "+temp.next.data);
			temp.next = null;
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
	
	private void deleteNode(int data) {
		if(root == null)
			System.out.println("\nList is empty");
		else if(root.data == data) {
			root = root.next;
			System.out.println("\nDeleted node "+data);
		}
		else {
			Node temp = root, prev = root;
			while(temp != null) {
				if(temp.data == data) {
					break;
				}
				prev = temp;
				temp = temp.next;
			}
			
			if(temp == null) {
				System.out.println("\n"+data+" not found in the list");
			}
			else {
				prev.next = temp.next;
				System.out.println("\nDeleted node "+data);
			}
		}
	}
	
	void menu() {
		System.out.print("\n\n\n1.Add element\n2.Remove last element\n3.Print Linked List\n4.Delete given data node"
						+"\n5.Remove Duplicates\n6.Print Kth to the Last Element\n7.Delete the middle Node"
						+"\n0.Exit\nEnter your choice : ");
	}
	
	private void removeDuplicates() {
		if(root == null)	System.out.println("\nList is empty");
		else {
			HashSet<Integer> set = new HashSet<>();
			Node temp = root, prev = root;
			
			while(temp != null) {
				if(set.contains(temp.data))
				{
					prev.next = temp.next;
					temp = prev.next;
				}
				else {
					set.add(temp.data);
					prev=temp;
					temp = temp.next;
				}
			}
			printList();
		}
	}
	
	private void kthToLastElement(int k) {
		if(root == null)
			System.out.println("\nList is empty");
		else
		{
			int n =0;
			Node temp = root;
			while(temp != null) {
				n++;
				temp = temp.next;
			}
			
			if(n<k) System.out.println("\nInvalid value of k");
			else if(n==k) System.out.println("\nKth to last element is: "+root.data);
			else {
				temp = root;
				for(int i=1; i<n-k ; i++, temp = temp.next);
				System.out.println("\nKth to last element is: "+temp.data);
			}
		}
	}
	
	private void deleteMiddleNode() {
		if(root == null)
			System.out.println("\nList is empty");
		else
		{
			Node p1 = root, p2 = root;
			while(p2 != null && p2.next != null) {
				p1 = p1.next;
				p2 = p2.next.next;
			}
			
			p2 = p1.next;
			
			int deleteNode = p1.data;
			
			//swap data to delete node
			p1.data = p1.data + p2.data;
			p2.data = p1.data - p2.data;
			p1.data = p1.data - p2.data;
			
			//now delete p2
			p1.next = p2.next;
			p2 = null;
			
			System.out.println("\nMiddle node is "+deleteNode+" and it is deleted");
			printList();
		}
	}
	
	public static void main(String args[]) {
		SinglyLinkedList list = new SinglyLinkedList();
		Scanner scanner = new Scanner(System.in);
		int ch =0;
		do {
			list.menu();
			ch = scanner.nextInt();
			switch(ch) {
			case 1: //Add element
				{
					System.out.print("\nEnter element to be added : ");
					int num = scanner.nextInt();
					list.add(num);
					break;
				}
				
			case 2: // Remove last element
				list.removeLast();
				break;
						
			case 3: //Print List
					list.printList();
					break;
			
			case 4: //Delete given data node
				{
					System.out.print("\nEnter element to be deleted : ");
					int data = scanner.nextInt();
					list.deleteNode(data);
					break;
				}
			
			case 5: //Remove Duplicates
				list.removeDuplicates();
				break;
				
			case 6: //Print Kth to the Last Element
				{
					System.out.print("\nEnter value of K: ");
					int k = scanner.nextInt();
					list.kthToLastElement(k);
					break;
				}
				
			case 7: //Delete the middle Node"
				list.deleteMiddleNode();
				break;
				
			case 0: //Exit
				break;
			}
		}while(ch != 0);
	}
}
