package eac3.gestors;

import eac3.model.Memoria;
import java.util.List;
import javax.persistence.*;

/**
 * Aquesta classe proporciona les operacions sobre l'entitat Memoria
 * @author Antonio Company Rodriguez
 */
public class GestorMemoria {
    EntityManager em;

    public GestorMemoria(EntityManager em) {
        this.em = em;
    }
    
    /**
     * Obte totes les memories de la BD
     * @return la llista de memories
     */
    public List<Memoria> obtenirMemories() {
        //TODO
        Query q = em.createNamedQuery("Memoria.tots");
        List<Memoria> list = q.getResultList();
        for (Memoria mem : list) {
            em.detach(mem);
        }
        return list;
    }
    
    /**
     * Obte totes les memories de la BD d'un tipus determinat
     * @param tipus el tipus
     * @return la llista de memòries
     */
    public List<Memoria> obtenirMemories(String tipus) {
        //TODO
        Query q = em.createNamedQuery("Memoria.perTipus");
        q.setParameter("tipus",tipus);
        List<Memoria> list = q.getResultList();
        for (Memoria mem : list) {
            em.detach(mem);
        }
        return list;
    }

}
