/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.servicio;

import ec.com.espe.distribuidas.perionet.facade.DetalleDienteFacade;
import ec.com.espe.distribuidas.perionet.facade.PacienteFacade;
import ec.com.espe.distribuidas.perionet.facade.PeriodontogramaFacade;
import ec.com.espe.distribuidas.perionet.modelo.DetalleDiente;
import ec.com.espe.distribuidas.perionet.modelo.Periodontograma;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;


/**
 *
 * @author carlo
 */
@LocalBean
@Stateless
public class PeriodontogramaServicio implements Serializable
{
    @EJB
    private PeriodontogramaFacade periodontogramaFacade;
    
    @EJB
    private DetalleDienteFacade detalleDienteFacade;
    
    @EJB
    private PacienteFacade pacienteFacade;
    
    
    
    /**
     * Obtener periodontogramas filtrado por cedula
     * @return 
     */
    public List<Periodontograma> obtenerPorPacienteCedula(String cedula)
    {
        return periodontogramaFacade.findByCedulaPaciente(cedula);
    }
    
    public Periodontograma buscar(Integer id)
    {
        Periodontograma periodontograma= periodontogramaFacade.find(id);
        //detalleDienteFacade.findOrderDesc();
        periodontograma.setDetalleDienteList(detalleDienteFacade.findOrderAsc(periodontograma.getIdPeriodontograma()));
        return periodontograma;
      
    }
    
    public void grabar(Periodontograma periodontograma)
    {
        
        periodontogramaFacade.create(periodontograma);
        Integer codigo=periodontograma.getIdPeriodontograma();
        
        List<DetalleDiente> lista=periodontograma.getDetalleDienteList();
        for (DetalleDiente detalle : lista) 
        {
            detalle.setIdPeriodontograma(periodontograma);
            detalleDienteFacade.edit(detalle);
            
        }
      //  pacienteFacade.refresh(periodontograma.getIdPaciente());
        
    }
    
    public void editar(Periodontograma periodontograma)
    {
        periodontogramaFacade.edit(periodontograma);
    }
}
