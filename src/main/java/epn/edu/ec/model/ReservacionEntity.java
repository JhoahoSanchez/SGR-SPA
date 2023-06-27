package epn.edu.ec.model;

import java.sql.Timestamp;
import java.util.Objects;

public class ReservacionEntity {
    private int idUsuario;
    private int codReservacion;
    private String descripcion;
    private Timestamp fecha;
    private int tipo;
    private int estado;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCodReservacion() {
        return codReservacion;
    }

    public void setCodReservacion(int codReservacion) {
        this.codReservacion = codReservacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservacionEntity that = (ReservacionEntity) o;
        return idUsuario == that.idUsuario && codReservacion == that.codReservacion && tipo == that.tipo && estado == that.estado && Objects.equals(descripcion, that.descripcion) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, codReservacion, descripcion, fecha, tipo, estado);
    }
}
