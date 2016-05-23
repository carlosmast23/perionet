/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.web;


import java.io.Serializable;
import javax.annotation.PostConstruct;
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
    @PostConstruct
    public void init()
    {
        System.out.println("iniciando paciente ...");
    }
    
    /**
     * Dialogo para abrir el paciente
     */
    public void abrirDialogoPaciente()
    {
        System.out.println("abriendo dialogo nuevoPaciente");
        RequestContext.getCurrentInstance().execute("PF('dlgNuevoPaciente').show()");
    }
    
}
