package com.andonyng.SpringApp01.controllers;

import com.andonyng.SpringApp01.dao.UsuarioDao;
import com.andonyng.SpringApp01.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable long id) {
        return usuarioDao.getUsuario(id);
    }

    @RequestMapping(value = "api/listado", method = RequestMethod.GET)
    public List<Usuario> getListado() {
        return usuarioDao.getUsuarios();
    }


    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.POST)
    public void eliminar(@PathVariable long id) {
        usuarioDao.eliminarUsuario(id);
    }




   /* @RequestMapping(value = "usuario")
    public Usuario modificar() {
        Usuario usuario = new Usuario("elevenloco","603100722","andony.ng.11@gmail.com","Andony200242");
        return usuario;
    }*/

    /*
    @RequestMapping(value = "usuario")
    public Usuario buscar() {
        Usuario usuario = new Usuario("elevenloco","603100722","andony.ng.11@gmail.com","Andony200242");
        return usuario;
    }*/

}
