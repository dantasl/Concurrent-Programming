/*
 * @author Lucas Gomes Dantas (dantaslucas@ufrn.edu.br)
 */
package com.vertumno.list.synchronization;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * The Class SharedList.
 * It is a monitor responsible for handling access and data manipulation of a linked list.
 */
public class SharedList {
	
	/** The list to be shared. */
	private LinkedList<Integer> list;
	
	/** The access lock to handle with Read/Write requests. */
	private ReentrantReadWriteLock accessLock;
	
	/** The insert lock to handle with Insert threads. */
	private ReentrantLock insertLock;
	
	/**
	 * Instantiates a new shared list.
	 */
	public SharedList() {
		list = new LinkedList<>();
		accessLock = new ReentrantReadWriteLock(true);
		insertLock = new ReentrantLock(true);
	}
	
	/**
	 * Searches for a given element inside the list. Deals with locks on a read level.
	 *
	 * @param value The value to be searched
	 */
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
	
	/**
	 * Inserts a given element at the back of the linked list.
	 * This method requires two locks: one that puts it as the same level of read operations and other
	 * that implements mutual exclusion on insert operations. 
	 *
	 * @param value The value to be inserted
	 */
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
	
	/**
	 * Removes a given element from the linked list.
	 * This method handles with a write lock and when a remove operation is happening, all other operations
	 * are put on wait.
	 *
	 * @param value The value to be removed
	 */
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
