package io.mine.ft.train.one.sequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SeqList<T> implements Iterable<T> {
	
	
	protected Object[] element;
	
	private int size;
	
	     
	public SeqList(int length) {
		element = new Object[length];
		size = 0;
	}
	
	public SeqList() {
		this(64);
	}
	
	
	public SeqList(T[] values) {
		
		if (values == null) {
			return;
		}
		this.element = new Object[values.length*2];
		for (int i=0; i<values.length; i++) {
			element[i] = values[i];
			size++;
		}
	}
	
	public void add(T t) {
		expandCapacity();
		element[size] = t;
		size++;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) {
		checkIndexValid(index);
		return (T)this.element[index];
	}
	public T set(int index, T x) {
		T t = get(index);
		this.element[index] = x;
		return t;
	}
	
	public void add(int index, T x) {
		
		checkAddByIndexValid(index);
		expandCapacity();
		for (int i=size; i>index; i-- ) {
			this.element[i]=this.element[i-1];
		}
		this.element[index] = x;
		size++;
	}
	
	public T remove(int index) {
		T t = this.get(index);
		//int mvNum = size - index -1;
		for (int i=index; i<size-1; i++) {
			this.element[i] = this.element[i+1];
		}
		this.element[--size] = null;
		return t;
	}
	
	public int size() {
	
		return this.size;
	}
	
	private void checkIndexValid(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("index out");
		}
	}
	
	private void checkAddByIndexValid(int index) {
		if (index > size) {
			throw new IndexOutOfBoundsException("index out");
		}
	}
	
	private void expandCapacity() {
		if (size >= element.length) {
			element = Arrays.copyOf(element, element.length*2);
		}
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("SeqList [");
		for (Object obj : this.element) {
			if (obj != null) {
				sb.append(obj.toString() + ",");
			}
		}
		return sb.substring(0, sb.length()-1) + "]";
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		
		List<Integer> list2 = new ArrayList<>();
		//list2.get(0);
		list2.set(0, 12);
		list2.add(2, 33);
//		list2.add(1);
//		list2.add(2);
//		list2.add(3);
//		list2.remove(0);
		Integer t = list2.get(0);
		System.out.println(list2);
		System.out.println(t);
		
		
//		Integer[] nums = {1,2,3,4,5};
//		SeqList<Integer> list = new SeqList<Integer>(nums);
//		list.add(100);
//		System.out.println(list);
//		System.out.println(list.size());
//		list.remove(0);
//		list.remove(1);
//		System.out.println(list);
//		list.add(0, 22);
//		System.out.println(list);
	}

}
