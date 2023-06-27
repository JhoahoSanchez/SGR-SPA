package epn.edu.ec.model;

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
            System.out.println("Error al iniciar sesion");

            return false;
        }
    }
    public boolean cerrar(){
        return false;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}
