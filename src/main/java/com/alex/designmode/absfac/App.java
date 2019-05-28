/**
 * 
 */
package com.alex.designmode.absfac;

import com.alex.designmode.absfac.obj.CPU;
import com.alex.designmode.absfac.obj.MainBoard;

/**
 * Title: App Description:
 * 
 * @author wangzi
 * @date 2019年1月8日
 */
public class App {
	public static void main(String[] args) {
		// 第一步就要选定一个“大厂”
		ComputorFactory cf = new AMDComputorFactory();
		// 从这个大厂造 CPU
		CPU cpu = cf.makeCPU();
		// 从这个大厂造主板
		MainBoard board = cf.makeMainBoard();
		System.out.println(cpu.getClass().getName() + "\n" + board.getClass().getName());
		
		// 第一步就要选定一个“大厂”
		ComputorFactory cf2 = new IntelComputorFactory();
		// 从这个大厂造 CPU
		CPU cpu2 = cf2.makeCPU();
		// 从这个大厂造主板
		MainBoard board2 = cf2.makeMainBoard();
		System.out.println(cpu2.getClass().getName() + "\n" + board2.getClass().getName());
	}
}
