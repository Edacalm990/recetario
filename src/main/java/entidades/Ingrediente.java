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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author eli
 */
@Entity
@Table(name = "ingrediente")
@NamedQueries({
    @NamedQuery(name = "Ingrediente.findAll", query = "SELECT i FROM Ingrediente i"),
    @NamedQuery(name = "Ingrediente.findByCodIngrediente", query = "SELECT i FROM Ingrediente i WHERE i.codIngrediente = :codIngrediente"),
    @NamedQuery(name = "Ingrediente.findByNombreIngrediente", query = "SELECT i FROM Ingrediente i WHERE i.nombreIngrediente = :nombreIngrediente")
})
    // namedQuery creada por mi
 
public class Ingrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codIngrediente")
    private Integer codIngrediente;
    @Basic(optional = false)
    @Column(name = "nombreIngrediente")
    private String nombreIngrediente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ingrediente")
    private List<Cantidad> cantidadList;

    public Ingrediente() {
    }

    public Ingrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public Integer getCodIngrediente() {
        return codIngrediente;
    }

    public void setCodIngrediente(Integer codIngrediente) {
        this.codIngrediente = codIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
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
        hash += (codIngrediente != null ? codIngrediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingrediente)) {
            return false;
        }
        Ingrediente other = (Ingrediente) object;
        if ((this.codIngrediente == null && other.codIngrediente != null) || (this.codIngrediente != null && !this.codIngrediente.equals(other.codIngrediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "%s;%s".formatted(this.codIngrediente,this.nombreIngrediente);
    }
    
}
