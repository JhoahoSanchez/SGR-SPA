package epn.edu.ec.controller;

import epn.edu.ec.model.ReservacionEntity;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

public class ReservacionDAO {
    public List<ReservacionEntity> leerReservaciones(int idUsuario) {
        List<ReservacionEntity> reservacionesUsuario = new ArrayList<>();
        try{
            Conexion.session.beginTransaction();
            Query query = Conexion.session.createQuery("from  ReservacionEntity where idUsuario = :idUsuario and estado = 1");
            query.setParameter("idUsuario",idUsuario);
            reservacionesUsuario = query.getResultList();
            Conexion.session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }
        return reservacionesUsuario;
    }

    public ReservacionEntity leerReservacion(int codReservacion, int idUsuario) {
        ReservacionEntity reservacion = null;
        try{
            Conexion.session.beginTransaction();
            Query query = Conexion.session.createQuery("FROM ReservacionEntity WHERE codReservacion = :codReservacion AND idUsuario = :idUsuario");
            query.setParameter("codReservacion", codReservacion);
            query.setParameter("idUsuario", idUsuario);
            reservacion = (ReservacionEntity) query.uniqueResult();
            Conexion.session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }
        return reservacion;
    }

    public String crearReservacion(ReservacionEntity reservacion) {
        try {
            Conexion.session.beginTransaction();
            Conexion.session.save(reservacion);
            Conexion.session.getTransaction().commit();
            return "Reservación creada";
        } catch (Exception e) {
            return "Error: Reservación no creada";
        }
    }

    public List<ReservacionEntity> verReservaciones(int idUsuario) {
        try {
            Conexion.session.beginTransaction();
            String sql = String.format("FROM ReservacionEntity AS r WHERE r.idUsuario = '%s'", idUsuario);
            List<ReservacionEntity> reservas = Conexion.session.createQuery(sql).getResultList();
            Conexion.session.getTransaction().commit();
            return reservas;
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }
}
