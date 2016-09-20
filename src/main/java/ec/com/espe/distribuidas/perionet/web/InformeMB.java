/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.web;

import ec.com.espe.distribuidas.perionet.modelo.Periodontograma;
import ec.com.espe.distribuidas.perionet.servicio.PeriodontogramaServicio;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author carlo
 */
@ManagedBean
@ViewScoped
public class InformeMB implements Serializable
{
    
    private Periodontograma periodontograma;
    
    @EJB
    private PeriodontogramaServicio periodontogramaServicio;
    
            
    
    @PostConstruct
    public void init()
    {
        System.out.println("iniciando variables");
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String codigo=request.getParameter("codigo");
        //System.out.println(cedula);
        
        periodontograma=periodontogramaServicio.buscar(Integer.parseInt(codigo));
    }

    public Periodontograma getPeriodontograma() {
        return periodontograma;
    }

    public void setPeriodontograma(Periodontograma periodontograma) {
        this.periodontograma = periodontograma;
    }
    
    
    
    
}
