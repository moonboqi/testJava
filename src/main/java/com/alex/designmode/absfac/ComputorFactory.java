/**
 * 
 */
package com.alex.designmode.absfac;

import com.alex.designmode.absfac.obj.CPU;
import com.alex.designmode.absfac.obj.MainBoard;

/**  
* Title: ComputorFactory  
* Description:   
* @author wangzi  
* @date 2019年1月8日  
*/
public interface ComputorFactory {
	public CPU makeCPU();
	public MainBoard makeMainBoard();
}
