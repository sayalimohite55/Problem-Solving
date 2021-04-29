/**
* Question: Implement a stack without using any built-in data structure.
*			Also in addition to push and pop functions, write a function min which returns the minimum element from the stack.
*			Note that all functions (push, pop, min, peek, isEmpty) should operate on a constant time of O(1).
*/

import java.util.Scanner;
import java.util.Stack;

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

class MyStack {
	private Node top;
	private Stack<Integer> minStack; //This will keep track of min elements
		
	public MyStack() {
		this.top = null;
		minStack = new Stack<>();
	}
	
	private boolean isEmpty() {
		return (top == null);
	}
	
	private void push(int data) {
		Node newNode = new Node(data);
		if(top == null) {
			top = newNode;
			minStack.push(data);
		}
		else {
			newNode.next = top;
			top = newNode;
			if(minStack.peek() >= data)
				minStack.push(data);
		}
	}
	
	private int pop() {
		int data = top.data;
		top=top.next;
		
		if(data <= minStack.peek()) {
			minStack.pop();
		}
		return data;
	}
	
	private int peek() {
		return top.data;
	}
	
	private int min() {
		return minStack.peek();
	}

	public static void main(String args[]) {
		MyStack myStack = new MyStack();
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.print("\n\n1.Push\n2.Pop\n3.Peek\n4.Min\n0.Exit\nEnter your choice: ");
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1: //Push
				System.out.print("Enter data : ");
				int data = scanner.nextInt();
				myStack.push(data);
				break;
				
			case 2: //Pop
				if(myStack.isEmpty())	System.out.println("\nStack is empty");
				else
					System.out.println("\nPopped element is "+myStack.pop());
				break;
				
			case 3: //Peek
				if(myStack.isEmpty())	System.out.println("\nStack is empty");
				else
					System.out.println("\nElement at top is "+myStack.peek());
				break;
			
			case 4: //Min
				if(myStack.isEmpty())	System.out.println("\nStack is empty");
				else
					System.out.println("\nMinimum element is "+myStack.min());
				break;
				
			case 0: //Exit
				break;
			}
		}while(choice != 0);
	}	
}
