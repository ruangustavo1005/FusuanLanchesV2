package dao;

import java.util.ArrayList;

/**
 *
 * @author Ruan
 */
public class Dao<Type> {
    
    private ArrayList<Type> lista;

    public Dao() {
        this.lista = new ArrayList<>();
    }

    public ArrayList<Type> getLista() {
        return lista;
    }

    public boolean add(Type object) {
        return this.getLista().add(object);
    }

    public boolean remove(Type object) {
        return this.getLista().remove(object);
    }
    
    public Type get(int i) {
        return this.getLista().get(i);
    }
    
}