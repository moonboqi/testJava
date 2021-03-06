/**
 * 
 */
package com.alex.testmybatis.dao;

import java.util.List;

import com.alex.testmybatis.Mail;

/**  
* Title: AAA  
* Description:   
* @author wangzi  
* @date 2019年1月17日  
*/
public interface MailDao {

    /**
     * 插入一条邮箱信息
     */
    public long insertMail(Mail mail);
    
    /**
     * 删除一条邮箱信息
     */
    public int deleteMail(long id);
    
    /**
     * 更新一条邮箱信息
     */
    public int updateMail(Mail mail);
    
    /**
     * 查询邮箱列表
     */
    public List<Mail> selectMailList();
    
    /**
     * 根据主键id查询一条邮箱信息
     */
    public Mail selectMailById(long id);
    
}
