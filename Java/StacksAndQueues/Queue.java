/**
* Question: Implement a queue without using any built-in data structure
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

class Queue {
	//We will add element at rear and re,move element from front to impelement FIFO
	private Node front, rear; 
	
	public Queue() {
		this.front = this.rear = null;
	}
	
	private boolean isEmpty() {
		return (rear == null);
	}
	
	private void enqueue(int data) {
		Node newNode = new Node(data);
		
		if(rear == null) rear = front = newNode;
		else {
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	private int dequeue() {
		int data = front.data;
		if(front == rear)
			rear = rear.next;
		front = front.next;
		return data;
	}
	
	private int peek() {
		return front.data;
	}

	public static void main(String args[]) {
		Queue queue = new Queue();
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.print("\n\n1.Enqueue\n2.Dequeue\n3.Peek\n0.Exit\nEnter your choice: ");
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1: //Push
				System.out.print("Enter data : ");
				int data = scanner.nextInt();
				queue.enqueue(data);
				break;
				
			case 2: //Pop
				if(queue.isEmpty())	System.out.println("\nQueue is empty");
				else
					System.out.println("\nRemoved element is "+queue.dequeue());
				break;
				
			case 3: //Peek
				if(queue.isEmpty())	System.out.println("\nQueue is empty");
				else
					System.out.println("\nElement at front is "+queue.peek());
				break;
				
			case 0: //Exit
				break;
			}
		}while(choice != 0);
	}	
	
}
