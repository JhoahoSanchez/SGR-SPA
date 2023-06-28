package epn.edu.ec.view;

import epn.edu.ec.controller.CalificacionDAO;
import epn.edu.ec.controller.Scaner;
import epn.edu.ec.model.Sesion;

import java.util.Scanner;

public class ViewCalificacion {
    private String comentario = "";
    private double puntuacion = 0.0;
    public void mostrarVistaCalificacion(int idReservacion, int idUsuario, Sesion sesion) {
        CalificacionDAO calificacionDAO = new CalificacionDAO();

        System.out.print("Ingrese el comentario para la reservacion escogida: ");
        comentario = Scaner.leerEntrada();
        System.out.print("Ingrese la puntuacion para el servicio de la reservacion escogida: ");
        puntuacion = Double.parseDouble(Scaner.leerEntrada());
        calificacionDAO.actualizarCalificacion(idReservacion,comentario,puntuacion);
        System.out.println("¡Gracias por calificar nuestros servicios!");
        new ViewNotificacion().mostrarVistaNotificacion(idUsuario,sesion);
    }
}
