/**
 * 
 */
package com.alex.designmode.absfac;

import com.alex.designmode.absfac.obj.CPU;
import com.alex.designmode.absfac.obj.IntelCPU;
import com.alex.designmode.absfac.obj.IntelMainBoard;
import com.alex.designmode.absfac.obj.MainBoard;

/**  
* Title: IntelComputorFactory  
* Description:   
* @author wangzi  
* @date 2019年1月8日  
*/
public class IntelComputorFactory implements ComputorFactory {

	@Override
	public CPU makeCPU() {
		return new IntelCPU();
	}

	@Override
	public MainBoard makeMainBoard() {
		return new IntelMainBoard();
	}

}
