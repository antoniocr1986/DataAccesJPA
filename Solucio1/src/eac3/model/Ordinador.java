package eac3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Antonio Company Rodriguez
 */
//TODO Cal posar les anotacions de JPA
@Entity
@NamedQueries({
        @NamedQuery(name = "Ordinador.tots", query= "SELECT o FROM Ordinador o"),
        @NamedQuery(name = "Ordinador.revisar", query = "SELECT c FROM Component c WHERE c.ordinador.id=:idOrdinador"),
        @NamedQuery(name= "Ordinador.desensambla", query = "UPDATE Component c SET c.ordinador = null WHERE c.ordinador=:id")
})
public class Ordinador implements Serializable {
    private int id;
    private String descripcio;
    private List<Component> components = new ArrayList<>();

    public Ordinador() {
    }

  
    public Ordinador(int id, String descripcio) {
        this.id = id;
        this.descripcio = descripcio;
    }

 
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column (length=50)
    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @OneToMany (mappedBy="ordinador")
    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ordinador other = (Ordinador) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.descripcio, other.descripcio);
        
    }
    
    
}
