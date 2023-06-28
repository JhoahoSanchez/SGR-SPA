package epn.edu.ec.model;

import java.util.Objects;

public class CalificacionEntity {
    private int codReservacion;
    private String comentario;
    private double puntuacion;
    private int estado;

    public int getCodReservacion() {
        return codReservacion;
    }

    public void setCodReservacion(int codReservacion) {
        this.codReservacion = codReservacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
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
        CalificacionEntity that = (CalificacionEntity) o;
        return codReservacion == that.codReservacion && Double.compare(that.puntuacion, puntuacion) == 0 && estado == that.estado && Objects.equals(comentario, that.comentario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codReservacion, comentario, puntuacion, estado);
    }

    public boolean comprobarEstado() {
        return estado == 1;
    }

    public void cambiarEstado(int estado) {
        this.estado = estado;
    }
}
