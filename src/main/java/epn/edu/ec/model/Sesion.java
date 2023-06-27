package epn.edu.ec.model;

import epn.edu.ec.controller.Conexion;

public class Sesion {
    private UsuarioEntity usuario;

    public Sesion(){
        this.usuario = new UsuarioEntity();
    }

    public Sesion(String correo, String pwd){
        this.usuario = new UsuarioEntity(correo, pwd);
    }

    public boolean iniciar(){
        if(ValidacionExistencia.validarCredencialesUS(this.usuario)){
            System.out.println("Bienvenido/a, desplegando el menu principal...");
            return true;
        }else{
            System.out.println("Error al iniciar sesion, vuelva a intentar...");
            return false;
        }
    }
    public void cerrar(){
        this.usuario = null;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }
}
