package com.cg;

public class MyLinkedList<K> {
	private INode head;
	private INode tail;

	public INode getHead() {
		return head;
	}

	public INode getTail() {
		return tail;
	}

	public MyLinkedList() {
		this.head = head;
		this.tail = tail;
	}

	public void add(INode newNode) {
		if (tail == null)
			this.tail = newNode;
		if (head == null)
			this.head = newNode;
		else {
			INode tempNode = this.head;
			this.head = newNode;
			newNode.setNext(tempNode);
		}
	}

	public <K extends Comparable<K>> void addOrdered(INode newNode) {
		if (head == null || (((Comparable<K>) head.getKey()).compareTo((K) newNode.getKey()) >= 0)) {
			newNode.setNext(head);
			this.head = newNode;
		} else {
			INode tempNode = head;
			while (tempNode.getNext() != null
					&& (((Comparable<K>) tempNode.getNext().getKey()).compareTo((K) newNode.getKey())) < 0) {
				tempNode = tempNode.getNext();
			}
			if (tempNode.getNext() == null) {
				INode myNode = search(tempNode.getKey());
				myNode.setNext(newNode);
				this.tail = newNode;
			} else {
				newNode.setNext(tempNode.getNext());
				INode myNode = search(tempNode.getKey());
				myNode.setNext(newNode);
			}
		}
	}

	public void append(INode newNode) {
		if (head == null)
			this.head = newNode;
		if (tail == null)
			this.tail = newNode;
		else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}

	public void printMyList() {
		System.out.print("My List is : ");
		StringBuffer myList = new StringBuffer();
		INode tempNode = head;
		while (!tempNode.equals(tail)) {
			myList.append(tempNode.getKey());
			myList.append("->");
			tempNode = tempNode.getNext();
		}
		myList.append(tempNode.getKey());
		System.out.println(myList);
	}

	public void insert(INode myNode, INode newNode) {
		INode tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}

	public INode deleteTop() {
		INode tempNode = this.head;
		this.head = head.getNext();
		return tempNode;
	}

	public INode deleteBottom() {
		INode tempNode = head;
		while (!tempNode.getNext().equals(tail)) {
			tempNode = tempNode.getNext();
		}
		this.tail = tempNode;
		tail.setNext(null);
		tempNode = tempNode.getNext();
		return tempNode;
	}

	public <K> INode search(K key) {
		INode tempNode = head;
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().equals(key)) {
				return tempNode;
			}
			tempNode = tempNode.getNext();
			if (tempNode.getKey().equals(key)) {
				return tempNode;
			}
		}
		return null;
	}

	public void insertAfter(K myKey, K newKey) {
		INode myNode = search(myKey);
		if (myNode != null) {
			insert(myNode, new MyNode(newKey));
			System.out.println("Element inserted");
		} else
			System.out.println("Element not inserted");
	}

	public void deleteElement(K key) {
		INode deleteNode = search(key);
		INode tempNode = head;
		if (deleteNode != null) {
			if (head.getKey().equals(deleteNode.getKey()))
				deleteTop();
			else if (tail.getKey().equals(deleteNode.getKey()))
				deleteBottom();
			else {
				while (!tempNode.getNext().getKey().equals(deleteNode.getKey())) {
					tempNode = tempNode.getNext();
				}
				tempNode.setNext(deleteNode.getNext());
			}
		}
	}

	public int size() {
		int size = 0;
		INode tempNode = head;
		while (tempNode != null) {
			size++;
			tempNode = tempNode.getNext();
		}
		return size;
	}

	@Override
	public String toString() {
		return "MyLinkedListNodes{" + head + "}";
	}
}