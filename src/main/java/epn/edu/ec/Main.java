package epn.edu.ec;

import epn.edu.ec.controller.UsuarioDAO;
import epn.edu.ec.model.UsuarioEntity;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola mundo!");
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setCorreo("mariohugo@gmail.com");
        usuario.setPwd("causa32");
        usuario.setRol(0);

        System.out.println(new UsuarioDAO().crear(usuario));

    }
}