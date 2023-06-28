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
}
