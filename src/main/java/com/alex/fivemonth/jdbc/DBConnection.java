/**
 * 
 */
package com.alex.fivemonth.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**  
* Title: bb  
* Description:   
* @author alexw  
* @date 2019年9月16日  
*/
public class DBConnection
{    
    private static Properties properties = new Properties();
    
    static
    {
        /** 要从CLASSPATH下取.properties文件，因此要加"/" */
        InputStream is = DBConnection.class.getResourceAsStream("/db.properties");
        try
        {
            properties.load(is);
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /** 这个mysqlConnection只是为了用来从里面读一个PreparedStatement，不会往里面写数据，因此没有线程安全问题，可以作为一个全局变量 */
    public static Connection mysqlConnection = getConnection();
    
    public static Connection getConnection()
    {
        Connection con = null;
        try
        {
            Class.forName((String)properties.getProperty("mysqlpackage"));
            con = DriverManager.getConnection((String)properties.getProperty("mysqlurl"), 
                    (String)properties.getProperty("mysqlname"), 
                    (String)properties.getProperty("mysqlpassword"));
        } 
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }
}
