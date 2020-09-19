package dao;

import interfaces.VerificaUsabilidadeItem;
import java.util.ArrayList;
import javax.persistence.Query;
import model.Comanda;
import model.ComandaItem;
import model.Item;

/**
 *
 * @author Ruan
 */
public class DaoComandaItem extends Dao<ComandaItem> implements VerificaUsabilidadeItem {
    
    public DaoComandaItem() {
        super(ComandaItem.class);
    }

    @Override
    public boolean usaItem(Item item) {
        Query query = em.createQuery("select comandaItem from ComandaItem comandaItem where comandaItem.item.codigo = :codigo");
        query.setParameter("codigo", item.getCodigo());
        return query.getResultList().size() > 0;
    }
    
    public ArrayList<ComandaItem> getItensFromComanda(Comanda comanda) {
        Query query = em.createQuery("select comandaItem from ComandaItem comandaItem where comandaItem.comanda.numero = :numero");
        query.setParameter("numero", comanda.getNumero());
        return (ArrayList<ComandaItem>) query.getResultList();
    }
    
}