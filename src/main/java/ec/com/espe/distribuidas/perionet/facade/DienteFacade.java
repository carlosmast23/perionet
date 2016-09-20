/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.facade;

import ec.com.espe.distribuidas.perionet.modelo.DetalleDiente;
import ec.com.espe.distribuidas.perionet.modelo.Diente;
import ec.com.espe.distribuidas.perionet.modelo.Periodontograma;
import java.util.List;
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
public class DienteFacade extends AbstractFacade<Diente> {

    @PersistenceContext(unitName = "perionet_persistent_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DienteFacade() {
        super(Diente.class);
    }

    public List<Diente> findDientes() 
    {

        try {
            String queryString = "SELECT d FROM Diente d order by d.orden asc";
            Query query = em.createQuery(queryString);            
            List<Diente> dienteList = (List<Diente>) query.getResultList();
            //System.out.println(cliente);
            return dienteList;
        } catch (NoResultException e) {
            return null;
        }

    }

}
