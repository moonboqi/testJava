/**
 * 
 */
package com.alex.testproxy.cglib;

import org.junit.Test;

/**  
* Title: aaa  
* Description:   
* @author wangzi  
* @date 2018年9月25日  
*/
/**
 * 测试类
 */
public class AppTest {

    @Test
    public void test(){
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }
}
