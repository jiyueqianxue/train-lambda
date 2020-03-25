package io.mine.ft.train.alg.linear;

public class LinkedList<T> {
	
	private Node<T> head;
	
	private int size;
	
	public LinkedList() {
		this.head = new Node<T>();
	}

	public LinkedList(T[] values) {
		this();
		Node<T> rear = head;
		for (T t : values) {
			rear.next = new Node<T>(t, null);
			rear = rear.next;
			++size;
		}
	}
	
	public Node<T> remove(T x) {
		
		Node<T> p = head;
		for (;p.next != null;) {
			
			if (p.next.data == x) {
				p.next = p.next.next;
			}
			p = p.next;
		}
		return p.next;
	}
	
	public Node<T> remove(int index) {
		
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("index下标越界");
		}
		
		return head;
		
	}
	
	//容错i<0，插入到链首，i>size，插入到最后;
	public Node<T> insert(int index, T x) {
		
		Node<T> p = head.next;
		for (int j=0; j<index && p.next != null; j++) {
			p = p.next;
		}
		p.next = new Node<T>(x, p.next);
		return p.next;
	}
}
