/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;
import data.PropertiesDAO;
import entities.Properties;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ALUMNO
 */
public class PropertiesControl {
    private final PropertiesDAO DATA;
    private final Properties obj;
    private DefaultTableModel modelTable;
    public int recordsDisplayed;
    
        public PropertiesControl(){
        this.DATA=new PropertiesDAO();
        this.obj=new Properties();
        this.recordsDisplayed=0;
    }
        
    public DefaultTableModel list(String text){
        List <Properties> list = new ArrayList();
        list.addAll(DATA.list(text));
        String[] titles = {"Id","Nombres","Direccion","Caracteristicas","estado","Precio de renta","Fecha creacion","Fecha actualizacion"};
        this.modelTable=new DefaultTableModel(null, titles);
        String[] register=new String[8];
        
        this.recordsDisplayed=0;    
        
        for (Properties item:list){
            /*
            if (item.isState()){
               state="Activo";
            }else{
                state="Inactivo";
            }
           */
            register[0]=Integer.toString(item.getId());
            register[1]=item.getName();
            register[2]=item.getDirection();
            register[3]=item.getCharacteristics();
            register[4]=item.getState();
            register[5]=Double.toString(item.getPriceRent());
            register[6]=item.getCreated_at();
            register[7]=item.getUpdated_at();
            this.modelTable.addRow(register);
            this.recordsDisplayed=this.recordsDisplayed+1;
        }
        return this.modelTable;
    }
    
    public String insert(String name, String direction,String characteristics,String state,double priceRent){
        if(DATA.exist(name)){
            return "El registro ya existe";
        }else{
            obj.setName(name);
            obj.setDirection(direction);
            obj.setCharacteristics(characteristics);
            obj.setState(state);
            obj.setPriceRent(priceRent);


            if(DATA.insert(obj)){
                return "OK";
            }else{
                return "Error en el registro";
            }
        }
    }
    
    public String update(int id,String name,String namePre, String direction,String characteristics,String state,double priceRent){
        if(name.equals(namePre)){
            obj.setId(id);
            obj.setName(name);
            obj.setDirection(direction);
            obj.setCharacteristics(characteristics);
            obj.setState(state);
            obj.setPriceRent(priceRent);

            if(DATA.update(obj)){
                return "OK";
            }else{
                return "Error en la actualizacion";
            }
        }else{
            if(DATA.exist(name)){
               return "El registro ya existe";
            }else{
                obj.setId(id);
                obj.setName(name);
                obj.setDirection(direction);
                obj.setCharacteristics(characteristics);
                obj.setState(state);
                obj.setPriceRent(priceRent);
                if(DATA.update(obj)){
                    return "OK";
                }else{
                    return "Error en la actualizacion";
                }
            }
        }
    }
    
    public String delete(int id){
        if (DATA.delete(id)) {
            return "OK";
        } else {
           return "Error al eliminar el registro.";
        } 
        
    }
    
    public int total(){
        return DATA.total();
    }
    
    public int totalDisplayed(){
        return this.recordsDisplayed;
    }

}
