/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USUARIO
 */
public class Validaciones {
    
    public boolean validarEmail(String email){
        
        Pattern pattern = Pattern.compile("^[_A-Za-z\\+]*@[A-Za-z]+(\\.[A-Za-z]+)");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    
    
    
    }
    public boolean validarUsuario(String usu){
        
        Pattern pattern = Pattern.compile("^[_A-Za-z-\\+]");
        Matcher mather = pattern.matcher(usu);
        return mather.find();
    
    
    
    }
    public boolean validarNombre(String nom){
        
        Pattern pattern = Pattern.compile("^[_A-Za-z-\\+]");
        Matcher mather = pattern.matcher(nom);
        return mather.find();
    
    }
    public boolean validarApellido(String ape){
        
        Pattern pattern = Pattern.compile("^[_A-Za-z-\\+]");
        Matcher mather = pattern.matcher(ape);
        return mather.find();
    
    }
    public boolean validarSexo(String sex){
        
        Pattern pattern = Pattern.compile("^[_A-Za-z-\\+]");
        Matcher mather = pattern.matcher(sex);
        return mather.find();
   
    }
    public boolean validarEstadoCivil(String estado){
        
        Pattern pattern = Pattern.compile("^[_A-Za-z-\\+]");
        Matcher mather = pattern.matcher(estado);
        return mather.find();
    
    
    
    }
    public boolean validarDireccion(String dire){
        
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-]+([A-Za-z0-9-]+)");
        Matcher mather = pattern.matcher(dire);
        return mather.find();
    
    }
    public boolean validarCedula(String cedu){
        
        Pattern pattern = Pattern.compile("^[_0-9-\\+]");
        Matcher mather = pattern.matcher(cedu);
        return mather.find();
        
    }
    public boolean validarTelefono(String tele){
        
        Pattern pattern = Pattern.compile("^[_0-9-\\+]");
        Matcher mather = pattern.matcher(tele);
        return mather.find();
        
    }
    public boolean validarFechaIngreso(String fecha){
        
        Pattern pattern = Pattern.compile("^[_0-9-\\+]");
        Matcher mather = pattern.matcher(fecha);
        return mather.find();
        
    }
}
    
