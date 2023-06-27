package epn.edu.ec.controller;

import epn.edu.ec.model.UsuarioEntity;

public class UsuarioDAO {

    public UsuarioDAO(){}
    public String crear(UsuarioEntity usuario) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            Conexion.session.save(usuario);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return "Usuario creado";
        } catch (Exception e) {
            return "Error: Usuario no creado";
        }
    }

    public UsuarioEntity buscarUsuario(UsuarioEntity usuario) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            String sql = String.format("FROM UsuarioEntity AS u WHERE u.correo = '%s' AND u.pwd = '%s'", usuario.getCorreo(), usuario.getPwd());
            UsuarioEntity user = (UsuarioEntity) Conexion.session.createQuery(sql).getSingleResult();
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return user;
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

/*
    public String actualizar(int id, String correo) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            ClienteEntity cliente = Conexion.session.get(ClienteEntity.class, id);
            cliente.setDireccionCorreo(correo);
            Conexion.session.update(cliente);
            Conexion.session.getTransaction().commit();
            Conexion.close();

            return "Correo actualizado";

        } catch (Exception e) {
            return "Error: Correo no actualizado";
        }
    }

    public String borrar(int id) {
        try {
            Conexion.open();
            Conexion.session.beginTransaction();
            ClienteEntity cliente = Conexion.session.get(ClienteEntity.class, id);
            Conexion.session.delete(cliente);
            Conexion.session.getTransaction().commit();
            Conexion.close();
            return "Cliente eliminado";
        } catch (Exception e) {
            return "Error: Cliente no eliminado";
        }
    }
    */
}
