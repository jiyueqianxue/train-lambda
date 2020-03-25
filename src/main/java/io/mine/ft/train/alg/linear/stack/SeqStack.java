package io.mine.ft.train.alg.linear.stack;

public class SeqStack<T> implements Stack<T> {
	
	
	private Object[] list;
	
	private int length;
	
	private int count;
	

	public SeqStack(int length) {
		this.list = new Object[length];
		this.length = length;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		if (count == 0) {
			//throw new IndexOutOfBoundsException(i+"");   
			return null;
		}
		T temp = (T) list[count-1];
		list[count-1] = null;
		--count;
		return temp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		if (count == 0) {
			//throw new IndexOutOfBoundsException(i+"");   
			return null;
		}
		return (T) list[count-1];
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public boolean push(T t) {
		if (count >= length) {
			//throw new IndexOutOfBoundsException(i+"");   
			return false;
		} else {
			this.list[count] = t;
			++count; 
		}
		return true;
	}

}
