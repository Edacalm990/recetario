/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author eli
 */
@Embeddable
public class CantidadPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codReceta")
    private int codReceta;
    @Basic(optional = false)
    @Column(name = "codIngrediente")
    private int codIngrediente;

    public CantidadPK() {
    }

    public CantidadPK(int codReceta, int codIngrediente) {
        this.codReceta = codReceta;
        this.codIngrediente = codIngrediente;
    }

    public int getCodReceta() {
        return codReceta;
    }

    public void setCodReceta(int codReceta) {
        this.codReceta = codReceta;
    }

    public int getCodIngrediente() {
        return codIngrediente;
    }

    public void setCodIngrediente(int codIngrediente) {
        this.codIngrediente = codIngrediente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codReceta;
        hash += (int) codIngrediente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CantidadPK)) {
            return false;
        }
        CantidadPK other = (CantidadPK) object;
        if (this.codReceta != other.codReceta) {
            return false;
        }
        if (this.codIngrediente != other.codIngrediente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.CantidadPK[ codReceta=" + codReceta + ", codIngrediente=" + codIngrediente + " ]";
    }
    
}
