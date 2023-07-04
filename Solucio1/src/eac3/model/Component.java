package eac3.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import static javax.persistence.DiscriminatorType.CHAR;
import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

/**
 *
 * @author Antonio Company Rodriguez
 */
//TODO Cal posar les anotacions de JPA
@Entity
@Inheritance (strategy=SINGLE_TABLE)
@DiscriminatorColumn(name = "tipusComponent", discriminatorType = CHAR)
@NamedQueries({
    @NamedQuery(name = "Component.tots", query = "SELECT c FROM Component c"),
    @NamedQuery(name = "Component.componentsPC", query = "SELECT c FROM Component c WHERE c.ordinador.id = :idOrdinador"),
    @NamedQuery(name = "Component.revZero", query = "UPDATE Component c SET c.revisions=0")
})
public abstract class Component implements Serializable {

    private int id;
    private String marca;
    private String model;
    private int revisions;
    private Ordinador ordinador;

    public Component() {
    }

    public Component(int id, String marca, String model, int revisions, Ordinador ordinador) {
        this.id = id;
        this.marca = marca;
        this.model = model;
        this.revisions = revisions;
        this.ordinador = ordinador;
    }

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRevisions() {
        return revisions;
    }
    
    public void setRevisions(int revisions) {
        this.revisions = revisions;
    }

    @ManyToOne
    public Ordinador getOrdinador() {
        return ordinador;
    }

    public void setOrdinador(Ordinador ordinador) {
        this.ordinador = ordinador;
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
        final Component other = (Component) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.revisions != other.revisions) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        
        return Objects.equals(this.model, other.model);
       
    }



}
