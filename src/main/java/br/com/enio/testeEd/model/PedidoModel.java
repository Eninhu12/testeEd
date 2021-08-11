package br.com.enio.testeEd.model;

import java.util.List;
import java.util.stream.Collectors;

import br.com.enio.testeEd.domain.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PedidoModel {

	private Long id;
	private List<ItemPedidoModel> itens;
	
	public PedidoModel(final Pedido domain) {
		this.id = domain.getId();
		this.itens = domain.getItens().stream().map(ItemPedidoModel::new).collect(Collectors.toList());
	}
}
