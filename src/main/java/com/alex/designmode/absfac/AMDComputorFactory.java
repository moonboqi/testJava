/**
 * 
 */
package com.alex.designmode.absfac;

import com.alex.designmode.absfac.obj.AMDCPU;
import com.alex.designmode.absfac.obj.AMDMainBoard;
import com.alex.designmode.absfac.obj.CPU;
import com.alex.designmode.absfac.obj.MainBoard;

/**  
* Title: AMDComputorFactory  
* Description:   
* @author wangzi  
* @date 2019年1月8日  
*/
public class AMDComputorFactory implements ComputorFactory {
	
	@Override
	public CPU makeCPU() {
		return new AMDCPU();
	}

	@Override
	public MainBoard makeMainBoard() {
		return new AMDMainBoard();
	}
}
