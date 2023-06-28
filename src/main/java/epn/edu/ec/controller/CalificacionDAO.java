package epn.edu.ec.controller;

import epn.edu.ec.model.CalificacionEntity;
import org.hibernate.Query;

import java.util.List;

public class CalificacionDAO {
    public List<CalificacionEntity> leerCalificaciones() {
        List<CalificacionEntity> calificaciones = null;
        try {
            Conexion.session.beginTransaction();
            Query query = Conexion.session.createQuery("FROM CalificacionEntity");
            calificaciones = (List<CalificacionEntity>) query.getResultList();
            Conexion.session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
        }
        return calificaciones;
    }

    public void actualizarCalificacion(int idReservacion, String comentario, double puntuacion) {
        try {
            Conexion.session.beginTransaction();
            CalificacionEntity calificacion = Conexion.session.get(CalificacionEntity.class, idReservacion);
            calificacion.setComentario(comentario);
            calificacion.setPuntuacion(puntuacion);
            calificacion.cambiarEstado(1);
            Conexion.session.update(calificacion);
            Conexion.session.getTransaction().commit();
            System.out.println("Exito al calificar la reserva");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
