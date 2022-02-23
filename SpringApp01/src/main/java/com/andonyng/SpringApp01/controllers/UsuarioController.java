package com.andonyng.SpringApp01.controllers;

import com.andonyng.SpringApp01.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    /* URL "/usuario" */
    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable long id) {
        Usuario usuario = new Usuario("elevenloco","603100722","andony.ng.11@gmail.com","Andony200242",id);
        return usuario;
    }

    @RequestMapping(value = "listado")
    public List<Usuario> getListado() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        Usuario usuario1 = new Usuario("elevenloco","603100722","andony.ng.11@gmail.com","Andony200242",1);
        Usuario usuario2 = new Usuario("andony2002","603100723","locoforeverywhere@gmail.com","jjj_200242",2);
        Usuario usuario3 = new Usuario("locoflipon","603100724","locoforeverywhere2@gmail.com","ggg$$eznoob",3);
        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario3);
        return listaUsuarios;
    }

   /* @RequestMapping(value = "usuario")
    public Usuario modificar() {
        Usuario usuario = new Usuario("elevenloco","603100722","andony.ng.11@gmail.com","Andony200242");
        return usuario;
    }

    @RequestMapping(value = "usuario")
    public Usuario eliminar() {
        Usuario usuario = new Usuario("elevenloco","603100722","andony.ng.11@gmail.com","Andony200242");
        return usuario;
    }

    @RequestMapping(value = "usuario")
    public Usuario buscar() {
        Usuario usuario = new Usuario("elevenloco","603100722","andony.ng.11@gmail.com","Andony200242");
        return usuario;
    }*/

}
