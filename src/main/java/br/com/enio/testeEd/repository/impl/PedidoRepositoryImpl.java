package br.com.enio.testeEd.repository.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.enio.testeEd.domain.Pedido;
import br.com.enio.testeEd.enuns.EnumStatusPedido;
import br.com.enio.testeEd.repository.PedidoRepository;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {

private final static List<Pedido> PEDIDOS = new ArrayList<>();
	
	@Override
	public Pedido salvar(final Pedido domain) {
		PEDIDOS.add(domain);
		return domain;
	}
	
	@Override
	public Pedido apagar(final Pedido domain) {
		PEDIDOS.remove(domain);
		return domain;
	}

	@Override
	public List<Pedido> listar() {
		return PEDIDOS;
	}

	@Override
	public Pedido consultar(final Long id) {
		for (Pedido item : PEDIDOS) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}
}
