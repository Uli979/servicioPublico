/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package conexionSQL;

import com.sun.jdi.connect.spi.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author USUARIO
 */
public class conexionSQLTest {
    
    public conexionSQLTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of conectar method, of class conexionSQL.
     */
    @Test
    public void testConectar() {
        System.out.println("conectar");
        conexionSQL instance = new conexionSQL();
        Connection expResult = null;
        Connection result = (Connection) instance.conectar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of desconectar method, of class conexionSQL.
     */
    @Test
    public void testDesconectar() throws SQLException {
        System.out.println("desconectar");
        conexionSQL instance = new conexionSQL();
        instance.desconectar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class conexionSQL.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        conexionSQL.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ejecutarSentenciaSql method, of class conexionSQL.
     */
    @Test
    public void testEjecutarSentenciaSql() {
        System.out.println("ejecutarSentenciaSql");
        String sentSQL = "";
        conexionSQL instance = new conexionSQL();
        int expResult = 0;
        int result = instance.ejecutarSentenciaSql(sentSQL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarReg method, of class conexionSQL.
     */
    @Test
    public void testConsultarReg() {
        System.out.println("consultarReg");
        String sentSQL = "";
        conexionSQL instance = new conexionSQL();
        ResultSet expResult = null;
        ResultSet result = instance.consultarReg(sentSQL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
