package io.mine.ft.train.alg.linear;

public class SimpleLinkedList<T> {
	
	private Node<T> head;
	
	private int size;
	
	public SimpleLinkedList() {
		this.head = new Node<T>();
	}

	public SimpleLinkedList(T[] values) {
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
		Node<T> q = null;
		
		for (;p.next != null;) {
			
			if (p.next.data == x) {
				q = p.next;
				p.next = p.next.next;
				--size;
			}
			p = p.next;
		}
		return q;
	}
	
	//容错i<0，删除到链首，i>size，删除到链尾;
	public Node<T> remove(int index) {
		
//		if (index < 0 || index >= size) {
//			throw new IndexOutOfBoundsException("index下标越界");
//		}
		Node<T> p = head;
		for (int j=0; j<index && p.next != null; j++) {
			p = p.next;
		}
		p.next = p.next.next;
		--size;
		return head;
		
	}
	
	//容错i<0，插入到链首，i>size，插入到最后;
	public Node<T> insert(int index, T x) {
		
		Node<T> p = head;
		for (int j=0; j<index && p.next != null; j++) {
			p = p.next;
		}
		p.next = new Node<T>(x, null);
		++size;
		return p.next;
	}
	
	public Node<T> insert(T x) {
		
		return insert(size, x);
	}
	
	@Override
	public String toString() {
		
		Node<T> p = head;
		StringBuilder sb = new StringBuilder("SimpleLinkedList [");
		
		for (;p.next != null;) {
			T t = p.next.data;
			sb.append(t).append(",");
			p = p.next;
		}
		return sb.substring(0, sb.length()-1).concat("]");
	}

	public static void main(String[] args) {
		SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
		list.insert(1);
		list.insert(2);
		System.out.println(list);
		
		
	}
}
