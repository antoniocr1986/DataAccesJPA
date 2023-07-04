package eac3.gestors;

import eac3.model.*;
import java.util.List;
import javax.persistence.*;

/**
 * Aquesta classe proporciona les operacions sobre l'entitat Ordinador
 * @author Antonio Company Rodriguez
 */
public class GestorOrdinador {

    EntityManager em;

    public GestorOrdinador(EntityManager em) {
        this.em = em;
    }

    /**
     * Insereix un ordinador a la BD
     * @param ordinador l'ordinador
     * @throws GestorException si l'ordinador ja existeix
     */
    public void inserir(Ordinador ordinador) throws GestorException {
        //TODO
        if (em.find(Ordinador.class, ordinador.getId()) == null) {
            em.getTransaction().begin();
            em.merge(ordinador);
            em.getTransaction().commit();
        } else {
            throw new GestorException("L'ordinador ja existeix no es pot inserir!");
        }
    }

    /**
     * Elimina un ordinador de la BD
     * @param id l'identificador de l'ordinador
     * @throws GestorException si l'ordinador no existeix
     */
    public void eliminar(int id) throws GestorException {
        //TODO
        Ordinador pc = em.find(Ordinador.class, id);
        if (pc != null) {
            em.getTransaction().begin();
            pc.getComponents().set(id, null);
            em.remove(pc);
            em.getTransaction().commit();
        } else {
            throw new GestorException("Aquest ordinador no existeix i no es pot eliminar!");
        }
    }

    /**
     * Obte tots els ordinadors de la BD
     * @return la llista d'ordinadors
     */
    public List<Ordinador> obtenirOrdinadors() {
        //TODO
        Query q = em.createNamedQuery("Ordinador.tots");
        List<Ordinador> list = q.getResultList();
        for (Ordinador o : list) {
            em.detach(o);
        }
        return list;
    }

    /**
     * Incrementa l'atribut revisions d'un ordinador
     * @param id l'identificador de l'ordinador
     */
    public void revisar(int id) {
        //TODO
        Query query = em.createNamedQuery("Ordinador.revisar");
        query.setParameter("idOrdinador", id);
        List<Component> compRevisions = query.getResultList();
        for (Component c : compRevisions) {
            em.getTransaction().begin();
            c.setRevisions(c.getRevisions() + 1);
            em.merge(c);
            em.getTransaction().commit();
        }
    }

    /**
     * Desensambla un ordinador, es a dir, desvincula els components de l'ordinador
     * @param id l'identificador de l'ordinador
     * @throws GestorException si l'ordinador no existeix
     */
    public void desensambla(int id) throws GestorException {
        //TODO
        Ordinador pc = em.find(Ordinador.class, id);

        if (pc!=null){
            List<Component> lista= pc.getComponents();
            for (Component c : lista){
                em.getTransaction().begin();
                Query q = em.createNamedQuery("Ordinador.desensambla");
                q.setParameter("id",c.getOrdinador());
                q.executeUpdate();
                em.getTransaction().commit();
            }
        }else{
            throw new GestorException ("L'ordinador no existeix!");
        }
    }
    
    
}
