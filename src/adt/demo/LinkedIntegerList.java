package adt.demo;

public class LinkedIntegerList {
	
	private int size;
	private Node head;
	private Node tail;
	
	
	public LinkedIntegerList() {
		size = 0;
		head = null;
		tail = null;
	}
	
	
	public boolean add(int item) {
		Node node = new Node(item);
		
		if(tail != null) {
			tail.setNext(node);
		}
		
		if (head == null) {
			head = node;
		}

		tail = node;
		size++;
		
		return true;
	}

	
	public int get(int index) throws IndexOutOfBoundsException {
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index " + index + " out of range (" + size + ")");
		}
		
		Node node = head;
		
		for(int i = 0; i < index; i++) {
			node = node.next();
		}
		
		return node.getValue();
	}
	
	
	public boolean remove(int item) {
		boolean removed = false;
		
		Node node = head;

		while(node.next() != null) {
			// Check if node needs to be removed
			if (node.next().getValue() == item) {
				removed = true;
				node.setNext(node.next().next());
				size--;
			}
			else node = node.next();
		}
		
		return removed;
	} 
	
	
	public int size() {
		return size;
	}
	
	
	
	public String toString() {
		String s = "[";
		
		Node node = head;
		
		while(node != null) {
			s += node.getValue();
			
			if (node.next() != null) {
				s += ", ";
			}
			
			node = node.next();
		}
		
		return s + "]";
	}
	
	
	private class Node {
		private int value;
		private Node link;
		
		Node(int newValue) {
			value = newValue;
			link = null;
		}
		
		int getValue() {
			return value;
		}
		
		void setNext(Node nextNode) {
			link = nextNode;
		}
		
		Node next() {
			return link;
		}
	}
	
}
