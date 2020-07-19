/*
 * @author Lucas Gomes Dantas (dantaslucas@ufrn.edu.br)
 */
package com.vertumno.list.synchronization;

/**
 * The Class InsertList is responsible for inserting elements on a shared list.
 */
public class InsertList extends Thread {
	
	/** The shared list. */
	private SharedList sharedList;
	
	/**
	 * Instantiates a new insert list.
	 *
	 * @param threadName The thread name
	 * @param sharedList The shared list
	 */
	public InsertList(String threadName, SharedList sharedList) {
		super(threadName);
		this.sharedList = sharedList;
	}
	
	/**
	 * Creates a random number up to 100 and calls the insert method of the shared list.
	 */
	@Override
	public void run() {
		int value = (int) (Math.random() * 100) + 1;
		sharedList.insert(value);
	}
}
