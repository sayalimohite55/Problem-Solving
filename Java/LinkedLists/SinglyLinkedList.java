/**
* Question: Write a program to implement singly linked list in java without using any build-in data structure
*/

import java.util.Scanner;

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
	
	void menu() {
		System.out.print("\n1.Add element\n2.Remove last element\n3.Print Linked List\n4.Delete given data node"
						+"\n0.Exit\nEnter your choice : ");
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
				{
					list.removeLast();
					break;
				}
			
			case 3: //Print List
				{
					list.printList();
					break;
				}
			
			case 4: //Delete given data node
				{
					System.out.print("\nEnter element to be deleted : ");
					int data = scanner.nextInt();
					list.deleteNode(data);
					break;
				}
				
			case 0: //Exit
				break;
			}
		}while(ch != 0);
	}
}
