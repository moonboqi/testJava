/**
 * 
 */
package com.alex.designmode.adapter.objadapter;

/**  
* Title: CockAdapter  
* Description:   
* @author wangzi  
* @date 2019年1月22日  
*/
//毫无疑问，首先，这个适配器肯定需要 implements Duck，这样才能当做鸭来用
public class CockAdapter implements Duck {

 Cock cock;
 // 构造方法中需要一个鸡的实例，此类就是将这只鸡适配成鸭来用
   public CockAdapter(Cock cock) {
     this.cock = cock;
 }

 // 实现鸭的呱呱叫方法
   @Override
   public void quack() {
     // 内部其实是一只鸡的咕咕叫
     cock.gobble();
 }

   @Override
   public void fly() {
     cock.fly();
 }
   /*
    * 到这里，大家也就知道了适配器模式是怎么回事了。无非是我们需要一只鸭，但是我们只有一只鸡，这个时候就需要定义一个适配器，由这个适配器来充当鸭，但是适配器里面的方法还是由鸡来实现的。
    */
   public static void main(String[] args) {
	    // 有一只野鸡
	      Cock wildCock = new WildCock();
	      // 成功将野鸡适配成鸭
	      Duck duck = new CockAdapter(wildCock);
	      duck.fly();
	      duck.quack();
	}
   
}
