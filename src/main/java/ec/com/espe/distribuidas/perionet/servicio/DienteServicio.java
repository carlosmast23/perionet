/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.servicio;

import ec.com.espe.distribuidas.perionet.facade.DetalleDienteFacade;
import ec.com.espe.distribuidas.perionet.facade.DienteFacade;
import ec.com.espe.distribuidas.perionet.modelo.DetalleDiente;
import ec.com.espe.distribuidas.perionet.modelo.Diente;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author carlo
 */
@Stateless
@LocalBean
public class DienteServicio implements Serializable
{
    @EJB
    private DienteFacade dienteFacade; 
    
    @EJB
    private DetalleDienteFacade detalleDienteFacade;
    
    public List<Diente> obtenerTodo()
    {
        //return dienteFacade.findAll();
        return dienteFacade.findDientes();
    }
    
    public List<DetalleDiente> buscarPorCodigo(DetalleDiente diente)
    {
        
        return detalleDienteFacade.findByCodigo(diente);
        //return null;
    }
    
}
