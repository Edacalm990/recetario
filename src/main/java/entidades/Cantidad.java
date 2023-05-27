/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author eli
 */
@Entity
@Table(name = "cantidad")
@NamedQueries({
    @NamedQuery(name = "Cantidad.findAll", query = "SELECT c FROM Cantidad c"),
    @NamedQuery(name = "Cantidad.findByCodReceta", query = "SELECT c FROM Cantidad c WHERE c.cantidadPK.codReceta = :codReceta"),
    @NamedQuery(name = "Cantidad.findByCodIngrediente", query = "SELECT c FROM Cantidad c WHERE c.cantidadPK.codIngrediente = :codIngrediente"),
    @NamedQuery(name = "Cantidad.findByCantidad", query = "SELECT c FROM Cantidad c WHERE c.cantidad = :cantidad")})
public class Cantidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CantidadPK cantidadPK;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "codIngrediente", referencedColumnName = "codIngrediente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingrediente ingrediente;
    @JoinColumn(name = "codReceta", referencedColumnName = "codReceta", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Receta receta;

    public Cantidad() {
    }

    public Cantidad(CantidadPK cantidadPK) {
        this.cantidadPK = cantidadPK;
    }

    public Cantidad(CantidadPK cantidadPK, int cantidad) {
        this.cantidadPK = cantidadPK;
        this.cantidad = cantidad;
    }

    public Cantidad(Ingrediente ingrediente, Receta receta, int cantidad) {
        this.cantidadPK = new CantidadPK(ingrediente.getCodIngrediente(), receta.getCodReceta());
        this.ingrediente=ingrediente;
        this.receta=receta;
        this.cantidad=cantidad;
    }

    public CantidadPK getCantidadPK() {
        return cantidadPK;
    }

    public void setCantidadPK(CantidadPK cantidadPK) {
        this.cantidadPK = cantidadPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cantidadPK != null ? cantidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cantidad)) {
            return false;
        }
        Cantidad other = (Cantidad) object;
        if ((this.cantidadPK == null && other.cantidadPK != null) || (this.cantidadPK != null && !this.cantidadPK.equals(other.cantidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "%s;%s;%s".formatted(this.ingrediente.getNombreIngrediente(), this.receta.getNombreReceta(), this.cantidad);
    }
    
}
