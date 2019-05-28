/**
 * 
 */
package com.alex.designmode.absfac;

import com.alex.designmode.absfac.obj.CPU;
import com.alex.designmode.absfac.obj.IntelCPU;

/**  
* Title: IntelCPUFactory  
* Description:   
* @author wangzi  
* @date 2019年1月8日  
*/
public class IntelCPUFactory implements CPUFactory {

	@Override
	public CPU makeCPU() {
		return new IntelCPU();
	}

}
