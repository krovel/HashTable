package com.cg;

public class MyNode<K> implements INode<K> {
	private K key;
	private INode<K> next;

	public MyNode(K key) {
		this.key = key;
		this.next = null;
	}

	public INode<K> getNext() {
		return next;
	}

	public void setNext(INode next) {
		this.next = (INode<K>) next;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}
}