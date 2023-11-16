/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;
import data.interfaces.CrudSimpleInterfaces;
import entities.Properties;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Conn;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author ALUMNO
 */
public class PropertiesDAO implements CrudSimpleInterfaces<Properties>{
    private final Conn CONN;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean answer; 
    
    public PropertiesDAO(){
        CONN=Conn.getInstance();
    }
    
        @Override
    public List<Properties> list(String text) {
        List<Properties> records = new ArrayList();
        try {
            ps=CONN.connect().prepareStatement("SELECT * FROM properties WHERE name LIKE ?");
            ps.setString(1,"%"+ text+"%");
            rs=ps.executeQuery();
            while(rs.next()){
                records.add(new Properties(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getDouble(6), rs.getString(7), rs.getString(8)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CONN.disconnect();
        }
        return records;
    }
    
    /*
    public List<Properties> select() {
        List<Properties> records = new ArrayList();
        try {
            ps=CONN.connect().prepareStatement("SELECT id,nombre FROM categoria ORDER BY nombre asc");
            rs=ps.executeQuery();
            while(rs.next()){
                records.add(new Properties(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getDouble(6), rs.getString(7), rs.getString(8)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CONN.disconnect();
        }
        return records;
    }
    
*/
    
    @Override
    public boolean insert(Properties obj) {
        answer=false;
        try {
            ps=CONN.connect().prepareStatement("INSERT INTO properties(name, direction,characteristics, state,priceRent) VALUES (?,?,?,?,?)");
            ps.setString(1,obj.getName());
            ps.setString(2,obj.getDirection());
            ps.setString(3,obj.getCharacteristics());
            ps.setString(4,obj.getState());
            ps.setDouble(5,obj.getPriceRent());

            if (ps.executeUpdate()>0){
                answer=true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }finally{
            ps=null;
            CONN.disconnect();
        }
        return answer;
    }

    @Override
    public boolean update(Properties obj) {
        answer=false;
        try {
            ps=CONN.connect().prepareStatement("UPDATE properties SET name=?,direction=?,characteristics=?,state=?,priceRent=? WHERE id=?");
            ps.setString(1,obj.getName());
            ps.setString(2,obj.getDirection());
            ps.setString(3,obj.getCharacteristics());
            ps.setString(4,obj.getState());
            ps.setDouble(5,obj.getPriceRent());
            ps.setInt(6,obj.getId());
            if (ps.executeUpdate()>0){
                answer=true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }finally{
            ps=null;
            CONN.disconnect();
        }
        return answer;    
    }
    
    @Override
    public boolean delete(int id) {
        answer = false;
        try {
            ps = CONN.connect().prepareStatement("DELETE FROM properties WHERE id = ?");
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                answer = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CONN.disconnect();
        }
        return answer;
    }

    @Override
    public int total() {
        int totalRecords=0;
        try {
            ps=CONN.connect().prepareStatement("SELECT COUNT(id) FROM properties");
            rs=ps.executeQuery();
            while (rs.next()){
                totalRecords=rs.getInt("COUNT(id)");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CONN.disconnect();
        }
        return totalRecords;    
    }

    @Override
    public boolean exist(String text) {
        answer=false;
        try {
            ps=CONN.connect().prepareStatement("SELECT name FROM properties WHERE name=?",
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, text);
            rs=ps.executeQuery();
            rs.last();
            if(rs.getRow()>0){
                answer=true;
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CONN.disconnect();
        }
        return answer;
    }

    
}
