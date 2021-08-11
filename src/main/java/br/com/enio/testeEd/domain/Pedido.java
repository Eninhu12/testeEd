package br.com.enio.testeEd.domain;

import java.time.LocalDateTime;
import java.util.List;

import br.com.enio.testeEd.enuns.EnumStatusPedido;
import lombok.Getter;

@Getter
public class Pedido {

	private static long gerador = 0;
	private EnumStatusPedido status;
	private LocalDateTime dataPagamento;
	private LocalDateTime dataPedido;
	private Long id;
	private List<ItemPedido> itens;

	public Pedido addProduto(final Perfume perfume, final Integer qtd) {

		return this;
	}
}