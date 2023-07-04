package eac3.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Antonio Company Rodriguez
 */
//TODO Cal posar les anotacions de JPA
@Entity
@NamedQueries({
    @NamedQuery(name = "Memoria.tots", query = "SELECT m FROM Memoria m"),
    @NamedQuery(name = "Memoria.perTipus", query = "SELECT m FROM Memoria m WHERE m.tipus = :tipus")
})
@DiscriminatorValue("M")
public class Memoria extends Component {

    private String tipus;
    private int midaGB;

    public Memoria() {
    }

    public Memoria(int id, String marca, String model, String tipus, int midaGB, int revisions, Ordinador ordinador) {
        super(id, marca, model, revisions, ordinador);
        this.tipus = tipus;
        this.midaGB = midaGB;
    }

    @Column (length=25)
    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getMidaGB() {
        return midaGB;
    }

    public void setMidaGB(int midaGB) {
        this.midaGB = midaGB;
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
       
         if ( !super.equals(obj))
            return false;
        
        final Memoria other = (Memoria) obj;
        
   
        
        if (this.midaGB != other.midaGB) {
            return false;
        }
        return Objects.equals(this.tipus, other.tipus);
    }

}
