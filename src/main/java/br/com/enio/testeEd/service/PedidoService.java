package br.com.enio.testeEd.service;

import java.util.List;

import br.com.enio.testeEd.domain.Pedido;
import br.com.enio.testeEd.model.AddProdutoModel;

public interface PedidoService {
	Pedido cadastrar(Long idCliente);
	List<Pedido> listar();
	Pedido adicionar(AddProdutoModel model);
	Pedido retirar(Long idItemPedido);
	Pedido pagar(Long id);
	Pedido excluir(Long id);
}