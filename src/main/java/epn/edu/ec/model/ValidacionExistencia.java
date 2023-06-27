package epn.edu.ec.model;

import epn.edu.ec.controller.UsuarioDAO;

public final class ValidacionExistencia implements Validacion{
    public static boolean validarCredencialesUS(UsuarioEntity usuario) {
        if (new UsuarioDAO().buscarUsuario(usuario) != null){
            return true;
        }else{
            System.out.println("Credenciales invalidas, vuelva a intentar...");
            return false;
        }
    }
}
