package br.com.enio.testeEd.model;

import br.com.enio.testeEd.domain.ItemPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemPedidoModel {

	private Long id;
	
	public ItemPedidoModel(ItemPedido domain) {
		this.id = domain.getId();
	}
}
