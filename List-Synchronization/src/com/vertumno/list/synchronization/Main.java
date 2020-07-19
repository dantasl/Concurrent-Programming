package com.vertumno.list.synchronization;

public class Main {
	private static final int LIST_SIZE = 100;
	private static final int NUM_THREADS = 3;
	
	public static void main(String[] args) {
		SharedList sharedList = new SharedList(LIST_SIZE);
		
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
