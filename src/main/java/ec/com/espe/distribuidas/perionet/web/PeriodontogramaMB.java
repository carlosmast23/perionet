/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.web;

import ec.com.espe.distribuidas.perionet.modelo.DetalleDiente;
import ec.com.espe.distribuidas.perionet.modelo.Diente;
import ec.com.espe.distribuidas.perionet.modelo.Paciente;
import ec.com.espe.distribuidas.perionet.modelo.Periodontograma;
import ec.com.espe.distribuidas.perionet.servicio.DienteServicio;
import ec.com.espe.distribuidas.perionet.servicio.PacienteServicio;
import ec.com.espe.distribuidas.perionet.servicio.PeriodontogramaServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import static org.primefaces.behavior.confirm.ConfirmBehavior.PropertyKeys.message;
import org.primefaces.context.RequestContext;

/**
 *
 * @author carlo
 */
@ViewScoped
@ManagedBean
public class PeriodontogramaMB implements Serializable {

    @EJB
    private PeriodontogramaServicio periodontogramaServicio;

    @EJB
    private DienteServicio dienteServicio;

    @EJB
    private PacienteServicio pacienteServicio;

    private List<Diente> dienteList;

    private List<Periodontograma> periodontogramaList;

    /**
     * Codigo del periodontograma
     */
    private Integer codigoPeridontograma;

    /**
     * Buscar por cedula al cliente
     */
    private String cedula;

    /**
     * Paciente para cargar en el periodontograma
     */
    private Paciente paciente;

    /**
     * Periodontograma seleccionado
     */
    private Periodontograma periodontogramaSeleccionado;

    private Periodontograma periodontogramaNuevo;

    private boolean panelVisibleHistorial;

    private DetalleDiente detalleDienteSeleccionado;

    /**
     * Detalle del diente para grabar
     */
    private DetalleDiente detalleDienteGrabar;

    /**
     * valor para activar las opciones
     */
    private Boolean activarOpcionesNuevo;

    /**
     * Valor para activar las opciones de editar
     *
     */
    private Boolean activarOpcionesEditar;

    /**
     * Variable para crear el nuevo paciente
     */
    private Paciente pacienteNuevo;

    /**
     *
     */
    private String buscarCodigo;

    /**
     * Periodontograma para editar
     */
    private Periodontograma periodontogramaEditar;

    /**
     * Cargar los datos iniciales
     */
    @PostConstruct
    public void init() {
        System.out.println("iniciando la pagina ...");
        dienteList = dienteServicio.obtenerTodo();
        panelVisibleHistorial = false;
        periodontogramaSeleccionado = new Periodontograma();
        activarOpcionesNuevo = true;
        activarOpcionesEditar = false;
        periodontogramaNuevo = new Periodontograma();
        periodontogramaEditar = new Periodontograma();
        periodontogramaEditar.setDetalleDienteList(new ArrayList<DetalleDiente>());
        codigoPeridontograma = new Integer(1);

    }

    public void abrirDialogoValores(DetalleDiente detalle) {
        System.out.println("Abriendo dialogo valores...");
        RequestContext.getCurrentInstance().execute("PF('dlgValor').show()");
        detalleDienteGrabar = detalle;
    }

    public void cerrarInformacion() {
        System.out.println("Cerrando dialogo valores...");
        RequestContext.getCurrentInstance().execute("PF('varInformacion').hide()");
    }

    public void buscarPaciente() {

        System.out.println("Buscando dialogo...");
        System.out.println(cedula);
        Paciente paciente = pacienteServicio.buscarPaciente(cedula);
        //paciente.setPeriodontogramaList(periodontogramaList);

        if (paciente == null) {
            RequestContext.getCurrentInstance().execute("PF('varInformacion').show()");
        } else {
            //////////////CUANDO ENCUENTRA EL PACIENTE /////////////////////////////
            panelVisibleHistorial = true;
            this.paciente = paciente;
            // System.out.println("tamanio-> "+paciente.getPeriodontogramaList().size());
            //this.periodontogramaList = paciente.getPeriodontogramaList();
            this.periodontogramaList = periodontogramaServicio.obtenerPorPacienteCedula(paciente.getCedula());
            this.paciente.setPeriodontogramaList(periodontogramaList);
            // System.out.println("tamanio=>"+this.paciente.getPeriodontogramaList().size());
        }

    }

    public void abrirNuevoPaciente() {
        System.out.println("abrir dialogo paciente...");
        RequestContext.getCurrentInstance().execute("PF('varInformacion').hide()");
        RequestContext.getCurrentInstance().execute("PF('dialogPaciente').show()");
        pacienteNuevo = new Paciente();
        pacienteNuevo.setCedula(cedula);
    }

    public void grabarPaciente() {
        pacienteServicio.grabar(pacienteNuevo);
        paciente = pacienteNuevo;
        System.out.println("grabando paciente ...");
        RequestContext.getCurrentInstance().execute("PF('dialogPaciente').hide()");
    }

