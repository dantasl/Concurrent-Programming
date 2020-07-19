package com.vertumno.list.synchronization;

/**
 * @author Lucas Gomes Dantas
 */

import java.util.LinkedList;

public class SharedList {
	private int size;
	private LinkedList<Integer> list;
	
	public SharedList(int size) {
		this.size = size;
		list = new LinkedList<>();
	}
	
	public synchronized void search(int item) {
		System.out.println(Thread.currentThread().getName() + " is searching for " + item);
		list.contains(item);		
	}
	
	public synchronized void insert(int item) {
		System.out.println(Thread.currentThread().getName() + " is inserting " + item);
		list.add(item);
	}
	
	public synchronized void remove(int item) {
		System.out.println(Thread.currentThread().getName() + " is removing " + item);
		list.remove(item);
	}
}
