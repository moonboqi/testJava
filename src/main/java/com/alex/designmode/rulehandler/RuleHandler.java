/**
 * 
 */
package com.alex.designmode.rulehandler;

/**  
* Title: RuleHandler  
* Description:   
* @author wangzi  
* @date 2019年1月23日  
*/
public abstract class RuleHandler {

    // 后继节点
  protected RuleHandler successor;

//  public abstract void apply(Context context);

  public void setSuccessor(RuleHandler successor) {
      this.successor = successor;
  }
  public RuleHandler getSuccessor() {
      return successor;
  }
}
