/*
 * @author Lucas Gomes Dantas (dantaslucas@ufrn.edu.br)
 */
package com.vertumno.list.synchronization;

/**
 * The Class RemoveList is responsible for removing elements on a shared list.
 */
public class RemoveList extends Thread {
	
	/** The shared list. */
	private SharedList sharedList;
	
	/**
	 * Instantiates a new RemoveList.
	 *
	 * @param threadName The thread name
	 * @param sharedList The shared list
	 */
	public RemoveList(String threadName, SharedList sharedList) {
		super(threadName);
		this.sharedList = sharedList;
	}
	
	/**
	 * Generates a random number up to 100 and calls the remove method of the shared list with it.
	 */
	@Override
	public void run() {
		Integer value = (int) (Math.random() * 100) + 1;
		sharedList.remove(value);
	}
}
