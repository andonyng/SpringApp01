package com.andonyng.SpringApp01.controllers;

import com.andonyng.SpringApp01.dao.UsuarioDao;
import com.andonyng.SpringApp01.models.Usuario;
import com.andonyng.SpringApp01.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controlador para autenticar Usuarios, capa Controller
@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping (value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) { //
        Usuario usuarioVerificado = usuarioDao.getByCredenciales(usuario); //Obtenemos el usuario si ha sido verificado

        if (usuarioVerificado == null) {
            return String.valueOf(null); //Si no se ha podido verificar el usuario retorna "null"
        }

        String token = jwtUtil.create(String.valueOf(usuarioVerificado.getId()),
                usuarioVerificado.getEmail()); //Tras haber verificado el usuario, creamos el token JWT

        return token; //Retornamos el token al cliente

    }

}
