package com.algaworks.ecommerce.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.algaworks.ecommerce.model.Produto;
import com.algaworks.ecommerce.util.jpa.FullTextSearch;

public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	@FullTextSearch
	private FullTextEntityManager fullTextEntityManager;

	@SuppressWarnings("unchecked")
	public List<Produto> fullTextSearch(String text) {
		QueryBuilder builder = fullTextEntityManager
									.getSearchFactory()
									.buildQueryBuilder()
									.forEntity(Produto.class)
									.get();
		
		org.apache.lucene.search.Query luceneQuery = builder
														.keyword()
														.onFields("nome", "descricao", "fabricante.nome")
														.matching(text)
														.createQuery();
		
		javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Produto.class);
		return jpaQuery.getResultList();
	}

}
