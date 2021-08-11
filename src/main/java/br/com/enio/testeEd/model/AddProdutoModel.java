package br.com.enio.testeEd.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddProdutoModel {

	private Long idPedido;
	private Long idProduto;
	private Integer qtd;
}
