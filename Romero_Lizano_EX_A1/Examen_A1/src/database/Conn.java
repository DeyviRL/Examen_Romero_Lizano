/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conn {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL="jdbc:mysql://localhost:3306/";
    private final String DB="db_examen";
    private final String USER="root";
    private final String PASSWORD="";
    
    public Connection cadena;
    public static Conn instancia;
    
    public Conn(){
        this.cadena=null;
    }
    
    
    public Connection connect(){
        try {
            Class.forName(DRIVER);
            this.cadena=DriverManager.getConnection(URL+DB,USER,PASSWORD);
                    
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
        return this.cadena;
    }
    
    public void disconnect(){
        try {
            this.cadena.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);

        }
    }
    
    public synchronized static Conn getInstance(){
        if(instancia==null){
            instancia=new Conn();
        }
        return instancia;
    }

}
