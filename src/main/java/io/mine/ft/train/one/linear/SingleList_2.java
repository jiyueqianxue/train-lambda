package io.mine.ft.train.one.linear;

public class SingleList_2<T> {
	
	public Node<T> head;
	
	public Node<T> rear;
	
	public SingleList_2() {
		this.head = new Node<T>();
		this.rear = this.head;
	}
	
	public SingleList_2(T[] values) {
		this();
		if (values == null) {
			return;
		}
		for (T t : values) {
			rear.setNext(new Node<T>(t, null));
			rear = rear.getNext();
		}
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
		rear.setNext(new Node<T>(data, null));
		rear = rear.getNext();
		return rear;
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
		Integer[] x={1,2,3,4};
		SingleList_2<Integer> singleList = new SingleList_2<>(x);
		System.out.println(singleList);
		singleList.insert(55);
		System.out.println(singleList);
	}
}
