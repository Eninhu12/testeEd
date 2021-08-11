package br.com.enio.testeEd.domain;

import java.util.List;

import lombok.Getter;

@Getter
public class Pedido {

	private static long gerador = 0;

	private Long id;
	private List<ItemPedido> itens;

	public Pedido addProduto(final Perfume perfume, final Integer qtd) {

		return this;
	}
}