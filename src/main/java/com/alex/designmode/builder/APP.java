/**
 * 
 */
package com.alex.designmode.builder;

/**  
* Title: App  
* Description:   
* @author wangzi  
* @date 2019年1月14日  
*/
public class APP {
    public static void main(String[] args) {
        User user = User.builder()
                .name("foo")
                .password("pAss12345")
                .age(25)
                .build();
        System.out.println(user);
    }
}
