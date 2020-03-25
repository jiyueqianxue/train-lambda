package io.mine.ft.train.one.linear;

public class SingleList<T> {
	
	public Node<T> head;
	
	private int size = 0;
	
	public SingleList() {
		this.head = new Node<T>();
	}
	
	public SingleList(T[] values) {
		this();
		if (values == null) {
			return;
		}
		Node<T> rear = this.head;
		for (T t : values) {
			rear.setNext(new Node<T>(t, null));
			rear = rear.getNext();
			size ++;
		}
	}
	/**
	 * 单链表长度
	 * @return
	 */
	public int size() {
		return size;
	}
	/**
	 * 从尾部插入
	 * @param data
	 * @return
	 */
	public Node<T> insert (T data) {
		if (data == null) {
			return null;
		}
		Node<T> front = this.head;
		
		for (;front.getNext() != null;) {
			front = front.getNext();
		}
		front.setNext(new Node<T>(data, null));
		size ++;
		return front.getNext();
		
	}
	
	/**
	 * 删除第i个, 0<= i < size
	 * @param data
	 * @return
	 */
	public T remove(int i) {
		if (i >= size) {
			throw new IndexOutOfBoundsException("i>=size");
		}
		Node<T> p = this.head;
		for (int j=0; p!=null && j<i; j++) {
			p = p.getNext();
		}
		//p指向第i-1个节点, 取出第i个节点
		Node<T> target = p.getNext();
		T old = target.getData();
		p.setNext(target.getNext());
		target = null;
		size --;
		return old;
	}  
	
	public void set(int i, T x) {
		if (i >= size) {
			throw new IndexOutOfBoundsException("i>=size");
		}
		Node<T> p = this.head;
		//p移动，指向第i-1个节点
		for (int j=0; j<i && p!=null; j++ ) {
			p = p.getNext();
		}
		p.getNext().setData(x);
	}
	
	public T get(int i) {
		if (i >= size) {
			throw new IndexOutOfBoundsException("i>=size");
		}
		Node<T> p = this.head;
		//p移动，指向第i-1个节点
		for (int j=0; j<i && p!=null; j++ ) {
			p = p.getNext();
		}
		return p.getNext().getData();
	}
	
	@Override
	public String toString() {
		
		Node<T> front = this.head;
		StringBuilder sb = new StringBuilder("SingleList [");
		for (;front.getNext() != null;) {
			Node<T> current = front.getNext();
			sb.append(current.getData() + ",");
			front = current;
		}
		return sb.replace(sb.length()-1, sb.length(), "]").toString();
	}

	public static void main(String[] args) {
		Integer[] x = {1,2,3,4};
		SingleList<Integer> singleList = new SingleList<>(x);
		System.out.println(singleList);
		singleList.insert(55);
		System.out.println(singleList);
		System.out.println(singleList.size());
		
		System.out.println(singleList.remove(4));
		System.out.println(singleList);
		singleList.set(3, 55);
		System.out.println(singleList.get(3));
		
	}
}
