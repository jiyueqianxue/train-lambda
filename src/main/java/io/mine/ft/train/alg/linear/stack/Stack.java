package io.mine.ft.train.alg.linear.stack;

public interface Stack<T> {
	
	T pop();
	
	T peek();
	
	int size();
	
	boolean isEmpty();
	
	boolean push(T t);
	
}
