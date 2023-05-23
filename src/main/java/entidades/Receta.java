/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
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

/**
 *
 * @author eli
 */
@Entity
@Table(name = "receta")
@NamedQueries({
    @NamedQuery(name = "Receta.findAll", query = "SELECT r FROM Receta r"),
    @NamedQuery(name = "Receta.findByCodReceta", query = "SELECT r FROM Receta r WHERE r.codReceta = :codReceta"),
    @NamedQuery(name = "Receta.findByNombreReceta", query = "SELECT r FROM Receta r WHERE r.nombreReceta = :nombreReceta"),
    @NamedQuery(name = "Receta.findByElaboracion", query = "SELECT r FROM Receta r WHERE r.elaboracion = :elaboracion")})
public class Receta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codReceta")
    private Integer codReceta;
    @Basic(optional = false)
    @Column(name = "nombreReceta")
    private String nombreReceta;
    @Column(name = "elaboracion")
    private String elaboracion;
    @JoinColumn(name = "creador", referencedColumnName = "codUsuario")
    @ManyToOne
    private Usuario creador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receta")
    private List<Cantidad> cantidadList;

    public Receta() {
    }

    public Receta(Integer codReceta) {
        this.codReceta = codReceta;
    }

    public Receta(Integer codReceta, String nombreReceta) {
        this.codReceta = codReceta;
        this.nombreReceta = nombreReceta;
    }

    public Integer getCodReceta() {
        return codReceta;
    }

    public void setCodReceta(Integer codReceta) {
        this.codReceta = codReceta;
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public String getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(String elaboracion) {
        this.elaboracion = elaboracion;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public List<Cantidad> getCantidadList() {
        return cantidadList;
    }

    public void setCantidadList(List<Cantidad> cantidadList) {
        this.cantidadList = cantidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codReceta != null ? codReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receta)) {
            return false;
        }
        Receta other = (Receta) object;
        if ((this.codReceta == null && other.codReceta != null) || (this.codReceta != null && !this.codReceta.equals(other.codReceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "%s".formatted(this.nombreReceta);
    }
    
    public String toStringCompleto() {
        return "%s - %s - %s".formatted(this.nombreReceta, this.creador, this.elaboracion);
    }
    
}
