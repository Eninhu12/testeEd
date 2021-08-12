package br.com.enio.testeEd.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.enio.testeEd.domain.Pedido;
import br.com.enio.testeEd.enuns.EnumStatusPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PedidoModel {

	private Long id;
	private ClienteModel cliente;
	private List<ItemPedidoModel> itens;
	private EnumStatusPedido status;
	private LocalDateTime data;
	private LocalDateTime dataPagto;
	private BigDecimal valorTotal;
	
	public PedidoModel(final Pedido domain) {
		this.id = domain.getId();
		this.cliente = new ClienteModel(domain.getCliente());
		this.itens = domain.getItens().stream().map(ItemPedidoModel::new).collect(Collectors.toList());
		this.status = domain.getStatus();
		this.data = domain.getData();
		this.dataPagto = domain.getDataPagto();
		this.valorTotal = domain.getValorTotal();
	}
}