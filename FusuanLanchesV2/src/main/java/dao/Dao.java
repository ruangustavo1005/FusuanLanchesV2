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

    private final ArrayList<Type> lista;
    private final Class<Type> classe;

    public Dao(Class<Type> classe) {
        this.classe = classe;
        this.lista = new ArrayList<>();
        emf = Persistence.createEntityManagerFactory("hibernatejpa");
        em  = emf.createEntityManager();
    }
    
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

    public boolean remove(Type object) {
        return this.getLista().remove(object);
    }
    
    public Type get(int i) {
        return this.getLista().get(i);
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
    
    protected void close() {
        em.close();
        emf.close();
    }
    
}