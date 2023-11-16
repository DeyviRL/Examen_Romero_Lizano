/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package data.interfaces;

import java.util.List;

/**
 *
 * @author jhair
 */
public interface CrudSimpleInterfaces<T> {
    public List<T> list (String text);
    public boolean insert (T obj);
    public boolean update(T obj);
    public boolean delete(int id);
    public int total();
    public boolean exist(String text);
}
