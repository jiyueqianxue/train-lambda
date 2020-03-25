package io.mine.ft.train.one.queue;

public interface Queue<T> {
	
	public boolean isEmpty();
	
	public int size();
	
	public T peek(); //返回队头元素，没有删除。若队列空，则返回null
	
	public T dequeue();
	
	public boolean enqueue(T x);

}
