/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "detalle_diente")

public class DetalleDiente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE")
    private Integer idDetalle;
    @Size(max = 20)
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "MG11")
    private Integer mg11;
    @Column(name = "PS11")
    private Integer ps11;
    @Column(name = "NI11")
    private Integer ni11;
    
    @Column(name = "MG12")
    private Integer mg12;
    
    @Column(name = "MG13")
    private Integer mg13;
    
    @Column(name = "PS12")
    private Integer ps12;
    @Column(name = "NI12")
    private Integer ni12;
    @Column(name = "MG21")
    private Integer mg21;
    @Column(name = "PS21")
    private Integer ps21;
    @Column(name = "NI21")
    private Integer ni21;
    @Column(name = "MG22")
    private Integer mg22;
    @Column(name = "PS22")
    private Integer ps22;
    @Column(name = "NI22")
    private Integer ni22;
    @Column(name = "MG31")
    private Integer mg31;
    @Column(name = "PS31")
    private Integer ps31;
    @Column(name = "NI31")
    private Integer ni31;
    @Column(name = "MG32")
    private Integer mg32;
    @Column(name = "PS32")
    private Integer ps32;
    @Column(name = "NI32")
    private Integer ni32;

    @Column(name = "PS13")
    private Integer ps13;

    @Column(name = "NI13")
    private Integer ni13;

    @Column(name = "LMG")
    private Integer lmg;

    @Column(name = "DG_ESP")
    private String diagnosticoEspecializado;

    @Column(name = "PRO_ESP")
    private String pronosticoEspecializado;

    @Column(name = "MOVI")
    private String movilidad;

    @Column(name = "FURCAS")
    private String furcas;

    @Column(name = "RECESIONES")
    private String recesiones;

    @Column(name = "S1")
    private String s1;

    @Column(name = "S2")
    private String s2;

    @Column(name = "S3")
    private String s3;

    @Column(name = "SULLIVAN")
    private String sullivan;

    @Column(name = "MILLER")
    private String miller;

    @Column(name = "PRATO")
    private String prato;
    
    @Column(name = "EDITADO")
    private String editado;

    @JoinColumn(name = "ID_DIENTE", referencedColumnName = "ID_DIENTE")
    @ManyToOne
    private Diente idDiente;
    @JoinColumn(name = "ID_PERIODONTOGRAMA", referencedColumnName = "ID_PERIODONTOGRAMA")
    @ManyToOne
    private Periodontograma idPeriodontograma;
    
    

    public DetalleDiente() {
    }
    
    ////////////////METODOS IMPLMENTADOS//////////////////////////
    public void calcularNi()
    {
        System.out.println("calculando valores ni");
        if(mg11!=null && ps11!=null)
        {
            ni11=calculosNi(mg11, ps11);
            System.out.println("ni11="+ni11);
        }
        
        if(mg12!=null && ps12!=null)
        {
            ni12=calculosNi(mg12, ps12);
            System.out.println("ni12="+ni12);
        }
        
        if(mg13!=null && ps13!=null)
        {
            ni13=calculosNi(mg13, ps13);
            System.out.println("ni13="+ni13);
        }
    }
    
    private Integer calculosNi(Integer mg,Integer ps)
    {
        Integer resultado=null;
        if(mg>=0)
        {
            if(mg>ps)
            {
                resultado=mg-ps;
            }
            else
            {
                resultado=ps-mg;
            }
        }
        else
        {
            resultado=mg+ps;
        }
        return resultado;
    }

    public DetalleDiente(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getMg11() {
        return mg11;
    }

    public void setMg11(Integer mg11) {
        this.mg11 = mg11;
    }

    public Integer getPs11() {
        return ps11;
    }

    public void setPs11(Integer ps11) {
        this.ps11 = ps11;
    }

    public Integer getNi11() {
        return ni11;
    }

    public void setNi11(Integer ni11) {
        this.ni11 = ni11;
    }

    public Integer getMg12() {
        return mg12;
    }

    public void setMg12(Integer mg12) {
        this.mg12 = mg12;
    }

    public Integer getPs12() {
        return ps12;
    }

    public void setPs12(Integer ps12) {
        this.ps12 = ps12;
    }

    public Integer getNi12() {
        return ni12;
    }

    public void setNi12(Integer ni12) {
        this.ni12 = ni12;
    }

    public Integer getMg21() {
        return mg21;
    }

    public void setMg21(Integer mg21) {
        this.mg21 = mg21;
    }

    public Integer getPs21() {
        return ps21;
    }

    public void setPs21(Integer ps21) {
        this.ps21 = ps21;
    }

    public Integer getNi21() {
        return ni21;
    }

    public void setNi21(Integer ni21) {
        this.ni21 = ni21;
    }

    public Integer getMg22() {
        return mg22;
    }

    public void setMg22(Integer mg22) {
        this.mg22 = mg22;
    }

    public Integer getPs22() {
        return ps22;
    }

    public void setPs22(Integer ps22) {
        this.ps22 = ps22;
    }

    public Integer getNi22() {
        return ni22;
    }

    public void setNi22(Integer ni22) {
        this.ni22 = ni22;
    }

    public Integer getMg31() {
        return mg31;
    }

    public void setMg31(Integer mg31) {
        this.mg31 = mg31;
    }

    public Integer getPs31() {
        return ps31;
    }

    public void setPs31(Integer ps31) {
        this.ps31 = ps31;
    }

    public Integer getNi31() {
        return ni31;
    }

    public void setNi31(Integer ni31) {
        this.ni31 = ni31;
    }

    public Integer getMg32() {
        return mg32;
    }

    public void setMg32(Integer mg32) {
        this.mg32 = mg32;
    }

    public Integer getPs32() {
        return ps32;
    }

    public void setPs32(Integer ps32) {
        this.ps32 = ps32;
    }

    public Integer getNi32() {
        return ni32;
    }

    public void setNi32(Integer ni32) {
        this.ni32 = ni32;
    }

    public Diente getIdDiente() {
        return idDiente;
    }

    public void setIdDiente(Diente idDiente) {
        this.idDiente = idDiente;
    }

    public Periodontograma getIdPeriodontograma() {
        return idPeriodontograma;
    }

    public void setIdPeriodontograma(Periodontograma idPeriodontograma) {
        this.idPeriodontograma = idPeriodontograma;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getPs13() {
        return ps13;
    }

    public void setPs13(Integer ps13) {
        this.ps13 = ps13;
    }

    public Integer getNi13() {
        return ni13;
    }

    public void setNi13(Integer ni13) {
        this.ni13 = ni13;
    }

    public Integer getLmg() {
        return lmg;
    }

    public void setLmg(Integer lmg) {
        this.lmg = lmg;
    }

    public String getDiagnosticoEspecializado() {
        return diagnosticoEspecializado;
    }

    public void setDiagnosticoEspecializado(String diagnosticoEspecializado) {
        this.diagnosticoEspecializado = diagnosticoEspecializado;
    }

    public String getMovilidad() {
        return movilidad;
    }

    public void setMovilidad(String movilidad) {
        this.movilidad = movilidad;
    }

    public String getFurcas() {
        return furcas;
    }

    public void setFurcas(String furcas) {
        this.furcas = furcas;
    }

    public String getRecesiones() {
        return recesiones;
    }

    public void setRecesiones(String recesiones) {
        this.recesiones = recesiones;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }

    public String getSullivan() {
        return sullivan;
    }

    public void setSullivan(String sullivan) {
        this.sullivan = sullivan;
    }

    public String getMiller() {
        return miller;
    }

    public void setMiller(String miller) {
        this.miller = miller;
    }

    public String getPrato() {
        return prato;
    }

    public void setPrato(String prato) {
        this.prato = prato;
    }

    public String getPronosticoEspecializado() {
        return pronosticoEspecializado;
    }

    public void setPronosticoEspecializado(String pronosticoEspecializado) {
        this.pronosticoEspecializado = pronosticoEspecializado;
    }

    public Integer getMg13() {
        return mg13;
    }

    public void setMg13(Integer mg13) {
        this.mg13 = mg13;
    }

    public String getEditado() {
        return editado;
    }

    public void setEditado(String editado) {
        this.editado = editado;
    }
    
    
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleDiente)) {
            return false;
        }
        DetalleDiente other = (DetalleDiente) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.espe.distribuidas.perionet.modelo.DetalleDiente[ idDetalle=" + idDetalle + " ]";
    }

}
