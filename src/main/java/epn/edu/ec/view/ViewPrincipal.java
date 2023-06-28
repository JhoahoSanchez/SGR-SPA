package epn.edu.ec.view;

import epn.edu.ec.controller.Scaner;
import epn.edu.ec.controller.UsuarioDAO;
import epn.edu.ec.model.Sesion;
import epn.edu.ec.model.UsuarioEntity;

import java.util.Scanner;

public class ViewPrincipal {
    private Sesion sesion;

    public ViewPrincipal(Sesion sesion){
        this.sesion = sesion;
    }
    public void displayView(){
        int op=-1;
        do {
            System.out.println("\n\tMenu Principal");
            System.out.println("Escoja una opcion:");
            System.out.println("1.\tReservacion");
            System.out.println("2.\tNotificaciones");
            System.out.println("3.\tCerrar Sesion");
            op = Integer.parseInt(Scaner.leerEntrada());
            switch (op){
                case 1:
                    new ViewReservacion().displayView(sesion);
                    break;
                case 2:
                    //Notificaciones
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    UsuarioEntity usuario = usuarioDAO.buscarUsuario(sesion.getUsuario());
                    new ViewNotificacion().mostrarVistaNotificacion(usuario.getId(),sesion);
                    break;
                case 3:
                    sesion.cerrar();
                    //scanner1.close();
                    new ViewInicio().displayView();
                    break;
                default:
                    System.out.println("Opcion incorrecta, vuelva a intentar...");
                    break;
            }
        }while (op!=3);



    }
}
