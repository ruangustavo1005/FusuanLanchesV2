package dao;

import interfaces.VerificaUsabilidadeItem;
import javax.persistence.Query;
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
    
}