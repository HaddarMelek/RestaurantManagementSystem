// 
// Decompiled by Procyon v0.6.0
// 

package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.io.InputStream;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class SingletonConnection
{
    Properties props;
    private static String user;
    private static String password;
    private static String url;
    private static Connection connect;
    
    private SingletonConnection() {
        this.props = new Properties();
        try {
            this.props.load(new FileInputStream("Restaurant.properties"));
            SingletonConnection.url = this.props.getProperty("jdbc.url");
            SingletonConnection.user = this.props.getProperty("jdbc.user");
            SingletonConnection.password = this.props.getProperty("jdbc.password");
            SingletonConnection.connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/managerestaurant", "root", "pass");
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        catch (final IOException e2) {
            e2.printStackTrace();
        }
    }
    
    public static Connection getInstance() {
        if (SingletonConnection.connect == null) {
            new SingletonConnection();
        }
        return SingletonConnection.connect;
    }
}
