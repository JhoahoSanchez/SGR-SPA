package epn.edu.ec.view;

import epn.edu.ec.controller.CalificacionDAO;
import epn.edu.ec.controller.ReservacionDAO;
import epn.edu.ec.model.CalificacionEntity;
import epn.edu.ec.model.Notificacion;
import epn.edu.ec.model.ReservacionEntity;
import epn.edu.ec.model.Sesion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewNotificacion {
    private Scanner scanner = new Scanner(System.in);
    private String respuesta = "";

    public void mostrarVistaNotificacion(int idUsuario, Sesion sesion) {
        Notificacion notificacion = new Notificacion();
        CalificacionDAO calificacionDAO = new CalificacionDAO();
        ReservacionDAO reservacionDAO = new ReservacionDAO();

        List<CalificacionEntity> calificaciones = calificacionDAO.leerCalificaciones();
        List<ReservacionEntity> reservaciones = reservacionDAO.leerReservaciones(idUsuario);

        System.out.println(notificacion.mostrar(calificaciones, idUsuario));
        if (!notificacion.mostrar(calificaciones, idUsuario).equals("\tReservaciones pendientes de calificar\n")) {
            List<Integer> numerosReservacion = new ArrayList<>();
            for (int i = 0; i < reservaciones.size(); i++) {
                numerosReservacion.add(reservaciones.get(i).getCodReservacion());
            }

            int numCalificados = notificacion.getNumeroDeCalificaciones(calificaciones, idUsuario);
            System.out.println("num calificados: " + numCalificados);

            if (numCalificados != 0) {
                do {
                    System.out.print("Escoja el id de una reservacion a calificar: ");
                    respuesta = scanner.nextLine();
//                    System.out.println(respuesta);
//                    System.out.println(numerosReservacion);
                    if (numerosReservacion.contains(Integer.parseInt(respuesta))) {
                        new ViewCalificacion().mostrarVistaCalificacion(Integer.parseInt(respuesta), idUsuario, sesion);
                    } else {
                        System.out.println("Seleccione un id asociado a una reserva restante por calificar");
                    }
                } while (respuesta.equals("no"));
            } else {
                new ViewPrincipal(sesion).displayView();
            }
        } else {
            new ViewPrincipal(sesion).displayView();
        }
    }
}
