/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.web;

import ec.com.espe.distribuidas.perionet.modelo.DetalleDiente;
import ec.com.espe.distribuidas.perionet.modelo.Periodontograma;
import ec.com.espe.distribuidas.perionet.servicio.PeriodontogramaServicio;
import ec.com.espe.distribuidas.perionet.web.temp.FilaReporte;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
public class ReporteMB implements Serializable{
    
    @EJB
    private PeriodontogramaServicio periodontogramaServicio;
    
    private Periodontograma periodontograma;
    
    /**
     * Variable que recibe el codigo enviado por parametro
     */
    private Integer codigoPeriodontograma;
    
    
    private List<FilaReporte> filas;
    
    
    @PostConstruct
    public void init()
    {
        //System.out.println(codigoPeriodontograma);
        //periodontograma=periodontogramaServicio.buscar(codigoPeriodontograma);
        //periodontograma=periodontogramaServicio.buscar(5);
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String codigo=request.getParameter("codigo");
        //System.out.println(cedula);
        
        periodontograma=periodontogramaServicio.buscar(Integer.parseInt(codigo));
        
//        System.out.println(periodontograma.getDetalleDienteList().size());
        filas=new ArrayList<FilaReporte>();
        rellenarFilasReportes();
        
    }
    
    private void rellenarFilasReportes()
    {
        List<DetalleDiente> lista=periodontograma.getDetalleDienteList();
        System.out.println("tam ->"+lista.size());
        
        for(int i=0;i<lista.size();)
        {
            FilaReporte fila=new FilaReporte();
            fila.d1=lista.get(i++);
            fila.d2=lista.get(i++);
            fila.d3=lista.get(i++);
            fila.d4=lista.get(i++);
            fila.d5=lista.get(i++);
            fila.d6=lista.get(i++);
            fila.d7=lista.get(i++);
            fila.d8=lista.get(i++);
            
            fila.d9=lista.get(i++);
            fila.d10=lista.get(i++);
            fila.d11=lista.get(i++);
            fila.d12=lista.get(i++);
            fila.d13=lista.get(i++);
            fila.d14=lista.get(i++);
            fila.d15=lista.get(i++);
            fila.d16=lista.get(i++);
            
            filas.add(fila);
            
            
        }
    }
    
    public void imprimir()
    {
        System.out.println("codigo---------->"+codigoPeriodontograma);
    }
    
    //////////////////////GET AND SET////////////////////////////

    public List<FilaReporte> getFilas() {
        return filas;
    }

    public void setFilas(List<FilaReporte> filas) {
        this.filas = filas;
    }

    public Integer getCodigoPeriodontograma() {
        return codigoPeriodontograma;
    }

    public void setCodigoPeriodontograma(Integer codigoPeriodontograma) {
        this.codigoPeriodontograma = codigoPeriodontograma;
        //System.out.println("codigos =>"+codigoPeriodontograma);
        //periodontograma=periodontogramaServicio.buscar(codigoPeriodontograma);
    }

    public Periodontograma getPeriodontograma() {
        return periodontograma;
    }

    public void setPeriodontograma(Periodontograma periodontograma) {
        this.periodontograma = periodontograma;
    }
    
    
    
    
    
}
