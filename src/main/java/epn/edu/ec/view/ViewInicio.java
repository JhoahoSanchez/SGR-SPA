package epn.edu.ec.view;

import epn.edu.ec.controller.UsuarioDAO;
import epn.edu.ec.model.Sesion;
import epn.edu.ec.model.UsuarioEntity;
import epn.edu.ec.model.ValidacionFormato;

import java.util.Scanner;

public class ViewInicio {

    private Scanner scanner;
    private Sesion sesion;

    public void displayView() {
        scanner = new Scanner(System.in);
        boolean log = false;
        int op = -1;
        do {
            System.out.println("\tBienvenido al sistema SGR-SPA");
            System.out.println("Seleccione una de las opciones:");
            System.out.println("1.\tIniciar Sesion.");
            System.out.println("2.\tRegistrarse.");
            System.out.println("3.\tSalir.\n");
            op = Integer.parseInt(scanner.nextLine());
            switch (op) {
                case 1:
                    log = displayLogin();
                    if (log) {
                        //scanner.close();
                        op = 3;
                    }
                    break;
                case 2:
                    displayRegistro();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    break;
            }
        } while (op != 3);

        if (log) {
            new ViewPrincipal(sesion).displayView();
        }
        scanner.close();
    }


    public void displayRegistro() {
        String correo, pwd;
        int rol;
        System.out.println("Registrar un nuevo usuario");
        System.out.print("Ingrese su correo electrónico: ");
        correo = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        pwd = scanner.nextLine();
        System.out.print("Ingrese su rol: ");
        rol = Integer.parseInt(scanner.nextLine());

        if (!ValidacionFormato.validarFormatoCorreo(correo) || !ValidacionFormato.validarLongitud(pwd, 15)) {
            System.out.println("Los datos ingresados no son validos, vuelva a intentar...");
        } else {
            new UsuarioDAO().crear(new UsuarioEntity(correo, pwd, rol));
        }
    }

    private boolean displayLogin() {
        String correo, pwd;
        System.out.println("\tIngreso de credenciales");
        System.out.print("Ingrese su correo: ");
        correo = scanner.nextLine();

        System.out.print("Ingrese su password: ");
        pwd = scanner.nextLine();

        this.sesion = new Sesion(correo, pwd);
        return this.sesion.iniciar();
    }
}
