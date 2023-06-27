package epn.edu.ec.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidacionFormatoTest {

    //Test correo
    @Test
    public void given_valid_email_when_check_then_ok() {
        System.out.println("Test 1");
        boolean expected = true;
        boolean actual = ValidacionFormato.validarFormatoCorreo("jhoaho.sanchez@epn.edu.ec");
        assertEquals(expected, actual);
    }

    @Test
    public void given_invalid_email_when_check_then_error() {
        System.out.println("Test 2");
        boolean expected = false;
        boolean actual = ValidacionFormato.validarFormatoCorreo("@43.com");
        assertEquals(expected, actual);
    }

    //Test texto
    @Test
    public void given_some_valid_text_when_check_then_ok() {
        System.out.println("Test 3");
        boolean expected = true;
        boolean actual = ValidacionFormato.validarFormatoTexto("Buenos dias mundo\nComo estas 12-353:65");
        assertEquals(expected, actual);
    }

    @Test
    public void given_some_invalid_text_when_check_then_error() {
        System.out.println("Test 4");
        boolean expected = false;
        boolean actual = ValidacionFormato.validarFormatoTexto("Buenos dias mundo\nComo estas 12-353:65;");
        assertEquals(expected, actual);
    }

    //Test id
    @Test
    public void given_a_valid_id_when_check_then_ok() {
        System.out.println("Test 5");
        boolean expected = true;
        boolean actual = ValidacionFormato.validarFormatoId("12");
        assertEquals(expected, actual);
    }

    //Test string
    @Test
    public void given_some_text_when_check_if_null_then_ok() {
        System.out.println("Test 6");
        boolean expected = false;
        boolean actual = ValidacionFormato.validarFormatoString("");
        assertEquals(expected, actual);
    }

    //Test fecha
    @Test
    public void given_a_date_with_format_when_check_then_ok() {
        System.out.println("Test 7");
        boolean expected = true;
        boolean actual = ValidacionFormato.validarFormatoFecha("1992-05-23");
        assertEquals(expected, actual);
    }

    //Test longitud
    @Test
    public void given_some_text_when_check_length_then_ok() {
        System.out.println("Test 8");
        boolean expected = true;
        boolean actual = ValidacionFormato.validarLongitud("Hola mucho gusto", 50);
        assertEquals(expected, actual);
    }

    //Test puntuacion
    @Test
    public void given_a_string_when_check_format_then_ok() {
        System.out.println("Test 9");
        boolean expected = true;
        boolean actual = ValidacionFormato.validarFormatoPuntuacion("5.4");
        assertEquals(expected, actual);
    }

}