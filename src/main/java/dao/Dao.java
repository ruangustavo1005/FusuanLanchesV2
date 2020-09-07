package dao;

import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Ruan
 */
public class Dao<Type> {
    
    private final EntityManagerFactory emf;
    private final EntityManager em;

    private final Class<Type> classe;

    public Dao(Class<Type> classe) {
        this.classe = classe;
        emf = Persistence.createEntityManagerFactory("hibernatejpa");
        em  = emf.createEntityManager();
    }
    
    /**
     * @todo Trocar o nome do metodo para "get"
     */
    public ArrayList<Type> getLista() {
        ArrayList<Type> lista = null;
        try {
            lista = (ArrayList<Type>) em.createQuery("from " + this.classe.getName()).getResultList();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public boolean add(Type object) {
        boolean retorno = true;
        try {
            this.begin();
            em.persist(object);
            this.commit();
        }
        catch (Exception e) { // seria daora fazer um log disso, acessível apenas pelo admin
            System.out.println(e.getMessage());
            retorno = false;
            if (em.getTransaction().isActive()) {
                this.rollback();
            }
        }
        return retorno;
    }

    public boolean remove(int id) {
        return this.remove(this.get(id));
    }
    
    public boolean remove(Type object) {
        boolean retorno = true;
        try {
            this.begin();
            em.remove(object);
            this.commit();
        }
        catch (Exception e) { // seria daora fazer um log disso, acessível apenas pelo admin
            System.out.println(e.getMessage());
            retorno = false;
            if (em.getTransaction().isActive()) {
                this.rollback();
            }
        }
        return retorno;
    }
    
    public boolean update(Type object) {
        boolean retorno = true;
        try {
            this.begin();
            em.merge(object);
            this.commit();
        }
        catch (Exception e) { // seria daora fazer um log disso, acessível apenas pelo admin
            System.out.println(e.getMessage());
            retorno = false;
            if (em.getTransaction().isActive()) {
                this.rollback();
            }
        }
        return retorno;
    }
    
    public Type get(int id) {
        Type object = null;
        try {
            object = em.find(this.classe, id);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return object;
    }
    
    protected final void begin() {
        em.getTransaction().begin();
    }

    protected final void commit() {
        em.getTransaction().commit();
    }

    protected final void rollback() {
        em.getTransaction().rollback();
    }
    
}