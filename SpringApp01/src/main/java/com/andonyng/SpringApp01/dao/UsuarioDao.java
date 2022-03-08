package com.andonyng.SpringApp01.dao;

import com.andonyng.SpringApp01.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    Usuario getUsuario(long id);

    List<Usuario> getUsuarios();

    void eliminarUsuario(long id);

}
