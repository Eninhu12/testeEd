package br.com.enio.testeEd.repository;

import java.util.List;

import br.com.enio.testeEd.domain.Pedido;

public interface PedidoRepository {
	Pedido salvar(Pedido domain);
	Pedido apagar(Pedido domain);
	List<Pedido> listar();
	Pedido consultar(Long id);
}
