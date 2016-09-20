/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.facade;

import ec.com.espe.distribuidas.perionet.modelo.Paciente;
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
public class PacienteFacade extends AbstractFacade<Paciente> {

    @PersistenceContext(unitName = "perionet_persistent_unit")
    private EntityManager em;

    public PacienteFacade() {
        super(Paciente.class);
    }

    public Paciente findByCedula(String cedula) {
        try {
            String queryString = "SELECT p FROM Paciente p where p.cedula=?1";
            Query query = em.createQuery(queryString);
            query.setParameter(1, cedula);
            Paciente paciente = (Paciente) query.getSingleResult();
            //System.out.println(cliente);
            return paciente;
        } catch (NoResultException e) {
            return null;
        }

    }
    
   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
