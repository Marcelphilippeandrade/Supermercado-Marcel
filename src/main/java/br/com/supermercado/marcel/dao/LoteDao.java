package br.com.supermercado.marcel.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import br.com.supermercado.marcel.modelo.Lote;
import br.com.supermercado.marcel.util.JPAUtil;

public class LoteDao {

	private EntityManager manager;

	public LoteDao() {
		this.manager = JPAUtil.getEntityManager();
	}

	public void salvar(Lote lote) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(lote);
		tx.commit();
		manager.close();
	}

	public Boolean findLote(Lote lote) {
		String jpql = "select l from Lote l where l.codigo =:codigo";
		List<Lote> lotes = manager.createQuery(jpql, Lote.class).setParameter("codigo", lote.getCodigo()).getResultList();

		if (lotes != null && !lotes.isEmpty()) {
			return true;
		}
		return false;
	}
}
