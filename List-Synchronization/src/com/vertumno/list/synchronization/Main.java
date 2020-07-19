/*
 * @author Lucas Gomes Dantas (dantaslucas@ufrn.edu.br)
 */
package com.vertumno.list.synchronization;

/**
 * Main class of the List Synchronization problem.
 * Creates and starts the Threads.
 */
public class Main {
	
	/** The constant NUM_THREADS defines how many threads per type are going to run. */
	private static final int NUM_THREADS = 3;
	
	/**
	 * The main method. It creates the proper amount of threads per type (searches, inserts and removes).
	 * After this, each thread is assigned a name and starts to run. Additionally, all threads receive a join
	 * command in order to sync with this method.
	 * 
	 * @param args No further arguments are necessary to run.
	 */
	public static void main(String[] args) {
		SharedList sharedList = new SharedList();
		
		SearchList[] searches = new SearchList[NUM_THREADS];
		InsertList[] inserts = new InsertList[NUM_THREADS];
		RemoveList[] removes = new RemoveList[NUM_THREADS];
		
		for (int i = 0; i < NUM_THREADS; i++) {
			searches[i] = new SearchList("SearchThread " + (i + 1), sharedList);
			inserts[i] = new InsertList("InsertThread " + (i + 1), sharedList);
			removes[i] = new RemoveList("RemoveThread " + (i + 1), sharedList);
		}
		
		for (int i = 0; i < NUM_THREADS; i++) {
			searches[i].start();
			inserts[i].start();
			removes[i].start();
		}
		
		try {
			for (int i = 0; i < NUM_THREADS; i++) {
				searches[i].join();
				inserts[i].join();
				removes[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
