package com.andonyng.SpringApp01.dao;

import com.andonyng.SpringApp01.models.Usuario;

import java.util.List;

//Interfaz capa DAO
public interface UsuarioDao {

    Usuario getUsuario(long id);

    List<Usuario> getListadoUsuarios();

    void eliminarUsuario(long id);

    void crearUsuario(Usuario usuario);

    Usuario getByCredenciales(Usuario usuario);
}
