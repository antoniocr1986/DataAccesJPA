package eac3.model;

import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author joan
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Processador.tots", query= "SELECT p FROM Processador p"),
        @NamedQuery(name = "Processador.marcaOverclock", query = "UPDATE Processador p SET p.frequenciaMhz = p.frequenciaMhz+(p.frequenciaMhz*(:percentatge/100)) WHERE p.marca = :marca")
})
@DiscriminatorValue("P")
public class Processador extends Component {

    private int nuclis;
    private int frequenciaMhz;

    public Processador() {
    }

    public Processador(int id, String marca, String model, int nuclis, int frequenciaMhz, int revisions, Ordinador ordinador) {
        super(id, marca, model, revisions, ordinador);
        this.nuclis = nuclis;
        this.frequenciaMhz = frequenciaMhz;
    }

    public int getNuclis() {
        return nuclis;
    }

    public void setNuclis(int nuclis) {
        this.nuclis = nuclis;
    }

    public int getFrequenciaMhz() {
        return frequenciaMhz;
    }

    public void setFrequenciaMhz(int frequenciaMhz) {
        this.frequenciaMhz = frequenciaMhz;
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
        
        
        final Processador other = (Processador) obj;

   
        

        if (this.nuclis != other.nuclis) {
            return false;
        }
        return this.frequenciaMhz == other.frequenciaMhz;
    }

}
