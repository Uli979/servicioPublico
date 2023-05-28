/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexionSQL.conexionSQL;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.RegistroDTO;
import modelo.UsuarioDTO;

/**
 *
 * @author USUARIO
 */
public class RegistroControlador {
        public ArrayList consultarDep() throws SQLException{
        conexionSQL conn=new conexionSQL();
        conn.conectar();
         ResultSet resul=null;
          ArrayList registros=new ArrayList<>();
          
        try {
             resul=(ResultSet) conn.consultarReg("SELECT * FROM registro");
             while (resul.next()){
                RegistroDTO registroDTO=new RegistroDTO();
                registroDTO.setId(resul.getInt("id"));
                registroDTO.setCedula(resul.getInt("cedula"));
                registroDTO.setNombre(resul.getString("nombre"));
                registroDTO.setApellido(resul.getString("apellidos"));
                registroDTO.setSexo(resul.getString("sexo"));
                registroDTO.setEstadoCivil(resul.getString("estadoCivil"));
                registroDTO.setDireccion(resul.getString("direccion"));
                registroDTO.setTelefono(resul.getInt("telefono"));
                registroDTO.setCorreo(resul.getString("correo"));
                registroDTO.setArea(resul.getString("area"));
                registroDTO.setDepartamento(resul.getString("departamento"));
                registroDTO.setZona(resul.getString("zona"));
                registroDTO.setFechaIngreso(resul.getInt("ingreso"));
                registros.add(registroDTO);
               
            } 
        }catch (SQLException e){
            System.out.println(e);            
        }finally{
            conn.desconectar();
        }
        return registros; 
    }
     public RegistroDTO consultarDepId(int id) throws IOException, SQLException{
            ResultSet resul;
            RegistroDTO registroDTO=new RegistroDTO();
            conexionSQL conn=new conexionSQL();
            conn.conectar();
            
            try{
                resul=(ResultSet) conn.consultarReg("SELECT * FROM `registro` WHERE `registro`.`id` ="+id+";");
                
                  while (resul.next()){
                      
                    registroDTO.setId(resul.getInt("id"));
                    registroDTO.setCedula(resul.getInt("cedula"));
                    registroDTO.setNombre(resul.getString("nombre"));
                    registroDTO.setApellido(resul.getString("apellidos"));
                    registroDTO.setSexo(resul.getString("sexo"));
                    registroDTO.setEstadoCivil(resul.getString("estadoCivil"));
                    registroDTO.setDireccion(resul.getString("direccion"));
                    registroDTO.setTelefono(resul.getInt("telefono"));
                    registroDTO.setCorreo(resul.getString("correo"));
                    registroDTO.setArea(resul.getString("area"));
                    registroDTO.setDepartamento(resul.getString("departamento"));
                    registroDTO.setZona(resul.getString("zona"));
                    registroDTO.setFechaIngreso(resul.getInt("ingreso"));
                  
                  
                  }
            
        } catch(SQLException e){
            System.out.println(e);
        }finally{
        conn.desconectar();  
            }
            
            return registroDTO;
     
     }
       public boolean crearRegistro(RegistroDTO registroDTO){
        boolean flag=false;
        conexionSQL conn=new conexionSQL();
        conn.conectar();
        int res=conn.ejecutarSentenciaSql("INSERT INTO `registro`(`id`,`cedula`,`nombre`,`apellidos`,`sexo`,`estadoCivil`,`direccion`,`telefono`,`correo`,`area`,`departamento`,`zona`,`ingreso`) VALUES ('"+registroDTO.getId()+"', '"+registroDTO.getCedula()+"', '"+registroDTO.getNombre()+"', '"+registroDTO.getApellido()+"', '"+registroDTO.getSexo()+"','"+registroDTO.getEstadoCivil()+"','"+registroDTO.getDireccion()+"','"+registroDTO.getTelefono()+"','"+registroDTO.getCorreo()+"','"+registroDTO.getArea()+"','"+registroDTO.getDepartamento()+"','"+registroDTO.getZona()+"','"+registroDTO.getFechaIngreso()+"')");
        
        
        if(res==0){
            System.out.println("Guardado con Exito");
            flag=true;
        }
        return flag;
    }
         public boolean eliminarRegistro(int id){
        boolean flag=false;
        conexionSQL conn=new conexionSQL();
        conn.conectar();
        int res=conn.ejecutarSentenciaSql("DELETE FROM `registro` WHERE `id`="+id+";");
        
            if(res==0){
            System.out.println("Borrado con Exito");
            flag=true;
        
        }
        
            return flag;
    
    }
          public boolean editarRegistro(RegistroDTO registroDTO){
        boolean flag=false;
        conexionSQL conn=new conexionSQL();
        conn.conectar();
      
        int res=conn.ejecutarSentenciaSql("UPDATE `registro` SET `nombre`='"+registroDTO.getNombre()+"',`apellido`='"+registroDTO.getApellido()+"',`sexo`='"+registroDTO.getSexo()+"',`estadoCivil`='"+registroDTO.getEstadoCivil()+"',`direccion`='"+registroDTO.getDireccion()+"',`telefono`='"+registroDTO.getTelefono()+"',`correo`='"+registroDTO.getCorreo()+"',`area`='"+registroDTO.getArea()+"',`Departamento`='"+registroDTO.getDepartamento()+"',`zona`='"+registroDTO.getZona()+"',`ingreso`='"+registroDTO.getFechaIngreso()+"' WHERE `id`='"+registroDTO.getId()+"'");
        
        if(res==1){
        System.out.println("Actualizado con Exito");
        flag=true;
    }
        return flag;
    }
}
