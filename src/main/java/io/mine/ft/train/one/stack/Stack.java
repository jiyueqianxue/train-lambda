package io.mine.ft.train.one.stack;

public interface Stack<T> {
	
	boolean isEmpty();
	
	void push(T x);
	
	T peek();
	
	T pop();
}
