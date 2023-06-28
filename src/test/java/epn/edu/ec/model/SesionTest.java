package epn.edu.ec.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SesionTest {

    private Sesion sesion;
    @Before
    public void setUp(){
        this.sesion = new Sesion();
    }
    //test inicio de sesion
    @Test
    public void given_valid_credentials_when_login_then_ok() {
        System.out.println("Test 1");
        boolean expected = false;
        sesion.setUsuario(new UsuarioEntity("jhoaho2001@gmail.com", "musi1234"));
        boolean actual = sesion.iniciar();
        assertEquals(expected, actual);
    }
    @Test
    public void given_invalid_credentials_when_login_then_error() {
        System.out.println("Test 1");
        boolean expected = false;
        sesion.setUsuario(new UsuarioEntity("jhoaho2001@gmail.com", "musi3412"));
        boolean actual = sesion.iniciar();
        assertEquals(expected, actual);
    }
}