/*
 * @author Lucas Gomes Dantas (dantaslucas@ufrn.edu.br)
 */
package com.vertumno.list.synchronization;

/**
 * The Class SearchList is responsible for searching elements on a shared list.
 */
public class SearchList extends Thread {
	
	/** The shared list. */
	private SharedList sharedList;
	
	/**
	 * Instantiates a new SearchList.
	 *
	 * @param threadName The thread name
	 * @param sharedList The shared list
	 */
	public SearchList(String threadName, SharedList sharedList) {
		super(threadName);
		this.sharedList = sharedList;
	}
	
	/**
	 * Generates a random number up to 100 and calls the search method of the shared list with it.
	 */
	@Override
	public void run() {
		int value = (int) (Math.random() * 100) + 1;
		sharedList.search(value);
	}
}
