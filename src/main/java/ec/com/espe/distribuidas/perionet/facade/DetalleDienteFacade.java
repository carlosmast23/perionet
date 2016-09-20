/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.facade;

import ec.com.espe.distribuidas.perionet.modelo.DetalleDiente;
import ec.com.espe.distribuidas.perionet.modelo.Diente;
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
public class DetalleDienteFacade extends AbstractFacade<DetalleDiente> {
    @PersistenceContext(unitName = "perionet_persistent_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleDienteFacade() {
        super(DetalleDiente.class);
    }
    
    public List<DetalleDiente> findOrderAsc(Integer codigo)
    {
        
        try {
            String queryString = "SELECT d FROM DetalleDiente d where d.idPeriodontograma.idPeriodontograma=?1 ORDER BY d.idDiente.orden ASC  ";

            Query query = em.createQuery(queryString);
            query.setParameter(1, codigo);

            List<DetalleDiente> dientes = (List<DetalleDiente>) query.getResultList();
            System.out.println("tamanio-> "+dientes.size());
            return dientes;
        } catch (NoResultException e) {
            return null;
        }

        
    }
    
    public List<DetalleDiente> findByCodigo(DetalleDiente diente)
    {
        try {
            String queryString = "SELECT d FROM DetalleDiente d where d.idPeriodontograma.idPeriodontograma=?1  ";

            Query query = em.createQuery(queryString);
            
            if(diente==null)
            {
                System.out.println("NULL");
            }
            else
            {
                System.out.println(diente.getIdDiente().getIdDiente());
            }
            
            System.out.println("-->"+diente.getIdPeriodontograma().getIdPeriodontograma());
            
            query.setParameter(1, diente.getIdPeriodontograma().getIdPeriodontograma());
           // query.setParameter(2, diente.getIdDiente().getCodigo());

            List<DetalleDiente> dientes = (List<DetalleDiente>) query.getResultList();
            System.out.println("tamanio-> "+dientes.size());
            return dientes;
        } catch (NoResultException e) {
            return null;
        }
    }   
    
   
    public void limpiar()
    {
        getEntityManager().clear();
    }
    
}
