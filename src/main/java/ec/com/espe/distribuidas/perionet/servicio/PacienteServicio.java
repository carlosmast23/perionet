/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.servicio;

import ec.com.espe.distribuidas.perionet.facade.PacienteFacade;
import ec.com.espe.distribuidas.perionet.modelo.Paciente;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author carlo
 */
@LocalBean
@Stateless
public class PacienteServicio implements Serializable
{
    @EJB
    private PacienteFacade pacienteFacade;
    
    public List<Paciente> obtenerDatos()
    {
        return pacienteFacade.findAll();
    }
    
    public void eliminar(Paciente paciente)
    {
        pacienteFacade.remove(paciente);
    }
    
    public void editar(Paciente paciente)
    {
        pacienteFacade.edit(paciente);
    }
    
    public void grabar(Paciente paciente)
    {
        pacienteFacade.create(paciente);
    }
    
    public Paciente buscarPaciente(String cedula)
    {
        return pacienteFacade.findByCedula(cedula);
    }
        
}
