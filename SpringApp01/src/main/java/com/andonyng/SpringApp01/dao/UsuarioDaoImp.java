package com.andonyng.SpringApp01.dao;

import com.andonyng.SpringApp01.models.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    public List<Usuario> getListado() {
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

}
