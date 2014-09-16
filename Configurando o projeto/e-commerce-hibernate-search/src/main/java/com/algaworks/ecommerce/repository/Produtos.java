package com.algaworks.ecommerce.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.search.jpa.FullTextEntityManager;

import com.algaworks.ecommerce.model.Produto;
import com.algaworks.ecommerce.util.jpa.FullTextSearch;

public class Produtos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@FullTextSearch
	private FullTextEntityManager fullTextEntityManager;

	public List<Produto> fullTextSearch(String text) {
		fullTextEntityManager.find(Produto.class, 1L);
		return null;
	}
	
}
