package epn.edu.ec.model;

import java.util.Objects;

public class UsuarioEntity {
    private int id;
    private String correo;
    private String pwd;
    private int rol;

    public UsuarioEntity(){}

    public UsuarioEntity(String correo, String pwd){
        this.correo = correo;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return id == that.id && rol == that.rol && Objects.equals(correo, that.correo) && Objects.equals(pwd, that.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, correo, pwd, rol);
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "id=" + id +
                ", correo='" + correo + '\'' +
                ", pwd='" + pwd + '\'' +
                ", rol=" + rol +
                '}';
    }
}
