/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "periodontograma")
public class Periodontograma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PERIODONTOGRAMA")
    private Integer idPeriodontograma;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Column(name = "DGN_DIAGNOSTICO")
    private String diagnostico;
    
    @Column(name = "DGN_NUM_DIAGNOSTICO")
    private Integer numeroDiagnostico;
    
    @Column(name = "DGN_OBSERVACIONES")
    private String diagnosticoObservaciones;
    
    @Column(name = "DGN_EVOLUCION")
    private String diagnosticoEvolucion;
    
    @Column(name = "TRA1_TERAPIA")
    private String tratamiento1Terapia;
    
    @Column(name = "TRA2_REMISION")
    private String tratamiento2Remision;
    
    @Column(name = "TRA2_FASE")
    private String tratamiento2Fase;
    
    @Column(name = "TRA3_R1_X1")
    private String tratamiento3R1X1;
    @Column(name = "TRA3_R1_X2")
    private String tratamiento3R1X2;
    @Column(name = "TRA3_R1_X3")
    private String tratamiento3R1X3;
    @Column(name = "TRA3_R1_X4")
    private String tratamiento3R1X4;
    
    @Column(name = "TRA3_R2_X1")
    private String tratamiento3R2X1;
    @Column(name = "TRA3_R2_X2")
    private String tratamiento3R2X2;
    @Column(name = "TRA3_R2_X3")
    private String tratamiento3R2X3;
    @Column(name = "TRA3_R2_X4")
    private String tratamiento3R2X4;
    @Column(name = "TRA3_R2_X5")
    private String tratamiento3R2X5;
    @Column(name = "TRA3_R2_X6")
    private String tratamiento3R2X6;
    
    @Column(name = "TRA3_REMISION")
    private String tratamiento3Remision;
    @Column(name = "TRA3_TERAPIA")
    private String tratamiento3Terapia;
    
    
    
    
    
    @OneToMany(mappedBy = "idPeriodontograma")
    private List<Diagnostico> diagnosticoList;

    @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "ID_PACIENTE")
    @ManyToOne
    private Paciente idPaciente;

    @OneToMany(mappedBy = "idPeriodontograma", cascade = CascadeType.ALL)
    private List<DetalleDiente> detalleDienteList;

    @OneToMany(mappedBy = "idPeriodontograma")
    private List<Tratamiento> tratamientoList;



    public Periodontograma() {
    }

    public Periodontograma(Integer idPeriodontograma) 
    {
        this.idPeriodontograma = idPeriodontograma;
    }

    //////////////////Metodos Implementados//////////////////////////////////
    public String diagnostico() {
        String diagnostico = "";

        if (!obtenerSangrado()) {
            ///Verificar si esta saludable
            if (MGRango(-3, 0) && PSRango(0, 3)) {
                diagnostico = "Saludable";
                
                //return diagnostico;
            }
        } else {
            ///Verificar Gingititis
            if (PSRango(0, 3)) {
                if (MGRango(-3, 3)) {
                    diagnostico = "Gingivitis";
                    
                }
            } else {
                /////Periodentitis
                diagnostico = "Periodentitis";
                

                if (NiMax() >= 1 && NiMax() <= 2) {
                    diagnostico += " leve";

                    Integer porcentaje = NiPorcetaje(1, 2);
                    if (porcentaje < 30) {
                        diagnostico += " localizada";
                    } else {
                        diagnostico += "generalizada";
                    }
                }

                if (NiMax() >= 3 && NiMax() <= 4) {
                    diagnostico += " moderado";

                    Integer porcentaje = NiPorcetaje(3, 4);
                    if (porcentaje < 30) {
                        diagnostico += " localizada";
                    } else {
                        diagnostico += "generalizada";
                    }
                }

                if (NiMax() >= 5) {
                    diagnostico += "severa";

                    Integer porcentaje = NiPorcetaje(5, 100);
                    if (porcentaje < 30) {
                        diagnostico += " localizada";
                    } else {
                        diagnostico += "generalizada";
                    }
                }

            }
        }

        return diagnostico;
    }
    
    //////////////////Metodos Implementados//////////////////////////////////
    public int tratamiento() {
        int tratamiento = 0;

        if (!obtenerSangrado()) {
            ///Verificar si esta saludable
            if (MGRango(-3, 0) && PSRango(0, 3)) {
                tratamiento = 1;
                
                //return diagnostico;
            }
        } else {
            ///Verificar Gingititis
            if (PSRango(0, 3)) {
                if (MGRango(-3, 3)) {
                    tratamiento = 2;
                    
                }
            } else {
                /////Periodentitis
                tratamiento = 3;
                

            }
        }

        return tratamiento;
    }

    private Integer NiPorcetaje(Integer min, Integer max) {
        Integer rango = 0;

        for (DetalleDiente detalle : detalleDienteList) {
            if (!detalle.getEstado().equals("Ausente")) {
                if (detalle.getNi11() >= min && detalle.getNi11() <= max) {
                    rango++;
                }

                if (detalle.getNi12() >= min && detalle.getNi12() <= max) {
                    rango++;
                }

                if (detalle.getNi13() >= min && detalle.getNi13() <= max) {
                    rango++;
                }
            }
        }

        return (rango * 100) / (detalleDienteList.size());
    }

    private boolean obtenerSangrado() {
        //boolean sangrado=false;
        if (detalleDienteList != null) {
            for (DetalleDiente detalle : detalleDienteList) {
                if (detalle.getS1().equals("true") || detalle.getS1().equals("true") || detalle.getS1().equals("true")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean MGRango(Integer inicio, Integer fin) {
        if (detalleDienteList != null) {
            for (DetalleDiente detalle : detalleDienteList) {
                if (!(detalle.getMg11() >= inicio && detalle.getMg11() <= fin)) {
                    return false;
                }

                if (!(detalle.getMg12() >= inicio && detalle.getMg12() <= fin)) {
                    return false;
                }

                if (!(detalle.getMg13() >= inicio && detalle.getMg13() <= fin)) {
                    return false;
                }
            }
        }

        return true;

    }

    private boolean PSRango(Integer inicio, Integer fin) {
        if (detalleDienteList != null) {
            for (DetalleDiente detalle : detalleDienteList) {
                if (!(detalle.getPs11() >= inicio && detalle.getPs11() <= fin)) {
                    return false;
                }

                if (!(detalle.getPs12() >= inicio && detalle.getPs12() <= fin)) {
                    return false;
                }

                if (!(detalle.getPs13() >= inicio && detalle.getPs13() <= fin)) {
                    return false;
                }
            }
        }

        return true;

    }

    private Integer NiMax() {
        Integer max = -999999;
        if (detalleDienteList != null) {

            for (DetalleDiente detalle : detalleDienteList) {
                if (detalle.getNi11() > max) {
                    max = detalle.getNi11();
                }

                if (detalle.getNi12() > max) {
                    max = detalle.getNi12();
                }

                if (detalle.getNi13() > max) {
                    max = detalle.getNi13();
                }
            }
        }
        return max;
    }

    ///////////////metodos get and set////////////////////////
    public Integer getIdPeriodontograma() {
        return idPeriodontograma;
    }

    public void setIdPeriodontograma(Integer idPeriodontograma) {
        this.idPeriodontograma = idPeriodontograma;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Diagnostico> getDiagnosticoList() {
        return diagnosticoList;
    }

    public void setDiagnosticoList(List<Diagnostico> diagnosticoList) {
        this.diagnosticoList = diagnosticoList;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    @XmlTransient
    public List<DetalleDiente> getDetalleDienteList() {
        return detalleDienteList;
    }

    public void setDetalleDienteList(List<DetalleDiente> detalleDienteList) {
        this.detalleDienteList = detalleDienteList;
    }

    @XmlTransient
    public List<Tratamiento> getTratamientoList() {
        return tratamientoList;
    }

    public void setTratamientoList(List<Tratamiento> tratamientoList) {
        this.tratamientoList = tratamientoList;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Integer getNumeroDiagnostico() {
        return numeroDiagnostico;
    }

    public void setNumeroDiagnostico(Integer numeroDiagnostico) {
        this.numeroDiagnostico = numeroDiagnostico;
    }

    public String getDiagnosticoObservaciones() {
        return diagnosticoObservaciones;
    }

    public void setDiagnosticoObservaciones(String diagnosticoObservaciones) {
        this.diagnosticoObservaciones = diagnosticoObservaciones;
    }

    public String getDiagnosticoEvolucion() {
        return diagnosticoEvolucion;
    }

    public void setDiagnosticoEvolucion(String diagnosticoEvolucion) {
        this.diagnosticoEvolucion = diagnosticoEvolucion;
    }

    public String getTratamiento1Terapia() {
        return tratamiento1Terapia;
    }

    public void setTratamiento1Terapia(String tratamiento1Terapia) {
        this.tratamiento1Terapia = tratamiento1Terapia;
    }

    public String getTratamiento2Remision() {
        return tratamiento2Remision;
    }

    public void setTratamiento2Remision(String tratamiento2Remision) {
        this.tratamiento2Remision = tratamiento2Remision;
    }

    public String getTratamiento2Fase() {
        return tratamiento2Fase;
    }

    public void setTratamiento2Fase(String tratamiento2Fase) {
        this.tratamiento2Fase = tratamiento2Fase;
    }

    public String getTratamiento3R1X1() {
        return tratamiento3R1X1;
    }

    public void setTratamiento3R1X1(String tratamiento3R1X1) {
        this.tratamiento3R1X1 = tratamiento3R1X1;
    }

    public String getTratamiento3R1X2() {
        return tratamiento3R1X2;
    }

    public void setTratamiento3R1X2(String tratamiento3R1X2) {
        this.tratamiento3R1X2 = tratamiento3R1X2;
    }

    public String getTratamiento3R1X3() {
        return tratamiento3R1X3;
    }

    public void setTratamiento3R1X3(String tratamiento3R1X3) {
        this.tratamiento3R1X3 = tratamiento3R1X3;
    }

    public String getTratamiento3R1X4() {
        return tratamiento3R1X4;
    }

    public void setTratamiento3R1X4(String tratamiento3R1X4) {
        this.tratamiento3R1X4 = tratamiento3R1X4;
    }

    public String getTratamiento3R2X1() {
        return tratamiento3R2X1;
    }

    public void setTratamiento3R2X1(String tratamiento3R2X1) {
        this.tratamiento3R2X1 = tratamiento3R2X1;
    }

    public String getTratamiento3R2X2() {
        return tratamiento3R2X2;
    }

    public void setTratamiento3R2X2(String tratamiento3R2X2) {
        this.tratamiento3R2X2 = tratamiento3R2X2;
    }

    public String getTratamiento3R2X3() {
        return tratamiento3R2X3;
    }

    public void setTratamiento3R2X3(String tratamiento3R2X3) {
        this.tratamiento3R2X3 = tratamiento3R2X3;
    }

    public String getTratamiento3R2X4() {
        return tratamiento3R2X4;
    }

    public void setTratamiento3R2X4(String tratamiento3R2X4) {
        this.tratamiento3R2X4 = tratamiento3R2X4;
    }

    public String getTratamiento3R2X5() {
        return tratamiento3R2X5;
    }

    public void setTratamiento3R2X5(String tratamiento3R2X5) {
        this.tratamiento3R2X5 = tratamiento3R2X5;
    }

    public String getTratamiento3R2X6() {
        return tratamiento3R2X6;
    }

    public void setTratamiento3R2X6(String tratamiento3R2X6) {
        this.tratamiento3R2X6 = tratamiento3R2X6;
    }

    public String getTratamiento3Remision() {
        return tratamiento3Remision;
    }

    public void setTratamiento3Remision(String tratamiento3Remision) {
        this.tratamiento3Remision = tratamiento3Remision;
    }

    public String getTratamiento3Terapia() {
        return tratamiento3Terapia;
    }

    public void setTratamiento3Terapia(String tratamiento3Terapia) {
        this.tratamiento3Terapia = tratamiento3Terapia;
    }

    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodontograma != null ? idPeriodontograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodontograma)) {
            return false;
        }
        Periodontograma other = (Periodontograma) object;
        if ((this.idPeriodontograma == null && other.idPeriodontograma != null) || (this.idPeriodontograma != null && !this.idPeriodontograma.equals(other.idPeriodontograma))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "ec.com.espe.distribuidas.perionet.modelo.Periodontograma[ idPeriodontograma=" + idPeriodontograma + " ]";
    }

}
