package dao;

import controller.ControllerLogin;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import model.Log;
import util.DateUtils;

/**
 *
 * @author Ruan
 */
public class Dao<Type> {
    
    protected final EntityManagerFactory emf;
    protected final EntityManager em;

    private final Class<Type> classe;

    public Dao(Class<Type> classe) {
        this.classe = classe;
        emf = Persistence.createEntityManagerFactory("hibernatejpa");
        em  = emf.createEntityManager();
    }
    
    public ArrayList<Type> get() {
        ArrayList<Type> lista = null;
        try {
            lista = (ArrayList<Type>) em.createQuery("from " + this.classe.getName()).getResultList();
        }
        catch (Exception e) {
            Dao.loga("select all", e);
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
        catch (Exception e) {
            Dao.loga("insert", e);
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
        catch (Exception e) {
            Dao.loga("delete", e);
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
        catch (Exception e) {
            this.loga("update", e);
            System.out.println(e.getMessage());
            retorno = false;
            if (em.getTransaction().isActive()) {
                this.rollback();
            }
        }
        return retorno;
    }
    
    public Type get(Object id) {
        Type object = null;
        try {
            object = em.find(this.classe, id);
        }
        catch (Exception e) {
            Dao.loga("select", e);
            System.out.println(e.getMessage());
        }
        return object;
    }
    
    static public boolean loga(String operacao, Exception e) {
        return (new Dao<>(Log.class)).add(new Log(ControllerLogin.getUsuarioLogado(), Log.TIPO_ERRO, operacao, e.getCause().toString(), DateUtils.nowComplete(), false));
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