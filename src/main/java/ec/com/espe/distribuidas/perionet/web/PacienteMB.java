/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.web;

import ec.com.espe.distribuidas.perionet.modelo.Paciente;
import ec.com.espe.distribuidas.perionet.servicio.PacienteServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author carlo
 */
@ViewScoped
@ManagedBean
public class PacienteMB implements Serializable 
{

    @EJB
    private PacienteServicio pacienteServicio;
    

    private List<Paciente> pacienteList;
    
    private Paciente pacienteNuevo;
    
    private Paciente pacienteEditar;
    
    

    @PostConstruct
    public void init() 
    {
        System.out.println("iniciando paciente ...");
        pacienteList = pacienteServicio.obtenerDatos();
        System.out.println(pacienteList.size());
    }

    /**
     * Dialogo para abrir el paciente
     */
    public void abrirDialogoPaciente() {
        System.out.println("abriendo dialogo nuevoPaciente");
        pacienteNuevo=new Paciente();
        RequestContext.getCurrentInstance().execute("PF('dlgNuevoPaciente').show()");
    }
    
    public void grabarPaciente()
    {
        System.out.println("grabando paciente...");
        System.out.println(pacienteNuevo.getCedula()+" , "+pacienteNuevo.getNombres()+" , "+pacienteNuevo.getHcl());
        pacienteServicio.grabar(pacienteNuevo);
        pacienteList=pacienteServicio.obtenerDatos();
        RequestContext.getCurrentInstance().execute("PF('dlgNuevoPaciente').hide()");
        
    }
    
    public void editarPaciente()
    {
        System.out.println("editar paciente...");
        //System.out.println(pacienteNuevo.getCedula()+" , "+pacienteNuevo.getNombres()+" , "+pacienteNuevo.getHcl());
        pacienteServicio.editar(pacienteEditar);
        pacienteList=pacienteServicio.obtenerDatos();
        RequestContext.getCurrentInstance().execute("PF('dlgEditarPaciente').hide()");
    }
    
    /**
     * Borrar el paciente
     */
    public void borrar(Paciente paciente)
    {
        System.out.println("borrando paciente");
        pacienteServicio.eliminar(paciente);
        pacienteList=pacienteServicio.obtenerDatos();
        
    }
    
    public void cerrarDialogoEditar()
    {
        System.out.println("cerrando diaogo editar paciente");
        RequestContext.getCurrentInstance().execute("PF('dlgEditarPaciente').hide()");
        //pacienteServicio.eliminar(pacienteEditar);
        //pacienteList=pacienteServicio.obtenerDatos();
    }

    public void cerrarDialogoNuevo() 
    {
        System.out.println("cerrando dialogo nuevoPaciente");
        RequestContext.getCurrentInstance().execute("PF('dlgNuevoPaciente').hide()");
    }
    
    public void abrirEdialogoEditar(Paciente paciente)
    {
        System.out.println("cerrando dialogo nuevoPaciente");
        RequestContext.getCurrentInstance().execute("PF('dlgEditarPaciente').show()");
        pacienteEditar=paciente;
    }

    ///////////////////METODOS GET AND SET///////////////////////
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    public Paciente getPacienteNuevo() {
        return pacienteNuevo;
    }

    public void setPacienteNuevo(Paciente pacienteNuevo) {
        this.pacienteNuevo = pacienteNuevo;
    }

    public Paciente getPacienteEditar() {
        return pacienteEditar;
    }

    public void setPacienteEditar(Paciente pacienteEditar) {
        this.pacienteEditar = pacienteEditar;
    }
    
    

}
