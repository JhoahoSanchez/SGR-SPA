package epn.edu.ec.model;

import epn.edu.ec.controller.ReservacionDAO;

import java.util.List;

public class Notificacion {
    public String mostrar(List<CalificacionEntity> calificaciones, int idUsuario) {
        ReservacionDAO reservacionDAO = new ReservacionDAO();
        String resultado = "\tReservaciones pendientes de calificar\n";
        if (calificaciones.size() > 0) {
            for (int i = 0; i < calificaciones.size(); i++) {
                if (!calificaciones.get(i).comprobarEstado()) {
                    ReservacionEntity reservacion = reservacionDAO.leerReservacion(calificaciones.get(i).getCodReservacion(), idUsuario);
                    if (reservacion.getEstado() == 1 && reservacion != null) {
                        resultado += "La reservacion con id: " + reservacion.getCodReservacion() + " atendida el dia: " + reservacion.getFecha()
                                + " con tratamiento: " + reservacion.getTipo() + "\n";
                    }
                }
            }
        } else resultado += "No existen reservaciones pendientes por calificar";
        return resultado;
    }

    public int getNumeroDeCalificaciones(List<CalificacionEntity> calificaciones, int idUsuario) {
        int contador = 0;
        ReservacionDAO reservacionDAO = new ReservacionDAO();
        if (calificaciones.size() > 0) {
            for (int i = 0; i < calificaciones.size(); i++) {
                if (calificaciones.get(i).getEstado() == 0) {
                    ReservacionEntity reservacion = reservacionDAO.leerReservacion(calificaciones.get(i).getCodReservacion(), idUsuario);
                    if (reservacion.getEstado() == 1) {
                        System.out.println(reservacion);
                        contador++;
                    }
                }
            }
        }
        return contador;
    }
}
