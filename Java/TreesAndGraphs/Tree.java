/**
* Question: Implement a Binary Search Tree data structure without using any built-in data structure
* 			Also add methods for tree traversal (In-order, Pre-order and Post-order Traversal)
*/

import java.util.Scanner;


class Node {
	int data;
	Node left, right;
	
	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

class Tree {
	private Node root;

	public Tree() {
		root = null;
	}
	
	private void createTree() {
		Node temp,newNode = new Node(0);
		root = temp = newNode;
		temp.left = new Node(1);
		temp.right = new Node(2);
		
		temp.left.right = new Node(3);
		temp.right.right = new Node(4);
	}
	
	private void inOrderTraversal(Node node) {
		if(node  ==  null) return;
		
		inOrderTraversal(node.left);
		System.out.print(node.data+" ");
		inOrderTraversal(node.right);
	}
	
	private void preOrderTraversal(Node node) {
		if(node  ==  null) return;
		
		System.out.print(node.data+" ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	private void postOrderTraversal(Node node) {
		if(node  ==  null) return;
		
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.data+" ");
	}

	private void treeTraversal() {
		System.out.println("\nIn-order traversal: ");
		inOrderTraversal(root);
		
		System.out.println("\nPre-order traversal: ");
		preOrderTraversal(root);
		
		System.out.println("\nPost-order traversal: ");
		postOrderTraversal(root);
	}
	
	public static void main(String args[]) {
		Tree tree = new Tree();
		tree.createTree();
		tree.treeTraversal();		
	}
}
