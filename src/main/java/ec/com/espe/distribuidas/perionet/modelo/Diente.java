/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.espe.distribuidas.perionet.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "diente")
public class Diente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DIENTE")
    private Integer idDiente;
    @Size(max = 5)
    @Column(name = "CODIGO")
    private String codigo;
    @Size(max = 20)
    @Column(name = "CATEGORIA")
    private String categoria;
    @Size(max = 15)
    @Column(name = "posi")
    private String posi;

    @Column(name = "IMG")
    private String imagen;

    @Column(name = "ORDEN")
    private Integer orden;

    @OneToMany(mappedBy = "idDiente")

    private List<DetalleDiente> detalleDienteList;

    public Diente() {
    }

    public Diente(Integer idDiente) {
        this.idDiente = idDiente;
    }

    public Integer getIdDiente() {
        return idDiente;
    }

    public void setIdDiente(Integer idDiente) {
        this.idDiente = idDiente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPosi() {
        return posi;
    }

    public void setPosi(String posi) {
        this.posi = posi;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
    
    

    @XmlTransient
    public List<DetalleDiente> getDetalleDienteList() {
        return detalleDienteList;
    }

    public void setDetalleDienteList(List<DetalleDiente> detalleDienteList) {
        this.detalleDienteList = detalleDienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiente != null ? idDiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diente)) {
            return false;
        }
        Diente other = (Diente) object;
        if ((this.idDiente == null && other.idDiente != null) || (this.idDiente != null && !this.idDiente.equals(other.idDiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.espe.distribuidas.perionet.modelo.Diente[ idDiente=" + idDiente + " ]";
    }

}
