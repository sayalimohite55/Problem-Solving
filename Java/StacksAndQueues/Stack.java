/**
* Question: Implement a stack without using any built-in data structure
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

class Stack {
	private Node top;
	
	public Stack() {
		this.top = null;
	}
	
	private boolean isEmpty() {
		return (top == null);
	}
	
	private void push(int data) {
		Node newNode = new Node(data);
		
		if(top == null) top = newNode;
		else {
			newNode.next = top;
			top = newNode;
		}
	}
	
	private int pop() {
		int data = top.data;
		top = top.next;
		return data;
	}
	
	private int peek() {
		return top.data;
	}

	public static void main(String args[]) {
		Stack stack = new Stack();
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.print("\n\n1.Push\n2.Pop\n3.Peek\n0.Exit\nEnter your choice: ");
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1: //Push
				System.out.print("Enter data : ");
				int data = scanner.nextInt();
				stack.push(data);
				break;
				
			case 2: //Pop
				if(stack.isEmpty())	System.out.println("\nStack is empty");
				else
					System.out.println("\nPopped element is "+stack.pop());
				break;
				
			case 3: //Peek
				if(stack.isEmpty())	System.out.println("\nStack is empty");
				else
					System.out.println("\nElement at top is "+stack.peek());
				break;
				
			case 0: //Exit
				break;
			}
		}while(choice != 0);
	}	
	
}
