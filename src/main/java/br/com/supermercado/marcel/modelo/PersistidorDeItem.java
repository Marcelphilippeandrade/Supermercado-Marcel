package br.com.supermercado.marcel.modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.supermercado.marcel.constantes.Tipo;
import br.com.supermercado.marcel.util.JPAUtil;

public class PersistidorDeItem {

	public static void main(String[] args) throws ParseException {
		EntityManager em = JPAUtil.getEntityManager();

		Item item = new Item();

		item.setNome("Sprit");
		item.setPreco(10.50);
		item.setDescricao("Lata de refrigerante.");
		item.setTipoEnum(Tipo.BEBIDA);
		item.setCodigoBarras("2152366785221475555");

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		item.setDataValidade(dateFormat.parse("22/10/2022"));
		item.setDataFabricacao(dateFormat.parse("22/10/2022"));
		
		List<Item> itens = new ArrayList<Item>();
		itens.add(item);
		
		Lote lote = new Lote();
		lote.setCodigo("5468");
		lote.setItens(itens);
		
		item.setLote(lote);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(lote);
		tx.commit();

		em.close();
	}
}
