package dao;

import interfaces.VerificaUsabilidadeItem;
import javax.persistence.Query;
import model.AbastecimentoItem;
import model.Item;

/**
 *
 * @author Ruan
 */
public class DaoSolicitacaoItem extends Dao<AbastecimentoItem> implements VerificaUsabilidadeItem {
    
    public DaoSolicitacaoItem() {
        super(AbastecimentoItem.class);
    }
    
    @Override
    public boolean usaItem(Item item) {
        Query query = em.createQuery("select abastecimentoItem from AbastecimentoItem abastecimentoItem where abastecimentoItem.item.codigo = :codigo");
        query.setParameter("codigo", item.getCodigo());
        return query.getResultList().size() > 0;
    }
    
}