    public void abrirImagen(DetalleDiente dienteDetalle) {
        System.out.println("abriendo la imagen ...");
        //dlgImagen
        RequestContext.getCurrentInstance().execute("PF('dlgImagen').show()");
        detalleDienteSeleccionado = dienteDetalle;
        System.out.println(detalleDienteSeleccionado.getIdDiente().getCodigo());
    }

    /**
     * Periodontograma nuevo para guardar los datos
     */
    public void nuevoPeriodontograma() {
        System.out.println("creando el periodontograma ...");
        activarOpcionesNuevo = false;
        periodontogramaNuevo = new Periodontograma();
        periodontogramaNuevo.setFecha(new Date());
        periodontogramaNuevo.setIdPaciente(paciente);
        periodontogramaNuevo.setDiagnostico("periodontitis");

        List<Diente> dientesList = dienteServicio.obtenerTodo();

        List<DetalleDiente> detalleDienteList = new ArrayList<DetalleDiente>();

        //Creando todos los dientes para el periodontograma
        for (Diente diente : dientesList) {
            DetalleDiente detalle = new DetalleDiente();
            detalle.setIdPeriodontograma(periodontogramaNuevo);
            detalle.setIdDiente(diente);
            detalle.setEstado("Normal");
            detalle.setS1("false");
            detalle.setS2("false");
            detalle.setS3("false");

            detalle.setMg11(0);
            detalle.setMg12(0);
            detalle.setMg13(0);
            detalle.setPs11(0);
            detalle.setPs12(0);
            detalle.setPs13(0);
            detalle.setNi11(0);
            detalle.setNi12(0);
            detalle.setNi13(0);
            
            detalle.setEditado("false");

            detalleDienteList.add(detalle);
        }

        periodontogramaNuevo.setDetalleDienteList(detalleDienteList);

        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Correcto", "Creando Periodontograma ..."));

    }
    
    public void cambiarEstadoEditar(DetalleDiente diente)
    {
        List<DetalleDiente> listas = periodontogramaEditar.getDetalleDienteList();

        for (DetalleDiente detalle : listas) {
            if (diente.getIdDiente().getCodigo().equals(detalle.getIdDiente().getCodigo())) {
                detalle.setEstado(diente.getEstado());
            }
        }
    }

    public void cambiarEstado(DetalleDiente diente) {
        List<DetalleDiente> listas = periodontogramaNuevo.getDetalleDienteList();

        for (DetalleDiente detalle : listas) {
            if (diente.getIdDiente().getCodigo().equals(detalle.getIdDiente().getCodigo())) {
                detalle.setEstado(diente.getEstado());
//                System.out.println("modificado->"+detalle.getEstado());
            }
        }

        //List<DetalleDiente> resultados=dienteServicio.buscarPorCodigo(diente);
        //for (DetalleDiente resultado : resultados) 
        //{
        //   resultado.setEstado(diente.getEstado());
        // }
    }

    public void buscarPeriodontograma() {

    }

    public void buscarPorCodigo() {
        //detalle periodontogramaNuevo.getDetalleDienteList();
    }

    public void probarImagen() {
        System.out.println(detalleDienteSeleccionado.getIdDiente().getImagen());

    }

    public void grabarDatos() {
        detalleDienteGrabar.setEditado("true");
        System.out.println("grabando los datos de cada diente ...");
        RequestContext.getCurrentInstance().execute("PF('dlgValor').hide()");

        //detalleDienteGrabar.
    }

    public void cancelarDatos() {
        System.out.println("canelando los datos de cada diente ...");
        RequestContext.getCurrentInstance().execute("PF('dlgValor').hide()");

    }

    public void cambiarValor() {
        System.out.println("Cambiando valores");
    }

    public void guardarEstado() {
        System.out.println("cambiando estado");
    }
    
    public void editarPeriodontograma()
    {
           if (periodontogramaEditar != null) {

            activarOpcionesEditar = false;
            periodontogramaEditar.setDiagnostico(periodontogramaEditar.diagnostico());
            periodontogramaEditar.setNumeroDiagnostico(periodontogramaEditar.getNumeroDiagnostico());

            System.out.println("editar periodontograma...");
            
            periodontogramaServicio.editar(periodontogramaEditar);

            //System.out.println("actual->"+paciente.getPeriodontogramaList().size());
            codigoPeridontograma = periodontogramaEditar.getIdPeriodontograma();

            //periodontogramaNuevo = new Periodontograma();
            FacesContext context = FacesContext.getCurrentInstance();
            
            context.addMessage(null, new FacesMessage("Correcto", "Periodontograma Editado ..."));
            
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrecto", "Seleccione un periodontograma para editar ..."));

        }

    }

