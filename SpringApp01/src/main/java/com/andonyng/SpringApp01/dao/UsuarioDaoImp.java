package com.andonyng.SpringApp01.dao;

import com.andonyng.SpringApp01.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//Implementación capa DAO
@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Usuario getUsuario(long id) {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public List<Usuario> getListadoUsuarios() {
        String query = "from Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminarUsuario(long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario getByCredenciales(Usuario usuario) {
        //Como estamos usando argon2 para cifrar contraseñas, solo verificamos el email en la consulta SQL
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> result = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        //Retorna null si no existe usuario con el email proporcionado
        if (result.isEmpty()) {
            return null;
        }

        //A continuación si que verificamos la contraseña cifrada

        //Aquí obtenemos la contraseña cifrada de la base de datos del usuario con el email indicado
        String hashedPassword = result.get(0).getPassword();

        //Aquí comparamos la contraseña del usuario en la base de datos con
        //la proporcionada en la pantalla de login
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(hashedPassword, usuario.getPassword())) {
            return result.get(0);
        } else {
            return null;
        }
    }

}
