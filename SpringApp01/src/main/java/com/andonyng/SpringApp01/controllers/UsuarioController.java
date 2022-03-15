package com.andonyng.SpringApp01.controllers;

import com.andonyng.SpringApp01.dao.UsuarioDao;
import com.andonyng.SpringApp01.models.Usuario;
import com.andonyng.SpringApp01.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controlador para Usuarios, capa Controller
@RestController
public class UsuarioController {

    //@Autowired crea un Singleton del objeto al que le ponemos la anotación
    //(Nos ahorramos tener que instanciar el objeto manualmente)
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    //@RequestMapping Mapea una función a una URL, es decir, si llamamos a esa URL, en el backend se ejecutará
    //dicha función.
    //method se refiere al método HTTP con el que se llama a la URL
    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    //Los corchetes alrededor de "id" en la URL y  @PathVariable sirven para indicar que "id" es un argumento para la función.
    //@RequestHeader sirve para obtener un Header que se haya mandado en la petición y pasarlo como parámetro.
    //En este caso obtenemos el contenido del valor "Authorization" del header para luego verificar la sesión del usuario
    public Usuario getUsuario(@PathVariable long id, @RequestHeader(value="Authorization") String token) {

        if (!validarToken(token)) {
            return null;
        }

        return usuarioDao.getUsuario(id);
    }

    @RequestMapping(value = "api/usuario/listado", method = RequestMethod.GET)
    public List<Usuario> getListadoUsuarios(@RequestHeader(value="Authorization") String token) {

        if (!validarToken(token)) {
            return null;
        }

        return usuarioDao.getListadoUsuarios();
    }


    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.POST)
    public void eliminarUsuario(@PathVariable long id, @RequestHeader(value = "Authorization") String token) {

        if (!validarToken(token)) {
            return;
        }

        usuarioDao.eliminarUsuario(id);
    }

    @RequestMapping(value = "api/usuario/crear", method = RequestMethod.POST)
    public void crearUsuario(@RequestBody Usuario usuario, @RequestHeader(value = "Authorization") String token) {

        if (!validarToken(token)) {
            return;
        }

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.crearUsuario(usuario);
    }

    //Función privada para validar el token que el navegador del usuario manda en el header de las peticiones
    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }


}
