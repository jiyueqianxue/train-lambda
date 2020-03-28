package io.mine.ft.train.alg.linear;

public class CircleSimpleLinkedList<T> {
	
	private Node<T> head;
	
	private Node<T> tail;
	
	private int size;

	public CircleSimpleLinkedList() {

		this.head = new Node<T>();
		this.tail = head;
	}

	public CircleSimpleLinkedList(T[] values) {
		this();
		Node<T> rear = tail;
		for (T t : values) {
			rear.next = new Node<T>(t, null);
			rear = rear.next;
			++size;
		}
		this.tail=rear;
		tail.next = head;
	}
	
	public Node<T> insert(T x) {
		this.tail.next = new Node<T>(x, null);
		tail = tail.next;
		tail.next = head;
		return tail;
	}
	
	public Node<T> remove(T x) {
		Node<T> p = head;
		Node<T> q = null;
		
		for (;p.next != null;) {
			if (x.equals(p.next.data)) {
				q = p.next;
				p.next = p.next.next;
			    --size;
			}
			p = p.next;
		}
		return q;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("CircleSimpleLinkedList [");
		Node<T> p = head;
		for (;p.next != null;) {
			T t = p.next.data;
			sb.append(t).append(",");
		}
		return sb.substring(0, sb.length()-1).concat("]");
	}
	
	
}
