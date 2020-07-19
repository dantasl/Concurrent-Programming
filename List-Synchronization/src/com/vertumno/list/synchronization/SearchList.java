package com.vertumno.list.synchronization;

public class SearchList extends Thread {
	private SharedList sharedList;
	
	public SearchList(String threadName, SharedList sharedList) {
		super(threadName);
		this.sharedList = sharedList;
	}
	
	@Override
	public void run() {
		int value = (int) (Math.random() * 100) + 1;
		sharedList.search(value);
	}
}
