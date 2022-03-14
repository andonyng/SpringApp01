package com.andonyng.SpringApp01.controllers;

import com.andonyng.SpringApp01.dao.UsuarioDao;
import com.andonyng.SpringApp01.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable long id) {
        return usuarioDao.getUsuario(id);
    }

    @RequestMapping(value = "api/usuario/listado", method = RequestMethod.GET)
    public List<Usuario> getListado() {
        return usuarioDao.getListado();
    }


    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.POST)
    public void eliminar(@PathVariable long id) {
        usuarioDao.eliminarUsuario(id);
    }

    @RequestMapping(value = "api/usuario/crear", method = RequestMethod.POST)
    public void crear(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.crearUsuario(usuario);
    }


}
