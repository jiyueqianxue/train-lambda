package io.mine.ft.train.one.queue;

import io.mine.ft.train.one.sequence.SeqList;

public class SeqQueue<T> implements Queue<T> {
	
	private int n;
	private int head, tail;
	private SeqList<T> list;
	
	public SeqQueue(int n) {
		this.n = n;
		this.list = new SeqList<>(n);
	}

	@Override
	public boolean isEmpty() {
		if (head == tail) return true; 
		return false;
	}
	
	@Override
	public int size() {
		return tail - head;
	}

	@Override
	public boolean enqueue(T t) {
		if (tail == n) {
			if (head == 0) {
				return false;
			}
			//int mvNum = tail-head;
			for (int i=head; i<tail; i++) {
				list.set(i-head, list.get(i));
			}
			head = 0;
			tail -= head;
		}
		if (tail < list.size()) {
			list.set(tail, t);
		} else {
			list.add(tail, t);
		}
		++tail;
		return true;
	}

	@Override
	public T peek() {
		return list.get(head);
	}

	@Override
	public T dequeue() {
		if (head == tail) return null;
		T t = list.get(head);
		++head;
		return t;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("SeqQueue [");
		for (int i=head; i<tail; i++) {
			sb.append(list.get(i) + ",");
		}
		sb.replace(sb.length()-1, sb.length(), "]");
		return sb.toString();
	}

	public static void main(String[] args) {
		SeqQueue<Integer> queue = new SeqQueue<Integer>(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		System.out.println(queue.enqueue(6));
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue);
	}
}
