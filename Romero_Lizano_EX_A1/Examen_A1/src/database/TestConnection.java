/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;


/**
 *
 * @author jhair
 */
public class TestConnection {
    public static void main(String[] args) {
        Conn conne=Conn.getInstance();
        conne.connect();
        if (conne.cadena!=null){
            System.out.println("conectado correctamente");
        }else{
            System.out.println("desconectado");
        }
    }
}


