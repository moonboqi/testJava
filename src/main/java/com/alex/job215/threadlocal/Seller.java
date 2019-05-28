package com.alex.job215.threadlocal;

public class Seller implements Runnable {

	private ThreadLocal<Integer> tl = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
			}
	};
	
	private Integer tl2 = 0;
	
	public void run() {
		for (int i = 0; i < 3; i++) {  
            // ④每个线程打出3个序列值  
//            System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["  
//                     + sn.getNextNum() + "]");  
        }
	}

}
