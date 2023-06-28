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
    private boolean estaBien = true;
    public void mostrarVistaNotificacion(int idUsuario, Sesion sesion) {
        Notificacion notificacion = new Notificacion();
        CalificacionDAO calificacionDAO = new CalificacionDAO();
        ReservacionDAO reservacionDAO = new ReservacionDAO();

        List<CalificacionEntity> calificaciones = calificacionDAO.leerCalificaciones();
        List<ReservacionEntity> reservaciones = reservacionDAO.leerReservaciones(idUsuario);
        System.out.println(calificaciones.size());

        System.out.println(notificacion.mostrar(calificaciones, idUsuario));
        if(!notificacion.mostrar(calificaciones, idUsuario).equals("\tReservaciones pendientes de calificar\n")){
            List<Integer> numerosReservacion = new ArrayList<>();
            for (int i = 0; i < reservaciones.size(); i++) {
                numerosReservacion.add(reservaciones.get(i).getCodReservacion());
            }
            do{
                do {
                    System.out.print("Escoja el id de una reservacion a calificar: ");
                    respuesta = scanner.nextLine();
                    System.out.println(respuesta);
                    System.out.println(numerosReservacion);
                    if (numerosReservacion.contains(Integer.parseInt(respuesta))) {
                        new ViewCalificacion().mostrarVistaCalificacion(Integer.parseInt(respuesta),idUsuario,sesion);
                    } else{
                        System.out.println("Seleccione un id asociado a una reserva restante por calificar");
                        estaBien = false;
                    }
                }while (estaBien);
                System.out.println("¿Desea salir al menu principal? si/no ");
                respuesta = scanner.nextLine();
            }while (respuesta.equals("no"));
        }
        //TODO:Redirigir a la ventana principal
        new ViewPrincipal(sesion).displayView();
    }
}
