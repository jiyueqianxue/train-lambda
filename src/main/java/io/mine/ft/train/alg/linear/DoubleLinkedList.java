package io.mine.ft.train.alg.linear;

public class DoubleLinkedList<T> {
	
	private DoubleNode<T> head;
	
	private int size;

	public DoubleLinkedList() {
		super();
		this.head = new DoubleNode<T>();
		this.head.prev = head;
		this.head.next = head;
	}
	
	public DoubleLinkedList(T[] values) {
		this();
		DoubleNode<T> rear = this.head;
		for (T t : values) {
			rear.next = new DoubleNode<>(t, rear, null);
			rear = rear.next;
			++size;
		}
	}
	
}
