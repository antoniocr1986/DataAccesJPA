package eac3.gestors;

import eac3.model.Disc;
import java.util.List;
import javax.persistence.*;

/**
 * Aquesta classe proporciona les operacions sobre l'entitat Disc
 * @author Antonio Company Rodriguez
 */
public class GestorDisc {
    
    EntityManager em;

    public GestorDisc(EntityManager em) {
        this.em = em;
    }
    
    /**
     * Obte tots els discs de la BD
     * @return la llista de discs
     */
    public List<Disc> obtenirDiscs(){
        //TODO
        Query q = em.createNamedQuery("Disc.tots");
        List<Disc> list = q.getResultList();
        for (Disc disc : list) {
            em.detach(disc);
        }
        return list;
    }
    
    /**
     * Obte tos els discs de mida igual o superior a una mida determinada
     * @param mida la mida mínima
     * @return la llista de discs amb mida igual o superior a la mínima
     */
    public List<Disc> obtenirDiscsMidaMin(int mida) {
        //TODO
        Query q = em.createNamedQuery("Disc.midaMin");
        q.setParameter("midaX",mida);
        List<Disc> list = q.getResultList();
        for (Disc disc : list) {
            em.detach(disc);
        }
        return list;
    }
    
    
}
