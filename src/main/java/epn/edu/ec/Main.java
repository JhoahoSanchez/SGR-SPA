package epn.edu.ec;

import epn.edu.ec.controller.UsuarioDAO;
import epn.edu.ec.model.UsuarioEntity;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola mundo!");
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setCorreo("cuquita@gmail.com");
        usuario.setPwd("weawea58");

        System.out.println(new UsuarioDAO().buscarUsuario(usuario));
    }
}