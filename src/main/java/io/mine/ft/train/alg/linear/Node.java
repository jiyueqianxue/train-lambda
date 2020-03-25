package io.mine.ft.train.alg.linear;

public class Node<T> {
	
	public T data;
	
	public Node<T> next;

	public Node() {
		super();
	}

	public Node(T data, Node<T> next) {
		super();
		this.data = data;
		this.next = next;
	}
}
