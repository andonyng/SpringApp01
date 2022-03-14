package com.andonyng.SpringApp01.controllers;

import com.andonyng.SpringApp01.dao.UsuarioDao;
import com.andonyng.SpringApp01.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    UsuarioDao usuarioDao;

    @RequestMapping (value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {
        return String.valueOf(usuarioDao.verificar(usuario));
    }

}
