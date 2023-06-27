package epn.edu.ec.view;

import epn.edu.ec.controller.Conexion;

public class Main {
    public static void main(String[] args) {
        Conexion.open();
        new ViewInicio().displayView();
        Conexion.close();
    }
}