package eac3.gestors;

import eac3.model.Processador;
import java.util.List;
import javax.persistence.*;

/**
 * Aquesta classe proporciona les operacions sobre l'entitat Processador
 * @author Antonio Company Rodriguez
 */
public class GestorProcessador {

    EntityManager em;

    public GestorProcessador(EntityManager em) {
        this.em = em;
    }

    /**
     * Obte tots els processadors de la base de dades
     * @return la llista de processadors
     */
    public List<Processador> obtenirProcessadors() {
        //TODO
        Query q = em.createNamedQuery("Processador.tots");
        List<Processador> list = q.getResultList();
        for (Processador b : list) {
            em.detach(b);
        }
        return list;
    }

    /**
     * Augmenta la frequencia dels processadors d'una marca determinada en un percentatge
     * @param marca la marca de processador
     * @param percentatgeFreq el percentatge d'increment de frequencia
     * @throws GestorException si hi ha hagut algun error
     */
    public void overclock(String marca, int percentatgeFreq) throws GestorException {
        //TODO          
        try{
            Query q = em.createNamedQuery("Processador.marcaOverclock");
            q.setParameter("marca",marca);
            q.setParameter("percentatge", percentatgeFreq);
            em.getTransaction().begin();
            q.executeUpdate();
            em.getTransaction().commit();
        }catch (Exception e){
            throw new GestorException ("Ha succeït algun tipus d'error!");
        }
    }
}
