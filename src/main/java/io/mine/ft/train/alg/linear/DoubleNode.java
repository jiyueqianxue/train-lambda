package io.mine.ft.train.alg.linear;

public class DoubleNode<T> {
	
	public T data;
	
	public DoubleNode<T> prev;
	
	public DoubleNode<T> next;

	public DoubleNode() {
		super();
	}

	public DoubleNode(T data, DoubleNode<T> prev, DoubleNode<T> next) {
		this(data);
		this.prev = prev;
		this.next = next;
	}

	public DoubleNode(T data) {
		this();
		this.data = data;
	}
}
