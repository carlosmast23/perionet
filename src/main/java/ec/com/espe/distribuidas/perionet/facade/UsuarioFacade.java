/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.facade;

import ec.com.espe.distribuidas.perionet.modelo.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author carlo
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "perionet_persistent_unit")
    private EntityManager em;

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Usuario login(String nick, String clave) {
        try {
            String queryString = "SELECT u FROM Usuario u where u.usuario=?1 And u.contrasena=?2";
            Query query = em.createQuery(queryString);
            query.setParameter(1, nick);
            query.setParameter(2, clave);
            Usuario usuario = (Usuario) query.getSingleResult();
            //System.out.println(usuario);
            return usuario;
        } catch (NoResultException e) {
            return null;
        }
       // return null;
    }
}
