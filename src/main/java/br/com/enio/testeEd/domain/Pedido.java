package br.com.enio.testeEd.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.enio.testeEd.enuns.EnumStatusPedido;
import lombok.Getter;

@Getter
public class Pedido {
	private static long gerador = 0;

	private Long id;
	private Cliente cliente;
	private List<ItemPedido> itens;
	private EnumStatusPedido status;
	private LocalDateTime data;
	private LocalDateTime dataPagto;

	public Pedido(final Cliente cliente) {
		this.id = ++gerador;
		this.itens = new ArrayList<>();
		this.status = EnumStatusPedido.AGUARDANDO_PAGAMENTO;
		this.cliente = cliente;
		this.data = LocalDateTime.now();
	}
	
	public void addPerfume(Perfume p, Integer qtd) {
		if (EnumStatusPedido.PAGO.equals(this.status)) {
			throw new RuntimeException("Pedido já finalizado");
		}
		this.itens.add(new ItemPedido(p, qtd));
	}
	
	public void removeItemPedido(ItemPedido item) {
		if (EnumStatusPedido.PAGO.equals(this.status)) {
			throw new RuntimeException("Pedido já finalizado");
		}
		this.itens.remove(item);
	}
	
	public void realizarPagamento() {
		if (this.getValorTotal().compareTo(BigDecimal.ZERO) < 1) {
			throw new RuntimeException("Pedido sem itens");
		}
		this.status = EnumStatusPedido.PAGO;
		this.dataPagto = LocalDateTime.now();
	}

	public BigDecimal getValorTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for (ItemPedido i : itens) {
			soma = soma.add(i.getValorTotal());
		}
		return soma;
	}
}