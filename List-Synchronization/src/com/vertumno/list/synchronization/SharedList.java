package com.vertumno.list.synchronization;

import java.util.LinkedList;
import java.util.Queue;

public class SharedList {
	private int size;
	private Queue<Integer> list;
	
	public SharedList(int size) {
		this.size = size;
		list = new LinkedList<Integer>();
	}
	
	public synchronized void search(int item) {
		System.out.println(Thread.currentThread().getName() + " is searching for " + item);
	}
	
	public synchronized void insert(int item) {
		System.out.println(Thread.currentThread().getName() + " is inserting " + item);
	}
	
	public synchronized void remove(int item) {
		System.out.println(Thread.currentThread().getName() + " is removing " + item);
	}
}
