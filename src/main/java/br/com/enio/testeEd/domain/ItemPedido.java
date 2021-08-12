package br.com.enio.testeEd.domain;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class ItemPedido {

	private static long gerador = 0;
	
	private Long id;
	private Perfume perfume;
	private Integer qtd;
	private BigDecimal valorTotal;

	public ItemPedido(Perfume p, Integer qtd) {
		this.id = ++gerador;
		this.perfume = p;
		this.qtd = qtd;
		this.valorTotal = p.getValor().multiply(BigDecimal.valueOf(qtd));
	}
}