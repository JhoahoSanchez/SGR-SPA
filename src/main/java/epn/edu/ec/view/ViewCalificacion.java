package epn.edu.ec.view;

import epn.edu.ec.controller.CalificacionDAO;
import epn.edu.ec.controller.Scaner;
import epn.edu.ec.model.Sesion;
import epn.edu.ec.model.ValidacionFormato;

import java.util.Scanner;

public class ViewCalificacion {
    private String comentario = "";
    private String puntuacion = "";
    public void mostrarVistaCalificacion(int idReservacion, int idUsuario, Sesion sesion) {
        CalificacionDAO calificacionDAO = new CalificacionDAO();

        do{
            System.out.print("Ingrese el comentario para la reservacion escogida: ");
            comentario = Scaner.leerEntrada();
            System.out.print("Ingrese la puntuacion para el servicio de la reservacion escogida: ");
            puntuacion = Scaner.leerEntrada();
            if(ValidacionFormato.validarLongitud(comentario, 400) &&  ValidacionFormato.validarFormatoPuntuacion(puntuacion)){
                Double score = Double.parseDouble(puntuacion);
                calificacionDAO.actualizarCalificacion(idReservacion,comentario,score);
                System.out.println("¡Gracias por calificar nuestros servicios!");
                new ViewNotificacion().mostrarVistaNotificacion(idUsuario,sesion);
            }else{
                System.out.println("Ingrese datos validos en los campos");
                System.out.println("Al menos 400 caracteres para el comentario y la puntuacion de 0 a 5");
            }
        }while(!ValidacionFormato.validarLongitud(comentario, 400) || !ValidacionFormato.validarFormatoPuntuacion(puntuacion));

    }
}
