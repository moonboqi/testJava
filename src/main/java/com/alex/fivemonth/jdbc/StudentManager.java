/**
 * 
 */
package com.alex.fivemonth.jdbc;

/**  
* Title: abc  
* Description:   
* @author alexw  
* @date 2020年5月26日  
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentManager
{
    private static StudentManager instance = new StudentManager();
    
    private StudentManager()
    {
        
    }
    
    public static StudentManager getInstance()
    {
        return instance;
    }
    
    public List<Student> querySomeStudents(String studentName) throws Exception
    {
        List<Student> studentList = new ArrayList<Student>();
        Connection connection = DBConnection.mysqlConnection;
        PreparedStatement ps = connection.prepareStatement("select * from student where studentName = ?");
        ps.setString(1, studentName);
        ResultSet rs = ps.executeQuery();
        
        Student student = null;
        while (rs.next())
        {
            student = new Student(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
            studentList.add(student);
        }
        
        ps.close();
        rs.close();
        return studentList;
    }
    
    public void addStudent(String studentName, int studentAge, String studentPhone) throws Exception
    {
        Connection connection = DBConnection.mysqlConnection;
        PreparedStatement ps = connection.prepareStatement("insert into student values(null,?,?,?)");
        ps.setString(1, studentName);
        ps.setInt(2, studentAge);
        ps.setString(3, studentPhone);
        if (ps.executeUpdate() > 0)
            System.out.println("添加学生信息成功");
        else
            System.out.println("添加学生信息失败");    
    }
    
    public void addStudentHandle(String studentName, int studentAge, String studentPhone) throws Exception
    {
        Connection connection = DBConnection.mysqlConnection;
        connection.setAutoCommit(false);
        PreparedStatement ps = connection.prepareStatement("insert into student values(null,?,?,?)");
        ps.setString(1, studentName);
        ps.setInt(2, studentAge);
        ps.setString(3, studentPhone);
        try
        {
            ps.executeUpdate();
            connection.commit();
            System.out.println("Handle方法添加学生信息成功");
        } 
        catch (Exception e)
        {
            e.printStackTrace();
            connection.rollback();
            System.out.println("Handle方法添加学生信息失败");    
        }
    }
}
