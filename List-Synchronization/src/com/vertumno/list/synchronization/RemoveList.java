package com.vertumno.list.synchronization;

public class RemoveList extends Thread {
	private SharedList sharedList;
	
	public RemoveList(String threadName, SharedList sharedList) {
		super(threadName);
		this.sharedList = sharedList;
	}
	
	@Override
	public void run() {
		Integer value = (int) (Math.random() * 100) + 1;
		sharedList.remove(value);
	}
}
