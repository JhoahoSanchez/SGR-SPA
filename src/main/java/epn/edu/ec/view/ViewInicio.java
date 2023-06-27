package epn.edu.ec.view;
import epn.edu.ec.model.UsuarioEntity;

import java.util.Scanner;
public class ViewInicio {

    public static UsuarioEntity registro(){
        UsuarioEntity usuario = new UsuarioEntity();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Registrar un nuevo usuario");
        System.out.print("Ingrese su correo electrónico: ");
        usuario.setCorreo(scanner.nextLine());

        System.out.print("Ingrese su contraseña: ");
        usuario.setPwd(scanner.nextLine());

        System.out.print("Ingrese su rol: ");
        usuario.setRol(Integer.parseInt(scanner.nextLine()));

        scanner.close();

        return usuario;
    }
}
