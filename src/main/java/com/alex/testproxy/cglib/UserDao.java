/**
 * 
 */
package com.alex.testproxy.cglib;

/**  
* Title: aa  
* Description:   
* @author wangzi  
* @date 2018年9月25日  
*/
/**
 * 目标对象,没有实现任何接口
 */
public class UserDao {

    public void save() {
        System.out.println("----保存数据成功!----");
    }
}
