package epn.edu.ec.view;

import epn.edu.ec.controller.Scaner;
import epn.edu.ec.controller.UsuarioDAO;
import epn.edu.ec.model.ReservacionEntity;
import epn.edu.ec.controller.ReservacionDAO;
import epn.edu.ec.model.Sesion;
import epn.edu.ec.model.UsuarioEntity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ViewReservacion {

    private Sesion sesion;
    private UsuarioDAO usuarioDAO;
    private UsuarioEntity usuario;
    private int idUsuario;

    public void displayView(Sesion sesion) {
        int opcion = -1;
        this.sesion = sesion;
        usuarioDAO = new UsuarioDAO();
        this.usuario = usuarioDAO.buscarUsuario(this.sesion.getUsuario());
        this.idUsuario = obtenerID();
        do {
            System.out.println("Reservación");
            System.out.println("1. Registrar reservacion");
            System.out.println("2. Ver reservaciones");
            System.out.println("3. Atras");
            System.out.print("Escoja la opcion: ");
            opcion = Integer.parseInt(Scaner.leerEntrada());
            switch (opcion) {
                case 1:
                    registrarReservacion();
                    break;
                case 2:
                    verReservacion();
                    break;
                case 3:
                    new ViewPrincipal(sesion).displayView();
                    break;
                default:
                    System.out.println("Opcion incorrecta, vuelva a intentar...");
                    break;
            }
        }while (opcion != 3);

    }

    private void verReservacion() {
        System.out.println("Ver reservaciones");
        System.out.println();
        ReservacionDAO reservacionDAO = new ReservacionDAO();
        int idUsuario = obtenerID();
        List<ReservacionEntity> reservaciones = reservacionDAO.verReservaciones(idUsuario);
        System.out.println(reservaciones);
    }

    public void registrarReservacion() {
        ReservacionEntity reservacion = null;
        ReservacionDAO reservacionDAO = new ReservacionDAO();
        System.out.println("Registrar una reservación");
        System.out.println();
        System.out.println("Tratamientos disponibles:");
        System.out.println("1. Tratamiento con aguas termales");
        System.out.println("2. Masajes con aceites naturales");
        System.out.println("3. Masajes con bambú");
        System.out.println("4. Tratamiento con piedras calientes");
        System.out.print("Elige el número del tratamiento que deseas: ");
        int opcion = Integer.parseInt(Scaner.leerEntrada());
        switch (opcion) {
            case 1:
                System.out.println("Has elegido el tratamiento con aguas termales.");
                reservacion = new ReservacionEntity(this.idUsuario, "Tratamiento con aguas termales", new Timestamp((new Date()).getTime()), 0, 0);
                System.out.println(reservacionDAO.crearReservacion(reservacion));
                break;
            case 2:
                System.out.println("Has elegido los masajes con aceites naturales.");
                reservacion = new ReservacionEntity(this.idUsuario, "Masajes con aceites naturales", new Timestamp((new Date()).getTime()), 0, 0);
                System.out.println(reservacionDAO.crearReservacion(reservacion));
                break;
            case 3:
                System.out.println("Has elegido los masajes con bambú.");
                reservacion = new ReservacionEntity(this.idUsuario, "Masajes con bambú", new Timestamp((new Date()).getTime()), 0, 0);
                System.out.println(reservacionDAO.crearReservacion(reservacion));
                break;
            case 4:
                System.out.println("Has elegido el tratamiento con piedras calientes.");
                reservacion = new ReservacionEntity(this.idUsuario, "Tratamiento con piedras calientes", new Timestamp((new Date()).getTime()), 0, 0);
                System.out.println(reservacionDAO.crearReservacion(reservacion));
                break;
            default:
                System.out.println("Opción inválida. Por favor, elige un número válido.");
                break;
        }
        System.out.println();
    }

    private int obtenerID() {
        return usuario.getId();
    }
}
