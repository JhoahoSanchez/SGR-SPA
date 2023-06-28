package epn.edu.ec.view;

import epn.edu.ec.controller.Conexion;
import epn.edu.ec.controller.Scaner;

public class Main {
    public static void main(String[] args) {
        Conexion.open();
        Scaner.open(System.in);
        new ViewInicio().displayView();
        Scaner.close();
        Conexion.close();
    }
}