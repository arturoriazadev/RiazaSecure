package com.riazasecure.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.riazasecure.database.ConexionBD;
import com.riazasecure.modelo.Usuario;

import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO {
    public void insertarUsuario(Usuario usuario) {

        String sql = "INSERT INTO usuarios (nombre, apellidos, dni, email, telefono, password, rol, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.getConexion();
                PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellidos());
            ps.setString(3, usuario.getDni());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getPassword());
            ps.setString(7, usuario.getRol().toString());
            ps.setBoolean(8, usuario.isActivo());

            ps.executeUpdate();

            System.out.println("✅ Usuario guardado en MySQL.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Usuario> listarUsuarios() {

        ArrayList<Usuario> lista = new ArrayList<>();

        String sql = "SELECT * FROM usuarios";

        try (Connection conexion = ConexionBD.getConexion();
                PreparedStatement ps = conexion.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Usuario usuario = new Usuario(
                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("dni"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("password"),
                        com.riazasecure.enums.Rol.valueOf(rs.getString("rol")),
                        rs.getBoolean("activo"));

                lista.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Usuario buscarPorDni(String dni) {

        String sql = "SELECT * FROM usuarios WHERE dni = ?";

        try (Connection conexion = ConexionBD.getConexion();
                PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Usuario(
                        rs.getLong("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("dni"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("password"),
                        com.riazasecure.enums.Rol.valueOf(rs.getString("rol")),
                        rs.getBoolean("activo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean actualizarUsuario(String dni, Usuario usuarioActualizado) {

        String sql = "UPDATE usuarios SET nombre = ?, apellidos = ?, email = ?, telefono = ?, password = ?, rol = ?, activo = ? WHERE dni = ?";

        try (Connection conexion = ConexionBD.getConexion();
                PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, usuarioActualizado.getNombre());
            ps.setString(2, usuarioActualizado.getApellidos());
            ps.setString(3, usuarioActualizado.getEmail());
            ps.setString(4, usuarioActualizado.getTelefono());
            ps.setString(5, usuarioActualizado.getPassword());
            ps.setString(6, usuarioActualizado.getRol().toString());
            ps.setBoolean(7, usuarioActualizado.isActivo());
            ps.setString(8, dni);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean eliminarUsuario(String dni) {

        String sql = "DELETE FROM usuarios WHERE dni = ?";

        try (Connection conexion = ConexionBD.getConexion();
                PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, dni);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
