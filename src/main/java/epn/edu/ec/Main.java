package epn.edu.ec;

import epn.edu.ec.controller.UsuarioDAO;
import epn.edu.ec.model.UsuarioEntity;
import epn.edu.ec.view.ViewInicio;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hola mundo!");
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setCorreo("cuquita@gmail.com");
        usuario.setPwd("weawea58");
        new UsuarioDAO().crear(usuario);
        System.out.println(new UsuarioDAO().buscarUsuario(usuario));

        System.out.println("----");
        UsuarioEntity nuevoUsuario = ViewInicio.registro();
        new UsuarioDAO().crear(nuevoUsuario);
    }
}