/**
 * 
 */
package com.alex.testAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
* Title: UseCase  
* Description:   
* @author wangzi  
* @date 2019年4月18日  
*/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
     public int id();
     public String description() default "no description";
}
