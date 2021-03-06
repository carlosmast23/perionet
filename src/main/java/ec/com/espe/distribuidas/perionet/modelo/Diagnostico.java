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
@Table(name = "diagnostico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostico.findAll", query = "SELECT d FROM Diagnostico d"),
    @NamedQuery(name = "Diagnostico.findByIdTratamiento", query = "SELECT d FROM Diagnostico d WHERE d.idTratamiento = :idTratamiento"),
    @NamedQuery(name = "Diagnostico.findByNotas", query = "SELECT d FROM Diagnostico d WHERE d.notas = :notas")})
public class Diagnostico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TRATAMIENTO")
    private Integer idTratamiento;
    @Size(max = 1000)
    @Column(name = "NOTAS")
    private String notas;
    @JoinColumn(name = "ID_PERIODONTOGRAMA", referencedColumnName = "ID_PERIODONTOGRAMA")
    @ManyToOne
    private Periodontograma idPeriodontograma;

    public Diagnostico() {
    }

    public Diagnostico(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Integer getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Periodontograma getIdPeriodontograma() {
        return idPeriodontograma;
    }

    public void setIdPeriodontograma(Periodontograma idPeriodontograma) {
        this.idPeriodontograma = idPeriodontograma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTratamiento != null ? idTratamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.idTratamiento == null && other.idTratamiento != null) || (this.idTratamiento != null && !this.idTratamiento.equals(other.idTratamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.espe.distribuidas.perionet.modelo.Diagnostico[ idTratamiento=" + idTratamiento + " ]";
    }
    
}
