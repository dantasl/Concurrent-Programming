package com.vertumno.list.synchronization;

public class SearchList extends Thread {
	private SharedList sharedList;
	
	public SearchList(String threadName, SharedList sharedList) {
		super(threadName);
		this.sharedList = sharedList;
	}
	
	@Override
	public void run() {
		sharedList.search(1);
	}
}
