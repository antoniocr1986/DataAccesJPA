package eac3.gestors;

import eac3.model.*;
import java.util.List;
import javax.persistence.*;

/**
 * Aquesta classe proporciona les operacions sobre l'entitat Component
 * @author Antonio Company Rodriguez
 */
public class GestorComponent {
    EntityManager em;

    public GestorComponent(EntityManager em) {
        this.em = em;
    }

    /**
     * Insereix un component
     * @param component el component
     * @throws GestorException si ja existeix el component
     */
    public void inserir(Component component) throws GestorException {
        //TODO
        if (em.find(Component.class, component.getId()) == null) {//Si el objecte busca't es null..
            em.getTransaction().begin();
            em.merge(component);
            em.getTransaction().commit();
        } else {
            throw new GestorException("Ja existeix el component no es pot inserir!");
        }
    }
    
    /**
     * Esobrra un component!!!!!!!!!!!!!!!!!!!!!!!
     * @param id l'identificador del component
     * @throws GestorException si no existeix el component
     */
    public void eliminar(int id) throws GestorException {
        //TODO
        Component component = em.find(Component.class, id);//Buscamos componente con la id pasada por parametro
        if (component != null) {//Si existe lo eliminamos
            em.getTransaction().begin();
            em.remove(component);//Pasamos objeto creado con el find para borrarlo
            em.getTransaction().commit();
        } else {
            throw new GestorException("No existeix un component amb aquest id! No el podem eliminar");
        }
    }
        
    /**
     * Obte tots els components de la BD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * @return la llista de components
     */
    public List<Component> obtenirComponents() {
        //TODO
        //TODO completar el metode
        Query q = em.createNamedQuery("Component.tots");
        List<Component> list = q.getResultList();
        for (Component b : list) {
            em.detach(b);
        }
        return list;
    }
    
    /**
     * Obte els components d'un ordinador!!!!!!!!!!!!!!!!!!!!!
     * @param idOrdinador l'identificador de l'ordinador
     * @return la llista de components de l'ordinador
     * @throws GestorException si l'ordinador no existeix
     */
    public List<Component> obtenirComponentsOrdinador(int idOrdinador) throws GestorException {
        //TODO
        Query q = em.createNamedQuery("Component.componentsPC");
        q.setParameter("idOrdinador", idOrdinador);

        List<Component> lista = q.getResultList();
        for (Component c : lista) {
            em.detach(c);
        }
        return lista;
    }
    

    /**
     * Posa a 0 l'atribut revisio de tots els components que estan ensamblats en algun ordinador
     */
    public void inicialitzaRevisioEnsamblats() {
        //TODO//REVISAARRRRRRR
        for (int id = 1; id < 9; id++) {
        }
            int id = 1;
            Ordinador pc = em.find(Ordinador.class, id);
            if (pc!=null){
                List<Component> lista= pc.getComponents();
                for (Component c : lista){
                    em.getTransaction().begin();
                    Query q = em.createNamedQuery("Component.revZero");
                    q.executeUpdate();
                    em.getTransaction().commit();
                 }
            }
    }
}