    public void grabarPeriodontograma() {
        if (paciente != null) {

            activarOpcionesNuevo = true;
            periodontogramaNuevo.setDiagnostico(periodontogramaNuevo.diagnostico());
            periodontogramaNuevo.setNumeroDiagnostico(periodontogramaNuevo.getNumeroDiagnostico());

            System.out.println("grabando periodontograma...");
            //System.out.println("antiguo->"+paciente.getPeriodontogramaList().size());
            periodontogramaServicio.grabar(periodontogramaNuevo);

//            paciente.getPeriodontogramaList().add(periodontogramaNuevo);
//            
//            
//            for (Periodontograma perio : paciente.getPeriodontogramaList()) 
//            {
//                perio.setIdPaciente(paciente);
//            }
            //System.out.println("actual->"+paciente.getPeriodontogramaList().size());
            codigoPeridontograma = periodontogramaNuevo.getIdPeriodontograma();

            //periodontogramaNuevo = new Periodontograma();
            FacesContext context = FacesContext.getCurrentInstance();
            System.out.println("cod=" + codigoPeridontograma);
            System.out.println(cedula);
            context.addMessage(null, new FacesMessage("Correcto", "Periodontograma Grabado ..."));
            RequestContext.getCurrentInstance().execute("PF('widgetImprimir').show()");
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrecto", "Seleccione un paciente para grabar ..."));

        }

    }

    private void buscarPorPaciente(Integer codigo) {

    }

    public void editarPeriodontograma(Periodontograma periodontograma) {
        System.out.println("Editar los periodontogramas");
        periodontogramaEditar = periodontogramaServicio.buscar(periodontograma.getIdPeriodontograma());
        activarOpcionesEditar = true;

    }

    public void cancelarPeriodontograma() {
        activarOpcionesNuevo = true;
        System.out.println("cancelando periodontograma...");
        periodontogramaNuevo = new Periodontograma();
    }

    public void cancelarPeriodontogramaEdit() {
        activarOpcionesEditar = false;
        System.out.println("cancelando periodontograma...");
        periodontogramaEditar = new Periodontograma();
    }

    public void probar() {
        System.out.println("codig=> " + codigoPeridontograma);
    }

    ///////////////// GET AND SET /////////////
    public List<Diente> getDienteList() {
        return dienteList;
    }

    public void setDienteList(List<Diente> dienteList) {
        this.dienteList = dienteList;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<Periodontograma> getPeriodontogramaList() {
        return periodontogramaList;
    }

    public void setPeriodontogramaList(List<Periodontograma> periodontogramaList) {
        this.periodontogramaList = periodontogramaList;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Periodontograma getPeriodontogramaSeleccionado() {
        return periodontogramaSeleccionado;
    }

    public void setPeriodontogramaSeleccionado(Periodontograma periodontogramaSeleccionado) {
        this.periodontogramaSeleccionado = periodontogramaSeleccionado;
    }

    public boolean isPanelVisibleHistorial() {
        return panelVisibleHistorial;
    }

    public void setPanelVisibleHistorial(boolean panelVisibleHistorial) {
        this.panelVisibleHistorial = panelVisibleHistorial;
    }

    public Periodontograma getPeriodontogramaNuevo() {
        return periodontogramaNuevo;
    }

    public void setPeriodontogramaNuevo(Periodontograma periodontogramaNuevo) {
        this.periodontogramaNuevo = periodontogramaNuevo;
    }

    public DetalleDiente getDetalleDienteSeleccionado() {
        return detalleDienteSeleccionado;
    }

    public void setDetalleDienteSeleccionado(DetalleDiente detalleDienteSeleccionado) {
        this.detalleDienteSeleccionado = detalleDienteSeleccionado;
    }

    public DetalleDiente getDetalleDienteGrabar() {
        return detalleDienteGrabar;
    }

    public void setDetalleDienteGrabar(DetalleDiente detalleDienteGrabar) {
        this.detalleDienteGrabar = detalleDienteGrabar;
    }

    public Boolean getActivarOpcionesNuevo() {
        return activarOpcionesNuevo;
    }

    public void setActivarOpcionesNuevo(Boolean activarOpcionesNuevo) {
        this.activarOpcionesNuevo = activarOpcionesNuevo;
    }

    public Paciente getPacienteNuevo() {
        return pacienteNuevo;
    }

    public void setPacienteNuevo(Paciente pacienteNuevo) {
        this.pacienteNuevo = pacienteNuevo;
    }

    public String getBuscarCodigo() {
        return buscarCodigo;
    }

    public void setBuscarCodigo(String buscarCodigo) {
        this.buscarCodigo = buscarCodigo;
    }

    public Integer getCodigoPeridontograma() {
        return codigoPeridontograma;
    }

    public void setCodigoPeridontograma(Integer codigoPeridontograma) {
        this.codigoPeridontograma = codigoPeridontograma;
    }

    public Periodontograma getPeriodontogramaEditar() {
        return periodontogramaEditar;
    }

    public void setPeriodontogramaEditar(Periodontograma periodontogramaEditar) {
        this.periodontogramaEditar = periodontogramaEditar;
    }

    public Boolean getActivarOpcionesEditar() {
        return activarOpcionesEditar;
    }

    public void setActivarOpcionesEditar(Boolean activarOpcionesEditar) {
        this.activarOpcionesEditar = activarOpcionesEditar;
    }

}
