/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.UsuarioDTO;
import conexionSQL.conexionSQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import vista.GestionUsuario;


/**
 *
 * @author USUARIO
 */
public class UsuarioContralador implements ActionListener {
   
    
    public boolean validarUsuario(String usuario, String pass) throws SQLException {
        conexionSQL conn=new conexionSQL();
        conn.conectar();
        boolean flag=false;
        
        
        try {
               ResultSet resul=conn.consultarReg("SELECT usuario, contraseña FROM usuario WHERE rol='admin'");
            while (resul.next()){
                System.out.println(resul.getString("usuario"));
                System.out.println(resul.getString("contraseña"));
                System.out.println(usuario);
                System.out.println(pass);
            if(usuario.equals(resul.getString("usuario")) && pass.equals(resul.getString("contraseña")))
             
                      {
                      flag=true;
                      }
         
            }
        
        } catch(SQLException e){
            System.out.println(e);
        }finally{
            conn.desconectar();
        
        }
        return flag;
    }
    public ArrayList<UsuarioDTO>consultarEmp() throws SQLException{
        conexionSQL conn=new conexionSQL();
        conn.conectar();
         ResultSet resul=null;
          ArrayList<UsuarioDTO> usuarios=new ArrayList<>();
        try {
            resul=conn.consultarReg("SELECT * FROM usuario");
            while (resul.next()){
                UsuarioDTO usuarioDTO=new UsuarioDTO();
            
         
            System.out.println(resul.getString("usuario"));
            System.out.println(resul.getString("correo"));
            usuarioDTO.setIdUsuario(resul.getInt("idUsuario"));
            usuarioDTO.setUsuario(resul.getString("usuario"));
            usuarioDTO.setCorreo(resul.getString("correo"));
            usuarioDTO.setRol(resul.getString("rol"));
            usuarios.add(usuarioDTO);
            
            }
        } catch (SQLException e){
            System.out.println(e);
        }finally{
            conn.desconectar();
        }
        return usuarios;
    
    }
    public boolean crearUsuario(UsuarioDTO usuarioDTO){
        boolean flag=false;
        conexionSQL conn=new conexionSQL();
        conn.conectar();
        int res=conn.ejecutarSentenciaSql("INSERT INTO `usuario`(`idUsuario`,`usuario`,`contraseña`,`correo`,`rol`) VALUES ('"+usuarioDTO.getIdUsuario()+"', '"+usuarioDTO.getUsuario()+"', '"+usuarioDTO.getContraseña()+"', '"+usuarioDTO.getCorreo()+"', '"+usuarioDTO.getRol()+"')");
        
        
            if(res==1){
            System.out.println("Guardado con Exito");
            flag=true;
        }
        
            return flag;
            
    }
    public boolean eliminarUsuario(int idUsuario){
        boolean flag=false;
        conexionSQL conn=new conexionSQL();
        conn.conectar();
        int res=conn.ejecutarSentenciaSql("DELETE FROM `usuario` WHERE `idUsuario`="+idUsuario+";");
        
            if(res==1){
            System.out.println("Borrado con Exito");
            flag=true;
        
        }
        
            return flag;
    
    }
    public boolean editarUsuario(UsuarioDTO usuarioDTO){
        boolean flag=false;
        conexionSQL conn=new conexionSQL();
        conn.conectar();
     
        int res=conn.ejecutarSentenciaSql("UPDATE `usuario` SET `usuario`='"+usuarioDTO.getUsuario()+"',`contraseña`='"+usuarioDTO.getContraseña()+"',`correo`='"+usuarioDTO.getCorreo()+"',`rol`='"+usuarioDTO.getRol()+"' WHERE `idUsuario`='"+usuarioDTO.getIdUsuario()+"'");
    
            if(res==1){
                
            System.out.println("Actualizado con Exito");
            
            flag=true;
            
        }
            
            return flag;
            
    }
    public UsuarioDTO consultarUsuarioId(int id) throws SQLException{
        ResultSet resul;
        UsuarioDTO usuarioDTO=new UsuarioDTO();
        conexionSQL conn=new conexionSQL();
        conn.conectar();
        
        try {
            
            resul=conn.consultarReg("SELECT * FROM `usuario` WHERE `usuario`, `idUsuario`="+id+";");
        
               while (resul.next()){
                   
                   
                   usuarioDTO.setIdUsuario(resul.getInt("idUsuario"));
                   usuarioDTO.setUsuario(resul.getString("usuario"));
                   usuarioDTO.setCorreo(resul.getString("correo"));
                   usuarioDTO.setContraseña(resul.getString("contraseña"));
                   usuarioDTO.setRol(resul.getString("rol"));
                   
               
               }
        }catch (Exception e){
            System.out.println(e);
        }finally{
            conn.desconectar();
        }
        
          return usuarioDTO;
    
    
    }
    public boolean modificar(UsuarioDTO usu){
        PreparedStatement ps = null;
        conexionSQL conn=new conexionSQL();
        conn.conectar();
        
        int res=conn.ejecutarSentenciaSql("UPDATE `usuario` SET `idUsuario`='"+usu.getIdUsuario()+"',`usuario`='"+usu.getUsuario()+"',`contraseña`='"+usu.getContraseña()+"',`correo`= '"+usu.getCorreo()+"',`rol`= '"+usu.getRol()+"WHERE id',");
        
        try{
            try {
                ps = conn.prepareStatement();
            } catch (Exception e) {
            }
            ps.setInt(1, usu.getIdUsuario());
            ps.setString(2, usu.getUsuario());
            ps.setString(3, usu.getContraseña());
            ps.setString(4, usu.getCorreo());
            ps.setString(5, usu.getRol());
            ps.execute();
            return true;
        }catch (SQLException e){
            System.err.println(e);
            return false;
        }finally{
            conn.close();
        }
  
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     
    
    
}
