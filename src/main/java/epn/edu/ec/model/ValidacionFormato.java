package epn.edu.ec.model;

import java.util.regex.Pattern;

public final class ValidacionFormato implements Validacion {

    public static boolean validarFormatoCorreo(String correo) {
        return Pattern.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", correo);
    }

    public static boolean validarFormatoTexto(String texto) {
        return Pattern.matches("([\\w][\\s\\n\\.:-]*)+", texto);
    }

    public static boolean validarFormatoId(String id) {
        return Pattern.matches("[0-9]+", id);
    }

    public static boolean validarFormatoString(String texto) {
        if (texto.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validarFormatoFecha(String fecha) {
        return Pattern.matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}", fecha);
    }

    public static boolean validarLongitud(String texto, int longitud) {
        if (texto.length() <= longitud) {
            return true;
        }
        return false;
    }

    public static boolean validarFormatoPuntuacion(String puntuacion) {
        return Pattern.matches("[0-5]{1}(\\.[0-9]+)?", puntuacion);
    }
}
