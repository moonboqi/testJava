/**
 * 
 */
package com.alex.testmybatis;

import static org.junit.Assert.*;

import java.io.File;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.junit.Test;

import com.alex.testmybatis.dao.MailDao;
import com.alex.testmybatis.dao.MailDaoImpl;

/**  
* Title: ABC  
* Description:   
* @author wangzi  
* @date 2019年1月17日  
*/
public class TestMyBatis {
	
//	@Test
//	public void test1() throws Exception {
////		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
////		File file = new File("config.xml");
////		System.out.println(file.getAbsolutePath());
//		Reader reader = Resources.getResourceAsReader("mybatis/config.xml");
//		char[] chs = new char[1024];
//		reader.read(chs);
//		System.out.println(new String(chs));
//	}

    private static MailDao mailDao;
    
    static {
        mailDao = new MailDaoImpl();
    }
    
    @Test
    public void testInsert() {
        Mail mail1 = new Mail(1, "123@sina.com", "个人使用");
        Mail mail2 = new Mail(2, "123@qq.com", "企业使用");
        Mail mail3 = new Mail(3, "123@sohu.com", "注册账号使用");
        System.out.println(mailDao.insertMail(mail1));
        System.out.println(mailDao.insertMail(mail2));
        System.out.println(mailDao.insertMail(mail3));
    }
    
    @Test
    public void testDelete() {
        System.out.println(mailDao.deleteMail(5));
    }
    
    @Test
    public void testUpdate() {
        Mail mail = new Mail(20, "12344@qq.com", "个人使用");
        mail.setId(6);
        System.out.println(mailDao.updateMail(mail));
        System.out.println(mailDao.selectMailById(6));
    }
    
    @Test
    public void testSelectOne() {
        System.out.println(mailDao.selectMailById(7));
    }
    
    @Test
    public void testSelectList() {
        List<Mail> mailList = mailDao.selectMailList();
        if (mailList != null && mailList.size() != 0) {
            for (Mail mail : mailList) {
                System.out.println(mail);
            }
        }
    }
    
}
