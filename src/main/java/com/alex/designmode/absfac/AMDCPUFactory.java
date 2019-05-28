/**
 * 
 */
package com.alex.designmode.absfac;

import com.alex.designmode.absfac.obj.AMDCPU;
import com.alex.designmode.absfac.obj.CPU;

/**  
* Title: MainBoardCPUFactory  
* Description:   
* @author wangzi  
* @date 2019年1月8日  
*/
public class AMDCPUFactory implements CPUFactory {

	@Override
	public CPU makeCPU() {
		return new AMDCPU();
	}
	
}
