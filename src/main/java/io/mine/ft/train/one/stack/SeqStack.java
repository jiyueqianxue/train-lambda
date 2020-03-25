package io.mine.ft.train.one.stack;

import io.mine.ft.train.one.sequence.SeqList;

public class SeqStack<T> implements Stack<T> {
	
	public SeqList<T> list;

	public SeqStack() {
		this(64);
	}
	
	public SeqStack(int length) {
		list = new SeqList<>(length);
	}

	@Override
	public boolean isEmpty() {
		this.list = new SeqList<>();
		return true;
	}

	@Override
	public void push(T x) {
		list.add(x);
	}

	@Override
	public T peek() {
		return list.get(list.size() -1);
	}

	@Override
	public T pop() {
		return list.remove(list.size()-1);
	}
	
	
	@Override
	public String toString() {
		return list.toString();
	}

	public static void main(String[] args) {
		SeqStack<Integer> stack = new SeqStack<>(20);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack);
		Integer peek = stack.peek();
		System.out.println(peek);
		stack.pop();
		System.out.println(stack);
	}
}
