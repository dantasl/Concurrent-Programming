package com.vertumno.list.synchronization;

/**
 * @author Lucas Gomes Dantas
 */

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedList {
	private LinkedList<Integer> list;
	private ReentrantReadWriteLock accessLock;
	private ReentrantLock insertLock;
	
	public SharedList() {
		list = new LinkedList<>();
		accessLock = new ReentrantReadWriteLock(true);
		insertLock = new ReentrantLock(true);
	}
	
	public void search(int value) {
		System.out.println(Thread.currentThread().getName() + " is trying to acquire read lock for searching value " + value + ".");		
		accessLock.readLock().lock();
		System.out.println(Thread.currentThread().getName() + " just acquired read lock for searching.");
		
		try {
			System.out.println("Element " + value + " is in list? " + list.contains(value));
		} finally {
			accessLock.readLock().unlock();
			System.out.println(Thread.currentThread().getName() + " finished the search and released the read lock.");
		}		
	}
	
	public void insert(int value) {
		System.out.println(Thread.currentThread().getName() + " is trying to acquire lock for inserting value " + value + ".");		
		accessLock.readLock().lock();
		insertLock.lock();
		System.out.println(Thread.currentThread().getName() + " just acquired lock for inserting.");
				
		try {
			list.add(value);
			System.out.println("Element " + value + " inserted at the back of the list.");
		} finally {
			insertLock.unlock();
			accessLock.readLock().unlock();
			System.out.println(Thread.currentThread().getName() + " finished inserting and released the lock.");
		}
	}
	
	public void remove(Integer value) {
		System.out.println(Thread.currentThread().getName() + " is trying to acquire write lock for removing value " + value + ".");		
		accessLock.writeLock().lock();
		System.out.println(Thread.currentThread().getName() + " just acquired write lock for removing.");
		
		try {
			if (list.remove(value)) {
				System.out.println("Element " + value + " removed from the list.");
			} else {
				System.out.println("Element " + value + " not removed because he was not in the list.");
			}
		} finally {
			accessLock.writeLock().unlock();
			System.out.println(Thread.currentThread().getName() + " finished the remove and released the write lock.");
		}
	}
}
