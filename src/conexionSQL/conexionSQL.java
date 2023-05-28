/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionSQL;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author USUARIO
 */
public class conexionSQL {
    String bd="serviciospublicos";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="123456";
    Connection cx=null;
    
    public conexionSQL(){
    
    }
    public Connection conectar(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cx=(Connection)DriverManager.getConnection(url+bd,user, password);
            System.out.println("SE HA CONECTADO A LA BD"+bd);
        } catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(conexionSQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            System.out.println("NO SE CONECTOA LA BD"+bd);
        
        }
        return cx;
    
    }
    public void desconectar() throws SQLException{
        cx.close();
    
    }
    public static void main (String[] args) {
         conexionSQL conn=new conexionSQL();
         conn.conectar();
    
    }
    public int ejecutarSentenciaSql(String sentSQL){
        try{
                PreparedStatement preSt=cx.prepareStatement(sentSQL);
                preSt.execute();
                return 1;
         
        } catch (SQLException ex){
                java.util.logging.Logger.getLogger(conexionSQL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                return 0;
         
        }
    }
    public ResultSet consultarReg(String sentSQL){
        try {
            PreparedStatement preSt=cx.prepareStatement(sentSQL);
            
            ResultSet res= preSt.executeQuery();
            return res;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        
        }
    
    
    }

    public void Open() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public PreparedStatement prepareStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}