/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.facade;

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
public class PeriodontogramaFacade extends AbstractFacade<Periodontograma> {

    @PersistenceContext(unitName = "perionet_persistent_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeriodontogramaFacade() {
        super(Periodontograma.class);
    }

    public List<Periodontograma> findByCedulaPaciente(String cedula) {
        try {
            String queryString = "SELECT p FROM Periodontograma p where p.idPaciente.cedula=?1 order by p.idPeriodontograma desc";
            Query query = em.createQuery(queryString);
            query.setParameter(1, cedula);
            List<Periodontograma> periodontogramaList = (List<Periodontograma>) query.getResultList();
            //System.out.println(cliente);
            return periodontogramaList;
        } catch (NoResultException e) {
            return null;
        }

    }
    
    public Periodontograma findByCode(Integer codigo) {
        try {
            String queryString = "SELECT p FROM Periodontrograma p where p.idPeriodontograma=?1";
            Query query = em.createQuery(queryString);
            query.setParameter(1, codigo);
            Periodontograma periodontograma = (Periodontograma) query.getSingleResult();
            //System.out.println(cliente);
            return periodontograma;
        } catch (NoResultException e) {
            return null;
        }
    }

}
