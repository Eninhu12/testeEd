package br.com.enio.testeEd.model;

import java.math.BigDecimal;

import br.com.enio.testeEd.domain.ItemPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemPedidoModel {

	private Long id;
	private PerfumeModel perfume;
	private Integer qtd;
	private BigDecimal valorTotal;
	
	public ItemPedidoModel(final ItemPedido domain) {
		this.id = domain.getId();
		this.perfume = new PerfumeModel(domain.getPerfume());
		this.qtd = domain.getQtd();
		this.valorTotal = domain.getValorTotal();
	}
}
